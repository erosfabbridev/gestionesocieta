package it.prova.gestionesocieta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.SocietaRepository;

@Service
public class SocietaServiceImpl implements SocietaService{
	
	@Autowired
	private SocietaRepository societaRepository ;

	@Transactional(readOnly = true)
	public List<Societa> listAllSocieta() {
		return (List<Societa>) societaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Societa caricaSingoloSocieta(Long id) {
		return societaRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Societa societaInstance) {
		societaRepository.save(societaInstance);
	}

	@Transactional
	public void inserisciNuova(Societa societaInstance) {
		societaRepository.save(societaInstance);
	}

	@Transactional
	public void rimuovi(Societa societaInstance) {
		societaRepository.delete(societaInstance);
	}

	@Transactional(readOnly = true)
	public List<Societa> findByExample(Societa example)   {
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING); 
		return (List<Societa>) societaRepository.findAll(Example.of(example, matcher));
	}

	@Transactional(readOnly = true)
	public Societa findAllEager() {
		
		return (Societa) societaRepository.findAllEager();
	}




}
