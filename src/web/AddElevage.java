package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FermeDao;
import dao.FermeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import model.Elevage;
import model.Ferme;
import model.Fermier;
import model.User;

/**
 * Servlet implementation class AddElevage
 */
@WebServlet("/farmanager/addElevage")
public class AddElevage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/addElevage.jsp";
	private UserDao userDao;
	private FermeDao fermeDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddElevage() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
        userDao = new UserDaoImpl();
       fermeDao = new FermeDaoImpl();
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String contextPath = (String) request.getContextPath();
		User user = (User) session.getAttribute("sessionUtilisateur");
		String type_Elevage = request.getParameter("type_Elevage");
		double superficie = Double.parseDouble(request.getParameter("superficie")) ;
		int headNumber = Integer.parseInt(request.getParameter("headNumber"));
		
		
		Fermier fermier = new Fermier();
		fermier.setId(user.getId());
		long id_fermier = fermier.getId() ;
		Ferme ferme = fermeDao.getFarmOfUser(id_fermier);
		Elevage elevage = new Elevage();
		elevage.setId_farm(ferme.getId_farm());
		elevage.setType_Elevage(type_Elevage);
		elevage.setHeadNumber(headNumber);
		elevage.setSuperficie(superficie);
		fermeDao.ajouter_Elevage(elevage);
		response.sendRedirect(contextPath + "/farmanager");
	}

}
