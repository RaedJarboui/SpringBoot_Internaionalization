/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void addTranslation(Translation t) {
		// cas1 : if objectId is the same :if list lang de t size =1, if language is same don't add
		// to list
		// cas2 : if objectId is the same :if lang de t size >1 compare with others translation
		// language
		// cas3 : if objectId not the same , add translation t

		List<Translation> arrayTranslations = translationRepository.findAll();
		boolean found = false;

		if (arrayTranslations.size() == 0) {
			translationRepository.save(t);

		}
		else if (arrayTranslations.size() > 0) {

			for (int i = 0; i < arrayTranslations.size(); i++) {
				/*
				 * for (int j = 0; j < arrayTranslations.get(i).getTranslations().size(); j++) { }
				 */
				if (arrayTranslations.get(i).getObject_id() == t.getObject_id() && arrayTranslations
						.get(i).getSelected_column() == t.getSelected_column()) {
					found = true;
					List<Langues> langues = arrayTranslations.get(i).getTranslations();
					langues.addAll(t.getTranslations());
					System.out.println("true ");
					/*
					 * for (int k = 0; k < t.getTranslations().size(); k++) { // System.out.println(
					 * // arrayTranslations.get(i).getTranslations().get(j).getLangue()); found =
					 * true; }
					 */

				}
				else if (arrayTranslations.get(i).getObject_id() == t.getObject_id()
						&& arrayTranslations.get(i).getSelected_column() != t
								.getSelected_column()) {
					translationRepository.save(t);

				}
				else {
					System.out.println("false ");

					found = false;
				}

				if (found) {
					System.out.println("this langue not existed ");
					translationRepository.save(arrayTranslations.get(i));

					// translationRepository.save(arrayTranslations.get(i));

				}
				else
					System.out.println("this langue exists already");
			}
		}

	}

	public List<Translation> getAllTranslation() {

		List<Translation> arrayTranslations = translationRepository.findAll();
		for (int i = 0; i < arrayTranslations.size(); i++) {
			// System.out.println(i);
			// System.out.println(arrayTranslations.get(i).getTranslations());
			for (int j = 0; j < arrayTranslations.get(i).getTranslations().size(); j++) {
				// System.out.println(arrayTranslations.get(i).getTranslations().get(j).getLangue());
			}
		}

		return translationRepository.findAll();
	}

	public Translation getTranslationById(Long id) {

		return translationRepository.findById(id).get();
	}

}
