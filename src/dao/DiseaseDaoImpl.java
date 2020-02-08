package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Disease;
import model.Parcelle;
import model.Plant;
import model.Treatment;

public class DiseaseDaoImpl implements DiseaseDao {

	public void mapDisease(ResultSet res, Disease disease) throws SQLException {
		disease.setName(res.getString("name"));
		disease.setLevelOfDanger(res.getString("levelOfDanger"));
		disease.setSymptomes(res.getString("symptomes"));
		disease.setTreatmentName(res.getString("treatmentName"));
	}
	
	@Override
	public ArrayList<Disease> getPlantDiseases(String pname) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = DBConnection.createConnection();
			ArrayList<Disease> diseases = new ArrayList<Disease>();
			System.out.println(con);
			String query = "SELECT * FROM disease WHERE scienceName = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, pname);
			System.out.println(preparedStatement);
			ResultSet res = preparedStatement.executeQuery();
			
			//map res to plant object
			while(res.next()) {
				Disease disease = new Disease();
				mapDisease(res, disease);
				diseases.add(disease);
				
			}
			return diseases;
		} catch(SQLException e) {
			 e.printStackTrace();
		}
		return null;
	}

	@Override
	public Disease getDiseaseByDiseaseName(String dname) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		Disease disease = new Disease();
		try {
			con = DBConnection.createConnection();
			System.out.println(con);
			String query = "SELECT * FROM disease WHERE name = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, dname);
			System.out.println(preparedStatement);
			ResultSet res = preparedStatement.executeQuery();
			//map res to plant object
			if(res.next()) {
				mapDisease(res, disease);
			}
			return disease;
		} catch(SQLException e) {
			 e.printStackTrace();
		}
		return null;
	}

	@Override
	public void affectToParcelle(Disease disease, Parcelle parcelle) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
	}

}
