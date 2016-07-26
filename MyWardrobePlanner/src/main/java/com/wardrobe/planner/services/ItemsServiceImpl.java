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

}
