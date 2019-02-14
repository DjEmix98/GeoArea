package it.objectmethod.geo.dao;

import java.util.List;

import it.objectmethod.geo.domain.Citta;

public interface CittaDao {

	public List<Citta> findCittaForCode (String code);
	public List<Citta> findCittaForFilter(String filterTextCity, String filterCode,int filterPopolazione, boolean flagOperatore);
	public void eliminaCitta(String id);
	public void inserisciCitta(String nome, String code);
}
