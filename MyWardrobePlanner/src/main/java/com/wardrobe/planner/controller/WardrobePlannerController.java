package com.wardrobe.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wardrobe.planner.model.Colors;
import com.wardrobe.planner.model.Items;
import com.wardrobe.planner.services.ColorService;
import com.wardrobe.planner.services.ItemsService;

@RestController
public class WardrobePlannerController {

	@Autowired
	ColorService colorService;
	
	@Autowired
	ItemsService itemsService;
	
	@RequestMapping(value = "/colors", method = RequestMethod.GET)
	public  List<Colors> listAllUsers() {
		List<Colors> colors = colorService.getAllColors();
		return colors;
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public  List<Items> listAllItems() {
		List<Items> items = itemsService.getAllItems();
		return items;
	}
}
