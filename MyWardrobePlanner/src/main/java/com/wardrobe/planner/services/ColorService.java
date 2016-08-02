package com.wardrobe.planner.services;

import java.util.List;

import com.wardrobe.planner.model.Colors;

public interface ColorService {

	List<Colors> getAllColors();
	Colors getColorById(long colorsId);
	void updateColors(Colors colors);
	Colors addColors(Colors colors);
	void deleteColor(long id);
}
