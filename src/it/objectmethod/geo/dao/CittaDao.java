package it.objectmethod.geo.dao;

import java.util.List;

import it.objectmethod.geo.domain.Citta;

public interface CittaDao {

	public List<Citta> findCittaByCode (String code);
	public List<Citta> findCittaByCityandFlag(Citta city, boolean flagOperatore);
	public Citta findCittaById(int id);
	public void eliminaCitta(int id);
	public void inserisciCitta(String nome, String code, String regione, int popolazione);
	public void modificaCitta(int id, String regione,String nome,String code, int popolazione );
}
