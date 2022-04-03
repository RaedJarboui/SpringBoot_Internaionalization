package com.translate.service;

import java.util.List;

import com.translate.entity.Languages;

public interface LanguagesService {
	public List<Languages> getAllLanguages();

	public Languages addLanguage(Languages l);

	public void deleteLanguage(int id);

	public Languages editLanguage(int id, Languages l);

}
