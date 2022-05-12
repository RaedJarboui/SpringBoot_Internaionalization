package com.translate.dto;

import java.io.Serializable;
import java.util.List;

import com.translate.entity.TableList;

public class TableListPaginationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8345351315298264981L;

	private Integer pageNumber;
	private Integer pageSize;
	private TableList params;
	private String sortDirection;
	private String sortField;
	private Integer totalPages;
	private long totalElements;
	private List<TableList> tab_list;

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

	public TableList getParams() {
		return params;
	}

	public void setParams(TableList params) {
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

	public List<TableList> getTab_list() {
		return tab_list;
	}

	public void setTab_list(List<TableList> tab_list) {
		this.tab_list = tab_list;
	}

}
