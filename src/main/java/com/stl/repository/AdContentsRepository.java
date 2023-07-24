package com.stl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.model.AdContents;

public interface AdContentsRepository extends JpaRepository<AdContents, Integer>{

	@Query(value="SELECT img_url from ad_contents", nativeQuery = true)
	public List<String> displayAdImage();
}
