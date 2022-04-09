package com.translate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suggestion")
public class Suggestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4621172225426924873L;

	@Id
	@GeneratedValue
	@Column(name = "text_id")
	public Long id;
	@Column(name = "text")
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
