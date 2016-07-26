package com.wardrobe.planner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.model.Items;

@Repository
public class ItemsDaoImpl implements ItemsDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public ItemsDaoImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public ItemsDaoImpl() {

	}

	@Transactional
	public List<Items> getAllItems() {
		@SuppressWarnings("unchecked")
		List<Items> itemsList = (List<Items>) hibernateTemplate.find("from Items");
		return itemsList;
	}

}
