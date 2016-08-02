package com.wardrobe.planner.services;

import java.util.List;

import com.wardrobe.planner.model.Items;

public interface ItemsService {

	List<Items> getAllItems();
	Items getItemsById(long itemId);
	void updateItem(Items items);
	Items addItem(Items items);
	void deleteItem(long id);
}
