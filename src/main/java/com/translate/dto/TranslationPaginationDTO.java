package com.translate.dto;

import java.io.Serializable;
import java.util.List;

import com.translate.entity.Translation;

public class TranslationPaginationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5004330270820654038L;
	private Integer pageNumber;
	private Integer pageSize;
	private Translation params;
	private String sortDirection;
	private String sortField;
	private Integer totalPages;
	private long totalElements;
	private List<Translation> translations;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Translation getParams() {
		return params;
	}

	public void setParams(Translation params) {
		this.params = params;
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}

}
