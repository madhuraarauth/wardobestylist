package com.wardrobe.planner.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "COLLECTION")
public class Collection {

	@Id
	@GeneratedValue
	@Column(name = "COLLECTION_ID")
	private long collectionId;

	@Column(name = "COLLECTION_NAME")
	private String collectionName;

	@JsonBackReference
	@ManyToMany(mappedBy = "collections")
	private Set<Items> items;
	
	
	public long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

		
}
