/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.translate.entity.i18n;
import com.translate.repository.i18nRepository;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class i18nService {
	@Autowired
	i18nRepository i18nrepository;

	public i18n addI18n(@RequestBody i18n i) {

		return i18nrepository.save(i);
	}

	public List<i18n> getAlli18n() {

		return (List<i18n>) i18nrepository.findAll();
	}

}
