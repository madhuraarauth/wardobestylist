package com.wardrobe.planner.dao;

import java.util.List;

import com.wardrobe.planner.model.Categories;

public interface CategoriesDao {

	List<Categories> getAllCategories();
	Categories getCategoryById(long categoryId);
	void updateCategories(Categories categories);
	Categories addCategories(Categories categories);
	void deleteCategories(long id);
	
}
