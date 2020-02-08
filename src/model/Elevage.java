package model;

public class Elevage {
	private Long id_Elevage;
	private String type_Elevage;
	private Long id_farm;
	private int headNumber;
	private double superficie;
	
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public Long getId_Elevage() {
		return id_Elevage;
	}
	public void setId_Elevage(Long id_Elevage) {
		this.id_Elevage = id_Elevage;
	}
	public String getType_Elevage() {
		return type_Elevage;
	}
	public void setType_Elevage(String type_Elevage) {
		this.type_Elevage = type_Elevage;
	}
	public int getHeadNumber() {
		return headNumber;
	}
	public void setHeadNumber(int headNumber) {
		this.headNumber = headNumber;
	}
	public Long getId_farm() {
		return id_farm;
	}
	public void setId_farm(Long id_farm) {
		this.id_farm = id_farm;
	}
	
	
	
}
