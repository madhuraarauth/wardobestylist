package com.wardrobe.planner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAL")
public class Material {

	
	@Id
	@GeneratedValue
	@Column(name = "MATERIAL_ID")
	private long materialId;
	
	@Column(name = "MATERIAL_NAME")
	private String materialName;

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
	
	
}
