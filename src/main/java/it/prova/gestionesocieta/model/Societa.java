package it.prova.gestionesocieta.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "societa")
public class Societa {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "ragionesociale")
	private String ragioneSociale;
	@Column(name = "indirizzo")
	private String indirizzo;
	@Column(name = "datafondazione")
	private Date dataFondazione;;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "societa")
	private Set<Dipendente> abitanti = new HashSet<>();
	
	public Societa() {
		
	}

	public Societa(String ragioneSociale, String indirizzo, Date dataFondazione, Set<Dipendente> abitanti) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.dataFondazione = dataFondazione;
		this.abitanti = abitanti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Date getDataFondazione() {
		return dataFondazione;
	}

	public void setDataFondazione(Date dataFondazione) {
		this.dataFondazione = dataFondazione;
	}

	public Set<Dipendente> getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(Set<Dipendente> abitanti) {
		this.abitanti = abitanti;
	}
	
	
	
}
