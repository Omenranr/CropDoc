package dao;

import model.Plant;

public interface PlantDao {
	Plant getPlant(String pname);
	Plant getPlantByName(String pNormalName);
}
