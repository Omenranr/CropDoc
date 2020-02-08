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
 * Servlet implementation class Worker_Oper
 */
@WebServlet(urlPatterns = {"/farmanager/updateWorker","/farmanager/deleteWorker"} )
public class Worker_Oper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/addWorker.jsp";
	private UserDao userDao;
	private FermeDao fermeDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Worker_Oper() {
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

		request.getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
