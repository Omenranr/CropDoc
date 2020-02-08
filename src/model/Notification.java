package model;

import java.sql.Date;

public class Notification {
	
	private long id_notificatoion;
	//elevage ou parcelle
	private String type;
	private String content;
	private Date date;
	//lue ou non lue
	private boolean status;
	private long id_user;
	//elevage ou parcelle
	private long id_commun;

	public long getId_notificatoion() {
		return id_notificatoion;
	}
	public void setId_notificatoion(long id_notificatoion) {
		this.id_notificatoion = id_notificatoion;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	public long getId_commun() {
		return id_commun;
	}
	public void setId_commun(long id_commun) {
		this.id_commun = id_commun;
	}
	public Notification() {
		super();
	}
	public Notification(String type, String content, Date date, boolean status, long id_user, long id_commun) {
		super();
		this.type = type;
		this.content = content;
		this.date = date;
		this.status = status;
		this.id_user = id_user;
		this.id_commun = id_commun;
	}
	
	

}
