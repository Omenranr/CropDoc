package model;
import java.util.ArrayList;
import java.util.HashMap;

public class Disease {
	private String name;
	private String symptomes;
	private String levelOfDanger;
	private String treatmentName;
	
	public String getTreatmentName() {
		return treatmentName;
	}
	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getName() {
		return this.name;
	}
	
	public String getSymptomes() {
		return symptomes;
	}
	public void setSymptomes(String symptomes) {
		this.symptomes = symptomes;
	}
	
	public String getLevelOfDanger() {
		return levelOfDanger;
	}
	public void setLevelOfDanger(String levelOfDanger) {
		this.levelOfDanger = levelOfDanger;
	}
	
}
