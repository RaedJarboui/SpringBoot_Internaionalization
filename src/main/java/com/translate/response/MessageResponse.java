/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.response;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
public class MessageResponse {
	private String message;

	public MessageResponse(String message) {

		this.message = message;
	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

}
