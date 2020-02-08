package model;
import java.util.HashMap;

public class Plant {
	private String scienceName;
	private String name;
	private String variety;
	private double nightTemp;
	private double dayTemp;
	private double criticalTempMax;
	private double criticalTempMin;
	private int numberMonths;
	private String climatGeography;
	private String insights;
	private String picture;
	
	public double getCriticalTempMax() {
		return criticalTempMax;
	}

	public void setCriticalTempMax(double criticalTempMax) {
		this.criticalTempMax = criticalTempMax;
	}

	public double getCriticalTempMin() {
		return criticalTempMin;
	}

	public void setCriticalTempMin(double criticalTempMin) {
		this.criticalTempMin = criticalTempMin;
	}

	
	
	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public double getNightTemp() {
		return nightTemp;
	}

	public void setNightTemp(double nightTemp) {
		this.nightTemp = nightTemp;
	}

	public double getDayTemp() {
		return dayTemp;
	}

	public void setDayTemp(double dayTemp) {
		this.dayTemp = dayTemp;
	}


	public int getNumberMonths() {
		return this.numberMonths;
	}

	public void setNumberMonths(int numberMonths) {
		this.numberMonths = numberMonths;
	}

	public String getClimatGeography() {
		return this.climatGeography;
	}

	public void setClimatGeography(String climatGeography) {
		this.climatGeography = climatGeography;
	}

	public String getInsights() {
		return this.insights;
	}

	public void setInsights(String insights) {
		this.insights = insights;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public String getScienceName() {
		return scienceName;
	}

	public void setScienceName(String scienceName) {
		this.scienceName = scienceName;
	}
	
}
