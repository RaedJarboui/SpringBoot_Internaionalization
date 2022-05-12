/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service;

import java.util.List;

import com.translate.dto.TableListPaginationDTO;
import com.translate.entity.TableList;

/**
 * 
 * {@link TableListService} class.
 *
 * @author Mr Raed
 * @since 0.0.1
 *
 */
public interface TableListService {

	/**
	 * List table.
	 *
	 * @return the list
	 */
	public List<String> listTable();

	/**
	 * List tables.
	 *
	 * @param page the page
	 * @param size the size
	 * @return the list
	 */
	public List<TableList> listTablesPaginated(int page, int size);

	/**
	 * List tables from DB.
	 *
	 * @return the list
	 */
	public List<TableList> listTablesFromDB();

	/**
	 * Adds the list table.
	 *
	 * @param l the l
	 */
	public void addListTable(List<TableList> l);

	/**
	 * Table list.
	 *
	 * @return the list
	 */
	public List<TableList> tableList();

	/**
	 * Edits the table list.
	 *
	 * @param id the id
	 * @param t  the t
	 * @return the table list
	 */
	public TableList editTableList(int id, TableList t);

	public TableListPaginationDTO find(TableListPaginationDTO languagesPaginationDTO);

}
