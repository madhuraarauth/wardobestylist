package com.wardrobe.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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

	@RequestMapping(value = "/colors/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Colors> getColor(@PathVariable("id") long colorId) {
		Colors color = colorService.getColorById(colorId);
		if(color==null){
			return new ResponseEntity<Colors>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Colors>(color, HttpStatus.OK);
	}

	@RequestMapping(value = "/colors", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Void> addColor(@RequestBody Colors colors, UriComponentsBuilder ucBuilder) {
		colorService.addColors(colors);    
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/colors/{id}").buildAndExpand(colors.getColorId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public  ResponseEntity<List<Items>> listAllItems() {
		List<Items> items = itemsService.getAllItems();
		if(items.isEmpty()){
			return new ResponseEntity<List<Items>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Items>>(items,HttpStatus.OK);
	}

	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Items> getItem(@PathVariable("id") long itemId) {
		Items item = itemsService.getItemsById(itemId);
		if(item==null){
			return new ResponseEntity<Items>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Items>(item, HttpStatus.OK);
	}

	@RequestMapping(value = "/items", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Void> addItem(@RequestBody Items item, UriComponentsBuilder ucBuilder) {
		itemsService.addItem(item);    
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/items/{id}").buildAndExpand(item.getItemId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/collections", method = RequestMethod.GET)
	public  ResponseEntity<List<Collection>> listAllCollections() {
		List<Collection> collections = collectionService.getAllCollections();
		if(collections.isEmpty()){
			return new ResponseEntity<List<Collection>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Collection>>(collections, HttpStatus.OK);
	}

	@RequestMapping(value = "/collections/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Collection> getCollection(@PathVariable("id") long collectionId) {
		Collection collection = collectionService.getCollectionById(collectionId);
		if(collection==null){
			return new ResponseEntity<Collection>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Collection>(collection, HttpStatus.OK);
	}

	@RequestMapping(value = "/collections", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Void> addCollection(@RequestBody Collection collection, UriComponentsBuilder ucBuilder) {
		collectionService.addCollection(collection);    
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/collections/{id}").buildAndExpand(collection.getCollectionId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/materials", method = RequestMethod.GET)
	public  ResponseEntity<List<Material>> listAllMaterials() {
		List<Material> materials = materialService.getAllMaterials();

		if(materials.isEmpty()){
			return new ResponseEntity<List<Material>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Material>>(materials, HttpStatus.OK);
	}

	@RequestMapping(value = "/materials/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Material> getMaterial(@PathVariable("id") long materialId) {
		Material material = materialService.getMaterialById(materialId);
		if(material==null){
			return new ResponseEntity<Material>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Material>(material, HttpStatus.OK);
	}

	@RequestMapping(value = "/materials", method = RequestMethod.POST)
	public   ResponseEntity<Void> addMaterials(@RequestBody Material materials, UriComponentsBuilder ucBuilder) {
		materialService.addMaterial(materials);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/materials/{id}").buildAndExpand(materials.getMaterialId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public  ResponseEntity<List<Categories>> listAllCategories() {
		List<Categories> categories = categoriesService.getAllCategories();
		if(categories.isEmpty()){
			return new ResponseEntity<List<Categories>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Categories>>(categories, HttpStatus.OK);
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Categories> getCategory(@PathVariable("id") long categoryId) {
		Categories category = categoriesService.getCategoryById(categoryId);
		if(category==null){
			return new ResponseEntity<Categories>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Categories>(category, HttpStatus.OK);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public  ResponseEntity<Void>  addCategory(@RequestAttribute("categories")Categories categories, UriComponentsBuilder ucBuilder) {
		categoriesService.addCategories(categories);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/categories/{id}").buildAndExpand(categories.getCategoryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getMyOutfit", method = RequestMethod.GET)
	public  Items getMyOutfit(@RequestAttribute Items item) {
		Items myItem = itemsService.getMyOutfit(item);
		return myItem;
	}


}
