package model;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DiseaseDao;
import dao.PlantDao;
import dao.RequestDao;
import dao.TreatmentDao;

public class GetAnalysis {
	private PlantDao plantDao;
	private DiseaseDao diseaseDao;
	private TreatmentDao treatmentDao;
	private RequestDao requestDao;
	
	public GetAnalysis(PlantDao plantDao, DiseaseDao diseaseDao, TreatmentDao treatmentDao, RequestDao requestDao) {
		this.plantDao = plantDao;
		this.diseaseDao = diseaseDao;
		this.treatmentDao = treatmentDao;
		this.requestDao = requestDao;
	}
	
	public Plant extractPlant(HttpServletRequest request) {
		String pname = (String) request.getParameter("pname");
		System.out.println(pname);
		Plant plant;
		plant = plantDao.getPlant(pname);
		return plant;
	}
	
	public Plant extractPlantNormal(HttpServletRequest request) {
		String pname = (String) request.getParameter("pname");
		System.out.println(pname);
		Plant plant;
		plant = plantDao.getPlantByName(pname);
		return plant;
	}
	
	public Disease extractDisease(HttpServletRequest request) {
		String dname = (String) request.getParameter("dname");
		Disease disease;
		disease = diseaseDao.getDiseaseByDiseaseName(dname);
		return disease;
	}
	
	public Treatment extractTreatment(HttpServletRequest request) {
		String dname = (String) request.getParameter("dname");
		Treatment treatment;
		treatment = treatmentDao.getTreatment(dname);
		return treatment;
	}
	
	public ArrayList<Disease> extractAllDisease(String pname) {
		ArrayList<Disease> diseases;
		diseases = diseaseDao.getPlantDiseases(pname);
		return diseases;
	}
	
	public void saveRequest(HttpServletRequest req) {
		Request request = new Request();
		java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("sessionUtilisateur");
		//Variable needed : String type, Long user_id, Date date;
		String type = (String) req.getParameter("dname") + "_request";
		System.out.println(user.getPrenom());
		long user_id = user.getId();
		request.setUserID(user_id);
		request.setType(type);
		request.setDate(sqlDate);
		requestDao.saveRequest(request, user_id);
	}
}
