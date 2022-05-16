/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Entity
@Table(name = "translation")
@TypeDef(name = "json", typeClass = JsonStringType.class)

public class Translation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7602179343085972411L;
	@Id
	@GeneratedValue
	@Column(name = "translation_id")
	public Long id;
	@Column(name = "name_table")
	private String name_table;
	@Column(name = "field_value")
	private String fieldValue;
	@Column(name = "selected_column")
	private String selectedColumn;
	@Type(type = "json")
	@Column(columnDefinition = "json")
	private List<Langues> translations;

	/**
	 * @return the translations
	 */
	public List<Langues> getTranslations() {

		return translations;
	}

	/**
	 * @param translations the translations to set
	 */
	public void setTranslations(List<Langues> translations) {

		this.translations = translations;
	}

	/**
	 * @return the id
	 */
	public Long getId() {

		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * @return the name_table
	 */
	public String getName_table() {

		return name_table;
	}

	/**
	 * @param name_table the name_table to set
	 */
	public void setName_table(String name_table) {

		this.name_table = name_table;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getSelectedColumn() {
		return selectedColumn;
	}

	public void setSelectedColumn(String selectedColumn) {
		this.selectedColumn = selectedColumn;
	}

}
