/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.translate.entity.Langues;
import com.translate.entity.Translation;
import com.translate.repository.TranslationRepository;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class TranslationService {
	@Autowired
	TranslationRepository translationRepository;

	public List<Translation> jsonArrayToObjectList() {

		List<Translation> arrayTranslations = translationRepository.findAll();

		List<Translation> translations = new ArrayList<>();
		for (int i = 0; i < arrayTranslations.size(); i++) {

			translations.add(arrayTranslations.get(i));

		}
		return translations;

	}

	public Translation getTranslationByColumn(Translation t, Long id) {

		List<Translation> arrayTranslations = translationRepository.findAll();
		boolean found = false;
		Translation translation = new Translation();

		for (int i = 0; i < arrayTranslations.size(); i++) {
			if (arrayTranslations.get(i).getObject_id() == id
					&& arrayTranslations.get(i).getName_table().equals(t.getName_table())
					&& arrayTranslations.get(i).getSelected_column()
							.equals((t.getSelected_column()))) {
				found = true;
				System.out.println("element found");
				System.out.println(arrayTranslations.get(i));
				translation.setName_table(arrayTranslations.get(i).getName_table());
				translation.setObject_id(id);
				translation.setSelected_column(arrayTranslations.get(i).getSelected_column());
				translation.setTranslations(arrayTranslations.get(i).getTranslations());
				break;
			}
			else {
				found = false;

			}

		}
		if (found) {
			// System.out.println("element found");
			return translation;
		}
		else
			System.out.println("element not found");
		return null;

	}

	public void editTranslation(Translation t, Long id) {

		List<Translation> arrayTranslations = translationRepository.findAll();
		boolean found = false;
		for (int i = 0; i < arrayTranslations.size(); i++) {
			if (arrayTranslations.get(i).getObject_id() == id
					&& arrayTranslations.get(i).getName_table().equals(t.getName_table())
					&& arrayTranslations.get(i).getSelected_column()
							.equals((t.getSelected_column()))) {
				found = true;
				arrayTranslations.get(i).setName_table(t.getName_table());
				arrayTranslations.get(i).setObject_id(id);
				arrayTranslations.get(i).setSelected_column(t.getSelected_column());
				arrayTranslations.get(i).setTranslations(t.getTranslations());
				translationRepository.save(arrayTranslations.get(i));
				break;

			}
			else {
				found = false;
				System.out.println("false");

			}

		}
		if (!found) {

			System.out.println("element not found");

		}

	}

	public void addTranslation(Translation t) throws JsonMappingException, JsonProcessingException {

		List<Translation> arrayTranslations = translationRepository.findAll();

		boolean found = false;

		if (arrayTranslations.size() == 0) {
			translationRepository.save(t);
			System.out.println("size 0");

		}
		else {
			System.out.println("size not 0");

			for (Translation ts : arrayTranslations) {
				if (ts.getObject_id() == t.getObject_id()) {
					if (ts.getSelected_column().equals(t.getSelected_column())) {
						found = true;
						List<Langues> langues = ts.getTranslations();
						langues.addAll(t.getTranslations());
						translationRepository.save(ts);
						break; // Break out of the loop to skip the remaining items
					}
				}
			}

		}
		if (found) {
			System.out.println("found");

		}
		else {
			System.out.println("not found");

			translationRepository.save(t);

		}

	}

	public List<Translation> getAllTranslation() {

		return translationRepository.findAll();
	}

	public Translation getTranslationById(Long id) {

		return translationRepository.findById(id).get();
	}

}
