package com.wardrobe.planner.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CATEGORIES")
public class Categories {
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private long categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@JsonBackReference
	@OneToMany(mappedBy = "category", cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Items> items;
	
	
	public Categories(long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<Items> getItems() {
		return items;
	}
	public void setItems(Set<Items> items) {
		this.items = items;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
}
