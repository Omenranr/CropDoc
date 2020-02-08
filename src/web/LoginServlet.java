package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import dao.FermeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import model.Ferme;
import model.LoginForm;
import model.User;
import model.Weather;
import model.WeatherData;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserDao dao;
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE = "/WEB-INF/login.jsp"; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
        dao = new UserDaoImpl();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	       LoginForm LoginForm = new LoginForm(dao);	
	       String contextPath = (String) request.getContextPath();
	       User user = LoginForm.login(request);
	       HttpSession session = request.getSession();
	       request.setAttribute("LoginForm", LoginForm);
	       request.setAttribute("user",user);

	       


	       if(LoginForm.getErreurs().isEmpty())
	       {
	           session.setAttribute( ATT_SESSION_USER, user );
	           //Rabat is the default city for users who don't have city i DB
	           String userCity = "Rabat";
	           Ferme farm = new Ferme();
	           System.out.println(user.getId());
	           farm = new FermeDaoImpl().getFarmOfUser(user.getId());
	           if(farm != null)
	        	userCity = farm.getCity();
	           	request.setAttribute("userCity", userCity);
	    	    response.sendRedirect(contextPath + "/home");
	       }
	       else 
	       {
		    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	       }
	      
	        
	    }
    
    
}
