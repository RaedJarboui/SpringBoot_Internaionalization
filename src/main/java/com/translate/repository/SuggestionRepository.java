package com.translate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.translate.entity.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

	@Query("select s.text from Suggestion s where s.text like :text%")
	List<String> findAllByText(@Param("text") String text);

	/*
	 * @Query("select t from Translation t join t.translations b where b.value like :text%"
	 * ) List<String> findAllByText(@Param("text") String text);
	 */

	/*
	 * @Query(nativeQuery = true, value =
	 * "select t.field_value from Translation t WHERE json_value(t.translations, '$.langue') = 'en' "
	 * ) public List<String> findAllByValue(@Param("value") String value);
	 */
}
