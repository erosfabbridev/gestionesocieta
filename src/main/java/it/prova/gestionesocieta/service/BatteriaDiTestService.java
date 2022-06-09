package it.prova.gestionesocieta.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;

@Service
public class BatteriaDiTestService {

	@Autowired
	private DipendenteService dipendenteService;
	@Autowired
	private SocietaService societaService;

	public void testInserisciNuovaSocieta() {

		try {

			Societa societaPerInsert = new Societa("societainsert", "via roma 33",
					new SimpleDateFormat("dd/mm/yyyy").parse("09/06/2022"));
			if (societaPerInsert.getId() != null)
				throw new RuntimeException("testInserisciNuovaSocieta...failed: transient object con id valorizzato");
			// salvo
			societaService.inserisciNuova(societaPerInsert);
			if (societaPerInsert.getId() == null || societaPerInsert.getId() < 1)
				throw new RuntimeException("testInserisciNuovaSocieta...failed: inserimento fallito");

			System.out.println("testInserisciNuovaSocieta........OK");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void testFindByExampleSocieta() {
		try {

			Societa societaTest = new Societa("societaexample", "via roma 33",
					new SimpleDateFormat("dd/mm/yyyy").parse("09/06/2022"));
			if (societaTest.getId() != null)
				throw new RuntimeException("testFindByExampleSocieta...failed: transient object con id valorizzato");
			// salvo
			societaService.inserisciNuova(societaTest);
			if (societaTest.getId() == null || societaTest.getId() < 1)
				throw new RuntimeException("testFindByExampleSocieta...failed: inserimento fallito");

			List<Societa> societaDaExample = societaService.findByExample(new Societa("societaexample"));

			societaDaExample.forEach(s -> System.out.println(s));

			System.out.println("testFindByExampleSocieta........OK");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void testDeleteSocieta() throws Exception {
		try {

			Societa societaTest = new Societa("societadelete", "via roma 33",
					new SimpleDateFormat("dd/mm/yyyy").parse("09/06/2022"));

			if (societaTest.getId() != null)
				throw new RuntimeException("testDeleteSocieta...failed: transient object con id valorizzato");
			societaService.inserisciNuova(societaTest);

			if (societaTest.getId() == null || societaTest.getId() < 1)
				throw new RuntimeException("testDeleteSocieta...failed: inserimento fallito");

			System.out.println("testFindByExampleSocieta........OK");

		} catch (Exception e) {

		}
	}

	public void testInsertDipendenteConSocieta() {

		try {

			Societa societaperDipendente = new Societa("societadelete", "via roma 33",
					new SimpleDateFormat("dd/mm/yyyy").parse("09/06/2022"));

			if (societaperDipendente.getId() != null)
				throw new RuntimeException(
						"testInsertDipendenteConSocieta...failed: transient object con id valorizzato");
			societaService.inserisciNuova(societaperDipendente);

			if (societaperDipendente.getId() == null || societaperDipendente.getId() < 1)
				throw new RuntimeException("testInsertDipendenteConSocieta...failed: inserimento fallito");

			Dipendente dipendenteInsert = new Dipendente("mario", "rossi",
					new SimpleDateFormat("dd/mm/yyyy").parse("09/06/2022"), 50000, societaperDipendente);

			if (dipendenteInsert.getId() != null)
				throw new RuntimeException(
						"testInsertDipendenteConSocieta...failed: transient object con id valorizzato");
			dipendenteService.inserisciNuovo(dipendenteInsert);
			if (dipendenteInsert.getId() == null || dipendenteInsert.getId() < 1)
				throw new RuntimeException("testInsertDipendenteConSocieta...failed: inserimento fallito");

			societaperDipendente.getDipendenti().add(dipendenteInsert);
			societaService.aggiorna(societaperDipendente);

			System.out.println("testInsertDipendenteConSocieta........OK");

		} catch (Exception e) {

		}

	}

	public void testModificaDipendente() {
		try {

			Dipendente dipendenteModifica = new Dipendente("mario", "rossi",
					new SimpleDateFormat("dd/mm/yyyy").parse("09/06/2022"), 50000);
			if (dipendenteModifica.getId() != null)
				throw new RuntimeException("testModificaDipendente...failed: transient object con id valorizzato");
			// salvo
			dipendenteService.inserisciNuovo(dipendenteModifica);
			if (dipendenteModifica.getId() == null || dipendenteModifica.getId() < 1)
				throw new RuntimeException("testModificaDipendente...failed: inserimento fallito");

			dipendenteModifica.setNome("marco");
			dipendenteService.aggiorna(dipendenteModifica);

			System.out.println("testInserisciNuovaSocieta........OK");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void testFindSocietaConDipendentiRALMinimo30k() {

		try {

			Societa societaperDipendente = new Societa("societadelete", "via roma 33",
					new SimpleDateFormat("dd/mm/yyyy").parse("09/06/2022"));

			if (societaperDipendente.getId() != null)
				throw new RuntimeException(
						"testInsertDipendenteConSocieta...failed: transient object con id valorizzato");
			societaService.inserisciNuova(societaperDipendente);

			if (societaperDipendente.getId() == null || societaperDipendente.getId() < 1)
				throw new RuntimeException("testInsertDipendenteConSocieta...failed: inserimento fallito");

			Dipendente dipendenteInsert = new Dipendente("mario", "rossi",
					new SimpleDateFormat("dd/mm/yyyy").parse("09/06/2022"), 50000, societaperDipendente);

			if (dipendenteInsert.getId() != null)
				throw new RuntimeException(
						"testInsertDipendenteConSocieta...failed: transient object con id valorizzato");
			dipendenteService.inserisciNuovo(dipendenteInsert);
			if (dipendenteInsert.getId() == null || dipendenteInsert.getId() < 1)
				throw new RuntimeException("testInsertDipendenteConSocieta...failed: inserimento fallito");

			societaperDipendente.getDipendenti().add(dipendenteInsert);
			societaService.aggiorna(societaperDipendente);

			List<Societa> societa = (List<Societa>) societaService.findAllEager();
			List<Dipendente> dipendentiRAL30k = societa.stream()
					.flatMap(s -> s.getDipendenti().stream().filter(d -> d.getRedditoAnnuoLordo() > 30000))
					.collect(Collectors.toList());
			
			dipendentiRAL30k.forEach(d -> System.out.println(d));

			System.out.println("testInsertDipendenteConSocieta........OK");

		} catch (Exception e) {

		}

	}

}
