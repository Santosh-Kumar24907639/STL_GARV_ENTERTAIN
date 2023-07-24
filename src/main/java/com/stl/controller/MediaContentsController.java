package com.stl.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stl.model.MediaCategories;
//import com.stl.model.MediaCategories;
import com.stl.model.MediaContents;
//import com.stl.repository.MediaCategoriesRepository;
import com.stl.repository.MediaContentsRepository;

@RestController
@RequestMapping("/entertain")
@CrossOrigin(origins = "http://localhost:4200")
public class MediaContentsController {

	@Autowired
	MediaContentsRepository mediaContentsRepository;

	// (post) — to post new media details
	@PostMapping("/add_new_Media")
	public String addNewContent(@RequestBody MediaContents mediaContents) {
		mediaContentsRepository.save(mediaContents);
		return "New Category added";

	}

	// (get) - to get all media details
	@GetMapping("/get_all_Media")
	public ResponseEntity<List<MediaContents>> getAllMediaContents() {
		List<MediaContents> mediaContentsList = new ArrayList<>();
		mediaContentsRepository.findAll().forEach(mediaContentsList::add);
		return new ResponseEntity<List<MediaContents>>(mediaContentsList, HttpStatus.OK);
	}

	// (get) - to get media details of particular id
	@GetMapping("/get_Media/{id}")
	public ResponseEntity<MediaContents> getContentById(@PathVariable int id) {
		Optional<MediaContents> medCon = mediaContentsRepository.findById(id);
		if (medCon.isPresent()) {
			return new ResponseEntity<MediaContents>(medCon.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<MediaContents>(HttpStatus.NOT_FOUND);
		}
	}

	// (post) - to add or update new media file for particular id --> file_url
	@PutMapping("add_new_Media_file/{id}")
	public String updateMediaFileById(@PathVariable int id, @RequestBody MediaContents mediaContents) {
		// emp->medCat
		Optional<MediaContents> medCon = mediaContentsRepository.findById(id);
//		if(medCon.isPresent()) {
//			MediaContents existMedCon = medCon.get();	
//			existMedCon.setFile_url(mediaContents.getFile_url());
//			
//			mediaContentsRepository.save(existMedCon);
//			return "Category Details against Id "+ id + " updated";
//		}else {
//			return "Category Details does not exist for id " + id;
//		}
		try {
			MediaContents existMedCon = medCon.get();
			existMedCon.setFile_url(mediaContents.getFile_url());

			mediaContentsRepository.save(existMedCon);
			return "Contents Details against Id " + id + " updated";
		} catch (Exception e) {
			// TODO: handle exception
//			return (HttpStatus.NOT_FOUND);
			return "Contents Details does not exist for id " + id;
		}
	}

	// (post) - to add or update new trailer file for particular id
	@PutMapping("add_new_Media_TrailerFile/{id}")
	public String updateMediaTrailerFileById(@PathVariable int id, @RequestBody MediaContents mediaContents) {
		// emp->medCat
		Optional<MediaContents> medCon = mediaContentsRepository.findById(id);
		try {
			MediaContents existMedCon = medCon.get();
			existMedCon.setTrailer_file_url(mediaContents.getTrailer_file_url());

			mediaContentsRepository.save(existMedCon);
			return "Contents Details against Id " + id + " updated";
		} catch (Exception e) {
			// TODO: handle exception
//			return (HttpStatus.NOT_FOUND);
			return "Contents Details does not exist for id " + id;
		}
	}

	// (post) - to add or update new outer view image for particular id
	@PutMapping("add_new_Media_OuterImage/{id}")
	public String updateMediaOuterImageById(@PathVariable int id, @RequestBody MediaContents mediaContents) {
		// emp->medCat
		Optional<MediaContents> medCon = mediaContentsRepository.findById(id);
		try {
			MediaContents existMedCon = medCon.get();
			existMedCon.setCategory_view_thumbnail(mediaContents.getCategory_view_thumbnail());

			mediaContentsRepository.save(existMedCon);
			return "Contents Details against Id " + id + " updated";
		} catch (Exception e) {
			// TODO: handle exception
//			return (HttpStatus.NOT_FOUND);
			return "Contents Details does not exist for id " + id;
		}
	}

	// (post) - to add or update new inner view image for particular id
	@PutMapping("add_new_Media_InnerImage/{id}")
	public String updateMediaInnerImageById(@PathVariable int id, @RequestBody MediaContents mediaContents) {
		// emp->medCat
		Optional<MediaContents> medCon = mediaContentsRepository.findById(id);
		try {
			MediaContents existMedCon = medCon.get();
			existMedCon.setDetail_view_thumbnail(mediaContents.getDetail_view_thumbnail());

			mediaContentsRepository.save(existMedCon);
			return "Contents Details against Id " + id + " updated";
		} catch (Exception e) {
			// TODO: handle exception
//			return (HttpStatus.NOT_FOUND);
			return "Contents Details does not exist for id " + id;
		}

	}

//		(put) - to update media details
	@PutMapping("update_Media/{id}")
	public String updateMediaById(@PathVariable int id, @RequestBody MediaContents mediaContents) {
		// emp->medCat
		Optional<MediaContents> medCon = mediaContentsRepository.findById(id);
		try {
			MediaContents existMedCon = medCon.get();
			existMedCon.setFile_url(mediaContents.getFile_url());
			existMedCon.setMedia_type(mediaContents.getMedia_type());
			existMedCon.setTitle(mediaContents.getTitle());
			existMedCon.setDescription(mediaContents.getDescription());
			existMedCon.setCategory_view_thumbnail(mediaContents.getCategory_view_thumbnail());
			existMedCon.setDetail_view_thumbnail(mediaContents.getDetail_view_thumbnail());
			existMedCon.setTrailer_file_url(mediaContents.getTrailer_file_url());
			existMedCon.setPrice(mediaContents.getPrice());
			existMedCon.setDownloadable(mediaContents.getDownloadable());
			existMedCon.setStatus(mediaContents.getStatus());
			existMedCon.setSource(mediaContents.getSource());
			existMedCon.setRegion(mediaContents.getRegion());
			existMedCon.setCreated(mediaContents.getCreated());
			existMedCon.setMax_downloads(mediaContents.getMax_downloads());
			existMedCon.setFile_upload_type(mediaContents.getFile_upload_type());
			existMedCon.setTrailer_upload_type(mediaContents.getTrailer_upload_type());

			mediaContentsRepository.save(existMedCon);
			return "Contents Details against Id " + id + " updated";
		} catch (Exception e) {
			// TODO: handle exception
//				return (HttpStatus.NOT_FOUND);
			return "Contents Details does not exist for id " + id;
		}

	}

//		(delete) - to delete media 
	@SuppressWarnings("finally")
	@DeleteMapping("/delete_Media/{id}")
	public String deleteMediaContentById(@PathVariable int id) {
		try {
			mediaContentsRepository.deleteById(id);
			return "Content Deleted Successfully";
		} catch (Exception e) { // why catch is not working
			// TODO: handle exception
			return "Content with id" + id + " not found";
		}
//			finally {
//				return "Hello";
//			}

	}

//-----------------------------------------		
//		(post) - to get media details where source is Amar_Chitra_Katha and based on media_type
	/*@GetMapping("{media_type}/get_outerImage")
//		public List<String> getAckMediaTypeOuterImage(@PathVariable String media_type){
	public List<String> ackMediaTypeOuterImage(@PathVariable String media_type) {
		List<String> outer_images = new ArrayList<String>();
//			try {
		outer_images = mediaContentsRepository.findByMediaType(media_type);
//				return new ResponseEntity<List<MediaContents>> (mediaContentsRepository.findByMediaType(ackMediaType), HttpStatus.OK);
		return outer_images;
//			} catch (Exception e) {
//				// TODO: handle exception
//			return null;
//			}
	}*/

	// (post) - to get media details where source is Amar_Chitra_Katha and based on media_type and category
	/*
	 * 
	 * 
	 * 
	 * 
	 */

	// (post) - to get media details where source is STL_Garv_Content and based on media_type and category
	/*
	@GetMapping("{sgcCategory}/get_outerImage")
//	public List<String> getAckMediaTypeOuterImage(@PathVariable String media_type){
	public List<String> ackSgcCategoryOuterImage(@PathVariable String sgcCategory) {
		List<String> outer_images = new ArrayList<String>();
//		try {
		outer_images = mediaContentsRepository.findBySgcCategoryMediaType(sgcCategory);
//			return new ResponseEntity<List<MediaContents>> (mediaContentsRepository.findByMediaType(ackMediaType), HttpStatus.OK);
		return outer_images;
//		} catch (Exception e) {
//			// TODO: handle exception
//		return null;
//		}
	}*/
	
	//(post) - to get media details where source is STL_Garv_Content and based on media_type
//	@GetMapping("{sgcMediaType}/get_outerImage")
	/*@GetMapping("{sgcMediaType}/get_outerImage")
	public List<String> ackSgcMediaTypeOuterImage(@PathVariable String sgcMediaType) {
		List<String> outer_images = new ArrayList<String>();
	//		try {
		outer_images = mediaContentsRepository.findBySgcMediaType(sgcMediaType);
	//			return new ResponseEntity<List<MediaContents>> (mediaContentsRepository.findByMediaType(ackMediaType), HttpStatus.OK);
		return outer_images;
	//		} catch (Exception e) {
	//			// TODO: handle exception
	//		return null;
	//		}
	}*/

//-----------------------------------------------------------
	// (get) - to get media details based on title
	@GetMapping("getMediaDetails/{title}")
	public ResponseEntity<MediaContents> getContentByTitle(@PathVariable String title) {
//			ResponseEntity<MediaContents> medCon = mediaContentsRepository.findByTitle(title);
//			if(medCon.isPresent()) {
//				return new ResponseEntity<MediaContents>(medCon.get(), HttpStatus.FOUND);
//			}else {
//				return new ResponseEntity<MediaContents>(HttpStatus.NOT_FOUND);
//			}

//			try {
//				return medCon;
		return new ResponseEntity<MediaContents>(mediaContentsRepository.findByTitle(title), HttpStatus.OK);
//			} catch (Exception e) {
		// TODO: handle exception
//				return new ResponseEntity<MediaContents>(HttpStatus.NOT_FOUND);
//			}
	}
	
	
	/*
	@GetMapping("/get_all_Media")
	public ResponseEntity<List<MediaContents>> getAllMediaContents() {
		List<MediaContents> mediaContentsList = new ArrayList<>();
		mediaContentsRepository.findAll().forEach(mediaContentsList::add);
		return new ResponseEntity<List<MediaContents>>(mediaContentsList, HttpStatus.OK);
	}
	*/
	
	//(post) - to get media details where source is Amar_Chitra_Katha and based on media_type and category
	@GetMapping("/ackCategory/get_outerImage/{media_type}/{ackCategory}")
//	public ResponseEntity<List<MediaContents>> getOuterImageByMediaTypeAndAckCategory(@PathVariable String media_type, String ackCategory){
		public List<String> getOuterImageByMediaTypeAndAckCategory(@PathVariable String media_type, @PathVariable String ackCategory){

//		List<MediaContents> mediaContentsList = new ArrayList<>();
		List<String> mediaContentsList = new ArrayList<>();
//		mediaContentsRepository.findAll().forEach(mediaContentsList::add);
//		mediaContentsRepository.findByMediaTypeAckCategory(media_type, ackCategory).forEach(mediaContentsList::add);
		mediaContentsList = mediaContentsRepository.findByMediaTypeAckCategory(media_type, ackCategory);
		return mediaContentsList;
	
		
//		Optional<MediaContents> outer_images = mediaContentsRepository.findByMediaTypeAckCategory(media_type, ackCategory);
////		return new ResponseEntity<MediaContents>(medCon.get(), HttpStatus.FOUND);
//		return new ResponseEntity<List<MediaContents>>((List<MediaContents>) outer_images.get(), HttpStatus.OK);
		
	}
	
	//(post) - to get media details where source is Amar_Chitra_Katha  and based on media_type
	@GetMapping("/ackMediaType/get_outerImage/{media_type}")
	public List<String> getOuterImageByMediaType(@PathVariable String media_type){
		List<String> mediaContentsList = new ArrayList<>();
		mediaContentsList = mediaContentsRepository.findByMediaType(media_type);
		return mediaContentsList;
	}
	
	
	//(post) - to get media details where source is STL_Garv_Content and based on media_type and category
	@GetMapping("/sgcCategory/get_outerImage/{media_type}/{sgcCategory}")
	public List<String> getOuterImageByMediaTypeAndSgcCategory(@PathVariable String media_type, @PathVariable String sgcCategory){
		List<String> mediaContentsList = new ArrayList<>();
		mediaContentsList = mediaContentsRepository.findByMediaTypeSgcCategory(media_type, sgcCategory);
		return mediaContentsList;
	}
	
	//(post) - to get media details where source is STL_Garv_Content and based on media_type
	@GetMapping("/sgcMediaType/get_outerImage/{media_type}")
	public List<String> getOuterImageBySgcMediaType(@PathVariable String media_type){
		List<String> mediaContentsList = new ArrayList<>();
		mediaContentsList = mediaContentsRepository.findBySgcMediaType(media_type);
		return mediaContentsList;
	}
	
}
