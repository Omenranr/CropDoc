package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Disease;
import model.Treatment;

public class TreatmentDaoImpl implements TreatmentDao {

	public void mapTreatment(ResultSet res, Treatment treatment) throws SQLException {
		treatment.setName(res.getString("name"));
		treatment.setCost(res.getDouble("cost"));
		treatment.setTreatment(res.getString("treatment"));
	}
	
	@Override
	public Treatment getTreatment(String dname) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		Treatment treatment = new Treatment();
		try {
			con = DBConnection.createConnection();
			System.out.println(con);
			String query = "SELECT * FROM treatment WHERE diseaseName = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, dname);
			System.out.println(preparedStatement);
			ResultSet res = preparedStatement.executeQuery();
			
			//map res to plant object
			if(res.next()) {
				mapTreatment(res, treatment);
			}
			
			return treatment;
		} catch(SQLException e) {
			 e.printStackTrace();
		}
		return null;
	}

}
