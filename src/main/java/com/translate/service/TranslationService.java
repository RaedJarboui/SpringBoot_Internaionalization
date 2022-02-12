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

	public void addTranslation(Translation t) throws JsonMappingException, JsonProcessingException {

		List<Translation> arrayTranslations = translationRepository.findAll();
		// List<Translation> translations = jsonArrayToObjectList();

		boolean found = false;
		// boolean found1 = true;

		if (arrayTranslations.size() == 0) {
			translationRepository.save(t);
			System.out.println("size 0");

		}
		else {
			System.out.println("size not 0");

			// for (int i = 0; i < arrayTranslations.size(); i++) {

			// if (arrayTranslations.get(i).getObject_id() == t.getObject_id()) {
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

			/*
			 * if (arrayTranslations.get(i).getSelected_column() .contains(t.getSelected_column()))
			 * { found = true; System.out.println("found"); System.out.println(i); List<Langues>
			 * langues = arrayTranslations.get(i).getTranslations();
			 * langues.addAll(t.getTranslations()); break; }
			 */

		}
		if (found) {
			System.out.println("found");

		}
		else {
			System.out.println("not found");
			// System.out.println(i);

			translationRepository.save(t);

		}
		// }

		// }

		//

	}

	/*
	 * public void addTranslation(Translation t) { // cas1 : if objectId is the same :if list lang
	 * de t size =1, if language is same don't add // to list // cas2 : if objectId is the same :if
	 * lang de t size >1 compare with others translation // language // cas3 : if objectId not the
	 * same , add translation t List<Translation> arrayTranslations =
	 * translationRepository.findAll(); boolean found = false; if (arrayTranslations.size() == 0) {
	 * translationRepository.save(t); } else if (arrayTranslations.size() > 0) { for (int i = 0; i <
	 * arrayTranslations.size(); i++) { /* for (int j = 0; j <
	 * arrayTranslations.get(i).getTranslations().size(); j++) { }
	 */
	/*
	 * if (arrayTranslations.get(i).getObject_id() == t.getObject_id() && arrayTranslations
	 * .get(i).getSelected_column() == t.getSelected_column()) { found = true; List<Langues> langues
	 * = arrayTranslations.get(i).getTranslations(); langues.addAll(t.getTranslations());
	 * System.out.println("true "); /* for (int k = 0; k < t.getTranslations().size(); k++) { //
	 * System.out.println( // arrayTranslations.get(i).getTranslations().get(j).getLangue()); found
	 * = true; }
	 */

	/*
	 * } else if (arrayTranslations.get(i).getObject_id() == t.getObject_id() &&
	 * arrayTranslations.get(i).getSelected_column() != t .getSelected_column()) {
	 * translationRepository.save(t); } else { System.out.println("false "); found = false; } if
	 * (found) { System.out.println("this langue not existed ");
	 * translationRepository.save(arrayTranslations.get(i)); //
	 * translationRepository.save(arrayTranslations.get(i)); } else
	 * System.out.println("this langue exists already"); } } }
	 */

	public List<Translation> getAllTranslation() {

		return translationRepository.findAll();
	}

	public Translation getTranslationById(Long id) {

		return translationRepository.findById(id).get();
	}

}
