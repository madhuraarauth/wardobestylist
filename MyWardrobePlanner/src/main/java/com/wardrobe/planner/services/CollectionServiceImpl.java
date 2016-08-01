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

}
