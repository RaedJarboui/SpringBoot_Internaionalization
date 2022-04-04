/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Class ColumnsDTO.
 */
@AllArgsConstructor
@Data
public class ColumnsDTO {

	/** The column. */
	private String column;

	/** The col. */
	private String col;

	/**
	 * Gets the column.
	 *
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}

	/**
	 * Sets the column.
	 *
	 * @param column the new column
	 */
	public void setColumn(String column) {
		this.column = column;
	}

	/**
	 * Gets the col.
	 *
	 * @return the col
	 */
	public String getCol() {
		return col;
	}

	/**
	 * Sets the col.
	 *
	 * @param col the new col
	 */
	public void setCol(String col) {
		this.col = col;
	}

}
