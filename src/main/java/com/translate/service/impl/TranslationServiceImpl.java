/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.underscore.U;
import com.translate.controller.SomeDao;
import com.translate.dto.ColumnsDTO;
import com.translate.entity.Languages;
import com.translate.entity.Langues;
import com.translate.entity.Translation;
import com.translate.repository.LanguagesRepository;
import com.translate.repository.TranslationRepository;
import com.translate.service.TranslationService;

import lombok.var;

/**
 * {@link TranslationServiceImpl} class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class TranslationServiceImpl implements TranslationService {

	/** The translation repository. */
	@Autowired
	TranslationRepository translationRepository;

	/** The language repository. */
	@Autowired
	LanguagesRepository languageRepository;

	/** The dao. */
	@Autowired
	private SomeDao dao;

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(TranslationServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.translate.service.TranslationService#jsonArrayToObjectList()
	 */
	@Override
	public List<Translation> jsonArrayToObjectList() {

		List<Translation> arrayTranslations = translationRepository.findAll();

		List<Translation> translations = new ArrayList<>();
		for (int i = 0; i < arrayTranslations.size(); i++) {

			translations.add(arrayTranslations.get(i));

		}
		return translations;

	}

	/**
	 * List tables.
	 *
	 * @return the list
	 */
	@Override
	public List<String> listTables() {

		return translationRepository.TablesList();
	}

	/**
	 * Columns tables type.
	 *
	 * @param value the value
	 * @return the list
	 */
	@Override
	public List<String> columnsTablesType(String value) {

		return translationRepository.TablesColumnsType(value);
	}

	/**
	 * Columns tables.
	 *
	 * @param value the value
	 * @return the list
	 */
	@Override
	public List<String> columnsTables(String value) {

		return translationRepository.TablesColumns(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.translate.service.TranslationService#editTranslation(java.lang.String,
	 * java.lang.String, java.lang.String, com.translate.entity.Translation)
	 */
	@Override
	public void editTranslation(String fieldvalue, String column, String tableName, Translation t) {

		List<Translation> arrayTranslations = translationRepository.findAll();
		boolean found = false;
		for (int i = 0; i < arrayTranslations.size(); i++) {
			logger.info(arrayTranslations.get(i).getField_value());
			if (arrayTranslations.get(i).getField_value().equals(fieldvalue)
					&& arrayTranslations.get(i).getSelected_column().equals(column)
					&& arrayTranslations.get(i).getName_table().equals(tableName)) {
				found = true;
				logger.info("true");
				logger.info(t.getTranslations());
				arrayTranslations.get(i).setTranslations(t.getTranslations());
				translationRepository.save(arrayTranslations.get(i));
				break;
			} else {
				found = false;
				logger.info("false");
				logger.info(column);

			}
		}
		if (!found) {
			logger.info("element not found");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.translate.service.TranslationService#addTranslation(com.translate.entity.
	 * Translation)
	 */
	@Override
	public void addTranslation(Translation t) {

		List<Translation> arrayTranslations = translationRepository.findAll();

		boolean found = false;

		if (!arrayTranslations.isEmpty()) {
			translationRepository.save(t);
			logger.info("size 0");

		} else {
			logger.info("size not 0");

			for (Translation ts : arrayTranslations) {
				if (ts.getField_value().equals(t.getField_value())
						&& ts.getSelected_column().equals(t.getSelected_column())) {
					found = true;
					List<Langues> langues = ts.getTranslations();
					langues.addAll(t.getTranslations());
					translationRepository.save(ts);
					break; // Break out of the loop to skip the remaining items

				}
			}

		}

		if (found) {
			logger.info("found");

		} else {
			logger.info("not found");

			translationRepository.save(t);

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.translate.service.TranslationService#getAllTranslation()
	 */
	@Override
	public List<Translation> getAllTranslation() {

		return translationRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.translate.service.TranslationService#getTranslationById(java.lang.Long)
	 */
	@Override
	public Translation getTranslationById(Long id) {

		Optional<Translation> translation = translationRepository.findById(id);
		Translation tr = null;
		if (translation.isPresent())
			tr = translation.get();

		return tr;

	}

	/**
	 * Name type column.
	 *
	 * @param nameTable the name table
	 * @return the string
	 */
	@Override
	public String nameTypeColumn(String nameTable) {

		List<String> list = translationRepository.TablesColumnsType(nameTable);
		logger.info(list);
		logger.info(list.get(0));
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			List<String> dummyList = new ArrayList<>();
			JSONObject jsonObj = new JSONObject();
			dummyList.add(list.get(i));
			logger.info("List of dummy Names : {} ", dummyList.get(0));
			String[] words = dummyList.get(0).split(",");
			logger.info("wordssssss : {} ", words[1]);
			jsonObj.put("name_column", words[0]);
			jsonObj.put("type_column", words[1]);
			jsonArray.put(jsonObj);

		}
		logger.info("jsonArray : {} ", jsonArray);
		return jsonArray.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.translate.service.TranslationService#nameColType(java.lang.String,
	 * java.lang.String, java.lang.Boolean)
	 */
	@Override
	public HashMap<Object, Object> nameColType(String nameTable, String selectedColumn, Boolean json, int page,
			int size) {

		Object l = dao.getTableData(nameTable);
		List<Translation> arrayTranslationValues = translationRepository.findAll();
		var tables = JSON.toJSONString(l);
		JSONArray jsonArray = new JSONArray(tables);
		int count = jsonArray.length();
		List<String> tabColumnStrings = translationRepository.TablesColumns(nameTable);
		logger.info("tab_columnStrings : {} ", tabColumnStrings);
		int columnIndex = tabColumnStrings.indexOf(selectedColumn);
		logger.info("column_index : {} ", columnIndex);
		List<String> arrayString = new ArrayList<>();
		logger.info("jsonArray : {} ", jsonArray);
		for (int i = 0; i < jsonArray.length(); i++) {
			arrayString.add(((JSONArray) jsonArray.get(i)).get(columnIndex).toString());
		}
		logger.info("array_string : {} ", arrayString);
		List<Translation> dbData = new ArrayList<>();
		for (int i = 0; i < arrayTranslationValues.size(); i++) {
			if (arrayTranslationValues.get(i).getName_table().equals(nameTable)) {
				dbData.add(arrayTranslationValues.get(i));
			}
		}
		logger.info("db_data : {} ", dbData);
		List<String> db1Data = new ArrayList<>();
		for (int i = 0; i < dbData.size(); i++) {
			if (arrayString.contains(dbData.get(i).getField_value())) {
				logger.info("it contains true");
				db1Data.add(dbData.get(i).getField_value());
			}
		}
		logger.info("db1_data : {} ", db1Data);
		List<String> missing = arrayString.stream().filter(item -> db1Data.indexOf(item) < 0)
				.collect(Collectors.toList());
		missing = missing.stream().distinct().collect(Collectors.toList());
		logger.info("missing : {} ", missing);
		List<Languages> langues = languageRepository.findAll();
		List<Languages> globalLangues = new ArrayList<>();
		List<String> globalLanguesLocal = new ArrayList<>();
		List<Langues> translationsLangues = new ArrayList<>();
		for (int i = 0; i < langues.size(); i++) {
			if (Boolean.TRUE.equals(langues.get(i).getGlobal())) {
				globalLangues.add(langues.get(i));
				globalLanguesLocal.add(langues.get(i).getLocale());
			}
		}
		logger.info("global_langues size : {} ", globalLangues.size());
		JSONArray missingLang = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < dbData.size(); i++) {
			translationsLangues.addAll(dbData.get(i).getTranslations());
			List<Langues> pojos = mapper.convertValue(translationsLangues, new TypeReference<List<Langues>>() {

			});
			logger.info("translationsLangues : {} ", translationsLangues);

			for (int j = 0; j < globalLangues.size(); j++) {
				String test = globalLangues.get(j).getLocale();

				boolean isPresent = pojos.stream().anyMatch(x -> x.getLangue().equals(test));
				if (isPresent) {
					logger.info(": {} ", j);
					logger.info("existed langue : {} ", globalLangues.get(j).getLanguageName());

				} else {
					logger.info("false : {} ", j);
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("field_value", dbData.get(i).getField_value());
					jsonObj.put("langue", test);
					logger.info("obj not existed langue: {} ", globalLangues.get(j).getLanguageName());

					missingLang.put(jsonObj);
				}
			}
			logger.info("pojos size : {} ", pojos.size());
		}

		for (int i = 0; i < dbData.size(); i++) {
			if (dbData.get(i).getSelected_column().equals(selectedColumn)) {
				List<Langues> translationsLanguess = new ArrayList<>();
				List<Langues> pojos1 = new ArrayList<>();
				List<String> pojos1_langues = new ArrayList<>();
				logger.info("same selected column : {} ", dbData.get(i).getTranslations());
				translationsLanguess.addAll(dbData.get(i).getTranslations());
				pojos1 = mapper.convertValue(dbData.get(i).getTranslations(), new TypeReference<List<Langues>>() {

				});
				for (int j = 0; j < pojos1.size(); j++) {
					logger.info("pojos1 de : {} ", pojos1.get(j).getLangue());
					pojos1_langues.add(pojos1.get(j).getLangue());

				}
				logger.info("pojos1_langues : {} ", pojos1_langues);
				List<String> missing1 = globalLanguesLocal.stream().filter(item -> pojos1_langues.indexOf(item) < 0)
						.collect(Collectors.toList());
				logger.info("missingLanguage de 1 : {} ", missing1);
				if (missing1.size() > 0) {
					for (int k = 0; k < missing1.size(); k++) {
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("field_value", dbData.get(i).getField_value());
						logger.info("missing1_langues : {} ", missing1.get(k));
						jsonObj.put("langue", missing1.get(k));
						missingLang.put(jsonObj);

					}
				}

			}

		}

		if (size <= 0 || page <= 0) {
			throw new IllegalArgumentException("invalid page size: " + size);
		}
		int fromIndex = (page - 1) * size;

		logger.info("missing_lang : {} ", missingLang);
		HashMap<Object, Object> data = new HashMap<Object, Object>();
		data.put("arrayString", arrayString.subList(fromIndex, Math.min(fromIndex + size, arrayString.size())));
		data.put("db_data", dbData);
		data.put("db1_data", db1Data);
		data.put("missing", missing);
		data.put("missing_lang", missingLang.toList());
		data.put("count", count);
		logger.info("data hasmap : {} ", data);

		return data;
	}

	/**
	 * Name type column data json.
	 *
	 * @param nameTable      the name table
	 * @param selectedColumn the selected column
	 * @param json           the json
	 * @return the JSON array
	 */
	@Override
	public JSONArray nameTypeColumnDatajson(String nameTable, String selectedColumn, Boolean json) {
		String abacus = "TABLE_ABACUS_NAME";
		String valueJson = "VALUE_JSON";
		var l = dao.getTableData(nameTable);
		var tables = JSON.toJSONString(l);
		JSONArray jsonarray = new JSONArray();
		JSONArray jsonArray = new JSONArray(tables);
		List<String> tabColumnStrings = translationRepository.TablesColumns(nameTable);
		int columnIndex = tabColumnStrings.indexOf(selectedColumn);
		int abacusNameColumnIndex = tabColumnStrings.indexOf(abacus);
		List<String> abacusJsonArray = new ArrayList<>();
		List<String> abacusJsonArrayNoDup = new ArrayList<>();
		if (abacusNameColumnIndex != -1) {
			for (int i = 0; i < jsonArray.length(); i++) {

				abacusJsonArray.add(((JSONArray) jsonArray.get(i)).get(abacusNameColumnIndex).toString());
			}
			Set<String> set = new HashSet<>(abacusJsonArray);
			abacusJsonArrayNoDup.addAll(set);

		}

		for (int i = 0; i < abacusJsonArrayNoDup.size(); i++) {
			for (int j = 0; j < jsonArray.length(); j++) {
				if (((JSONArray) jsonArray.get(j)).get(abacusNameColumnIndex) == abacusJsonArrayNoDup.get(i)) {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put(abacus, abacusJsonArrayNoDup.get(i));
					jsonObj.put(valueJson, ((JSONArray) jsonArray.get(j)).get(columnIndex));
					jsonarray.put(jsonObj);

				}

			}
		}
		logger.info("jsonarray : {} ", jsonarray);
		JSONArray lastArray = new JSONArray();

		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonObj = jsonarray.getJSONObject(i);
			String value = jsonObj.getString(valueJson);
			String value1 = jsonObj.getString(abacus);
			logger.info("value : [{}]", value1);
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = new JSONObject();

			try {
				org.json.simple.JSONObject jsonObj1 = (org.json.simple.JSONObject) parser.parse(value);
				logger.info("key : {} ", jsonObj1.keySet());
				jsonObject.put(abacus, value1);
				jsonObject.put(valueJson, jsonObj1.keySet());
				lastArray.put(jsonObject);

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		logger.info("last_array : {} ", lastArray);

		List<String> arrayString = new ArrayList<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			arrayString.add(((JSONArray) jsonArray.get(i)).get(columnIndex).toString());

		}
		return lastArray;

	}

	@Override
	public JSONArray select1(String nameTable, String selectedColumn, Boolean json, String column) {
		String abacus = "TABLE_ABACUS_NAME";
		String valueJson = "VALUE_JSON";
		var l = dao.getTableData(nameTable);
		var tables = JSON.toJSONString(l);
		JSONArray jsonArray = new JSONArray(tables);
		logger.info("jsonArray : {}", jsonArray);
		List<String> tabColumnStrings = translationRepository.TablesColumns(nameTable);
		int columnIndex = tabColumnStrings.indexOf(selectedColumn);
		logger.info("columnIndex : {}", columnIndex);
		int abacusNameColumnIndex = tabColumnStrings.indexOf(abacus);
		logger.info("abacusNameColumnIndex : {}", abacusNameColumnIndex);
		JSONArray selectarray = new JSONArray();
		logger.info("column : {}", column);
		String result = column.substring(1, column.length() - 1);
		logger.info("result : {}", result);
		if (abacusNameColumnIndex != -1) {
			for (int i = 0; i < jsonArray.length(); i++) {
				if (((JSONArray) jsonArray.get(i)).get(abacusNameColumnIndex).equals(result)) {
					logger.info("true");
					JSONObject jsonObj = new JSONObject();
					jsonObj.put(abacus, ((JSONArray) jsonArray.get(i)).get(abacusNameColumnIndex));
					String ts = ((String) ((JSONArray) jsonArray.get(i)).get(columnIndex))
							.replaceAll("(\\r\\n|\\n|\\r)", "");
					;
					Map<String, Object> jsonObject = U.fromJsonMap(ts);
					logger.info("jsonObject : {}", jsonObject);
					jsonObj.put(valueJson, jsonObject);
					selectarray.put(jsonObj);

				}

			}

		}
		logger.info("selectarray : {}", selectarray.toList());

		return selectarray;
	}

	@Override
	public HashMap<Object, Object> select2(String nameTable, String selectedColumn, Boolean json, ColumnsDTO Columns,
			int page, int size) {
		String abacus = "TABLE_ABACUS_NAME";
		String valueJson = "VALUE_JSON";
		JSONArray selectarray = select1(nameTable, selectedColumn, json, '"' + Columns.getColumn() + '"');
		logger.info("columns.getColumn() : {}", '"' + Columns.getColumn() + '"');
		logger.info("selectarray : {}", selectarray);
		JSONArray lastArray = nameTypeColumnDatajson(nameTable, selectedColumn, json);
		List<String> select2Array = new ArrayList<>();

		for (int i = 0; i < lastArray.length(); i++) {
			JSONObject jsonObj = lastArray.getJSONObject(i);
			logger.info("jsonObj :{} ", jsonObj.get(abacus));

			if (jsonObj.get(abacus).equals(Columns.getColumn())) {
				logger.info("true ");
				Object columns = jsonObj.get(valueJson);
				logger.info("columns :{} ", columns);

			} else {
				logger.info("false ");
				logger.info("columns.getColumn() : {} ", Columns.getColumn());
				logger.info("jsonObj :{} ", jsonObj);

			}

		}

		logger.info("selectarray : {}", selectarray.length());
		for (int i = 0; i < selectarray.length(); i++) {
			JSONObject jsonObj = selectarray.getJSONObject(i);
			logger.info("jsonObj :{} ", jsonObj.get(valueJson));
			String o = jsonObj.get(valueJson).toString();
			logger.info("object :{} ", o);
			JSONObject json1 = new JSONObject(o);
			logger.info("json1 :{} ", json1.get(Columns.getCol()));
			select2Array.add((String) json1.get(Columns.getCol()));

		}
		logger.info("select2Array :{} ", select2Array);
		int count = select2Array.size();
		List<Translation> array_translation_values = translationRepository.findAll();
		List<Translation> db_data_json = new ArrayList<>();
		for (int i = 0; i < array_translation_values.size(); i++) {
			if (array_translation_values.get(i).getName_table().equals(nameTable)) {
				db_data_json.add(array_translation_values.get(i));

			} else {
				logger.info("no translation found for this table");
			}

		}
		logger.info("db_data_json :{} ", db_data_json);
		List<String> db1_data_json = new ArrayList<>();
		for (int i = 0; i < db_data_json.size(); i++) {
			if (select2Array.contains(db_data_json.get(i).getField_value())) {
				logger.info("it contains true");
				db1_data_json.add(db_data_json.get(i).getField_value());
			}
		}
		logger.info("db1_data_json : {} ", db1_data_json);
		List<String> missing = select2Array.stream().filter(item -> db1_data_json.indexOf(item) < 0)
				.collect(Collectors.toList());
		missing = missing.stream().distinct().collect(Collectors.toList());
		logger.info("missing : {} ", missing);
		List<Languages> langues = languageRepository.findAll();
		List<Languages> globalLangues = new ArrayList<>();
		List<String> globalLanguesLocal = new ArrayList<>();
		List<Langues> translationsLangues = new ArrayList<>();
		for (int i = 0; i < langues.size(); i++) {
			if (Boolean.TRUE.equals(langues.get(i).getGlobal())) {
				globalLangues.add(langues.get(i));
				globalLanguesLocal.add(langues.get(i).getLocale());

			}
		}
		logger.info("global_langues size : {} ", globalLangues.size());
		JSONArray missingLang = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < db_data_json.size(); i++) {
			translationsLangues.addAll(db_data_json.get(i).getTranslations());
			List<Langues> pojos = mapper.convertValue(translationsLangues, new TypeReference<List<Langues>>() {
			});
			for (int j = 0; j < globalLangues.size(); j++) {
				String test = globalLangues.get(j).getLocale();

				boolean isPresent = pojos.stream().anyMatch(x -> x.getLangue().equals(test));
				if (isPresent) {
					logger.info(": {} ", j);
				} else {
					logger.info("false : {} ", j);
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("field_value", db_data_json.get(i).getField_value());
					jsonObj.put("langue", test);
					missingLang.put(jsonObj);
				}
			}
			logger.info("pojos size : {} ", pojos.size());
		}

		for (int i = 0; i < db_data_json.size(); i++) {
			if (db_data_json.get(i).getSelected_column().equals(selectedColumn)) {
				List<Langues> translationsLanguess = new ArrayList<>();
				List<Langues> pojos1 = new ArrayList<>();
				List<String> pojos1_langues = new ArrayList<>();
				logger.info("same selected column : {} ", db_data_json.get(i).getTranslations());
				translationsLanguess.addAll(db_data_json.get(i).getTranslations());
				pojos1 = mapper.convertValue(db_data_json.get(i).getTranslations(), new TypeReference<List<Langues>>() {

				});
				for (int j = 0; j < pojos1.size(); j++) {
					logger.info("pojos1 de : {} ", pojos1.get(j).getLangue());
					pojos1_langues.add(pojos1.get(j).getLangue());

				}
				logger.info("pojos1_langues : {} ", pojos1_langues);
				List<String> missing1 = globalLanguesLocal.stream().filter(item -> pojos1_langues.indexOf(item) < 0)
						.collect(Collectors.toList());
				logger.info("missingLanguage de 1 : {} ", missing1);
				if (missing1.size() > 0) {
					for (int k = 0; k < missing1.size(); k++) {
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("field_value", db_data_json.get(i).getField_value());
						logger.info("missing1_langues : {} ", missing1.get(k));
						jsonObj.put("langue", missing1.get(k));
						missingLang.put(jsonObj);

					}
				}

			}

		}

		if (size <= 0 || page <= 0) {
			throw new IllegalArgumentException("invalid page size: " + size);
		}
		int fromIndex = (page - 1) * size;
		logger.info("translations_langues size : {} ", translationsLangues.size());
		logger.info("missing_lang : {} ", missingLang);
		HashMap<Object, Object> data = new HashMap<>();
		data.put("select2_array", select2Array.subList(fromIndex, Math.min(fromIndex + size, select2Array.size())));
		data.put("db_data_json", db_data_json);
		data.put("db1_data_json", db1_data_json);
		data.put("missing", missing);
		data.put("missing_lang", missingLang.toList());
		data.put("count", count);
		logger.info("data hasmap : {} ", data);

		return data;

	}

	@Override
	public List<String> AutocompleteTranslation(String langue, String value) {
		List<Languages> langues = languageRepository.findAll();
		List<Translation> translations = translationRepository.findAll();
		List<Languages> globalLangues = new ArrayList<>();
		for (int i = 0; i < langues.size(); i++) {
			if (Boolean.TRUE.equals(langues.get(i).getGlobal())) {
				globalLangues.add(langues.get(i));
			}
		}
		logger.info("global_langues size : {} ", globalLangues.size());
		List<Langues> translationsLangues = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		List<Langues> translations_langues = new ArrayList<>();
		for (int i = 0; i < translations.size(); i++) {
			logger.info("translations : {} ", translations.get(i).getTranslations());
			translationsLangues.addAll(translations.get(i).getTranslations());
			translations_langues = mapper.convertValue(translationsLangues, new TypeReference<List<Langues>>() {
			});

		}
		logger.info("global_langues size : {} ", globalLangues.size());
		logger.info("translationsLangues size : {} ", translationsLangues);
		List<String> translations_values = new ArrayList<>();
		for (int i = 0; i < translations_langues.size(); i++) {
			for (int j = 0; j < globalLangues.size(); j++) {

				logger.info("translationsLangues languess : {} ", translations_langues.get(i).getValue());
				if (translations_langues.get(i).getLangue().equals(langue)) {
					logger.info("true");
					translations_values.add(translations_langues.get(i).getValue());

				} else
					logger.info("false");

			}
		}
		logger.info("translations_values : {} ", translations_values);
		List<String> translations_values_no_dup = new ArrayList<>();
		Set<String> set = new HashSet<>(translations_values);
		translations_values_no_dup.addAll(set);
		logger.info("translations_values_no_dup : {} ", translations_values_no_dup);
		List<String> filtered_translations = new ArrayList<>();

		for (int i = 0; i < translations_values_no_dup.size(); i++) {
			if (translations_values_no_dup.get(i).indexOf(value) >= 0) {
				logger.info("value found");
				filtered_translations.add(translations_values_no_dup.get(i));

			}
		}
		logger.info("filtered_translations : {} ", filtered_translations);

		return filtered_translations;
	}

	@Override
	public List<String> get_Values_FromSelectedLang(String nameTable, String selectedColumn, String langue) {
		List<Translation> arrayTranslation = translationRepository.findAll();
		ObjectMapper mapper = new ObjectMapper();
		List<Langues> translations_langues = new ArrayList<>();
		List<Langues> arrayTranslation_langues = new ArrayList<>();
		for (int i = 0; i < arrayTranslation.size(); i++) {
			if (arrayTranslation.get(i).getName_table().equals(nameTable)
					&& arrayTranslation.get(i).getSelected_column().equals(selectedColumn)) {
				logger.info("true ");
				arrayTranslation_langues.addAll(arrayTranslation.get(i).getTranslations());
				translations_langues = mapper.convertValue(arrayTranslation_langues,
						new TypeReference<List<Langues>>() {

						});
			}
		}
		logger.info("translations_langues : {} ", translations_langues);
		List<String> translation_values = new ArrayList<>();
		for (int i = 0; i < translations_langues.size(); i++) {
			if (translations_langues.get(i).getLangue().equals(langue)) {
				translation_values.add(translations_langues.get(i).getValue());
			}
		}
		logger.info("translation_values : {} ", translation_values);

		return translation_values;

	}

	@Override
	public void readDocxFile(String path) {
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);
			List<XWPFParagraph> paragraphs = document.getParagraphs();
			for (XWPFParagraph para : paragraphs) {
				System.out.println(para.getText());
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
