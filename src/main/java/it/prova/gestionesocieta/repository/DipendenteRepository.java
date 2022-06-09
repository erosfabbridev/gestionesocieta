package it.prova.gestionesocieta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionesocieta.model.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long>, QueryByExampleExecutor<Dipendente> {


	// la query viene costruita in automatico!!!
	List<Dipendente> findByNome(String name);

	// Anche questa!!!
	List<Dipendente> findByEtaGreaterThan(int etaInput);

	// Combinazione di campi!!! (Come i dynamic finders)
	List<Dipendente> findByNomeAndEta(String nome, int eta);

	// Order by!!!!
	List<Dipendente> findByEtaOrderByNomeDesc(int eta);

	// se ho necessità particolari
	@Query("from Dipendente d where d.nome like ?1%")
	List<Dipendente> findByNomeStartsWith(String token);

	//se voglio un caricamento EAGER per esempio by cognome
	//anche se i caricamenti EAGER conviene scriverli in JPQL
	@EntityGraph(attributePaths = { "societa" })
	List <Dipendente> findByCognome(String cognome);
	
}
