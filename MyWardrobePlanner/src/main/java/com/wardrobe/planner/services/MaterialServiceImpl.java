package com.wardrobe.planner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.dao.MaterialDao;
import com.wardrobe.planner.model.Material;

@Service("materialService")
@Transactional
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialDao materialDao;
	
	public List<Material> getAllMaterials() {
		return materialDao.getAllMaterials();
	}

	public Material getMaterialById(long materialId) {
		return materialDao.getMaterialById(materialId);
	}

	public void updateMaterial(Material materials) {
		materialDao.updateMaterial(materials);
	}

	public Material addMaterial(Material materials) {
		return materialDao.addMaterial(materials);
	}

	public void deleteMaterial(long id) {
		materialDao.deleteMaterial(id);		
	}

}
