package com.wardrobe.planner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.model.Categories;
@Repository
public class CategoriesDaoImpl implements CategoriesDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public CategoriesDaoImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public CategoriesDaoImpl() {

	}


	@Transactional
	public List<Categories> getAllCategories() {
		List<Categories> categoriesList = (List<Categories>) hibernateTemplate.find("from Categories");
		return categoriesList;
	}

}
