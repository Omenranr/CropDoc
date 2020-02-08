package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Plant;
import model.User;

public class PlantDaoImpl implements PlantDao {
	
	public void mapPlant(ResultSet res, Plant plant) throws SQLException {
		plant.setScienceName(res.getString("scienceName"));
		plant.setName(res.getString("name"));
		plant.setInsights(res.getString("insights"));
		plant.setVariety(res.getString("variety"));
		plant.setNightTemp(res.getDouble("nightTemp"));
		plant.setDayTemp(res.getDouble("dayTemp"));
		plant.setCriticalTempMax(res.getDouble("criticalTempMax"));
		plant.setCriticalTempMin(res.getDouble("criticalTempMin"));
		plant.setNumberMonths(res.getInt("numberMonths"));
		plant.setClimatGeography(res.getString("climatGeography"));
		plant.setInsights(res.getString("insights"));
		plant.setPicture(res.getString("picture"));
	}
	
	@Override
	public Plant getPlant(String pname) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		Plant plant = new Plant();
		try {
			con = DBConnection.createConnection();
			System.out.println(con);
			String query = "SELECT * FROM plant WHERE scienceName = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, pname);
			System.out.println(preparedStatement);
			
			ResultSet res = preparedStatement.executeQuery();
			
			//map res to plant object
			if(res.next()) {
				mapPlant(res, plant);
			}
			return plant;
		} catch(SQLException e) {
			 e.printStackTrace();
		}
		return null;
	}
	
	public Plant getPlantByName(String pNormalName) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		Plant plant = new Plant();
		try {
			con = DBConnection.createConnection();
			System.out.println(con);
			String query = "SELECT * FROM plant WHERE name = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, pNormalName);
			System.out.println(preparedStatement);
			
			ResultSet res = preparedStatement.executeQuery();
			
			//map res to plant object
			if(res.next()) {
				mapPlant(res, plant);
			}
			return plant;
		} catch(SQLException e) {
			 e.printStackTrace();
		}
		return null;
	}
}
