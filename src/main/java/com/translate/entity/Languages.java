package com.translate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Languages")
public class Languages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1091452757207215571L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int id;
	@Column(name = "locale")
	String locale;
	@Column(name = "global")
	Boolean global;
	@Column(name = "languageName")
	String languageName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Boolean getGlobal() {
		return global;
	}

	public void setGlobal(Boolean global) {
		this.global = global;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

}
