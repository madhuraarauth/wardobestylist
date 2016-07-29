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
@Table(name = "MATERIAL")
public class Material {

	
	@Id
	@GeneratedValue
	@Column(name = "MATERIAL_ID")
	private long materialId;
	
	@Column(name = "MATERIAL_NAME")
	private String materialName;
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "materials")
	private Set<Items> items;

	public long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}
	
	
}
