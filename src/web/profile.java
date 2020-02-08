package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import model.ProfileForm;
import model.User;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserDao dao;
	public static final String VUE = "/WEB-INF/testJsp.jsp"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
        dao= new UserDaoImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   ProfileForm profileForm=new ProfileForm(dao);	
	       User user=profileForm.updateProfil(request);
	       request.setAttribute("profileForm", profileForm);
	       request.setAttribute("user",user);
	       String contextPath = (String) request.getContextPath();
	       if(profileForm.getErreurs().isEmpty())
	       {
	    	   response.sendRedirect(contextPath + "/home");
	       }
	       else
	       {
		       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	       }
	}

}
