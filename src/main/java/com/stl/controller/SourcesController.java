package com.stl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.stl.model.MediaContents;
import com.stl.model.Sources;
import com.stl.repository.SourcesRepository;

@RestController
@RequestMapping("/entertain")
@CrossOrigin(origins = "http://localhost:4200")
public class SourcesController {
	
	@Autowired
	SourcesRepository sourcesRepository;
	private Date UPDATED_AT;
	

	//(post) - to add new source data (eg: Amar_Chitra_Katha)
	@PostMapping("/add_new_source")
	/*public String addNewSource(@RequestBody Sources sources) {
		
		sourcesRepository.save(sources);
		return "New sources added";
	
	}*/
	public String addNewSource(@RequestBody Sources sources) throws ParseException {
		Date CREATED_AT=new Date();
	    SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    sources.setCreated_at(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
//	    sources.setUpdated_at(DATE_FORMATTER.parse(DATE_FORMATTER.format(UPDATED_AT)));
//	    sources.setUpdated_at(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
		
	    sourcesRepository.save(sources);
		return "New sources added";
	}
	
	/*
//	(post) - to add image to the source data
	@PutMapping("add_sourceImage/{id}")
	public String updateSourceImageById(@PathVariable int id,@RequestBody Sources sources) {
		Optional<Sources> sour = sourcesRepository.findById(id);
		try {
			Sources existSour = sour.get();	
			existSour.setSource_image(sources.getSource_image());
			
			sourcesRepository.save(existSour);
			return "Contents Details against Id "+ id + " updated";
		} catch (Exception e) {
			// TODO: handle exception
//			return (HttpStatus.NOT_FOUND);
			return "Contents Details does not exist for id " + id;
		}
		
	}*/
	
	//(get) - to get all sources
	@GetMapping("/get_all_sources")
	public ResponseEntity<List<Sources>> getAllSources(){
		List<Sources> sourcesList = new ArrayList<>();
		sourcesRepository.findAll().forEach(sourcesList::add);
		return new ResponseEntity<List<Sources>>(sourcesList, HttpStatus.OK);
	}
	
	
	//(get) - to source data by of particular id
	@GetMapping("/get_source_by_ID/{id}")
	public ResponseEntity<Sources> getSourceById(@PathVariable int id){
		Optional<Sources> sources = sourcesRepository.findById(id);
//		return null;
		try {
			return new ResponseEntity<Sources>(sources.get(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Sources>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//(put) - to update source details
	@PutMapping("/update_source_details/{id}")
	public String updateSourceById(@PathVariable int id, @RequestBody Sources sources) {
		Optional<Sources> sour = sourcesRepository.findById(id);
		
		try {
			
			Sources existSour = sour.get();	
			existSour.setSource_name(sources.getSource_name());
			existSour.setSource_image(sources.getSource_image());
			existSour.setSource_description(sources.getSource_description());
			existSour.setSource_url(sources.getSource_url());
			existSour.setSource_status(sources.getSource_status());
			existSour.setIsRedirection(sources.getIsRedirection());
//			existSour.setCreated_at(sources.getCreated_at());
//			existSour.setUpdated_at(sources.getUpdated_at());
			
//			Date CREATED_AT=new Date();
			Date UPDATED_AT=new Date();
		    SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		    sources.setCreated_at(DATE_FORMATTER.parse(DATE_FORMATTER.format(UPDATED_AT)));
		    
//			existSour.setUpdated_at(sources.getUpdated_at());
		    existSour.setUpdated_at(DATE_FORMATTER.parse(DATE_FORMATTER.format(UPDATED_AT)));
		    
			sourcesRepository.save(existSour);
			return "Contents Details against Id "+ id + " updated";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Content doesn't exist";
			//
		}
		
	}
	
	
	//(delete) - to delete source data
	@DeleteMapping("/delete_source/{id}")
	public String deleteSourceById(@PathVariable int id) {
		
		try {
			sourcesRepository.deleteById(id);
			return "Source with id " + id + " deleted";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Source with id " + id + " not found";
		}
	}
	
	
	//(get) - to display source image in user entertainment page
	@GetMapping("/get_sourceImage")
	public List<String> displaySourceImage() {
		List<String> source_images = new ArrayList<String>();
		source_images = sourcesRepository.displaySourceImage();
		return source_images;
		
	}
	
	
	/*
	//write logic for admin
	//(get) - to display source data in admin page
	@GetMapping("/adminSource")
	public ResponseEntity<List<Sources>> getAdminAllSources(){
		List<Sources> sourceList = new ArrayList<>();
		sourcesRepository.findAll().forEach(sourceList::add);
		return new ResponseEntity<List<Sources>>(sourceList, HttpStatus.OK);
		
	}
	*/
	
}
	
