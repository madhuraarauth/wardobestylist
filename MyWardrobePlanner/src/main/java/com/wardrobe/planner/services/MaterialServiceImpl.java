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

}
