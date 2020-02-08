package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FermeDao;
import dao.FermeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Servlet implementation class Elevage
 */
@WebServlet("//farmanager/Elevage")
public class Elevage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private FermeDao fermeDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Elevage() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
        fermeDao = new FermeDaoImpl();
        userDao = new UserDaoImpl();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		System.out.println(path);
		request.getRequestDispatcher("/WEB-INF/updateElevage.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
