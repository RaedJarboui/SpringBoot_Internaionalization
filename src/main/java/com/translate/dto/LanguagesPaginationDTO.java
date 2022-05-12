package com.translate.dto;

import java.io.Serializable;
import java.util.List;

import com.translate.entity.Languages;

public class LanguagesPaginationDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4582320322428761212L;
	private Integer pageNumber;
	private Integer pageSize;
	private Languages params;
	private String sortDirection;
	private String sortField;
	private Integer totalPages;
	private long totalElements;
	private List<Languages> languages;

	public List<Languages> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Languages> languages) {
		this.languages = languages;
	}

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

	public Languages getParams() {
		return params;
	}

	public void setParams(Languages params) {
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

}
