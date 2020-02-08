package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.Elevage;
import model.Ferme;
import model.Fermier;
import model.Parcelle;
import model.Task;
import model.User;
import model.Worker;

public class TestDao {

	public static void main(String[] args) {
		

		UserDao userDao = new UserDaoImpl();
		FermeDao fermeDao = new FermeDaoImpl();
		
		
//		Task tache = fermDao.getTaskById((long)3);
//		Elevage elevage = fermDao.getElevageById((long)3);
//		Parcelle parcelle = fermDao.getParcelleById((long)1);
//		System.out.println(tache.getDesignation());
//		System.out.println(elevage.getType_Elevage());
//		System.out.println(parcelle.getScienceName());

//		UserDao userDao = new UserDaoImpl();
//		FermeDaoImpl fermDao = new FermeDaoImpl();
//		Ferme farm = new Ferme();
//		farm.setId_farm((long)1);
//		Worker worker = new Worker();
//		worker.setPrenom("alaa");	
//		worker.setFerme(farm);
//		worker.setEmail("emailTest2@gmail.com");
//		worker.setPassword("123");
//		userDao.add_worker(worker);
		
//		Worker worker = new Worker();
//		worker.setId((long)18);
//		List<Task> taches = null;
//		taches = fermDao.getTasksOfWorker(worker);
//		
//		for(Task tache:taches )
//		{
//			System.out.println(tache.getDesignation());
//		}

		
//		Ferme ferme = fermeDao.getFarmById((long)1);
//		String ville= ferme.getCity() ;
//		System.out.println(ville);     // TEST GETFARMBYID
        
        
        
	//AJOUT D'UNE PARCELLE	
        
//	Parcelle parcelle = new Parcelle();
//	
//	parcelle.setId_parcelle((long)6);
//	parcelle.setId_farm((long)1);
//	parcelle.setSuperficie(200);
//	parcelle.setType_culture("Pommes de terre ");
//	fermeDao.ajouter_Parcelle(parcelle);   //REUSSI 
    // SUPPRIMER PARCELLE     
//		fermeDao.supprimer_Parcelle(parcelle);   //REUSSI 
    // ELARGIR PARCELLE 
  //  fermeDao.reduire_Parcelle(parcelle, 300);  
    // REDUIRE PARCELLE 
	   // fermeDao.reduire_Parcelle(parcelle, 200);  
        
    //   Elevage elevage = new Elevage(); 
       
 //       elevage.setId_farm((long)1);
 //       elevage.setId_Elevage((long)6);
//        elevage.setSuperficie(200);
//        elevage.setHeadNumber(20);
//        elevage.setType_Elevage("cows");
//        fermeDao.ajouter_Elevage(elevage);     // AJOUT ELEVAGE REUSSI 
//        fermeDao.reduire_Elevage(elevage, 200);
        
        
		
		
		
		
		
		
//		Ferme ferme = fermDao.getFarmById((long)1);
//		System.out.println(ferme.getCity());
		
//		Ferme farm = new Ferme();
//		farm.setId_farm((long)1);
//		farm.setCity("Agadir");
//		farm.setSuperficie_totale(10000);
//		double supDispo = fermDao.getSuperficie_dispo(farm);
//		System.out.println("superficie dispo "+supDispo);
		
//		Fermier fermier = new Fermier();
//		fermier.setId((long)6);
//		farm.setFermier(fermier);
//		fermDao.addFarm(farm);
		
//		Ferme ferme = fermDao.getFarmOfUser((long)5);
//		Fermier fermier = new Fermier();
//		fermier.setId((long)5);
//		ferme.setFermier(fermier);
//		fermDao.addFarm(ferme);
//		System.out.println(ferme.getCity());
		
		
		//Tasks test
//		Task tache = new Task();
//		tache.setDesignation("keep an eye on horses");
//		fermDao.ajouterTache(tache);
//		
//		Worker worker1 = new Worker();
//		Worker worker2 = new Worker();
//		worker1.setId((long)18);
//		worker2.setId((long)19);
//		
//		fermDao.affecter_Tache(tache, worker1);
//		fermDao.affecter_Tache(tache, worker2);
		
//		Ferme ferme = fermeDao.getFarmById((long)2);
//		System.out.println("la supr disp"+fermeDao.getSuperficie_dispo(ferme));
//		Parcelle parcelle = fermeDao.getParcelleById((long)2);
//		System.out.println(parcelle.getId_farm());
//		parcelle.setSuperficie(1901);
//		System.out.println(fermeDao.updateParcelle(parcelle));
		
//		Elevage elevage = fermeDao.getElevageById((long)8);
//		elevage.setSuperficie(100);
//		System.out.println(fermeDao.updateElevage(elevage));
//		
		
		
		Ferme ferme1 = fermeDao.getFarmById((long)1);
		ferme1.setCity("Rabat");
		fermeDao.updateFarm(ferme1);
		
//		
//		Elevage ship_1 = new Elevage();
//		ship_1.setId_Elevage((long)2);
//		ship_1.setId_farm(farm.getId_farm());
//		ship_1.setType_Elevage("Ships");
//		FermeDaoImpl fermDao = new FermeDaoImpl();
	
		//fermDao.ajouter_Elevage(ship_1);
		//fermDao.supprimer_Elevage(ship_1);
		
//		List<Worker> workers = fermDao.getWorkers((long)1);
//		List<Elevage> elevages = fermDao.getElevages((long)1);
//		
//		for(Worker worker:workers )
//		{
//			System.out.println(worker.getEmail());
//		}
//		
		
//		for(Elevage elevage:elevages)
//		{
//			System.out.println(elevage.getType_Elevage());
//		}
		
		
		
		
		
//		Iterator<Worker> iter = workers.iterator();
//		while(iter.hasNext())
//		{
//			System.out.println(((Worker)iter.next()).getEmail());
//		}
		
		
//		userDao.deleteWorker((long)20);
		

	}

}
