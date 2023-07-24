package com.stl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.model.MediaCategories;

public interface MediaCategoriesRepository extends JpaRepository<MediaCategories, Integer>{

	@Query(value="SELECT category_name FROM media_categories", nativeQuery = true)
    	public List<String> findByCategoryName();
}
