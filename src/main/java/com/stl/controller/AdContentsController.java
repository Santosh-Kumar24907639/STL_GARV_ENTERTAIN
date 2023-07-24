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
import org.springframework.web.bind.annotation.RestController;

import com.stl.model.AdContents;
import com.stl.model.MediaCategories;
import com.stl.model.MediaContents;
import com.stl.repository.AdContentsRepository;

@RestController
@RequestMapping("/entertain")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdContentsController {
	
	@Autowired
	AdContentsRepository adContentsRepository;
	
	//(post) - to post new AD details
	@PostMapping("/add_New_AD")
	public String addNewAD(@RequestBody AdContents adContents) {
		
		try {
			adContentsRepository.save(adContents);
			return "New Category added";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
            return "SOME ERROR";
//			return HttpStatus.NOT_FOUND;
		}
		
	}
	
	
	//(post) - to add or update new image for AD
	@PutMapping("add_Image/{id}")
	public String updateAdImageById(@PathVariable int id,@RequestBody AdContents adContents) {
		//emp->medCat
		Optional<AdContents> adCon = adContentsRepository.findById(id);
		try {
			AdContents existAdCon = adCon.get();	
			existAdCon.setImg_url(adContents.getImg_url());
			
			adContentsRepository.save(existAdCon);
			return "Contents Details against Id "+ id + " updated";
		} catch (Exception e) {
			// TODO: handle exception
//			return (HttpStatus.NOT_FOUND);
			return "Contents Details does not exist for id " + id;
		}
	}
	
	
	
	//(get) - to get all AD details
	@GetMapping("/get_all_ADs")
	public ResponseEntity<List<AdContents>> getAllAdContents(){
		List<AdContents> adContentsList = new ArrayList<>();
		adContentsRepository.findAll().forEach(adContentsList::add);
		return new ResponseEntity<List<AdContents>>(adContentsList, HttpStatus.OK);
		
	}
	
	
	
	//(get) - to get AD details for particular id
	@GetMapping("/get_AD_by_ID/{id}")
	public ResponseEntity<AdContents> getAdContentById(@PathVariable int id){
		Optional<AdContents> adContents = adContentsRepository.findById(id);
		
		try {
			return new ResponseEntity<AdContents>(adContents.get(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<AdContents>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
	
	//(put) - to update AD details
	@PutMapping("/update_AD_details/{id}")
	public String updateAdContentById(@PathVariable int id,@RequestBody AdContents adContents) {
		//emp->medCat
		Optional<AdContents> adCon = adContentsRepository.findById(id);
		try {
			AdContents existAdCon = adCon.get();	
			existAdCon.setPlacement(adContents.getPlacement());
			existAdCon.setImg_url(adContents.getImg_url());
			existAdCon.setCreated(adContents.getCreated());
			existAdCon.setStatus(adContents.getStatus());
			existAdCon.setRegion(adContents.getRegion());
			
			adContentsRepository.save(existAdCon);
			return "Contents Details against Id "+ id + " updated";
		} catch (Exception e) {
			// TODO: handle exception
//				return (HttpStatus.NOT_FOUND);
			return "Contents Details does not exist for id " + id;
		}
	}
	
	
	
	//(delete) - to delete AD
	@DeleteMapping("delete_AD/{id}")
	public String deleteAdContentById(@PathVariable int id) {
		try {
			adContentsRepository.deleteById(id);
			return "Ad content for id " + id + " deleted successfully";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Content with id" + id + " not found";
		}
	}
	
	
	
	//(get) - to display AD images in user entertain page
	@GetMapping("/displayAD")
	public List<String> displayAD() {
		List<String> ad_images = new ArrayList<String>();
		ad_images = adContentsRepository.displayAdImage();
		return ad_images;
		
	}
	
	
	/*
	 //write logic for admin
	//(get) - to display AD details in admin page
	@GetMapping("/adminAD")
	public ResponseEntity<List<AdContents>> getAdminAllAdContents(){
		List<AdContents> adContentsList = new ArrayList<>();
		adContentsRepository.findAll().forEach(adContentsList::add);
		return new ResponseEntity<List<AdContents>>(adContentsList, HttpStatus.OK);
		
	}
	*/
	
	

}
