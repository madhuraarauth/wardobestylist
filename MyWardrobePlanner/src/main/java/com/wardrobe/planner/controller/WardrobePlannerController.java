package com.wardrobe.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wardrobe.planner.model.Categories;
import com.wardrobe.planner.model.Collection;
import com.wardrobe.planner.model.Colors;
import com.wardrobe.planner.model.Items;
import com.wardrobe.planner.model.Material;
import com.wardrobe.planner.services.CategoriesService;
import com.wardrobe.planner.services.CollectionService;
import com.wardrobe.planner.services.ColorService;
import com.wardrobe.planner.services.ItemsService;
import com.wardrobe.planner.services.MaterialService;

@RestController
public class WardrobePlannerController {

	@Autowired
	ColorService colorService;
	
	@Autowired
	ItemsService itemsService;
	

	@Autowired
	CollectionService collectionService;
	
	@Autowired
	MaterialService materialService;
	
	@Autowired
	CategoriesService categoriesService;
	
	@RequestMapping(value = "/colors", method = RequestMethod.GET)
	public  ResponseEntity<List<Colors>> listAllUsers() {
		List<Colors> colors = colorService.getAllColors();
		if(colors.isEmpty()){
            return new ResponseEntity<List<Colors>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Colors>>(colors, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public  ResponseEntity<List<Items>> listAllItems() {
		List<Items> items = itemsService.getAllItems();
		if(items.isEmpty()){
			return new ResponseEntity<List<Items>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Items>>(items,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/collections", method = RequestMethod.GET)
	public  List<Collection> listAllCollections() {
		List<Collection> collections = collectionService.getAllCollections();
		return collections;
	}
	
	@RequestMapping(value = "/materials", method = RequestMethod.GET)
	public  List<Material> listAllMaterials() {
		List<Material> materials = materialService.getAllMaterials();
		return materials;
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public  List<Categories> listAllCategories() {
		List<Categories> categories = categoriesService.getAllCategories();
		return categories;
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public  void addCategory(@RequestAttribute("categories")Categories categories) {
		categoriesService.addCategories(categories);
	}
	
	@RequestMapping(value = "/colors", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  void addColor(@RequestBody Colors colors) {
		colorService.addColors(colors);
	}
	
	@RequestMapping(value = "/materials", method = RequestMethod.POST)
	public  void addMaterials(@RequestBody Material materials) {
		materialService.addMaterial(materials);
	}
	
	@RequestMapping(value = "/collections", method = RequestMethod.POST)
	public  void addCollections(@RequestBody Collection collections) {
		collectionService.addCollection(collections);
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public  void addItems(@RequestBody Items items) {
		itemsService.addItem(items);
	}
	
	@RequestMapping(value = "/getMyOutfit", method = RequestMethod.GET)
	public  Items getMyOutfit(@RequestAttribute Items item) {
		Items myItem = itemsService.getMyOutfit(item);
		return myItem;
	}
	
	
}
