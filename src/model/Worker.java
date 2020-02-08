package model;

import java.util.HashMap;

public class Worker extends User {
	private Ferme ferme;
	private Double salary;
	private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	};
	
	public void setTasks(HashMap<String, Task> tasks) {
		this.tasks = tasks;
	}
	public HashMap<String, Task> getTasks() {
		return this.tasks;
	}
	public Ferme getFerme() {
		return ferme;
	}
	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}
	
	
}
