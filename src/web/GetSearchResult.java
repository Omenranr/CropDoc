package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DiseaseDao;
import dao.DiseaseDaoImpl;
import dao.PlantDao;
import dao.PlantDaoImpl;
import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.TreatmentDao;
import dao.TreatmentDaoImpl;
import model.AnalysisHolder;
import model.Disease;
import model.GetAnalysis;
import model.Plant;
import model.SearchHolder;
import model.Treatment;

/**
 * Servlet implementation class GetSearchResult
 */
@WebServlet("/GetSearchResult")
public class GetSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  PlantDao plantDao;
	private DiseaseDao diseaseDao;
	private TreatmentDao treatmentDao;
	private RequestDao requestDao;
	private AnalysisHolder analysisHolder;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSearchResult() {
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
		SearchHolder searchHolder = new SearchHolder();
		Gson gson = new Gson();
		ArrayList<Disease> diseases = new ArrayList<Disease>();
		System.out.println("Extract plant,disease,treatment");
		Plant plant = analyser.extractPlantNormal(request);
		if(plant.getName() != null) {
			diseases = analyser.extractAllDisease(plant.getScienceName());
		}
		searchHolder.setPlant(plant);
		searchHolder.setDiseases(diseases);
		
		String searchHolderJson = gson.toJson(searchHolder);
		//send objects to front end
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(searchHolderJson);
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
