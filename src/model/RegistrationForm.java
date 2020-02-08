package model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;

public class RegistrationForm {
	private  UserDao dao;
	private User user;
	private Map<String,String> erreurs = new HashMap<String, String>();
	private String resultat;
	private String errorMsg = null;
	
	
	public RegistrationForm(UserDao dao)
	{
		this.dao=dao;
	}
	
	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}
	
	public User register(HttpServletRequest request )
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmation = request.getParameter("password_repeat");
		String user_type = request.getParameter("user_type");
		user=new User();
		user.setEmail(email);
		user.setPassword(password);
		this.ValidateEmail(email);
		this.validatePassword(password, confirmation);
		if(!erreurs.isEmpty()) //les champs ne sont pas saisis corrrectement 
			{
			resultat="Failure";
			return user;
			}
		boolean status=dao.register(user,user_type);
		if (status==false)
		{
			resultat="Registration failed";
			erreurs.put("register",resultat);
		}
		else
		{
			resultat="Success";
			
		}
		
		System.out.println("le id de l'user qui vient detre insere est "+user.getId());
		return user;
		
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
