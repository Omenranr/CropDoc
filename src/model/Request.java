package model;

import java.sql.Date;

public class Request {
	private double id;
	private String type;
	private long user_id;
	private Date date;
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getUserID() {
		return this.user_id;
	}
	public void setUserID(long user_id) {
		this.user_id = user_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
