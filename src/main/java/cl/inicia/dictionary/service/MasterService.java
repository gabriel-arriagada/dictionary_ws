package cl.inicia.dictionary.service;

import java.util.List;

import cl.inicia.dictionary.domain.Word;

public interface MasterService {
	public abstract List<Word> getAll(String username);	
}
