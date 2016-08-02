package com.wardrobe.planner.services;

import java.util.List;

import com.wardrobe.planner.model.Material;

public interface MaterialService {

	List<Material> getAllMaterials();
	Material getMaterialById(long materialId);
	void updateMaterial(Material materials);
	Material addMaterial(Material materials);
	void deleteMaterial(long id);
}
