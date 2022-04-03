package com.translate.dto;

import java.io.Serializable;

public class TableListDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2566171741954821860L;
	public int id;
	String tableName;
	private Boolean translate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Boolean getTranslate() {
		return translate;
	}

	public void setTranslate(Boolean translate) {
		this.translate = translate;
	}

}
