package model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;

public class LoginForm {
	private  UserDao dao;
	private User user;
	private Map<String,String> erreurs = new HashMap<String, String>();
	private String resultat;
	private String errorMsg = null;
	
	
	public LoginForm(UserDao dao)
	{
		this.dao = dao;
	}
	
	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}
	
	public User login(HttpServletRequest request )
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user = new User();
		user.setEmail(email);
		user.setPassword(password);
		this.ValidateEmail(email);
		this.validatePassword(password);
		if(!erreurs.isEmpty()) //les champs ne sont pas saisis corrrectement 
			{
			resultat="Login Failed";
			return user;
			}
		boolean status = dao.login(user);
		if (status==false)
		{
			resultat="Login failed : Wrong email or password";
			erreurs.put("login", resultat);
		}
		else
		{
			resultat="Success";
		}
		
		return user;
		
	}
	
	
	public boolean ValidateEmail(String email)
	{
		if(email == null || email.equals("")){
			errorMsg = "Email field can't be empty.";
			erreurs.put( "email", errorMsg );
			return false;
		}
		
		return true;
		
	}
	
	public boolean validatePassword(String password)
	{
		if(password == null || password.equals("")){
			errorMsg = "Password field can't be empty.";
			erreurs.put( "password", errorMsg );
			System.out.println(erreurs.get("password"));
			return false;
		}
		
		return true;
	}
}
