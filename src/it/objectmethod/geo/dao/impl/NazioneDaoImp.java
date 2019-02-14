package it.objectmethod.geo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.geo.config.ConnectionConfig;
import it.objectmethod.geo.dao.NazioneDao;
import it.objectmethod.geo.domain.Nazione;

public class NazioneDaoImp implements NazioneDao {

	@Override
	public List<String> findContinenti() {
		List<String> listaContinenti = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT DISTINCT Continent FROM country";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				Nazione continente = new Nazione();
				continente.setContinente(rs.getString("Continent"));
				listaContinenti.add(continente.getContinente());
			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null) {
					stmt.close();
				}				
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{
				if(conn!=null) {
					conn.close();
				}	
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return listaContinenti;
	}

	@Override
	public List<Nazione> findNazioni(String continente) {

		List<Nazione> listaNazioni = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM country where Continent =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, continente);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Nazione nazioni = new Nazione();
				nazioni.setPopulation(rs.getString("Population"));
				nazioni.setContinente(rs.getString("Continent"));
				nazioni.setNazione(rs.getString("Name"));
				nazioni.setCode(rs.getString("Code"));
				listaNazioni.add(nazioni);
			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null) {
					stmt.close();
				}				
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{
				if(conn!=null) {
					conn.close();
				}	
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return listaNazioni;
	}

	@Override
	public List<Nazione> findAllNazioni() {
		List<Nazione> listaNazioni = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM country";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Nazione nazioni = new Nazione();
				nazioni.setPopulation(rs.getString("Population"));
				nazioni.setContinente(rs.getString("Continent"));
				nazioni.setNazione(rs.getString("Name"));
				nazioni.setCode(rs.getString("Code"));
				listaNazioni.add(nazioni);
			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null) {
					stmt.close();
				}				
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{
				if(conn!=null) {
					conn.close();
				}	
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return listaNazioni;
	}

}
