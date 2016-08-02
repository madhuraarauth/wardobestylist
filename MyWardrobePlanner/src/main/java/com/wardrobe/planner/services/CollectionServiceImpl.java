package com.wardrobe.planner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.dao.CollectionDao;
import com.wardrobe.planner.model.Collection;

@Service("collectionService")
@Transactional
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	private CollectionDao collectionDao;
	
	
	public List<Collection> getAllCollections() {
		return collectionDao.getAllCollections();
	}


	public Collection getCollectionById(long collectionId) {
		return collectionDao.getCollectionById(collectionId);
	}


	public void updateCollection(Collection collections) {
		collectionDao.updateCollection(collections);		
	}


	public Collection addCollection(Collection collections) {
		return collectionDao.addCollection(collections);
	}


	public void deleteCollection(long id) {
		collectionDao.deleteCollection(id);		
	}

}
