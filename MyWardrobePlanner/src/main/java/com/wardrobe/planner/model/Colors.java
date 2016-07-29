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
@Table(name = "COLORS")
public class Colors {

	@Id
	@GeneratedValue
	@Column(name = "COLOR_ID")
	private long colorId;
	
	@Column(name = "COLOR_NAME")
	private String colorName;
	
	@Column(name = "COLOR_CODE")
	private String colorCode;
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "colors")
	private Set<Items> items;

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}
	
	
}
