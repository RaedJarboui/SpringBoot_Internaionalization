/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Entity
@Table(name = "i18n")
public class i18n implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8775568707248550987L;
	@Id
	@GeneratedValue
	@Column(name = "i18n_ID")
	public Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")

	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "i18n_id")
	private List<Languages> languages = new ArrayList<>();

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

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * @return the languages
	 */
	public List<Languages> getLanguages() {

		return languages;
	}

	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(List<Languages> languages) {

		this.languages = languages;
	}

}
