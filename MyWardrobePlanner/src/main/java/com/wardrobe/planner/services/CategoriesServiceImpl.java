package com.wardrobe.planner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.dao.CategoriesDao;
import com.wardrobe.planner.model.Categories;

@Service("categoriesService")
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;
	
	
	public List<Categories> getAllCategories() {
		return categoriesDao.getAllCategories();
	}

}
