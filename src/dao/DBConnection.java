package dao;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {
 
 public static Connection createConnection()
 {
 Connection con = null;
 
 //Mazid Config
 //String url = "jdbc:mysql://localhost:3306/projetjee?useLegacyDatetimeCode=false&serverTimezone=UTC"; //MySQL URL followed by the database name
 //String username = "User"; //MySQL username
 //String password = "123"; //MySQL password 

// Omar Config
 String url = "jdbc:mysql://localhost:3306/projetjee?useLegacyDatetimeCode=false&serverTimezone=UTC";
 String username = "root";
 String password="";
// String url = "jdbc:mysql://localhost:3306/projetjee?useLegacyDatetimeCode=false&serverTimezone=UTC"; //MySQL URL followed by the database name
// String username = "User"; //MySQL username
// String password = "123"; //MySQL password 
// 
//String url= "jdbc:mysql://127.0.0.1/projetjee";
//String username="root";
//String password="";



try {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
	 } catch (ClassNotFoundException e) {
		 e.printStackTrace();
	 }
	 con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	 System.out.println("Printing connection object " + con);
} catch (Exception e) {
	e.printStackTrace();
	} 
 return con; 
}
}