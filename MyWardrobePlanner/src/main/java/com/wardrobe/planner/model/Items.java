package com.wardrobe.planner.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ITEMS")
public class Items {

	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private long itemId;
	
	@Column(name = "ITEM_NAME")
	private String itemName;
	
	@Column(name = "ITEM_DESC")
	private String itemDesc;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "CATEGORY_ID")
	private Categories category;

	/*@ManyToMany
	@JoinTable(name="MATERIAL")
	@JoinColumn(name="MATERIAL_ID")
	private Set<Material> materialSet;*/
	
	/*@Column(name = "IMAGE")
	private Blob image;*/

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	/*public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}*/
}
