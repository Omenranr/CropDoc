package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Request;
import model.User;

public class RequestDaoImpl implements RequestDao {
	
	public void mapRequests(ResultSet res, ArrayList<Request> requests) {
		
	}
	
	@Override
	public void saveRequest(Request request, long user_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try {
			con = DBConnection.createConnection();
			System.out.println(con);
			String query = "INSERT INTO request(type, user_id, date) values (?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, request.getType());
			preparedStatement.setLong(2, user_id);
			preparedStatement.setDate(3, (Date) request.getDate());
			System.out.println("prepared statement" + preparedStatement);
			
			preparedStatement.executeUpdate();
			
		} catch(SQLException e) {
			 e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Request> getUserRequests(User user) {
		// TODO Auto-generated method stub
		Connection con = null;
		ArrayList<Request> requests = new ArrayList<Request>();
		PreparedStatement preparedStatement = null;
		try {
			con = DBConnection.createConnection();
			
			String query = "SELECT * FROM request WHERE user_id = ?";
			preparedStatement.setDouble(1, user.getId());
			ResultSet res = preparedStatement.executeQuery();
			
			return requests;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
