package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Elevage;
import model.Ferme;
import model.Parcelle;
import model.Task;
import model.User;
import model.Worker;

public class FermeDaoImpl implements FermeDao {

	public void ajouter_Parcelle(Parcelle parcelle) {
		Long id_farm = parcelle.getId_farm();
		Ferme ferme = getFarmById(id_farm);
		double superficie = parcelle.getSuperficie();
		String type_culture = parcelle.getType_culture();
		boolean disease_detected = parcelle.isDisease_Detected();
		if (superficie > getSuperficie_dispo(ferme)) {
			System.out.println("La superficie disponible est insuffisante , pensez a r�duire d'autres parcelles");
		}
		else {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "insert into parcelle(superficie ,type_culture, disease_detected, scienceName, id_farm) values (?,?, FALSE,?,?)"; //Insert parcelle details into the table 'PARCELLE'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setDouble(1, superficie );
		 preparedStatement.setString(2, type_culture);
		 preparedStatement.setString(3, parcelle.getScienceName());
		 preparedStatement.setLong(4,  id_farm);
		 System.out.println(preparedStatement);
		 preparedStatement.executeUpdate();
		 preparedStatement.close();
		
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 }
		
	}
	

public void supprimer_Parcelle(Parcelle parcelle ) {
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 Long id = parcelle.getId_parcelle();
	 try
	 {
	 con = DBConnection.createConnection();
	 System.out.println(con);
	 String query = "delete from parcelle where id_parcelle= ?  "; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setLong(1, id );
	 preparedStatement.executeUpdate();
	 preparedStatement.close();
	 
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
}

	
	
	public void elargir_Parcelle(Parcelle parcelle , double superficie_more) {
		Ferme ferme = getFarmById(parcelle.getId_farm());
		double superficie_dispo= getSuperficie_dispo(ferme);
		if (superficie_more > superficie_dispo) 
			System.out.println("superficie insuffisante");
		else {
			 double superficie=parcelle.getSuperficie()+superficie_more;		
			 parcelle.setSuperficie(superficie);			
			 Connection con = null;
			 PreparedStatement preparedStatement = null;
			 try
			 {
			 con = DBConnection.createConnection();
			 System.out.println(con);
			 String query = "update parcelle set superficie = superficie + ? where id_parcelle= ? "; //Update parcelle's superficie into the table 'USERS'
			 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			 preparedStatement.setDouble(1, superficie_more);
			 preparedStatement.setLong(2, parcelle.getId_parcelle());
			 preparedStatement.executeUpdate();
			 preparedStatement.close();
			 System.out.println(preparedStatement) ;
			 }
			 catch(SQLException e)
			 {
			 e.printStackTrace();
			 }
		}
		 
	}
	
	public void reduire_Parcelle(Parcelle parcelle,double superficie_less) {
		 
		 Ferme ferme = getFarmById(parcelle.getId_farm());
		 double superficie=parcelle.getSuperficie()-superficie_less;
		 
		 
		 parcelle.setSuperficie(superficie);	
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "update parcelle set superficie = superficie - ? where id_parcelle = ?  "; //Update parcelle's superficie into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setDouble(1, superficie_less);
		 preparedStatement.setLong(2, parcelle.getId_parcelle());
		 preparedStatement.executeUpdate();
		 System.out.println(preparedStatement);
		 preparedStatement.close();
		 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		
	}
	public void ajouter_Elevage(Elevage elevage) {
		
		Long id_farm = elevage.getId_farm();
		Ferme ferme = getFarmById(id_farm);
		double superficie = elevage.getSuperficie();
		String type_elevage = elevage.getType_Elevage();
		if (superficie > getSuperficie_dispo(ferme)) {
			System.out.println("La superficie disponible est insuffisante , pensez a r�duire d'autres elevage");
		}
		else
		{
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "insert into elevage(id_Elevage,type_Elevage,superficie,id_farm, headNumber) values (NULL,?,?,?,?)"; 
		 preparedStatement = con.prepareStatement(query);
		 preparedStatement.setString(1, elevage.getType_Elevage());
		 preparedStatement.setDouble(2, elevage.getSuperficie());
		 preparedStatement.setLong(3, elevage.getId_farm());
		 preparedStatement.setInt(4 , elevage.getHeadNumber());
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

	
	public void supprimer_Elevage(Elevage elevage) {
			
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "delete from elevage where id_Elevage =? "; 
		 preparedStatement = con.prepareStatement(query);
		 preparedStatement.setLong(1, elevage.getId_Elevage());
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();	 
		 preparedStatement.close();
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
	}

	public void elargir_Elevage(Elevage elevage, double superficie_more) {
		// TODO Auto-generated method stub
		Ferme ferme = getFarmById(elevage.getId_farm());
		double superficie_dispo= getSuperficie_dispo(ferme);
		if (superficie_more > superficie_dispo) 
			System.out.println("superficie insuffisante");
		else {
			 double superficie=elevage.getSuperficie()+superficie_more;		
			 elevage.setSuperficie(superficie);			
			 Connection con = null;
			 PreparedStatement preparedStatement = null;
			 try
			 {
			 con = DBConnection.createConnection();
			 System.out.println(con);
			 String query = "update elevage set superficie = superficie + ? where id_Elevage = ?   "; //Update parcelle's superficie into the table 'USERS'
			 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			 preparedStatement.setDouble(1, superficie_more);
			 preparedStatement.setLong(2, elevage.getId_Elevage());
			 preparedStatement.executeUpdate();
			 preparedStatement.close();
			 
			 }
			 catch(SQLException e)
			 {
			 e.printStackTrace();
			 }
		}
	}
	
	public void reduire_Elevage(Elevage elevage , double elevage_less) {
		 Ferme ferme = getFarmById(elevage.getId_farm());
		 double superficie=elevage.getSuperficie()-elevage_less;
		 elevage.setSuperficie(superficie);
		 Long id= elevage.getId_Elevage();		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "update elevage" + "set superficie = superficie - ? where id_elevage= ?  "; //Update parcelle's superficie into the table 'ELEVAGE'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setDouble(1, elevage_less);
		 preparedStatement.setLong(2, id);
		 preparedStatement.executeUpdate();
		 
		 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
	}
	
	public void ajouterTache(Task tache) {
		java.sql.Date dateDebut = new java.sql.Date(tache.getDateDebut().getTime());
		java.sql.Date dateFin = new java.sql.Date(tache.getDateFin().getTime());
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "insert into task(Id_task,designation,urgency,accomplie,dateDebut, dateFin) values (NULL,?,?,false,?,?)";
		 
		 preparedStatement = con.prepareStatement(query);
		 preparedStatement.setString(1,tache.getDesignation());
		 preparedStatement.setString(2,tache.getUrgency());
		 System.out.println(dateDebut);
		 System.out.println(dateFin);
		 preparedStatement.setDate(3, dateDebut);		
		 preparedStatement.setDate(3, dateDebut);
		 preparedStatement.setDate(4, dateFin);
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();
		 if(i!=0)
		 {
			 PreparedStatement preparedStatement2 = null;
			 String query2 = "select MAX(id_task) as MAX_ID from task";
			 preparedStatement2 = con.prepareStatement(query2);
			 System.out.println(preparedStatement2);
			 ResultSet rs = preparedStatement2.executeQuery();
			 if(rs.next())
			 {
				 tache.setId_tache(rs.getLong("MAX_ID"));
			 }
			 preparedStatement2.close();
		 }
		 preparedStatement.close();
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
	}

	
	
	public void affecter_Tache(Task tache,Worker worker) {
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "insert into task_user(id_task,id_user) "
		 		+ "values (?,?)";
		 
		 preparedStatement = con.prepareStatement(query);
		 preparedStatement.setLong(1,tache.getId_task());
		 preparedStatement.setLong(2,worker.getId());
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();
		 preparedStatement.close();
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
	}
	
	@Override
	public List<Task> gettasks(Long id_farm) {
		List<Task> taches = new ArrayList<Task>();
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			 String query="select distinct(task.id_task),task.designation,task.urgency,task.accomplie from task,task_user,user where task.id_task=task_user.id_task"
			 		+ " and task_user.id_user=user.id and user.id_farm=? and task.accomplie=0";
			preparedStatement = con.prepareStatement(query); 
        preparedStatement.setLong(1, id_farm);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
        	 
      	  Task tache = new Task();
      	  tache.setId_tache(rs.getLong("task.id_task"));
      	  tache.setDesignation(rs.getString("task.designation"));
      	  tache.setUrgency(rs.getString("task.urgency"));
      	  tache.setAccomplie(rs.getBoolean("task.accomplie"));
      	  taches.add(tache);
     	   
        }
        preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		return taches;
	}
	
	public List<Task> getTasksOfWorker(Worker worker)
	{
		List<Task> taches = new ArrayList<Task>();
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			 String query="select * from task,task_user where task.id_task=task_user.id_task and id_user=?";
			preparedStatement = con.prepareStatement(query); 
         preparedStatement.setLong(1, worker.getId());
         System.out.println(preparedStatement);
         ResultSet rs = preparedStatement.executeQuery();
         while(rs.next())
         {
         	 
       	  Task tache = new Task();
       	  tache.setId_tache(rs.getLong("task.id_task"));
       	  tache.setDesignation(rs.getString("designation"));
       	  tache.setUrgency(rs.getString("urgency"));
       	  tache.setAccomplie(rs.getBoolean("accomplie"));
       	  taches.add(tache);
      	   
         }
         preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		return taches;
	}
	
	
//	public HashMap<String, Worker> getWorkers(Long id_farm)
	public List<Worker> getWorkers(Long id_farm)
	{
		List<Worker> workers = new ArrayList<Worker>();
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			 String query="select * from user where id_farm=?";
			preparedStatement = con.prepareStatement(query); 
          preparedStatement.setLong(1, id_farm);
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
          while(rs.next())
          {
        	  Worker worker = new Worker();
        	  worker.setId(rs.getLong("id"));
        	  worker.setEmail(rs.getString("email"));
        	  workers.add(worker);
       	   
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		return workers;
	}
	
	public ArrayList<User> getAllFarmers()
	{
		ArrayList<User> farmers = new ArrayList();
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			 String query="select * from user where type_user= 'farmer'";
			preparedStatement = con.prepareStatement(query); 
          ResultSet rs = preparedStatement.executeQuery();
          while(rs.next())
          {
        	  User farmer = new User();
        	  farmer.setId(rs.getLong("id"));
        	  farmers.add(farmer);
       	   
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		return farmers;
	}
	public List<Parcelle> getParcelles(Long id_farm)
	{
		List<Parcelle> parcelles = new ArrayList<Parcelle>();
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			 String query="select * from parcelle where id_farm =? ";
		  preparedStatement = con.prepareStatement(query); 
          preparedStatement.setLong(1, id_farm);
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
          while(rs.next())
          {
        	  Parcelle parcelle = new Parcelle();
        	  parcelle.setId_parcelle(rs.getLong("id_parcelle"));
        	  parcelle.setId_farm(rs.getLong("id_farm"));
        	  parcelle.setType_culture(rs.getString("type_culture"));
        	  parcelle.setSuperficie(rs.getDouble("superficie"));
        	  parcelle.setScienceName(rs.getString("scienceName"));
        	  parcelles.add(parcelle);
        	   	         	   
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		return parcelles;
	}
	public ArrayList<Parcelle> getParcellesOfFarmer(Long id_farmer)
	{
		ArrayList<Parcelle> parcelles = new ArrayList<Parcelle>();
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			 String query="SELECT p.* from parcelle p, farm f WHERE p.id_farm = f.id_farm AND f.id_fermier = ? ";
		  preparedStatement = con.prepareStatement(query); 
          preparedStatement.setLong(1, id_farmer);
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
          while(rs.next())
          {
        	  Parcelle parcelle = new Parcelle();
        	  parcelle.setId_parcelle(rs.getLong("id_parcelle"));
        	  parcelle.setId_farm(rs.getLong("id_farm"));
        	  parcelle.setType_culture(rs.getString("type_culture"));
        	  parcelle.setScienceName(rs.getString("scienceName"));
        	  parcelle.setSuperficie(rs.getDouble("superficie"));
        	  parcelles.add(parcelle);
        	   	         	   
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		return parcelles;
	}
	
	public List<Elevage> getElevages(Long id_farm)
	{
		List<Elevage> eleveges = new ArrayList<Elevage>();
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
			 String query="select * from elevage where id_farm =? ";
		  preparedStatement = con.prepareStatement(query); 
          preparedStatement.setLong(1, id_farm);
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
          while(rs.next())
          {
        	  Elevage elevage = new Elevage();
        	  elevage.setId_Elevage(rs.getLong("id_Elevage"));
        	  elevage.setId_farm(rs.getLong("id_farm"));
        	  elevage.setType_Elevage(rs.getString("type_Elevage"));
        	  elevage.setSuperficie(rs.getDouble("superficie"));
        	  elevage.setHeadNumber(rs.getInt("headNumber"));
        	  eleveges.add(elevage);
        	   	         	   
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		return eleveges;
	}
	
	
	public Ferme getFarmById(Long id) { 
		Ferme ferme = null;
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
           // Step 2:Create a statement using connection object
			 String query="select * from farm where id_farm =?";
			preparedStatement = con.prepareStatement(query); 
           preparedStatement.setLong(1, id);
           System.out.println(preparedStatement);
           ResultSet rs = preparedStatement.executeQuery();
           boolean status = rs.next();
           if(status)
           {
        	   ferme = new Ferme();
        	   ferme.setId_farm(rs.getLong("id_farm"));
        	   ferme.setCity(rs.getString("city"));
        	   ferme.setSuperficie_totale(rs.getDouble("superficie_totale"));
        	   
           }
           preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		return ferme;
	}

	
	public Ferme getFarmOfUser(Long id)
	{
		Ferme ferme = null;
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
           // Step 2:Create a statement using connection object
			 String query="select * from farm where id_fermier =? ";
			preparedStatement = con.prepareStatement(query); 
           preparedStatement.setLong(1, id);
           System.out.println(preparedStatement);
           ResultSet rs = preparedStatement.executeQuery();
           boolean status = rs.next();
           if(status)
           {
        	   ferme = new Ferme();
        	  Long id_farm = rs.getLong("id_farm");
        	   ferme.setId_farm(id_farm);
        	   ferme.setCity(rs.getString("city"));
        	   ferme.setSuperficie_totale(rs.getDouble("superficie_totale"));
           }
           preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		return ferme;
	}
	
	public void addFarm(Ferme ferme)
	{
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "insert into farm(id_farm,id_fermier,city,superficie_totale) values (NULL,?,?,?)"; 
		 preparedStatement = con.prepareStatement(query);
		 preparedStatement.setLong(1, ferme.getFermier().getId());
		 preparedStatement.setString(2, ferme.getCity());
		 preparedStatement.setDouble(3, ferme.getSuperficie_totale());
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();
		 
		 preparedStatement.close();
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
	}
	
	@Override
	public void updateFarm(Ferme ferme) {
		
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "update farm set city=? ,superficie_totale=? where id_farm=? "; 
		 preparedStatement = con.prepareStatement(query); 
		 preparedStatement.setString(1, ferme.getCity());
		 preparedStatement.setDouble(2, ferme.getSuperficie_totale());
		 preparedStatement.setLong(3, ferme.getId_farm());
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();		
		 
		 preparedStatement.close();
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
	}

	
	public double getSuperficie_dispo(Ferme ferme) {
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 Long id= ferme.getId_farm();
		 double superficie_dispo = ferme.getSuperficie_totale() ;
		 System.out.println("le superficie totale de ferme "+superficie_dispo);
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con); 
//		 String query = " select sum(parcelle.superficie) as sup_exp1,sum(elevage.superficie) as sup_exp2 from parcelle,elevage"
//		 		+ " where parcelle.id_farm=elevage.id_farm and elevage.id_farm=?  "; 
		 String query = " select sum(elevage.superficie) as sup_exp1 from elevage where id_farm=?  ";
		 //sup_exp = superficie exploit�e
		 preparedStatement = con.prepareStatement(query); 
		 preparedStatement.setLong(1, id);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery(); 
        
       	if(rs.next()){
       		
       		String query2 = " select sum(parcelle.superficie) as sup_exp2 from parcelle where id_farm=?  ";
       		PreparedStatement preparedStatement2 = con.prepareStatement(query2);
       		preparedStatement2.setLong(1, id);
            System.out.println(preparedStatement2);
       		ResultSet rs2 = preparedStatement2.executeQuery(); 
       		if(rs2.next())
       		{
       			superficie_dispo = ferme.getSuperficie_totale() - rs.getDouble("sup_exp1")-rs2.getDouble("sup_exp2") ;
       			System.out.println(superficie_dispo);
       		}
       		
       			preparedStatement2.close();

       	}
        preparedStatement.close();
//        PreparedStatement preparedStatement2 = null ;
//        String query2= "update ferme" + "set superficie_dispo = ? where id farm = ?";
//        preparedStatement2 = con.prepareStatement(query2);
//        preparedStatement2.setDouble(1, superficie_dispo);
//        preparedStatement2.setLong(2, id);
        
        
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		
		return superficie_dispo ;
	}


	@Override
	public Parcelle getParcelleById(Long id) {
		Parcelle parcelle = null;
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
          // Step 2:Create a statement using connection object
			 String query="select * from parcelle  where id_parcelle =? ";
			preparedStatement = con.prepareStatement(query); 
          preparedStatement.setLong(1, id);
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
          boolean status = rs.next();
          if(status)
          {
        	  parcelle = new Parcelle();
        	  parcelle.setId_parcelle(rs.getLong("id_parcelle"));
        	  parcelle.setType_culture(rs.getString("type_culture"));
        	  parcelle.setSuperficie(rs.getDouble("superficie"));
        	  parcelle.setScienceName(rs.getString("scienceName"));
        	  parcelle.setId_farm(rs.getLong("id_farm"));
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		return parcelle;
	}


	@Override
	public Elevage getElevageById(Long id) {
		Elevage elevage = null;
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
          // Step 2:Create a statement using connection object
			 String query="select * from elevage  where id_elevage =? ";
			preparedStatement = con.prepareStatement(query); 
          preparedStatement.setLong(1, id);
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
          boolean status = rs.next();
          if(status)
          {
        	  elevage = new Elevage();
        	  elevage.setId_Elevage(rs.getLong("id_elevage"));
        	  elevage.setType_Elevage(rs.getString("type_Elevage"));
        	  elevage.setSuperficie(rs.getDouble("superficie"));
        	  elevage.setHeadNumber(rs.getInt("headNumber"));
        	  elevage.setId_farm(rs.getLong("id_farm"));
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		return elevage;
	}


	@Override
	public Task getTaskById(Long id) {

		Task tache = null;
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
			con = DBConnection.createConnection();
          // Step 2:Create a statement using connection object
			 String query="select * from task  where id_task =? ";
			preparedStatement = con.prepareStatement(query); 
          preparedStatement.setLong(1, id);
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
          boolean status = rs.next();
          if(status)
          {
        	  tache = new Task();
        	  tache.setId_tache(rs.getLong("Id_task"));
        	  tache.setDesignation(rs.getString("designation"));
        	  tache.setUrgency(rs.getString("urgency"));
        	  tache.setDateDebut((Date)rs.getDate("dateDebut"));
        	  tache.setAccomplie(rs.getBoolean("accomplie"));
          }
          preparedStatement.close(); 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		return tache;
	}


	@Override
	public String updateParcelle(Parcelle parcelle) {
		
		Long id_farm = parcelle.getId_farm();
		Ferme ferme = getFarmById(id_farm);
		Parcelle oleParcelle = getParcelleById(parcelle.getId_parcelle());
		double superficie = parcelle.getSuperficie();
		String type_culture = parcelle.getType_culture();
		String scienceName = parcelle.getScienceName();
		boolean disease_detected = parcelle.isDisease_Detected();
		if (superficie > (getSuperficie_dispo(ferme)+oleParcelle.getSuperficie())) {
			return "La superficie disponible est insuffisante , pensez a r�duire d'autres parcelles";
		}
		else {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "update parcelle set superficie=? ,type_culture=?, scienceName=?  where id_parcelle=?"; //Insert parcelle details into the table 'PARCELLE'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setDouble(1, superficie );
		 preparedStatement.setString(2, type_culture);
		 preparedStatement.setString(3, scienceName);
		 preparedStatement.setLong(4, parcelle.getId_parcelle());
		 System.out.println(preparedStatement);
		 preparedStatement.executeUpdate();
		 preparedStatement.close();
		 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		return "Succes";
		 }
		
	}


	@Override
	public String updateElevage(Elevage elevage) {
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 System.out.println(con);
		 String query = "update elevage set type_Elevage=? ,superficie=? ,headNumber=? where id_Elevage=?"; 
		 preparedStatement = con.prepareStatement(query);
		 preparedStatement.setString(1, elevage.getType_Elevage());
		 preparedStatement.setDouble(2, elevage.getSuperficie());
		 preparedStatement.setInt(3 , elevage.getHeadNumber());
		 preparedStatement.setLong(4,elevage.getId_Elevage());
		 
		 System.out.println(preparedStatement);
		 int i= preparedStatement.executeUpdate();
		 preparedStatement.close();
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 return "Succes";
	}


	

	
	

}
