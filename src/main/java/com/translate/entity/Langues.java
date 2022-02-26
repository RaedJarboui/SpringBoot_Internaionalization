/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.entity;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */

public class Langues implements Serializable {

	@Column(name = "langue")
	private String langue;
	@Column(name = "value")
	private String value;

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
