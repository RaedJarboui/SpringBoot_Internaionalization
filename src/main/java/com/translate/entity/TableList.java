/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Entity
@Table(name = "TableList")
public class TableList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 438878357977316984L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int id;
	@Column(name = "name_table")
	String tableName;
	@Column(name = "translate")
	private Boolean translate;

	public TableList() {

		super();
	}

	public TableList(String tableName, Boolean translate) {

		this.tableName = tableName;
		this.translate = translate;
	}

	/**
	 * @return the id
	 */
	public int getId() {

		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {

		this.id = id;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {

		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {

		this.tableName = tableName;
	}

	/**
	 * @return the translate
	 */
	public Boolean getTranslate() {

		return translate;
	}

	/**
	 * @param translate the translate to set
	 */
	public void setTranslate(Boolean translate) {

		this.translate = translate;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {

		return serialVersionUID;
	}

}
