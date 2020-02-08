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
import model.Ferme;
import model.Fermier;
import model.Parcelle;
import model.User;

/**
 * Servlet implementation class Parcelle_Oper
 */
@WebServlet(urlPatterns = {"/farmanager/deleteParcelle","/farmanager/updateParcelle","/farmanager/viewParcelle"})
public class Parcelle_Oper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private FermeDao fermeDao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parcelle_Oper() {
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
		Long id = Long.parseLong(request.getParameter("id"));
		Parcelle parcelle = fermeDao.getParcelleById(id);
		if(path.equals("/farmanager/deleteParcelle") ) {
			System.out.println("FIIIRST");			
			fermeDao.supprimer_Parcelle(parcelle);
			String contextPath = (String) request.getContextPath();
			response.sendRedirect(contextPath + "/farmanager");
		}
		else if(path.equals("/farmanager/updateParcelle")) {
			System.out.println("SECOND");
			request.setAttribute("parcelle", parcelle);
			request.getRequestDispatcher("/WEB-INF/updateParcelle.jsp").forward(request,  response);
		}
		else if(path.equals("/farmanager/viewParcelle")) {
			System.out.println("THIRD");
			request.getRequestDispatcher("/WEB-INF/viewParcelle.jsp").forward(request,  response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String contextPath = (String) request.getContextPath();
		User user = (User) session.getAttribute("sessionUtilisateur");
		long id_parcelle = Long.parseLong(request.getParameter("id_parcelle"));
		long id_farm = Long.parseLong(request.getParameter("id_farm"));
		String type_culture = request.getParameter("type_culture");
		String scienceName = request.getParameter("scienceName");
		double superficie = Double.parseDouble(request.getParameter("superficie"));
		Parcelle parcelle = new Parcelle();
		parcelle.setType_culture(type_culture);
		parcelle.setSuperficie(superficie);
		parcelle.setScienceName(scienceName);
		parcelle.setId_parcelle(id_parcelle);
		parcelle.setId_farm(id_farm);
		fermeDao.updateParcelle(parcelle);
		response.sendRedirect(contextPath + "/farmanager");
	}

}
