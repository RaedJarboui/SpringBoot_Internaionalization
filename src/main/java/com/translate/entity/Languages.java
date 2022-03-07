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
@Table(name = "Languages")
public class Languages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4609732778002731756L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int id;
	@Column(name = "locale")
	String locale;
	@Column(name = "language_name")
	private String LanguageName;
	@Column(name = "global")
	private Boolean global;

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
	 * @return the locale
	 */
	public String getLocale() {

		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {

		this.locale = locale;
	}

	/**
	 * @return the languageName
	 */
	public String getLanguageName() {

		return LanguageName;
	}

	/**
	 * @param languageName the languageName to set
	 */
	public void setLanguageName(String languageName) {

		LanguageName = languageName;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {

		return serialVersionUID;
	}

	/**
	 * @return the global
	 */
	public Boolean getGlobal() {

		return global;
	}

	/**
	 * @param global the global to set
	 */
	public void setGlobal(Boolean global) {

		this.global = global;
	}

}
