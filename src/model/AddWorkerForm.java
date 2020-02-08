package model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;

public class AddWorkerForm {
	private  UserDao dao;
	private Map<String,String> erreurs = new HashMap<String, String>();
	private String resultat;
	private String errorMsg = null;
	
	
	public AddWorkerForm(UserDao dao)
	{
		this.dao=dao;
	}
	
	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}
	
	public Worker registerWorker(HttpServletRequest request,Worker worker )
	{
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmation = request.getParameter("password_repeat");
		double salary=0;
	    if(request.getParameter("salary")!=null)
	    	salary = Double.parseDouble(request.getParameter("salary")) ;
		worker.setNom(nom);
		worker.setPrenom(prenom);
		worker.setEmail(email);
		worker.setPassword(password);
		worker.setSalary(salary);
		this.ValidateEmail(email);
		this.validatePassword(password, confirmation);
		if(!erreurs.isEmpty()) //les champs ne sont pas saisis corrrectement 
			{
			resultat="Failure";
			return worker;
			}
		boolean status=dao.add_worker(worker);
		if (status==false)
		{
			resultat="Registration failed";
			erreurs.put("register",resultat);
			
		}
		else
		{
			Mail.send("projetJEE.mail@gmail.com","projetjee"
					,email,"Automated Mail sending ","Your are assigned as worker in our site ,here is your email : "+email+" and password :"+password); 
			resultat="Success";
			
		}
		
		System.out.println("le id de l'worker qui vient detre insere est "+worker.getId());
		return worker;
		
	}
	
	
	public boolean ValidateEmail(String email)
	{
		if(email == null || email.equals("")){
			errorMsg = "Email field can't be empty.";
			erreurs.put( "email", errorMsg );
			return false;
		}
		else if(dao.emailAlreadyExist(email))
			{
				errorMsg = "Email Already in use";
				erreurs.put( "email", errorMsg );
				return false;
			}
		else
			return true;
		
	}
	
	public boolean validatePassword(String password,String confirmation)
	{
		if(password == null || password.equals("")){
			errorMsg = "Password  field can't be empty.";
			erreurs.put( "password", errorMsg );
			System.out.println(erreurs.get("password"));
			return false;
		}
		else if (!password.equals(confirmation)){
			errorMsg = "wrong repetition of password.";
			erreurs.put( "confirmation", errorMsg );
			System.out.println(erreurs.get("confirmation"));
			return false;
		}
		else
			return true;
	}
}
