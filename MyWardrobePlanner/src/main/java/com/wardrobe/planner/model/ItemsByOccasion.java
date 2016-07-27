package com.wardrobe.planner.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class ItemsByOccasion {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OCCASION_ID")
	private Collection occasion;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ITEM_ID")
	private Items item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection getOccasion() {
		return occasion;
	}

	public void setOccasion(Collection occasion) {
		this.occasion = occasion;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}
	
	
}
