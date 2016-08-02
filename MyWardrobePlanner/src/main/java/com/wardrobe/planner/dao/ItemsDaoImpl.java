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
	
	@Transactional
	public Items getItemsById(long itemId) {
		Items items = (Items) hibernateTemplate.get(Items.class, itemId);
		return items;
	}
	public void updateItem(Items item) {
		try {
			hibernateTemplate.saveOrUpdate(item);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public Items addItem(Items item) {
		try {
			hibernateTemplate.save(item);
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public void deleteItem(long id) {
		try {
			hibernateTemplate.delete(getItemsById(id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
