package com.translate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.repository.SuggestionRepository;
import com.translate.service.SuggestionService;

@Service
public class SuggestionImpl implements SuggestionService {
	@Autowired
	SuggestionRepository suggestionRepository;

	@Override
	public List<String> findAllByText(String text) {
		return suggestionRepository.findAllByText(text);
	}

}
