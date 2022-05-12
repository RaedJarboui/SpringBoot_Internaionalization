/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.translate.dto.LanguagesPaginationDTO;
import com.translate.entity.Languages;
import com.translate.entity.QLanguages;
import com.translate.entity.SearchCriteria;
import com.translate.entity.SearchSpecification;
import com.translate.repository.LanguagesRepository;
import com.translate.service.LanguagesService;

import processor.SearchCriteriaParser;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class LanguagesServiceImpl implements LanguagesService {
	@Autowired
	LanguagesRepository languageRepository;

	@Autowired
	SearchCriteriaParser searchCriteriaParser;

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(LanguagesServiceImpl.class);

	public List<Languages> getPageableLanguages(int page, int size) {
		if (size <= 0 || page <= 0) {
			throw new IllegalArgumentException("invalid page size: " + size);
		}
		int fromIndex = (page - 1) * size;
		List<Languages> languages = languageRepository.findAll();

		return languages.subList(fromIndex, Math.min(fromIndex + size, languages.size()));
	}

	@Override
	public List<Languages> search(String searchString, int pageIndex, int pageSize, int sort) {
		List<SearchCriteria> searchCriteria = searchCriteriaParser.parse(searchString);
		List<SearchSpecification> specList = searchCriteria.stream()
				.map(criterion -> new SearchSpecification(criterion)).collect(Collectors.toList());
		Specification<Languages> specs = andSpecification(specList)
				.orElseThrow(() -> new IllegalArgumentException("No criteria provided"));
		System.out.println(searchCriteria.get(0).getKey());

		if (sort == 1) {
			System.out.println("asc");
			Pageable pageable = PageRequest.of(pageIndex, pageSize,
					Sort.by(Sort.Direction.ASC, searchCriteria.get(0).getKey()));
			Page page = languageRepository.findAll(specs, pageable);
			return page.getContent();

		} else if (sort == -1) {
			System.out.println("desc");
			Pageable pageable = PageRequest.of(pageIndex, pageSize,
					Sort.by(Sort.Direction.DESC, searchCriteria.get(0).getKey()));
			Page page = languageRepository.findAll(specs, pageable);

			return page.getContent();

		} else {
			System.out.println("no asc no desc");
			List<Sort> sortList = generateSortList(searchCriteria);
			Sort sort1 = andSort(sortList).orElse(Sort.unsorted());
			Pageable pageable = PageRequest.of(pageIndex, pageSize, sort1);
			Page page = languageRepository.findAll(specs, pageable);
			return page.getContent();
		}

	}

	private <T, V extends Specification<T>> Optional<Specification<T>> andSpecification(List<V> criteria) {
		Iterator<V> itr = criteria.iterator();
		if (itr.hasNext()) {
			Specification<T> spec = Specification.where(itr.next());
			while (itr.hasNext()) {
				spec = spec.and(itr.next());
			}
			return Optional.of(spec);
		}
		return Optional.empty();
	}

	private <T, V extends Sort> Optional<Sort> andSort(List<V> criteria) {

		Iterator<V> itr = criteria.iterator();
		if (itr.hasNext()) {
			Sort sort = (itr.next());
			while (itr.hasNext()) {
				sort = sort.and(itr.next());
			}
			return Optional.of(sort);
		}
		return Optional.empty();
	}

	private List<Sort> generateSortList(List<SearchCriteria> criteria) {
		return criteria.stream().map((criterion) -> {
			System.out.println(criterion);
			switch (criterion.getOperation()) {
			case SORT_ASC:
				return Sort.by(Order.asc(criterion.getKey()));
			case SORT_DESC:
				return Sort.by(Order.desc(criterion.getKey()));
			default:
				return null;
			}
		}).filter((sort) -> sort != null).collect(Collectors.toList());
	}

	public Languages addLanguage(Languages l) {

		l.setGlobal(false);
		return languageRepository.save(l);
	}

	public void deleteLanguage(int id) {

		languageRepository.deleteById(id);
	}

	public Languages editLanguage(int id, Languages l) {

		Languages ll = languageRepository.findById(id).get();
		ll.setLocale(l.getLocale());
		ll.setLanguageName(l.getLanguageName());
		ll.setGlobal(l.getGlobal());
		return languageRepository.save(ll);
	}

	@Override
	public List<Languages> getAllLanguages() {
		return languageRepository.findAll();
	}

	@Override
	public Optional<Languages> FindLanguageById(int id) {
		return languageRepository.findById(id);
	}

	@Override
	public LanguagesPaginationDTO find(LanguagesPaginationDTO languagesPaginationDTO) {
		List<Languages> languages = languageRepository.findAll();
		Pageable pageable = null;
		languagesPaginationDTO.setLanguages(new ArrayList<>());
		QLanguages qlanguages = QLanguages.languages;
		// init Predicate
		BooleanBuilder predicate = new BooleanBuilder();
		languagesPaginationDTO.setLanguages(new ArrayList<>());
		// setting default totals pages
		languagesPaginationDTO.setTotalElements(0L);
		// setting default totals elements
		languagesPaginationDTO.setTotalPages(0);

		// find LIKE Id
		if (languagesPaginationDTO.getParams() != null) {
			if (languagesPaginationDTO.getParams().getId() != 0) {
				logger.info("languages id not null");
				predicate.and(qlanguages.id.like("%" + languagesPaginationDTO.getParams().getId() + "%"));
			}
			// find LIKE Locale
			if (languagesPaginationDTO.getParams().getLocale() != null) {
				logger.info("languages locale not null");
				predicate.and(qlanguages.locale.like("%" + languagesPaginationDTO.getParams().getLocale() + "%"));
			}

			// find LIKE LanguageName
			if (languagesPaginationDTO.getParams().getLanguageName() != null) {
				logger.info("languages languagename not null");
				predicate.and(
						qlanguages.languageName.like("%" + languagesPaginationDTO.getParams().getLanguageName() + "%"));
			}

		}
		// init pageable params (page number / page size / sorting direction if exist)

		String sortField = languagesPaginationDTO.getSortField();

		if (sortField != null) {
			Direction sort = Sort.Direction.ASC;
			if ("-1".equals(languagesPaginationDTO.getSortDirection())) {
				sort = Sort.Direction.DESC;
			}
			logger.info("languages sorted field : {}", languagesPaginationDTO.getSortField());
			pageable = PageRequest.of(languagesPaginationDTO.getPageNumber(), languagesPaginationDTO.getPageSize(),
					sort, sortField);

		} else {
			pageable = PageRequest.of(languagesPaginationDTO.getPageNumber(), languagesPaginationDTO.getPageSize(),
					Sort.Direction.ASC, "locale");
		}

		// load data Page<Languages> pagedResult =
		Page<Languages> pagedResult = languageRepository.findAll(predicate, pageable);
		if (pagedResult.hasContent()) {
			languagesPaginationDTO.setLanguages(pagedResult.getContent());
			logger.info("pageResult get content : {}", pagedResult.getContent().get(0));

			languagesPaginationDTO.setTotalElements(languages.size());
			languagesPaginationDTO.setTotalPages(languages.size() / languagesPaginationDTO.getPageSize());
		}
		return languagesPaginationDTO;
	}

}
