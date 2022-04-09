/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.entity.TableList;
import com.translate.repository.TableListRepository;
import com.translate.repository.TranslationRepository;
import com.translate.service.TableListService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class TableListServiceImpl implements TableListService {
	@Autowired
	TableListRepository tableListRepository;
	@Autowired
	TranslationRepository translationRepository;

	@Override
	public List<String> listTable() {

		return translationRepository.TablesList();
	}

	@Override
	public List<TableList> listTablesPaginated(int page, int size) {
		if (size <= 0 || page <= 0) {
			throw new IllegalArgumentException("invalid page size: " + size);
		}
		int fromIndex = (page - 1) * size;
		List<TableList> tab = tableListRepository.findAll();

		return tab.subList(fromIndex, Math.min(fromIndex + size, tab.size()));
	}

	@Override
	public void addListTable(List<TableList> l) {

		tableListRepository.saveAll(l);

	}

	@Override
	public List<TableList> tableList() {

		List<TableList> list_tabList = tableListRepository.findAll();
		List<String> tableNameStrings = translationRepository.TablesList();
		boolean boolval = false;
		for (TableList tab : list_tabList) {
			for (String table : tableNameStrings) {
				boolval = tab.getTableName().equals(table);

			}

		}
		if (boolval == false) {
			System.out.println("false");
			for (String table : tableNameStrings) {
				TableList tableList = new TableList(table, false);
				list_tabList.add(tableList);
				tableListRepository.save(tableList);
			}

		} else {
			System.out.println("true");
			return null;

		}

		return list_tabList;

	}

	@Override
	public TableList editTableList(int id, TableList t) {

		TableList tab = tableListRepository.findById(id).get();
		tab.setTableName(t.getTableName());
		tab.setTranslate(t.getTranslate());
		return tableListRepository.save(tab);
	}

	@Override
	public List<TableList> listTablesFromDB() {
		return tableListRepository.findAll();
	}
}
