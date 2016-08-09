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

	@Transactional
	public Categories getCategoryById(long categoryId) {
		Categories categories = (Categories) hibernateTemplate.get(Categories.class, categoryId);
		return categories;
	}
	
	@Transactional
	public void updateCategories(Categories categories) {
		try {
			hibernateTemplate.saveOrUpdate(categories);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	@Transactional
	public Categories addCategories(Categories categories) {
		try {
			hibernateTemplate.save(categories);
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	@Transactional
	public void deleteCategories(long id) {
		try {
			hibernateTemplate.delete(getCategoryById(id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
