package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.FermeDao;
import dao.FermeDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import model.Ferme;
import model.Fermier;
import model.Task;
import model.User;
import model.Worker;
import model.WorkersHolder;

/**
 * Servlet implementation class AddTask
 */
@WebServlet("/farmanager/addTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/addTask.jsp";
	private UserDao userDao;
	private FermeDao fermeDao;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTask() {
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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUtilisateur");
		WorkersHolder workersHolder = new WorkersHolder();
		Ferme ferme = null;
		ferme = fermeDao.getFarmOfUser(user.getId());
		List<Worker> workers = fermeDao.getWorkers(ferme.getId_farm());
		workersHolder.setWorkers(workers);
		request.setAttribute("workers", workers);
		Gson gson = new Gson();
		String workersHolderJson = gson.toJson(workersHolder);
		//send objects to front end
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(workersHolderJson);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = (String) request.getContextPath();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUtilisateur");
		Fermier fermier = new Fermier();
		fermier.setId(user.getId());
		long id_fermier = fermier.getId() ;
		Ferme ferme = fermeDao.getFarmOfUser(id_fermier);
		List<Worker> workers = fermeDao.getWorkers(ferme.getId_farm());
		String designation = request.getParameter("designation");
		String urgency = request.getParameter("urgency");
		String startDateStr = request.getParameter("dateDebut");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String endDateStr = request.getParameter("dateFin");
		System.out.println(endDateStr);
		System.out.println(startDateStr);
		Date dateDebut = null;
		Date dateFin = null;
		try {
			dateDebut = sdf.parse(startDateStr);
			dateFin = sdf.parse(endDateStr);
			System.out.println(dateDebut);
			System.out.println(dateFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Task tache = new Task();
		tache.setDesignation(designation);
		tache.setUrgency(urgency);
		tache.setDateDebut(dateDebut);
		tache.setDateFin(dateFin);
		fermeDao.ajouterTache(tache);
		for(Worker worker:workers )
		{
			if(request.getParameter(""+worker.getId()) != null)
			{
				System.out.println("Workder id" + worker.getId());
				fermeDao.affecter_Tache(tache, worker);
			}
		}
		response.sendRedirect(contextPath + "/farmanager");
		
	}

}
