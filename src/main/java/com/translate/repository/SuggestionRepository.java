package com.translate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.translate.entity.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
	@Query("select s.text from Suggestion s where s.text like :text%")
	List<String> findAllByText(@Param("text") String text);

}
