package com.translate.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.translate.service.SuggestionService;

@RestController
@CrossOrigin
public class SuggestionController {
	@Autowired
	SuggestionService suggestionService;

	private static final Logger logger = LogManager.getLogger(SuggestionController.class);

	@GetMapping("/find/suggestion/{text}")
	@ResponseBody
	public List<String> columnTypeTable(@PathVariable("text") String text) {

		return suggestionService.findAllByText(text);
	}

}
