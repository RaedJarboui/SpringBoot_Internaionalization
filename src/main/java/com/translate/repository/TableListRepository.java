/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.translate.entity.TableList;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Repository
public interface TableListRepository extends JpaRepository<TableList, Integer>, QuerydslPredicateExecutor<TableList>,
		CrudRepository<TableList, Integer>, PagingAndSortingRepository<TableList, Integer> {

}
