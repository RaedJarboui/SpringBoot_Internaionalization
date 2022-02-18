/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.translate.entity.Translation;
import com.translate.service.TranslationService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@RestController
@CrossOrigin
public class TranslationController {
	@Autowired
	TranslationService translationService;

	@PutMapping("/translate/edit/{id}")
	@ResponseBody
	public void editTranslation(@RequestBody Translation t, @PathVariable("id") Long id) {

		translationService.editTranslation(t, id);
	}

	@PostMapping("/translate/add")
	@ResponseBody
	public void addTranslation(@RequestBody Translation t) {

		try {
			translationService.addTranslation(t);
		}
		catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/translate/get")
	@ResponseBody
	public List<Translation> getAllTranslations() {

		return translationService.getAllTranslation();
	}

	@PostMapping("/translation/delete/{id}")
	@ResponseBody
	public void removeTranslation(@PathVariable("id") int id, @RequestBody Translation t) {

		translationService.removeTranslation(id, t);
	}

	@GetMapping("/translation/get/{id}")
	@ResponseBody
	public Translation getTranslationByColumn(@RequestBody Translation t,
			@PathVariable("id") Long id) {

		return translationService.getTranslationByColumn(t, id);
	}

	@GetMapping("/translate/get/{id}")
	@ResponseBody
	public Translation getSingleTranslate(@PathVariable("id") Long id) {

		return translationService.getTranslationById(id);

	}
}
