package com.wardrobe.planner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.model.Colors;
@Repository
public class ColorDaoImpl implements ColorDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public ColorDaoImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public ColorDaoImpl() {

	}



	@Transactional
	public List<Colors> getAllColors() {
		@SuppressWarnings("unchecked")
		List<Colors> colorsList = (List<Colors>) hibernateTemplate.find("from Colors");

		return colorsList;
	}

	public Colors getColorByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addColor(Colors color) {
		// TODO Auto-generated method stub

	}

}
