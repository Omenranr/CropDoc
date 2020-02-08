package model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;



import model.Elevage;
import model.Fermier;
import model.Parcelle;
import model.Worker;



public class Ferme {
	private Long id_farm;
	private Fermier fermier ; 
	private String city ;
	private double superficie_totale;

	List <Worker> workers = new ArrayList<Worker>();
	List <Parcelle> parcelle = new ArrayList<Parcelle>();
	List <Elevage> elevage = new ArrayList<Elevage>();
//	HashMap<String, Worker> workers = new HashMap<String, Worker>();
//	HashMap<String, Parcelle> parcelles = new HashMap<String, Parcelle>();
//	HashMap<String, Elevage> elevages = new HashMap<String, Elevage>();
	
	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public List<Parcelle> getParcelle() {
		return parcelle;
	}

	public void setParcelle(List<Parcelle> parcelle) {
		this.parcelle = parcelle;
	}

	public List<Elevage> getElevage() {
		return elevage;
	}

	public void setElevage(List<Elevage> elevage) {
		this.elevage = elevage;
	}

	public Long getId_farm() {
		return id_farm;
	}

	public void setId_farm(Long id_farm) {
		this.id_farm = id_farm;
	}

	public Fermier getFermier() {
		return fermier;
	}


	public void setFermier(Fermier fermier) {
		this.fermier = fermier;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

//	public HashMap<String, Worker> getWorkers() {
//		return workers;
//	}
//
//	public void setWorkers(HashMap<String, Worker> workers) {
//		this.workers = workers;
//	}
//
//	public HashMap<String, Parcelle> getParcelles() {
//		return parcelles;
//	}
//
//	public void setParcelles(HashMap<String, Parcelle> parcelles) {
//		this.parcelles = parcelles;
//	}
//
//	public HashMap<String, Elevage> getElevages() {
//		return elevages;
//	}
//
//	public void setElevages(HashMap<String, Elevage> elevages) {
//		this.elevages = elevages;
//	}
	

	public double getSuperficie_totale() {
		return superficie_totale;
	}

	public void setSuperficie_totale(double superficie_totale) {
		this.superficie_totale = superficie_totale;
	}
	
	
}