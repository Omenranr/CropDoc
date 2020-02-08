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
import model.AddWorkerForm;
import model.Ferme;
import model.Fermier;
import model.User;
import model.Worker;

/**
 * Servlet implementation class AddWorker
 */
@WebServlet("/farmanager/addWorker")
public class AddWorker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/addWorker.jsp";
	private UserDao userDao;
	private FermeDao fermeDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWorker() {
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
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUtilisateur");
		Fermier fermier = new Fermier();
		fermier.setId(user.getId());
		long id_fermier = fermier.getId() ;
		Ferme ferme = fermeDao.getFarmOfUser(id_fermier);
		Worker worker = new Worker();
		worker.setFerme(ferme);
		AddWorkerForm workerForm = new AddWorkerForm(userDao);
		worker = workerForm.registerWorker(request, worker);
		request.setAttribute("workerForm", workerForm);
	       request.setAttribute("worker",worker);
	       String contextPath = (String) request.getContextPath();
	       if(workerForm.getErreurs().isEmpty())
	       {
	    	   response.sendRedirect(contextPath + "/farmanager");
	       }
	       else
	       {
		       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	       }
	    }
		
		
	

}
