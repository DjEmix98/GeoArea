package it.objectmethod.geo.dao;

import java.util.List;

import it.objectmethod.geo.domain.Citta;

public interface CittaDao {

	public List<Citta> findCittaByCode (String code);
	public List<Citta> findCittaByCityandFlag(Citta city, boolean flagOperatore);
	public Citta findCittaById(int id);
	public void eliminaCitta(int id);
	public void inserisciCitta(Citta city);
	public void modificaCitta(Citta city);
}
