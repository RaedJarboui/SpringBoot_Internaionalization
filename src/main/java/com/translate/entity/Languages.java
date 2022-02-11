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
	public Long id;
	@Column(name = "name")

	private String name;
	@Column(name = "description")

	private String description;
	@Column(name = "locale")
	String locale;

	/**
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {

		this.description = description;
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

}
