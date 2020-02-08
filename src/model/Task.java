package model;

import java.util.Date;

//import java.util.Date;

public class Task {
	private Long id_task ;
	private String designation ;  
	private Date dateDebut;
	private Date dateFin;
	private String urgency;
	private Boolean accomplie ;
	
//	Date date = new Date();
//	formater = new SimpleDateFormat("EEEE, d MMM yyyy");
//    System.out.println(formater.format(aujourdhui));

    
	public Long getId_task() {
		return id_task;
	}
	public void setId_tache(Long id_task) {
		this.id_task = id_task;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public Boolean getAccomplie() {
		return accomplie;
	}
	public void setAccomplie(Boolean accomplie) {
		this.accomplie = accomplie;
	}
	
	
	
}
