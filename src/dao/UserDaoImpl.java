package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import model.Task;
import model.User;
import model.Worker;

public class UserDaoImpl implements UserDao{
	
	
	
	
	public boolean register(User user,String type_user)
	{
		String email = user.getEmail();
		 String password = user.getPassword();	 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "insert into user(Id,email,password,type_user) values (NULL,?,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, email);
		 preparedStatement.setString(2, password);
		 preparedStatement.setString(3, type_user);
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();
		 preparedStatement.close();
		 if (i!=0)  // data has been inserted into the database
		 {
			 //Récuperer le ID du utilisateur qui vient d'être inseré 
			 PreparedStatement preparedStatement2 = null;
			 String query2 = "select MAX(id) as MAX_ID from user";
			 preparedStatement2 = con.prepareStatement(query2);
			 System.out.println("HELLO");
			 System.out.println(preparedStatement2);
			 ResultSet rs = preparedStatement2.executeQuery();
			 if(rs.next())
			 {
				 user.setId(rs.getLong("MAX_ID"));
			 }
			 preparedStatement2.close();
			 return true; 
		 }
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
	   
		 return false;  // On failure, send a message from here.
	    
		 	
	}

	public boolean updateProfil(User user)
	{
		 String email = user.getEmail();
		 Long id=user.getId();
		 String password = user.getPassword();	 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "update user"
		 		+ " set email = ?, password = ? where id=?"; //update user details 
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, email);
		 preparedStatement.setString(2, password);
		 preparedStatement.setLong(3,id); 
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

	@Override
	public boolean login(User user) {
		boolean status = false;
		String email = user.getEmail();
		String password = user.getPassword();

		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
            // Step 2:Create a statement using connection object
			 String query="select * from user where email = ? and password = ? ";
			preparedStatement = con.prepareStatement(query); 
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            if(status)
            {
         	   map(rs,user);
            }
            preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 System.out.println(status);
		 return status;
		 
	} 
	
	public boolean emailAlreadyExist(String email) {
		boolean status = false;
		
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			
			 String query="select * from user where email= ?  ";
			preparedStatement = con.prepareStatement(query); 
            preparedStatement.setString(1, email);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 
		 return status;
		 
	}

	@Override
	public boolean emailAlreadyExist_withException(String email, String oldEmail) {
		boolean status = false;
		
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			
			 String query="select * from user where email= ? and email!=? ";
			preparedStatement = con.prepareStatement(query); 
           preparedStatement.setString(1, email);
           preparedStatement.setString(2,oldEmail);
           System.out.println(preparedStatement);
           ResultSet rs = preparedStatement.executeQuery();
           status = rs.next();
           preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 
		 return status;
	}

	// map the resultat set to the user
	private static void map( ResultSet resultSet,User user ) throws SQLException {
		
		user.setId(resultSet.getLong("id"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		
	}

	@Override
	public String getUserType(User user) {
		
		Long id = user.getId();
		String userType = "";
		
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			
			 String query="select * from user where id=? ";
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setLong(1, user.getId());
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
         if( rs.next())
         {
        	 System.out.println(rs.getString("type_user"));
        	 userType = rs.getString("type_user");
         }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 
		 return userType;
		
	}

	@Override
	public boolean add_worker(Worker worker) {
		
		String nom = worker.getNom();
		String prenom = worker.getPrenom();
		String email = worker.getEmail();
		 String password = worker.getPassword();
		 double salary = worker.getSalary();
		 Long id_farm = worker.getFerme().getId_farm();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "insert into user(Id,email,password,type_user,id_farm,nom,prenom,salary) values (NULL,?,?,'worker',?,?,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, email);
		 preparedStatement.setString(2, password);
		 preparedStatement.setLong(3, id_farm);
		 preparedStatement.setString(4, nom);
		 preparedStatement.setString(5, prenom);
		 preparedStatement.setDouble(6, salary); 
		 int i= preparedStatement.executeUpdate();
		 preparedStatement.close();
		 if (i!=0)  // data has been inserted into the database
		 {
			 //Récuperer le ID du utilisateur qui vient d'être inseré 
			 PreparedStatement preparedStatement2 = null;
			 String query2 = "select MAX(id) as MAX_ID from user";
			 preparedStatement2 = con.prepareStatement(query2);
			 System.out.println("HELLO");
			 System.out.println(preparedStatement2);
			 ResultSet rs = preparedStatement2.executeQuery();
			 if(rs.next())
			 {
				 worker.setId(rs.getLong("MAX_ID"));
			 }
			 preparedStatement2.close();
			 return true; 
		 }
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
	   
		 return false;  // On failure, send a message from here.
	    
	}

	@Override
	public Worker getWorkerById(Long id) {
		
		Worker worker = null;

		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
            // Step 2:Create a statement using connection object
			 String query="select * from user where id=? ";
			preparedStatement = con.prepareStatement(query); 
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
         	   worker = new Worker();
         	   worker.setId(rs.getLong("id"));
         	   worker.setEmail(rs.getString("email"));
         	   worker.setNom(rs.getString("nom"));
         	   worker.setPrenom(rs.getString("prenom"));
         	   worker.setSalary(rs.getDouble("salary"));
            }
            preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		return worker;
	}


	@Override
	public void finishTask(Task tache) {
		
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "update task set accomplie='TRUE' where id_task=?"; //update user details 
		 preparedStatement = con.prepareStatement(query);
		 preparedStatement.setLong(1,tache.getId_task()); 
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();
		 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
	   
		
	}

	@Override
	public void deleteWorker(Long id) {
			 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "delete from user where id=?"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setLong(1, id);
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();
		 preparedStatement.close();
		 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
	   
	
		
	}

}