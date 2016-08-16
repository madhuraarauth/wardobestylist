package com.wardrobe.planner.dao;

import java.util.List;

import org.hibernate.Hibernate;
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
		for(Collection collection : collectionList){
            Hibernate.initialize(collection.getItems());
        }
		return collectionList;
	}
	
	@Transactional
	public Collection getCollectionById(long collectionId) {
		Collection collections = (Collection) hibernateTemplate.get(Collection.class, collectionId);
		if(collections != null){
			 Hibernate.initialize(collections.getItems());
		}
		return collections;
	}
	public void updateCollection(Collection collections) {
		try {
			hibernateTemplate.saveOrUpdate(collections);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public Collection addCollection(Collection collections) {
		try {
			hibernateTemplate.save(collections);
			return collections;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public void deleteCollection(long id) {
		try {
			hibernateTemplate.delete(getCollectionById(id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


}
