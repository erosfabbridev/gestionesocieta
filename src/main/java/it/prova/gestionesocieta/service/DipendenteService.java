package it.prova.gestionesocieta.service;

import java.util.List;

import it.prova.gestionesocieta.model.Dipendente;

public interface DipendenteService {
	public List<Dipendente> listAllDipendenti();

	public Dipendente caricaSingoloDipendente(Long id);

	public void aggiorna(Dipendente dipendenteInstance);

	public void inserisciNuovo(Dipendente dipendenteInstance);

	public void rimuovi(Dipendente dipendenteInstance);

	public List<Dipendente> findByExample(Dipendente example);
	
	public List<Dipendente> findByNome(String nameInput);
	
	public List<Dipendente> cercaAbitantiPerNomeAndCognome(String nomeInput, int etaInput);
	
	public List<Dipendente> cercaPerNomeCheIniziaCon(String tokenIniziale);
	
	public List<Dipendente> cercaPerCognomeEager(String cognomeInput);
}
