package it.prova.gestionesocieta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionesocieta.model.Societa;

public interface SocietaRepository extends CrudRepository<Societa, Long>, QueryByExampleExecutor<Societa> {

	List<Societa> findAllByRagionesocialeContaining(String term);

	// c'è anche la possibilità di andare nelle 'nested' properties...MAGNIFICO
	// lo faccio eager per provare
	@EntityGraph(attributePaths = { "dipendenti" })
	List<Societa> findAllDistinctByDipendentiNome(String name);
	
	@EntityGraph(attributePaths = { "dipendenti" })
	List<Societa> findAllEager();

}