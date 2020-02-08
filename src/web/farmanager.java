package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FermeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import model.Elevage;
import model.Ferme;
import model.Fermier;
import model.Task;
import model.Parcelle;
import model.User;
import model.Worker;


/**
 * Servlet implementation class farmanager
 */
@WebServlet("/farmanager")
public class farmanager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/farmanager.jsp";
	private UserDao userDao;
	private FermeDaoImpl fermeDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public farmanager() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUtilisateur");
		String userType = userDao.getUserType(user);
		if(userType.equals("farmer"))
		{
			
			Ferme ferme = null;
			ferme = fermeDao.getFarmOfUser(user.getId());
			if(ferme != null)
			{
				List<Worker> workers = fermeDao.getWorkers(ferme.getId_farm());
				ferme.setWorkers(workers);
				List<Elevage> elevages = fermeDao.getElevages(ferme.getId_farm());
				ferme.setElevage(elevages);
				List<Parcelle> parcelles = fermeDao.getParcelles(ferme.getId_farm());
				ferme.setParcelle(parcelles);
				request.setAttribute("ferme", ferme);
				
			}
		}
		else if (userType.equals("worker"))
		{
			Worker worker = new Worker();
			worker.setId(user.getId());
			List<Task> taches =  fermeDao.getTasksOfWorker(worker);
			request.setAttribute("taches", taches);
		}
		request.setAttribute("userType",userType);
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
