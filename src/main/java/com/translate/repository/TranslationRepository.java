/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.translate.entity.Translation;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long>, QuerydslPredicateExecutor<Translation>,
		CrudRepository<Translation, Long>, PagingAndSortingRepository<Translation, Long> {

	@Query(value = "select table_name from information_schema.tables where TABLE_SCHEMA='translate'", nativeQuery = true)
	public List<String> TablesList();

	@Query(value = "SELECT COLUMN_NAME,DATA_TYPE  FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA ='translate' AND TABLE_NAME =:value order by ordinal_position", nativeQuery = true)
	public List<String> TablesColumnsType(@Param("value") String value);

	@Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA ='translate' AND TABLE_NAME =:value order by ordinal_position", nativeQuery = true)
	public List<String> TablesColumns(@Param("value") String value);

	// @Query("select t.field_value from Translation t join t.translations p where
	// p.value =: value")
	@Query(value = "t.field_value from Translation t where t.translations ->> 'value' = :value", nativeQuery = true)
	public List<String> findAllByValue(@Param("value") String value);

	@Query(value = "SELECT * FROM acm_udf_list_values WHERE ID_UDF_LIST_LINK =:id", nativeQuery = true)
	public List<Object[]> find_Acm_UDF_LIST_VALUES(@Param("id") int id);

}
