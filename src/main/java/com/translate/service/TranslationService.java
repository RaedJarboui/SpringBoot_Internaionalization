/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;

import com.translate.dto.ACM_UDF_LIST_VALUESDTO;
import com.translate.dto.ColumnsDTO;
import com.translate.dto.TranslationPaginationDTO;
import com.translate.entity.Translation;

/**
 * 
 * {@link TranslationService} class.
 *
 * @author Mr Raed
 * @since 0.0.1
 *
 */
public interface TranslationService {

	/**
	 * Json array to object list.
	 *
	 * @return the list
	 */
	public List<Translation> jsonArrayToObjectList();

	/**
	 * List tables.
	 *
	 * @return the list
	 */
	public List<String> listTables();

	/**
	 * Columns tables type.
	 *
	 * @param value the value
	 * @return the list
	 */
	public List<String> columnsTablesType(String value);

	/**
	 * Columns tables.
	 *
	 * @param value the value
	 * @return the list
	 */
	public List<String> columnsTables(String value);

	/**
	 * Find udf list values.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<ACM_UDF_LIST_VALUESDTO> findUdfListValues(int id);

	/**
	 * Edits the translation.
	 *
	 * @param fieldvalue          the fieldvalue
	 * @param column              the column
	 * @param tableName           the table name
	 * @param tblabacusName       the tblabacus name
	 * @param tblabacusNameColumn the tblabacus name column
	 * @param t                   the t
	 */
	public void editTranslation(String fieldvalue, String column, String tableName, String tblabacusName,
			String tblabacusNameColumn, Translation t);

	/**
	 * Adds the translation.
	 *
	 * @param t the t
	 */
	public void addTranslation(Translation t);

	/**
	 * Gets the all translation.
	 *
	 * @return the all translation
	 */
	public List<Translation> getAllTranslation();

	/**
	 * Gets the translation by id.
	 *
	 * @param id the id
	 * @return the translation by id
	 */
	public Translation getTranslationById(Long id);

	/**
	 * Name type column.
	 *
	 * @param nameTable the name table
	 * @return the string
	 */
	public String nameTypeColumn(String nameTable);

	/**
	 * Name col type.
	 *
	 * @param nameTable      the name table
	 * @param selectedColumn the selected column
	 * @param json           the json
	 * @param page           the page
	 * @param size           the size
	 * @return the hash map
	 */
	public HashMap<Object, Object> nameColType(String nameTable, String selectedColumn, Boolean json, int page,
			int size);

	/**
	 * Name type column datajson.
	 *
	 * @param nameTable      the name table
	 * @param selectedColumn the selected column
	 * @param json           the json
	 * @return the JSON array
	 */
	public JSONArray nameTypeColumnDatajson(String nameTable, String selectedColumn, Boolean json);

	/**
	 * Columndatajson.
	 *
	 * @param nameTable      the name table
	 * @param selectedColumn the selected column
	 * @param json           the json
	 * @param column         the column
	 * @return the JSON array
	 */
	public JSONArray select1(String nameTable, String selectedColumn, Boolean json, String column);

	/**
	 * Select 2.
	 *
	 * @param nameTable      the name table
	 * @param selectedColumn the selected column
	 * @param json           the json
	 * @param columns        the columns
	 * @param page           the page
	 * @param size           the size
	 * @return the JSON array
	 */
	public HashMap<Object, Object> select2(String nameTable, String selectedColumn, Boolean json, ColumnsDTO columns,
			int page, int size);

	/**
	 * Autocomplete translation.
	 *
	 * @param langue the langue
	 * @param value  the value
	 * @return the list
	 */
	public List<String> AutocompleteTranslation(String langue, String value);

	/**
	 * Gets the values from selected lang.
	 *
	 * @param nameTable      the name table
	 * @param selectedColumn the selected column
	 * @param langue         the langue
	 * @return the values from selected lang
	 */
	public List<String> get_Values_FromSelectedLang(String nameTable, String selectedColumn, String langue);

	/**
	 * Read docx file.
	 *
	 * @param path the path
	 * @return the string
	 */
	public String readDocxFile(String path);

	/**
	 * Translate text.
	 *
	 * @param langFrom the lang from
	 * @param langTo   the lang to
	 * @param text     the text
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String TranslateText(String langFrom, String langTo, String text) throws IOException;

	/**
	 * Find.
	 *
	 * @param translationPaginationDTO the translation pagination DTO
	 * @return the translation pagination DTO
	 */
	public TranslationPaginationDTO find(TranslationPaginationDTO translationPaginationDTO);

}
