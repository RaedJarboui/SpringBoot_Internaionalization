/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.translate.controller.SomeDao;
import com.translate.entity.Languages;
import com.translate.entity.Langues;
import com.translate.entity.Translation;
import com.translate.repository.LanguagesRepository;
import com.translate.repository.TranslationRepository;

import lombok.var;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class TranslationService {
	@Autowired
	TranslationRepository translationRepository;
	@Autowired
	LanguagesRepository languageRepository;
	@Autowired
	private SomeDao dao;
	private static final Logger logger = LogManager.getLogger(TranslationService.class);

	public List<Translation> jsonArrayToObjectList() {

		List<Translation> arrayTranslations = translationRepository.findAll();

		List<Translation> translations = new ArrayList<>();
		for (int i = 0; i < arrayTranslations.size(); i++) {

			translations.add(arrayTranslations.get(i));

		}
		return translations;

	}

	public List<String> List_Tables() {

		return translationRepository.TablesList();
	}

	public List<String> Columns_Tables_Type(String value) {

		return translationRepository.TablesColumnsType(value);
	}

	public List<String> Columns_Tables(String value) {

		return translationRepository.TablesColumns(value);
	}

	public void editTranslation(String fieldvalue, String column, String tableName, Translation t) {

		List<Translation> arrayTranslations = translationRepository.findAll();
		boolean found = false;
		for (int i = 0; i < arrayTranslations.size(); i++) {
			System.out.println(arrayTranslations.get(i).getField_value());
			if (arrayTranslations.get(i).getField_value().equals(fieldvalue)
					&& arrayTranslations.get(i).getSelected_column().equals(column)
					&& arrayTranslations.get(i).getName_table().equals(tableName)) {
				found = true;
				System.out.println("true");
				System.out.println(t.getTranslations());
				arrayTranslations.get(i).setTranslations(t.getTranslations());
				translationRepository.save(arrayTranslations.get(i));
				break;
			}
			else {
				found = false;
				System.out.println("false");
				System.out.println(column);

			}
		}
		if (!found) {
			System.out.println("element not found");
		}
	}

	public void addTranslation(Translation t) throws JsonMappingException, JsonProcessingException {

		List<Translation> arrayTranslations = translationRepository.findAll();

		boolean found = false;

		if (arrayTranslations.size() == 0) {
			translationRepository.save(t);
			System.out.println("size 0");

		}
		else {
			System.out.println("size not 0");

			for (Translation ts : arrayTranslations) {
				if (ts.getField_value().equals(t.getField_value())) {
					if (ts.getSelected_column().equals(t.getSelected_column())) {
						found = true;
						List<Langues> langues = ts.getTranslations();
						langues.addAll(t.getTranslations());
						translationRepository.save(ts);
						break; // Break out of the loop to skip the remaining items
					}
				}
			}

		}
		if (found) {
			System.out.println("found");

		}
		else {
			System.out.println("not found");

			translationRepository.save(t);

		}

	}

	public List<Translation> getAllTranslation() {

		return translationRepository.findAll();
	}

	public Translation getTranslationById(Long id) {

		return translationRepository.findById(id).get();
	}

	public String name_type_column(String name_table) {

		List<String> list = translationRepository.TablesColumnsType(name_table);
		System.out.println(list);
		System.out.println(list.get(0));
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			List<String> dummyList = new ArrayList<String>();
			JSONObject jsonObj = new JSONObject();
			dummyList.add(list.get(i));
			System.out.println("List of dummy Names :" + dummyList.get(0));
			String[] words = dummyList.get(0).split(",");
			System.out.println("words :" + Arrays.toString(words));
			System.out.println("wordssssss :" + words[1]);
			jsonObj.put("name_column", words[0]);
			jsonObj.put("type_column", words[1]);
			jsonArray.put(jsonObj);

		}
		System.out.println("jsonArray : " + jsonArray);
		return jsonArray.toString();

	}

	public void name_type_column_data(String name_table, String selected_column, Boolean Json) {

		ObjectMapper mapper = new ObjectMapper();
		var l = dao.getTableData(name_table);
		List<Translation> array_translation_values = translationRepository.findAll();
		Gson gson = new Gson();
		var tables = JSON.toJSONString(l);
		JSONArray jsonArray = new JSONArray(tables);
		List<String> tab_columnStrings = translationRepository.TablesColumns(name_table);
		System.out.println("tab_columnStrings :" + tab_columnStrings);
		int column_index = tab_columnStrings.indexOf(selected_column);
		System.out.println("column_index :" + column_index);
		List<String> array_string = new ArrayList<String>();
		System.out.println("jsonArray :" + jsonArray);
		for (int i = 0; i < jsonArray.length(); i++) {
			array_string.add(((JSONArray) jsonArray.get(i)).get(column_index).toString());

		}
		System.out.println("array_string :" + array_string);
		List<Translation> db_data = new ArrayList<>();
		for (int i = 0; i < array_translation_values.size(); i++) {
			if (array_translation_values.get(i).getName_table().equals(name_table)) {
				db_data.add(array_translation_values.get(i));
			}
		}
		System.out.println("db_data :" + db_data);
		List<String> db1_data = new ArrayList<>();
		for (int i = 0; i < db_data.size(); i++) {
			if (array_string.contains(db_data.get(i).getField_value())) {
				System.out.println("it contains true");
				db1_data.add(db_data.get(i).getField_value());
				// System.out.println("db_data1 :" + db_data1);

			}
		}
		System.out.println("db1_data :" + db1_data);
		var missing = array_string.stream().filter(item -> db1_data.indexOf(item) < 0)
				.collect(Collectors.toList());
		System.out.println("missing :" + missing);
		List<Languages> langues = languageRepository.findAll();
		List<Languages> global_langues = new ArrayList<>();
		List<Langues> translations_langues = new ArrayList<>();
		for (int i = 0; i < langues.size(); i++) {
			if (langues.get(i).getGlobal() == true) {
				global_langues.add(langues.get(i));

			}
		}
		System.out.println("global_langues size :" + global_langues.size());
		JSONArray missing_lang = new JSONArray();
		for (int i = 0; i < db_data.size(); i++) {
			translations_langues.addAll(db_data.get(i).getTranslations());
			List<Langues> pojos = mapper.convertValue(translations_langues,
					new TypeReference<List<Langues>>() {});
			for (int j = 0; j < global_langues.size(); j++) {
				var test = global_langues.get(j).getLocale();

				boolean isPresent = pojos.stream().anyMatch(x -> x.getLangue().equals(test));
				if (isPresent == true) {
					System.out.println("true :" + j);
				}
				else {
					System.out.println("false :" + j);
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("field_value", db_data.get(i).getField_value());
					jsonObj.put("langue", test);
					missing_lang.put(jsonObj);

				}
			}
			System.out.println("pojos size :" + pojos.size());

		}
		System.out.println("translations_langues size :" + translations_langues.size());
		System.out.println("missing_lang :" + missing_lang);

	}

	public JSONArray name_type_column_data_json(String name_table, String selected_column,
			Boolean Json) {

		var l = dao.getTableData(name_table);
		Gson gson = new Gson();
		var tables = JSON.toJSONString(l);
		JSONArray jsonarray = new JSONArray();
		JSONArray jsonArray = new JSONArray(tables);
		List<String> tab_columnStrings = translationRepository.TablesColumns(name_table);
		int column_index = tab_columnStrings.indexOf(selected_column);
		int abacus_name_column_index = tab_columnStrings.indexOf("TABLE_ABACUS_NAME");
		List<String> abacus_json_array = new ArrayList<String>();
		List<String> abacus_json_array_no_dup = new ArrayList<String>();
		if (abacus_name_column_index != -1) {
			for (int i = 0; i < jsonArray.length(); i++) {

				abacus_json_array.add(
						((JSONArray) jsonArray.get(i)).get(abacus_name_column_index).toString());
			}
			// System.out.println("abacus_json_array : " + abacus_json_array);
			Set<String> set = new HashSet<>(abacus_json_array);
			// abacus_json_array.clear();
			abacus_json_array_no_dup.addAll(set);
			// System.out.println("abacus_json_array not duplicated : " + abacus_json_array_no_dup);

		}

		for (int i = 0; i < abacus_json_array_no_dup.size(); i++) {
			for (int j = 0; j < jsonArray.length(); j++) {
				if (((JSONArray) jsonArray.get(j))
						.get(abacus_name_column_index) == abacus_json_array_no_dup.get(i)) {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("TABLE_ABACUS_NAME", abacus_json_array_no_dup.get(i));
					jsonObj.put("VALUE_JSON", ((JSONArray) jsonArray.get(j)).get(column_index));
					jsonarray.put(jsonObj);

				}

			}
		}
		System.out.println("jsonarray :" + jsonarray);
		JSONArray last_array = new JSONArray();

		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonObj = (JSONObject) jsonarray.getJSONObject(i);
			// System.out.println("jsonObj : " + jsonObj);
			String value = jsonObj.getString("VALUE_JSON");
			String value1 = jsonObj.getString("TABLE_ABACUS_NAME");
			System.out.println("value : " + value1.toString());
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = new JSONObject();

			try {
				org.json.simple.JSONObject jsonObj1 =
						(org.json.simple.JSONObject) parser.parse(value.toString());
				// System.out.println("value : " + jsonObj1);
				System.out.println("key : " + jsonObj1.keySet());
				jsonObject.put("TABLE_ABACUS_NAME", value1.toString());
				jsonObject.put("VALUE_JSON", jsonObj1.keySet());
				last_array.put(jsonObject);

			}
			catch (ParseException e) {
				e.printStackTrace();
			}

		}
		System.out.println("last_array : " + last_array);

		List<String> array_string = new ArrayList<String>();
		for (int i = 0; i < jsonArray.length(); i++) {
			array_string.add(((JSONArray) jsonArray.get(i)).get(column_index).toString());

		}
		return last_array;

	}

	public void get_table_data_by_columns(String name_table, String selected_column, Boolean Json) {

		// JSONArray last_array = name_type_column_data(name_table, selected_column, Json);

	}

}
