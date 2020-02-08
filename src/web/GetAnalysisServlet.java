package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.AnalysisHolder;
import model.Disease;
import model.GetAnalysis;
import model.Plant;
import model.Treatment;

import dao.DiseaseDao;
import dao.DiseaseDaoImpl;
import dao.PlantDao;
import dao.PlantDaoImpl;
import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.TreatmentDao;
import dao.TreatmentDaoImpl;

/**
 * Servlet implementation class testServ
 */
@WebServlet("/getAnalysisServlet")
public class GetAnalysisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  PlantDao plantDao;
	private DiseaseDao diseaseDao;
	private TreatmentDao treatmentDao;
	private RequestDao requestDao;
	private AnalysisHolder analysisHolder;
	String pname;
	String dname;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAnalysisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        plantDao = new PlantDaoImpl();
        diseaseDao = new DiseaseDaoImpl();
        treatmentDao = new TreatmentDaoImpl();
        requestDao = new RequestDaoImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				GetAnalysis analyser = new GetAnalysis(plantDao, diseaseDao, treatmentDao, requestDao);
				
				//extract Plant, Disease, Treatment objects
				System.out.println("Extract plant,disease,treatment");
				Plant plant = analyser.extractPlant(request);
				Disease disease = analyser.extractDisease(request);
				Treatment treatment = analyser.extractTreatment(request);
				if(plant.getScienceName() != null) {
					System.out.println("saving request");
					analyser.saveRequest(request);
				}
				System.out.println(disease.getLevelOfDanger());
				//serialize objects : plant, disease, treatment.
				Gson gson = new Gson();
				analysisHolder = new AnalysisHolder();
				analysisHolder.setDisease(disease);
				analysisHolder.setPlant(plant);
				analysisHolder.setTreatment(treatment);
				String analysisHolderJson = gson.toJson(analysisHolder);
				//send objects to front end
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(analysisHolderJson);
				out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}