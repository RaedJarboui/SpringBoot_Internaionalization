/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.translate.entity.TableList;
import com.translate.service.TableListService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@RestController
@CrossOrigin
public class TableListController {
	@Autowired
	TableListService tableListService;

	@GetMapping("list/tabless")
	@ResponseBody
	public List<TableList> getTablesLists() {

		return tableListService.ListTables();
	}

	@GetMapping("list/tables")
	@ResponseBody
	public List<String> getTablesList() {

		return tableListService.ListTable();
	}

	@PostMapping("list/tables")
	@ResponseBody
	public void addTablesList(@RequestBody List<TableList> l) {

		tableListService.addListTable(l);
	}

	@PutMapping("list/tables/{id}")
	@ResponseBody
	public void addTablesList(@PathVariable("id") int id, @RequestBody TableList t) {

		tableListService.editTableList(id, t);
	}

}
