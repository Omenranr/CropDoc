package model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDao;

public class ProfileForm {
	private  UserDao dao;
	private User user;
	private Map<String,String> erreurs = new HashMap<String, String>();
	private String resultat;
	private String errorMsg = null;
	
	
	public ProfileForm(UserDao dao)
	{
		this.dao=dao;
	}
	
	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}
	
	public User updateProfil(HttpServletRequest request )
	{
		HttpSession session = request.getSession();
		//Récuperer l'id et l'ancienne email du l'utilsateur
		Long id =((User)session.getAttribute("sessionUtilisateur")).getId();
		String oldEmail =((User)session.getAttribute("sessionUtilisateur")).getEmail();
		System.out.println("le id de de user est "+id);
		
		//Récuperer les informations saisis dans la formulaire 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmation = request.getParameter("password_repeat");
		user=new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		this.ValidateEmail(email,oldEmail);
		this.validatePassword(password, confirmation);
		if(!erreurs.isEmpty()) //les champs ne sont pas saisis corrrectement 
			{
			resultat="Failure";
			return user;
			}
		boolean status=dao.updateProfil(user);
		if (status==false)
		{
			resultat="Update failed";
			erreurs.put("updateProfil",resultat);
		}
		else
		{
			resultat="Success";
		}
		
		return user;
		
	}
	
	
	public boolean ValidateEmail(String email,String OldEmail)
	{
		if(email == null || email.equals("")){
			errorMsg = "Email field can't be empty.";
			erreurs.put( "email", errorMsg );
			System.out.println(erreurs.get("email"));
			return false;
		}
		else if(dao.emailAlreadyExist_withException(email, OldEmail))
			{
				errorMsg = "Email Already in use";
				erreurs.put( "email", errorMsg );
				System.out.println(erreurs.get("email"));
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
