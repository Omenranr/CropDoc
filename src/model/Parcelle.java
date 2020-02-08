package model;

import java.util.HashMap;

public class Parcelle {
	private Long id_parcelle;	
	private double superficie; 
	private String type_culture; 
	private String scienceName;
	private boolean disease_Detected;
	private HashMap<String, Disease> diseases = new HashMap<String, Disease>();
	private Long id_farm;
	 
	
	public Parcelle() {};
	
	public HashMap<String, Disease> getParcelleDiseases() {
		return this.diseases;
	}
	
	public void setParcelleDiseases(HashMap<String, Disease> diseases) {
		this.diseases = diseases;
	}
	
	public Long getId_parcelle() {
		return id_parcelle;
	}

	public void setId_parcelle(Long id_parcelle) {
		this.id_parcelle = id_parcelle;
	}
	
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public String getType_culture() {
		return type_culture;
	}

	public boolean isDisease_Detected() {
		return disease_Detected;
	}

	public void setDisease_Detected(boolean disease_Detected) {
		this.disease_Detected = disease_Detected;
	}

	public void setType_culture(String type_culture) {
		this.type_culture = type_culture;
	}

	public String getScienceName() {
		return scienceName;
	}

	public void setScienceName(String scienceName) {
		this.scienceName = scienceName;
	}


	public Long getId_farm() {
		return id_farm;
	}

	public void setId_farm(Long id_farm) {
		this.id_farm = id_farm;
	};
	
	
}
