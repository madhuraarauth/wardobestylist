package com.wardrobe.planner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.model.Collection;
@Repository
public class CollectionDaoImpl implements CollectionDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public CollectionDaoImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public CollectionDaoImpl() {

	}


	@Transactional
	public List<Collection> getAllCollections() {
		List<Collection> collectionList = (List<Collection>) hibernateTemplate.find("from Collection");
		return collectionList;
	}

}
