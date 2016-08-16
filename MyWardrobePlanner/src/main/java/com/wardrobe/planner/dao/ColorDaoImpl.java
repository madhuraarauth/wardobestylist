package com.wardrobe.planner.dao;

import java.util.List;

import org.hibernate.Hibernate;
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
		for(Colors color : colorsList){
            Hibernate.initialize(color.getItems());
        }
		return colorsList;
	}

	@Transactional
	public Colors getColorById(long colorId) {
		Colors colors = (Colors) hibernateTemplate.get(Colors.class, colorId);
		if(colors!=null){
			Hibernate.initialize(colors.getItems());
		}
		return colors;
	}
	public void updateColors(Colors colors) {
		try {
			hibernateTemplate.saveOrUpdate(colors);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public Colors addColors(Colors colors) {
		try {
			hibernateTemplate.save(colors);
			return colors;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public void deleteColor(long id) {
		try {
			hibernateTemplate.delete(getColorById(id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
