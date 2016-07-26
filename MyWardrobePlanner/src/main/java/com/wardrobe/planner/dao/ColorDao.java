package com.wardrobe.planner.dao;

import java.util.List;

import com.wardrobe.planner.model.Colors;

public interface ColorDao {

	List<Colors> getAllColors();
	Colors getColorByName(String name);
	void addColor(Colors color);
}
