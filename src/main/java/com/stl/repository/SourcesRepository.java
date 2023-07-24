package com.stl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.model.Sources;

public interface SourcesRepository extends JpaRepository<Sources, Integer>{

	@Query(value="SELECT source_image from garv_tbl_sources", nativeQuery = true)
	public List<String> displaySourceImage();
	
}
