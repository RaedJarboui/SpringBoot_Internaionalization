/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class TranslationDTO.
 */
public class TranslationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4939079428583136581L;
	public Long id;
	private String name_table;
	private String field_value;
	private String selected_column;
	private List<LanguesDTO> translations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_table() {
		return name_table;
	}

	public void setName_table(String name_table) {
		this.name_table = name_table;
	}

	public String getField_value() {
		return field_value;
	}

	public void setField_value(String field_value) {
		this.field_value = field_value;
	}

	public String getSelected_column() {
		return selected_column;
	}

	public void setSelected_column(String selected_column) {
		this.selected_column = selected_column;
	}

	public List<LanguesDTO> getTranslations() {
		return translations;
	}

	public void setTranslations(List<LanguesDTO> translations) {
		this.translations = translations;
	}

}
