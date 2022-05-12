package com.translate.service;

import java.util.List;
import java.util.Optional;

import com.translate.dto.LanguagesPaginationDTO;
import com.translate.entity.Languages;

public interface LanguagesService {
	public List<Languages> getAllLanguages();

	public List<Languages> getPageableLanguages(int page, int size);

	public Languages addLanguage(Languages l);

	public void deleteLanguage(int id);

	public Languages editLanguage(int id, Languages l);

	public Optional<Languages> FindLanguageById(int id);

	public List<Languages> search(String searchString, int pageIndex, int pageSize, int sort);

	public LanguagesPaginationDTO find(LanguagesPaginationDTO languagesPaginationDTO);

}
