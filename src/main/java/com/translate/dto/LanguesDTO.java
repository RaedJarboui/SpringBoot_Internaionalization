/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.dto;

import java.io.Serializable;

/**
 * The Class LanguesDTO.
 */
public class LanguesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1099177115391955159L;
	private String langue;
	private String value;

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
