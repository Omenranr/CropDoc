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
import model.Elevage;

/**
 * Servlet implementation class Elevage_Oper
 */
@WebServlet(urlPatterns = {"/farmanager/deleteElevage","/farmanager/updateElevage","/farmanager/viewElevage"})
public class Elevage_Oper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VUE = "";
	private UserDao userDao;
	private FermeDao fermeDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Elevage_Oper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() {
        fermeDao = new FermeDaoImpl();
        userDao = new UserDaoImpl();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		Long id = Long.parseLong(request.getParameter("id"));
		Elevage elevage = fermeDao.getElevageById(id);
		if(path.equals("/farmanager/deleteElevage") ) {
			System.out.println("FIIIRST");			
			fermeDao.supprimer_Elevage(elevage);
			String contextPath = (String) request.getContextPath();
			response.sendRedirect(contextPath + "/farmanager");
		}
		else if(path.equals("/farmanager/updateElevage")) {
			System.out.println("SECOND");
			request.setAttribute("elevage", elevage);
			request.getRequestDispatcher("/WEB-INF/updateElevage.jsp").forward(request,  response);
		}
		else if(path.equals("/farmanager/viewElevage")) {
			System.out.println("THIRD");
			request.getRequestDispatcher("/WEB-INF/viewElevage.jsp").forward(request,  response);
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextPath = (String) request.getContextPath();
		System.out.println("-1----"  + "------");
		long id_Elevage = Long.parseLong(request.getParameter("id_elevage"));
		System.out.println("-2----" + "------");
		String type_Elevage = request.getParameter("type_Elevage");
		System.out.println("-3----" + "------");
		double superficie = Double.parseDouble(request.getParameter("superficie")) ;
		int headNumber = Integer.parseInt(request.getParameter("headNumber"));
		System.out.println("-----" + id_Elevage + type_Elevage + superficie + headNumber + "------");
		Elevage elevage = new Elevage();
		elevage.setId_Elevage(id_Elevage);
		elevage.setType_Elevage(type_Elevage);
		elevage.setHeadNumber(headNumber);
		elevage.setSuperficie(superficie);
		fermeDao.updateElevage(elevage);
		response.sendRedirect(contextPath + "/farmanager");
	}

}
