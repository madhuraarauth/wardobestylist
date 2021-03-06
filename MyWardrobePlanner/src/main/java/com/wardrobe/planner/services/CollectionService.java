package com.wardrobe.planner.services;

import java.util.List;

import com.wardrobe.planner.model.Collection;

public interface CollectionService {

	List<Collection> getAllCollections();
	Collection getCollectionById(long collectionId);
	void updateCollection(Collection collections);
	Collection addCollection(Collection collections);
	void deleteCollection(long id);
}
