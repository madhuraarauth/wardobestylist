package com.wardrobe.planner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.model.Material;
@Repository
public class MaterialDaoImpl implements MaterialDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public MaterialDaoImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public MaterialDaoImpl() {

	}

	@Transactional
	public List<Material> getAllMaterials() {
		List<Material> materialList = (List<Material>) hibernateTemplate.find("from Material");
		return materialList;
	}
	
	@Transactional
	public Material getMaterialById(long materialId) {
		Material materials = (Material) hibernateTemplate.get(Material.class, materialId);
		return materials;
	}
	public void updateMaterial(Material materials) {
		try {
			hibernateTemplate.saveOrUpdate(materials);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public Material addMaterial(Material materials) {
		try {
			hibernateTemplate.save(materials);
			return materials;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public void deleteMaterial(long id) {
		try {
			hibernateTemplate.delete(getMaterialById(id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
