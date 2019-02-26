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
	public List<Citta> findCittaByCode(String code) {
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
				citta.setPopulation(rs.getInt("Population"));
				citta.setCountryCode(rs.getString("countryCode"));
				citta.setDistrict(rs.getString("District"));
				citta.setId(rs.getInt("ID"));
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
	public List<Citta> findCittaByCityandFlag(Citta city, boolean flagOperatore) {
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
			stmt.setString(1, city.getNome());
			// stmt.setString(2, filterOperator);
			stmt.setInt(2, city.getPopulation());
			stmt.setInt(3, city.getPopulation());
			stmt.setString(4, city.getCountryCode());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Citta citta = new Citta();
				citta.setNome(rs.getString("Name"));
				citta.setPopulation(rs.getInt("Population"));
				citta.setCountryCode(rs.getString("CountryCode"));
				citta.setDistrict(rs.getString("District"));
				citta.setId(rs.getInt("ID"));
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
	public void eliminaCitta(int id) {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		String sql = "DELETE FROM city where ID = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void inserisciCitta(Citta city) {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO city (Name,CountryCode,District,Population) values(?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,city.getNome());
			stmt.setString(2,city.getCountryCode());
			stmt.setString(3,city.getDistrict());
			stmt.setLong(4,city.getPopulation());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modificaCitta(Citta city) {
		Connection conn = ConnectionConfig.getConnection();
		PreparedStatement stmt = null;
		String sql = "update city set Name=?,District=?,Population=?, CountryCode=? where id=? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,city.getNome());
			stmt.setString(2,city.getDistrict());
			stmt.setInt(3, city.getPopulation());
			stmt.setString(4,city.getCountryCode());
			stmt.setInt(5,city.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public Citta findCittaById(int id) {
		Connection conn = ConnectionConfig.getConnection();
		Citta city = new Citta();
		PreparedStatement stmt = null;
		String sql = "SELECT* FROM city where ID = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				city.setCountryCode(rs.getString("CountryCode"));
				city.setDistrict(rs.getString("District"));
				city.setId(rs.getInt("ID"));
				city.setNome(rs.getString("Name"));
				city.setPopulation(rs.getInt("Population"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

}
