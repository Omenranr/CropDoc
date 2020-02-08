package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import model.Ferme;
import model.Notification;
import model.Parcelle;
import model.Plant;
import model.User;
import model.Weather;
import model.WeatherData;

public class NotificationDaoImpl implements NotificationDao {

	public boolean PlanTempNotSuitable(Plant plant, User user) {
		String userCity = "Rabat";
		Ferme farm = new FermeDaoImpl().getFarmOfUser(user.getId());
		if (farm != null)
			userCity = farm.getCity();
		Weather weatherToday = new Weather();
		weatherToday = WeatherData.getWeather(userCity);
		double Tmin = plant.getCriticalTempMin(), Tmax = plant.getCriticalTempMax();
		int Temp = weatherToday.getTemperature();
		if (Temp < Tmax && Temp > Tmin)
			return false;
		return true;
	}

	@Override
	public void notificationAllUpdate() {

		FermeDaoImpl DB = new FermeDaoImpl();

		ArrayList<User> farmers = DB.getAllFarmers();
		ArrayList<Parcelle> parcelles;

		for (User farmer : farmers) {
			parcelles = new ArrayList<Parcelle>();
			parcelles = DB.getParcellesOfFarmer(farmer.getId());

			for (Parcelle parcelle : parcelles) {
				Plant P = new PlantDaoImpl().getPlant(parcelle.getScienceName());

				

				if (PlanTempNotSuitable(P, farmer)) {
					Date today = Date.valueOf("2020-02-08");
					String content = new String("Today's weather is not suitable for the plant " + P.getName());
					Notification notif = new Notification("parcelle", content, today, true, farmer.getId(),
							parcelle.getId_parcelle());
					addNotification(notif);
					System.out.println("*****A notif was added");

				}

			}

		}

	}

	public void addNotification(Notification Not) {

		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = DBConnection.createConnection();
			String query = "INSERT INTO notification (id_notification, type, content, date, status, id_user, id_commun) VALUES (NULL, ?, ?, ?, ?, ?, ?);";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, Not.getType());
			preparedStatement.setString(2, Not.getContent());
			preparedStatement.setDate(3, Not.getDate());
			preparedStatement.setBoolean(4, Not.isStatus());
			preparedStatement.setLong(5, Not.getId_user());
			preparedStatement.setLong(6, Not.getId_commun());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Notification> getNotifsOfUser(int id_user)
	{
		ArrayList<Notification> Notifs = new ArrayList<Notification>();
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			 String query="SELECT * FROM notification WHERE id_user = ?";
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setInt(1, id_user);
          ResultSet rs = preparedStatement.executeQuery();
          while(rs.next())
          {
        	  Notification Notif = new Notification();
        	  Notif.setDate(rs.getDate("date"));
        	  Notif.setContent(rs.getString("content"));
        	  Notif.setStatus(rs.getBoolean("status"));
        	  Notifs.add(Notif);
       	   
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		return Notifs;
	}

	public boolean upadeNotifsOfuser(int id_user) {
		
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "UPDATE notification SET status= 0 WHERE id_user = ?"; 
		 preparedStatement = con.prepareStatement(query);
		 preparedStatement.setLong(1, id_user); 
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();
		 
		 if (i!=0)  // data has been updated in the database
		 return true; 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
	   
		 return false;  //  failure
	    
	
		
		
	}
}
