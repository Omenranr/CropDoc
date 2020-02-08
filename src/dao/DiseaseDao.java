package dao;

import java.util.ArrayList;

import model.Disease;
import model.Parcelle;

public interface DiseaseDao {
	ArrayList<Disease> getPlantDiseases(String pname);
	Disease getDiseaseByDiseaseName(String dname);
	void affectToParcelle(Disease disease, Parcelle parcelle);
}