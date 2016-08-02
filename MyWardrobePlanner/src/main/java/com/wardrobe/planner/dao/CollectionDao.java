package com.wardrobe.planner.dao;

import java.util.List;

import com.wardrobe.planner.model.Collection;

public interface CollectionDao {

	List<Collection> getAllCollections();
	Collection getCollectionById(long collectionId);
	void updateCollection(Collection collections);
	Collection addCollection(Collection collections);
	void deleteCollection(long id);
}
