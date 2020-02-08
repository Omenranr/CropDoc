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
import model.User;

/**
 * Servlet implementation class AddFarm
 */
@WebServlet("/farmanager/addFarm")
public class AddFarm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/farmanager";
	private UserDao userDao;
	private FermeDao fermeDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFarm() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String contextPath = (String) request.getContextPath();
		User user = (User) session.getAttribute("sessionUtilisateur");
		String city = request.getParameter("city");
		double superficie_totale = Double.parseDouble(request.getParameter("superficie")) ;
		Fermier fermier = new Fermier();
		fermier.setId(user.getId());
		Ferme ferme = new Ferme();		
		ferme.setCity(city);
		ferme.setFermier(fermier);
		ferme.setSuperficie_totale(superficie_totale);
		fermeDao.addFarm(ferme);
		response.sendRedirect(contextPath + "/farmanager");
	}

}
