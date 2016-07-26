package com.wardrobe.planner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OCCASION")
public class Occasion {

	@Id
	@GeneratedValue
	@Column(name = "OCCASION_ID")
	private long occasionId;

	@Column(name = "OCCASION_NAME")
	private String occasionName;

	public long getOccasionId() {
		return occasionId;
	}

	public void setOccasionId(long occasionId) {
		this.occasionId = occasionId;
	}

	public String getOccasionName() {
		return occasionName;
	}

	public void setOccasionName(String occasionName) {
		this.occasionName = occasionName;
	}
	
}
