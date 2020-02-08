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
import model.Parcelle;
import model.User;

/**
 * Servlet implementation class AddParcelle
 */
@WebServlet("/farmanager/addParcelle")
public class AddParcelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/addParcelle.jsp";
	private UserDao userDao;
	private FermeDao fermeDao;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddParcelle() {
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
		
		request.getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String contextPath = (String) request.getContextPath();
		User user = (User) session.getAttribute("sessionUtilisateur");
		Fermier fermier = new Fermier();
		fermier.setId(user.getId());
		long id_fermier = fermier.getId() ;
		Ferme ferme = fermeDao.getFarmOfUser(id_fermier);
		
		String type_culture = request.getParameter("type_culture");
		String scienceName = request.getParameter("scienceName");
		double superficie = Double.parseDouble(request.getParameter("superficie")) ;
		Parcelle parcelle = new Parcelle();
		parcelle.setType_culture(type_culture);
		parcelle.setSuperficie(superficie);
		parcelle.setScienceName(scienceName);
		parcelle.setId_farm(ferme.getId_farm());
		fermeDao.ajouter_Parcelle(parcelle);
		response.sendRedirect(contextPath + "/farmanager");
	}

}
