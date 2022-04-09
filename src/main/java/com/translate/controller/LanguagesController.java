/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.translate.entity.Languages;
import com.translate.service.LanguagesService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@RestController
@CrossOrigin
public class LanguagesController {
	@Autowired
	LanguagesService languagesService;

	@GetMapping("/langues")
	@ResponseBody
	public List<Languages> getAllLanguages() {

		return languagesService.getAllLanguages();
	}

	@GetMapping("/paginated/langues")
	@ResponseBody
	public List<Languages> getPageableLanguages(@RequestParam int page, @RequestParam int size) {

		return languagesService.getPageableLanguages(page, size);
	}

	@PostMapping("/langues")
	@ResponseBody

	public Languages addLanguage(@RequestBody Languages languages) {

		return languagesService.addLanguage(languages);
	}

	@PutMapping("/langues/{id}")
	@ResponseBody

	public Languages addLanguage(@PathVariable int id, @RequestBody Languages languages) {

		return languagesService.editLanguage(id, languages);
	}

	@DeleteMapping("/langues/{id}")
	@ResponseBody
	public void deleteLanguage(@PathVariable("id") int id) {

		languagesService.deleteLanguage(id);

	}

}
