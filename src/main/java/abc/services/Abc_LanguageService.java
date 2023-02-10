package abc.services;

import abc.dao.IAbc_Language;
import abc.entities.Abc_Language;

import java.util.List;

import abc.controller.Abc_LanguageController;

public class Abc_LanguageService 
{
	IAbc_Language Abc_LanguageController;
	
	public Abc_LanguageService()
	{
		Abc_LanguageController = new Abc_LanguageController();
	}
	
	public List<Abc_Language> getAllLanguages()
	{
		return Abc_LanguageController.get();
	}
}
