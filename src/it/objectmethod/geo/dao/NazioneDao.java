package it.objectmethod.geo.dao;

import java.util.List;

import it.objectmethod.geo.domain.Nazione;

public interface NazioneDao {

	public List<String> findContinenti();
	public List<Nazione> findNazioni(String continente);
	public List<Nazione> findAllNazioni();
	public List<Nazione> findNazionilessParameter(String codice);
	public Nazione findSingleNation(String codice);
}
