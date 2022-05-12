/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.translate.dto.LanguagesPaginationDTO;
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

	/**
	 * Search endpoint allows for filtering, sorting and paging.
	 *
	 * @param search    Format of search string: {key}{operation}{value?},. ex.
	 *                  key1:value1,key2>value2,key3+ .
	 * @param pageSize  number of records per page
	 * @param pageIndex index of the page requested
	 * @return List of records
	 */
	@GetMapping("/languages")
	@ResponseBody
	public ResponseEntity search(@RequestParam("search") String search,
			@RequestParam(value = "pageIndex") int pageIndex, @RequestParam(value = "pageSize") int pageSize,
			@RequestParam("sort") int sort) {
		try {
			List<Languages> mainObjList = languagesService.search(search, pageIndex, pageSize, sort);
			return new ResponseEntity(mainObjList, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
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

	@GetMapping("/langues/{id}")
	@ResponseBody
	public Optional<Languages> findLanguageById(@PathVariable("id") int id) {
		return languagesService.FindLanguageById(id);
	}

	@PostMapping("/langues/find")
	@ResponseBody
	public LanguagesPaginationDTO find(@RequestBody LanguagesPaginationDTO languagesPaginationDTO) {
		return languagesService.find(languagesPaginationDTO);
	}

}
