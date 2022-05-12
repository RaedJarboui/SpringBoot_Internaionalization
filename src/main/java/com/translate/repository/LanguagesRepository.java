/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.translate.entity.Languages;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Integer>, QuerydslPredicateExecutor<Languages>,
		CrudRepository<Languages, Integer>, PagingAndSortingRepository<Languages, Integer> {

	Page findAll(Specification<Languages> specs, Pageable pageable);

}
