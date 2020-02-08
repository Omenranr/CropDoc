package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import model.RegistrationForm;
import model.User;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserDao dao;
	public static final String VUE = "/WEB-INF/register.jsp";   
    
	
	
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	public void init() {
	        dao= new UserDaoImpl();
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( VUE ).forward( request, response );
	}
		
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	       RegistrationForm registerForm=new RegistrationForm(dao);	
	       User user=registerForm.register(request);
	       request.setAttribute("registerForm", registerForm);
	       request.setAttribute("user",user);
	       String contextPath = (String) request.getContextPath();
	       if(registerForm.getErreurs().isEmpty())
	       {
	    	   response.sendRedirect(contextPath + "/login");
	       }
	       else
	       {
		       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	       }
	    }

}
