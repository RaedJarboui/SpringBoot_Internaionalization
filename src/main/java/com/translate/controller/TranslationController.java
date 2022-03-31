/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.translate.entity.Translation;
import com.translate.repository.TranslationRepository;
import com.translate.service.TranslationService;

import lombok.var;

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
	@Autowired
	private SomeDao dao;
	@Autowired
	TranslationRepository translationRepository;

	@PutMapping("/translate/edit/{field_value}/{column}/{tableName}")
	@ResponseBody
	public void editTranslation(@PathVariable("field_value") String field_value,
			@PathVariable("column") String column, @PathVariable("tableName") String tableName,
			@RequestBody Translation t) {

		translationService.editTranslation(field_value, column, tableName, t);
	}

	@PostMapping("/translate/add")
	@ResponseBody
	public void addTranslation(@RequestBody Translation t) {

		try {
			translationService.addTranslation(t);
		}
		catch (JsonMappingException e) {
			e.printStackTrace();
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/translate/get")
	@ResponseBody
	public List<Translation> getAllTranslations() {

		return translationService.getAllTranslation();
	}

	@GetMapping("/table/data/{tableName}")
	@ResponseBody
	public List<JSONObject> getTableData(@PathVariable("tableName") String tableName) {

		var l = dao.getTableData(tableName);
		Gson gson = new Gson();
		String jsonUsersSet = gson.toJson(l);
		System.out.println("jsonUsersSet: " + jsonUsersSet);
		System.out.println(l);
		System.out.println(JSON.toJSONString(l));
		return l;
	}

	@GetMapping("/list/table")
	@ResponseBody
	public List<String> listTable() {

		return translationService.List_Tables();
	}

	@GetMapping("/column/type/table/{value}")
	@ResponseBody
	public List<String> column_Type_Table(@PathVariable("value") String value) {

		return translationService.Columns_Tables_Type(value);
	}

	@GetMapping("/column/table/{value}")
	@ResponseBody
	public List<String> columnsTable(@PathVariable("value") String value) {

		return translationService.Columns_Tables(value);
	}

	@GetMapping("/translate/get/{id}")
	@ResponseBody
	public Translation getSingleTranslate(@PathVariable("id") Long id) {

		return translationService.getTranslationById(id);

	}

	@GetMapping("/translate/get/table/{name_table}")
	@ResponseBody
	public String name_type_column(@PathVariable("name_table") String name_table) {

		return translationService.name_type_column(name_table);

	}

	@GetMapping("/translate/get/table/data/{name_table}/{selected_column}/{Json}")
	@ResponseBody
	public void name_type_column_data(@PathVariable("name_table") String name_table,
			@PathVariable("selected_column") String selected_column,
			@PathVariable("Json") Boolean Json) {

		translationService.name_type_column_data(name_table, selected_column, Json);

	}

	@GetMapping("/translate/get/table/data/json/{name_table}/{selected_column}/{Json}")
	@ResponseBody
	public ResponseEntity<?> name_type_column_data_json(
			@PathVariable("name_table") String name_table,
			@PathVariable("selected_column") String selected_column,
			@PathVariable("Json") Boolean Json) {

		return ResponseEntity.status(HttpStatus.OK).body(translationService
				.name_type_column_data_json(name_table, selected_column, Json).toString());

	}
}
