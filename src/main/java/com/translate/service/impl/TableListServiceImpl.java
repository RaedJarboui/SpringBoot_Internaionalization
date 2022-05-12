/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.translate.dto.TableListPaginationDTO;
import com.translate.entity.QTableList;
import com.translate.entity.TableList;
import com.translate.repository.TableListRepository;
import com.translate.repository.TranslationRepository;
import com.translate.service.TableListService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class TableListServiceImpl implements TableListService {
	@Autowired
	TableListRepository tableListRepository;
	@Autowired
	TranslationRepository translationRepository;

	private static final Logger logger = LogManager.getLogger(TableListServiceImpl.class);

	@Override
	public List<String> listTable() {

		return translationRepository.TablesList();
	}

	@Override
	public List<TableList> listTablesPaginated(int page, int size) {
		if (size <= 0 || page <= 0) {
			throw new IllegalArgumentException("invalid page size: " + size);
		}
		int fromIndex = (page - 1) * size;
		List<TableList> tab = tableListRepository.findAll();

		return tab.subList(fromIndex, Math.min(fromIndex + size, tab.size()));
	}

	@Override
	public void addListTable(List<TableList> l) {

		tableListRepository.saveAll(l);

	}

	@Override
	public List<TableList> tableList() {

		List<TableList> list_tabList = tableListRepository.findAll();
		List<String> tableNameStrings = translationRepository.TablesList();
		List<String> list_string = new ArrayList<>();

		logger.info("list_tabList size : {}", list_tabList.size());
		logger.info("tableNameStrings size : {}", tableNameStrings.size());

		boolean contains = false;
		for (int i = 0; i < list_tabList.size(); i++) {

			list_string.add(list_tabList.get(i).getTableName());
		}
		logger.info("list_string size : {}", list_string.size());

		if (list_string.size() < tableNameStrings.size()) {
			List<String> s = tableNameStrings.stream().filter(item -> !list_string.contains(item))
					.collect(Collectors.toList());
			logger.info("missing table names : {}", s);

			for (int i = 0; i < s.size(); i++) {
				TableList tableList = new TableList(s.get(i), false);
				tableListRepository.save(tableList);
			}

		}

		return tableListRepository.findAll();

	}

	@Override
	public TableList editTableList(int id, TableList t) {

		TableList tab = tableListRepository.findById(id).get();
		tab.setTableName(t.getTableName());
		tab.setTranslate(t.getTranslate());
		return tableListRepository.save(tab);
	}

	@Override
	public List<TableList> listTablesFromDB() {
		return tableListRepository.findAll();
	}

	@Override
	public TableListPaginationDTO find(TableListPaginationDTO tableListPaginationDTO) {
		List<TableList> tab_list = this.tableList();
		Pageable pageable = null;
		tableListPaginationDTO.setTab_list(new ArrayList<>());
		QTableList qtablelist = QTableList.tableList;
		// init Predicate
		BooleanBuilder predicate = new BooleanBuilder();
		// setting default totals pages
		tableListPaginationDTO.setTotalElements(0L);
		// setting default totals elements
		tableListPaginationDTO.setTotalPages(0);

		// find LIKE Id
		if (tableListPaginationDTO.getParams() != null) {
			if (tableListPaginationDTO.getParams().getId() != 0) {
				logger.info("tableList id not null");
				predicate.and(qtablelist.id.like("%" + tableListPaginationDTO.getParams().getId() + "%"));
			}
			// find LIKE TableName
			if (tableListPaginationDTO.getParams().getTableName() != null) {
				logger.info("tableList tableName not null");
				predicate.and(qtablelist.tableName.like("%" + tableListPaginationDTO.getParams().getTableName() + "%"));
			}

		}
		// init pageable params (page number / page size / sorting direction if exist)

		String sortField = tableListPaginationDTO.getSortField();

		if (sortField != null) {
			Direction sort = Sort.Direction.ASC;
			if ("-1".equals(tableListPaginationDTO.getSortDirection())) {
				sort = Sort.Direction.DESC;
			}
			logger.info("languages sorted field : {}", tableListPaginationDTO.getSortField());
			pageable = PageRequest.of(tableListPaginationDTO.getPageNumber(), tableListPaginationDTO.getPageSize(),
					sort, sortField);

		} else {
			pageable = PageRequest.of(tableListPaginationDTO.getPageNumber(), tableListPaginationDTO.getPageSize(),
					Sort.Direction.ASC, "tableName");
		}

		// load data Page<Languages> pagedResult =
		Page<TableList> pagedResult = tableListRepository.findAll(predicate, pageable);
		if (pagedResult.hasContent()) {
			tableListPaginationDTO.setTab_list(pagedResult.getContent());
			logger.info("pageResult get content : {}", pagedResult.getContent().get(0));

			tableListPaginationDTO.setTotalElements(tab_list.size());
			tableListPaginationDTO.setTotalPages(tab_list.size() / tableListPaginationDTO.getPageSize());
		}
		return tableListPaginationDTO;
	}
}
