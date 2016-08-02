package com.wardrobe.planner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wardrobe.planner.dao.ColorDao;
import com.wardrobe.planner.model.Colors;

@Service("colorService")
@Transactional
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorDao colorDao;
	
	public List<Colors> getAllColors() {
		return colorDao.getAllColors();
	}

	public Colors getColorById(long colorsId) {
		return colorDao.getColorById(colorsId);
	}

	public void updateColors(Colors colors) {
		colorDao.updateColors(colors);
	}

	public Colors addColors(Colors colors) {
		return colorDao.addColors(colors);
	}

	public void deleteColor(long id) {
		colorDao.deleteColor(id);		
	}

}
