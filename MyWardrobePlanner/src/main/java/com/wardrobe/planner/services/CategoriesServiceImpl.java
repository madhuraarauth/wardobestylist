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


	public Categories getCategoryById(long categoryId) {
		return categoriesDao.getCategoryById(categoryId);
	}


	public void updateCategories(Categories categories) {
		categoriesDao.updateCategories(categories);		
	}


	public Categories addCategories(Categories categories) {
		return categoriesDao.addCategories(categories);
	}


	public void deleteCategories(long id) {
		categoriesDao.deleteCategories(id);
	}

}
