package com.wardrobe.planner.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ITEMS")
public class Items implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(
			name = "ITEMS_BY_COLLECTION", 
			joinColumns = @JoinColumn(name = "ITEM_ID"), 
			inverseJoinColumns = @JoinColumn(name = "COLLECTION_ID")
	)
	private List<Collection> collections;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(
			name = "ITEMS_BY_COLOR", 
			joinColumns = @JoinColumn(name = "ITEM_ID"), 
			inverseJoinColumns = @JoinColumn(name = "COLOR_ID")
	)
	private List<Colors> colors;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(
			name = "ITEMS_BY_MATERIAL", 
			joinColumns = @JoinColumn(name = "ITEM_ID"), 
			inverseJoinColumns = @JoinColumn(name = "MATERIAL_ID")
	)
	private List<Material> materials;


	/*@ManyToMany
	@JoinTable(name="MATERIAL")
	@JoinColumn(name="MATERIAL_ID")
	private List<Material> materialSet;*/
	
	/*@Column(name = "IMAGE")
	private Blob image;*/

	public Items(){
		
	}
	public Items(long itemId, String itemName, String itemDesc) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
	}

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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	public List<Colors> getColors() {
		return colors;
	}

	public void setColors(List<Colors> colors) {
		this.colors = colors;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	

	/*public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}*/
}
