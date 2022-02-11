/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.translate.entity.i18n;
import com.translate.service.i18nService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@RestController
@CrossOrigin

public class i18nController {
	@Autowired
	i18nService i18nservice;

	@PostMapping("/add")
	@ResponseBody
	public i18n create(@RequestBody i18n i) {

		return i18nservice.addI18n(i);

	}

	@GetMapping("/i18n")
	@ResponseBody
	public List<i18n> getI18n() {

		return i18nservice.getAlli18n();
	}

}
