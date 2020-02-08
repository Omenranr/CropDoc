package dao;

import java.util.ArrayList;
import java.util.List;

import model.Elevage;
import model.Ferme;
import model.Parcelle;
import model.Task;
import model.User;
import model.Worker;

public interface FermeDao {
	void ajouter_Parcelle(Parcelle parcelle);
	String updateParcelle(Parcelle parcelle);
	void supprimer_Parcelle(Parcelle parcelle);
	void elargir_Parcelle(Parcelle parcelle, double superficie_more);
	void reduire_Parcelle(Parcelle parcelle, double superficie_less);
	List<Parcelle> getParcelles(Long id_farm);
	
	public void ajouter_Elevage(Elevage elevage);
	String updateElevage(Elevage elevage);
	void reduire_Elevage(Elevage elevage , double elevage_less);
	void elargir_Elevage(Elevage elevage, double superficie_more);
	void supprimer_Elevage(Elevage elevage);
	
	List<Elevage> getElevages(Long id_farm);
	
	List<Worker> getWorkers(Long id_farm);
	List<Task> getTasksOfWorker(Worker worker);
	void ajouterTache(Task tache);
	void affecter_Tache(Task tache,Worker worker);
	
	void addFarm(Ferme ferme);
	void updateFarm(Ferme ferme);
	
	Ferme getFarmOfUser(Long id);
	Ferme getFarmById(Long id);
	Parcelle getParcelleById(Long id);
	Elevage getElevageById(Long id);
	Task getTaskById(Long id);
	

	public ArrayList<User> getAllFarmers();
	

	 double getSuperficie_dispo(Ferme ferme);
	List<Task> gettasks(Long id_farm);

	
}