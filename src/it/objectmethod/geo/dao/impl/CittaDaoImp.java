package it.objectmethod.geo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import it.objectmethod.geo.config.ConnectionConfig;
import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.domain.Citta;

public class CittaDaoImp implements CittaDao {

	@Override
	public List<Citta> findCittaForCode(String code) {
		List<Citta> listaCitta = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		try {

			String sql = "SELECT * FROM city where CountryCode =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, code);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Citta citta = new Citta();
				citta.setNome(rs.getString("Name"));
				citta.setPopulation(rs.getString("Population"));
				citta.setCountryCode(rs.getString("countryCode"));
				citta.setDistrict(rs.getString("District"));
				citta.setId(rs.getString("ID"));
				listaCitta.add(citta);
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
		return listaCitta;
	}

	@Override
	public List<Citta> findCittaForFilter(String filterTextCity, String filterCode, int filterPopolazione, boolean flagOperatore) {
		List<Citta> listaCitta = new ArrayList<>();
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		String sql = null;
		try {
			if(flagOperatore)
			{
				sql = "SELECT * FROM city where Name LIKE ? AND (Population > ? OR ?=0) AND CountryCode = ?";
			}
			else
			{
				sql = "SELECT * FROM city where Name LIKE ? AND (Population < ? OR ? =0) AND CountryCode = ?";
			}
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, filterTextCity);
			// stmt.setString(2, filterOperator);
			stmt.setInt(2, filterPopolazione);
			stmt.setInt(3, filterPopolazione);
			stmt.setString(4, filterCode);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Citta citta = new Citta();
				citta.setNome(rs.getString("Name"));
				citta.setPopulation(rs.getString("Population"));
				citta.setCountryCode(rs.getString("CountryCode"));
				citta.setDistrict(rs.getString("District"));
				citta.setId(rs.getString("ID"));
				listaCitta.add(citta);
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
		return listaCitta;
	}

	@Override
	public void eliminaCitta(String id) {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		String sql = "DELETE FROM city where ID = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void inserisciCitta(String nome, String code) {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO city (Name,CountryCode) values(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,nome);
			stmt.setString(2, code);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
