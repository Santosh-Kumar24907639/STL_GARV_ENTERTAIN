package com.stl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stl.model.MediaCategories;
import com.stl.repository.MediaCategoriesRepository;

@RestController
@RequestMapping("/entertain")
@CrossOrigin(origins = "http://localhost:4200")
public class MediaCategoriesController {
	
	@Autowired
	MediaCategoriesRepository mediaCategoriesRepository;

	//(post) — to post new category-details
	@PostMapping("/add_new_category")
	public String addNewCategory(@RequestBody MediaCategories mediaCategories) {
		mediaCategoriesRepository.save(mediaCategories);
		return "New Category added";
		
	}
	
	//(get) - to get all categories and its details
	@GetMapping("/get_all_categories")
	public ResponseEntity<List<MediaCategories>> getAllMediaCategories(){
		List<MediaCategories> mediaCategoriesList = new ArrayList<>();
		mediaCategoriesRepository.findAll().forEach(mediaCategoriesList::add);
		return new ResponseEntity<List<MediaCategories>>(mediaCategoriesList, HttpStatus.OK);
	}
	
	
	//(put) - to update category
	@PutMapping("/update_category/{id}")
	public String updateMediaCategoriesById(@PathVariable int id,@RequestBody MediaCategories mediaCategories) {
		//emp->medCat
		Optional<MediaCategories> medCat = mediaCategoriesRepository.findById(id);
		if(medCat.isPresent()) {
			MediaCategories existMedCat = medCat.get();
			existMedCat.setCategory_name(mediaCategories.getCategory_name());
			existMedCat.setSlug(mediaCategories.getSlug());
			existMedCat.setParent_id(mediaCategories.getParent_id());
			existMedCat.setCreated(mediaCategories.getCreated());
			existMedCat.setStatus(mediaCategories.getStatus());
			existMedCat.setFeatured(mediaCategories.getFeatured());
//			existEmp.setEmp_city(employee.getEmp_city());
//			existEmp.setEmp_name(employee.getEmp_name());
//			existEmp.setEmp_salary(employee.getEmp_salary());
			mediaCategoriesRepository.save(existMedCat);
			return "Category Details against Id "+ id + " updated";
		}else {
			return "Category Details does not exist for id " + id;
		}
	}
	
	
	//(delete) - to delete category
	@DeleteMapping("/delete_category/{id}")
	public String deleteMediaCategoryById(@PathVariable int id) {
			mediaCategoriesRepository.deleteById(id);
			return "Category Deleted Successfully";
	}
	
	
	
	//(get) - to display category data in admin page
//	if(/*token authentication*/)
	/*
	@GetMapping("/admin/admin_Category")
	public ResponseEntity<List<MediaCategories>> getAllAdminMediaCategories(){
		List<MediaCategories> mediaCategoriesList = new ArrayList<>();
		mediaCategoriesRepository.findAll().forEach(mediaCategoriesList::add);
		return new ResponseEntity<List<MediaCategories>>(mediaCategoriesList, HttpStatus.OK);
	}
	*/
	
	
	
	
	//(get) - to get all category names
	@GetMapping("/getCategory")
	public List<String> getCategoryNames(){
		List<String> category_names=new ArrayList<String>();
		category_names = mediaCategoriesRepository.findByCategoryName();
		return category_names;
		
	}

}
