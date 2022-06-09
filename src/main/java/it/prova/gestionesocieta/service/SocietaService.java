package it.prova.gestionesocieta.service;

import java.util.List;


import it.prova.gestionesocieta.model.Societa;

public interface SocietaService {

	public List<Societa> listAllSocieta() ;

	public Societa caricaSingoloSocieta(Long id);

	public void aggiorna(Societa societaInstance);

	public void inserisciNuova(Societa societaInstance);

	public void rimuovi(Societa societaInstance);

	public List<Societa> findByExample(Societa example) throws Exception;
	
	public Societa findAllEager();
}
