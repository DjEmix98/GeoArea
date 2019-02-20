package it.objectmethod.geo.dao;

import java.util.List;

import it.objectmethod.geo.domain.Citta;

public interface CittaDao {

	public List<Citta> findCittaForCode (String code);
	public List<Citta> findCittaForFilter(String filterTextCity, String filterCode,int filterPopolazione, boolean flagOperatore);
	public Citta findCittaForId(int id);
	public void eliminaCitta(int id);
	public void inserisciCitta(String nome, String code, String regione, int popolazione);
	public void modificaCitta(int id, String regione,String nome,String code, int popolazione );
}
