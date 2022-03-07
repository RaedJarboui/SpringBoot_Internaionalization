/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

	@PutMapping("/translate/edit/{id}")
	@ResponseBody
	public void editTranslation(@RequestBody Translation t, @PathVariable("id") Long id) {

		translationService.editTranslation(t, id);
	}

	@PostMapping("/translate/delete/{id}/{langue}")
	@ResponseBody
	public void delete_of_list_translation(@Valid @RequestBody Translation t,
			@PathVariable("id") Long id, @PathVariable("langue") String l) {

		translationService.delete_of_list_translation(t, id, l);
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

	@GetMapping("/table/data/{tableName}")
	@ResponseBody
	public List<JSONObject> getTableData(@PathVariable("tableName") String tableName) {

		var l = dao.listFoodMoneyDateOfPayment(tableName);
		Gson gson = new Gson();

		// convert your set to json
		String jsonUsersSet = gson.toJson(l);

		// print your generated json
		System.out.println("jsonUsersSet: " + jsonUsersSet);

		System.out.println(l);
		System.out.println(JSON.toJSONString(l));
		// JSONArray jsonArray = JSONArray.fromObject(l);
		// System.out.println(jsonArray);

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

	@GetMapping("/data/table/{value}")
	@ResponseBody
	public List<Object> dataTable(@PathVariable("value") String value) {

		return translationService.Data_Tables(value);
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
