/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Entity
@Table(name = "Langues")
public class Langues implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7310818547674347850L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "langue_id")
	public Long id;
	@Column(name = "langue")
	private String langue;
	@Column(name = "value")
	private String value;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {

		return serialVersionUID;
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
	 * @return the langue
	 */
	public String getLangue() {

		return langue;
	}

	/**
	 * @param langue the langue to set
	 */
	public void setLangue(String langue) {

		this.langue = langue;
	}

	/**
	 * @return the value
	 */
	public String getValue() {

		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {

		this.value = value;
	}

	/**
	 * @author hp
	 * @param langue2
	 */
	public void add(String langue2) {

		// TODO Auto-generated method stub

	}

}
