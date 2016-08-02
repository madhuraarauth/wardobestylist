package com.wardrobe.planner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.dao.ItemsDao;
import com.wardrobe.planner.model.Items;

@Service("itemsService")
@Transactional
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsDao itemsDao;
	
	public List<Items> getAllItems() {
		return itemsDao.getAllItems();
	}

	public Items getItemsById(long itemId) {
		return itemsDao.getItemsById(itemId);
	}

	public void updateItem(Items items) {
		itemsDao.updateItem(items);
	}

	public Items addItem(Items items) {
		return itemsDao.addItem(items);
	}

	public void deleteItem(long id) {
		itemsDao.deleteItem(id);
	}

}
