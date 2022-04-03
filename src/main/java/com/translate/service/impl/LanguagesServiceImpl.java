/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.entity.Languages;
import com.translate.repository.LanguagesRepository;
import com.translate.service.LanguagesService;

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

	public List<Languages> getAllLanguages() {

		return languageRepository.findAll();
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

}
