package com.wardrobe.planner.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "COLORS")
public class Colors implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "COLOR_ID")
	private long colorId;
	
	@Column(name = "COLOR_NAME")
	private String colorName;
	
	@Column(name = "COLOR_CODE")
	private String colorCode;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "colors")
	@JsonIgnore
	private List<Items> items;

	public Colors(){
		
	}
	
	public Colors(long colorId, String colorName, String colorCode) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
		this.colorCode = colorCode;
	}
	
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

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

}
