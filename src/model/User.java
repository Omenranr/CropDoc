package model;

import java.util.ArrayList;

public class User {
	 private Long      id;
	 private String    nom;
	 private String    prenom;
	 private String    email;
	 private String    password;
	 
	 
	public User() {};
	 public User(String nom, String prenom, String email, String password)
	 {
		 this.nom=nom;
		 this.prenom=prenom;
		 this.email = email;
		 this.password=password;
	 }
	 public Long getId() {
	        return id;
	    }
	    public void setId( Long id ) {
	        this.id = id;
	    }
	    
	    public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

	    public void setEmail( String email ) {
	        this.email = email;
	    }
	    public String getEmail() {
	        return email;
	    }

	    public void setPassword( String password ) {
	        this.password = password;
	    }
	    public String getPassword() {
	        return password;
	    }

	    
}
