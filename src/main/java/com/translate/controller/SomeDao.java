/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Component
public class SomeDao {
	@Autowired
	EntityManager em;

	public List<JSONObject> getTableData(String tableName) {

		String s = "select * from (%s)";
		String sql = String.format(s, tableName);

		return em.createNativeQuery(sql).getResultList();
		
	}

}
