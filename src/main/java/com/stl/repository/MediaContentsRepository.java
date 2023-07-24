package com.stl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.stl.model.MediaContents;

public interface MediaContentsRepository extends JpaRepository<MediaContents, Integer>{

//	@Query(value="SELECT * from media_contents WHERE title=?", nativeQuery=true)
	public MediaContents findByTitle(String title);

	
//	@Query(value="SELECT category_view_thumbnail, title from media_contents WHERE source='Amar_Chitra_Katha' and media_type=?", nativeQuery=true)
//	public List<String> findByMediaType(String media_type);



	/*
	@Query(value="SELECT tbl_role.role_name FROM tbl_role,tbl_user WHERE tbl_role.role_id=tbl_user.role_id AND tbl_user.unique_id=?",nativeQuery = true)
    public String findRoleNameByUniqueId(String UNIQUE_ID);
	*/
	
//	@Query(value = "SELECT * FROM media_contents, media_categories,media_categories_join WHERE media_categories.id=media_categories_join.category_id AND media_contents.id=media_categories_join.media_id AND source = 'Amar_Chitra_Katha' AND media_type=? AND media_categories.category_name=?")
//	public Optional<MediaContents> findByMediaTypeAckCategory(String media_type, String ackCategory);

//	@Query(value = "SELECT * FROM media_contents WHERE media_categories.id=media_categories_join.category_id AND media_contents.id=media_categories_join.media_id AND source = 'Amar_Chitra_Katha' AND media_type=? AND media_categories.category_name=?")
	@Query(value = "SELECT media_contents.category_view_thumbnail, media_contents.title FROM media_contents, media_categories, media_categories_join WHERE media_categories.id=media_categories_join.category_id AND media_contents.id=media_categories_join.media_id AND source = 'Amar_Chitra_Katha' AND media_type=? AND category_name=?", nativeQuery = true)
//	public List<String> findByMediaTypeAckCategory(String media_type, String ackCategory);
	public List<String> findByMediaTypeAckCategory(String media_type, String ackCategory);

	//	public ResponseEntity<MediaContents> findByMediaTypeAckCategory(String media_type, String ackCategory);
	
	@Query(value = "SELECT media_contents.category_view_thumbnail, media_contents.title FROM media_contents WHERE source = 'Amar_Chitra_Katha' AND media_type=?", nativeQuery = true)
	public List<String> findByMediaType(String media_type);
	
	@Query(value = "SELECT media_contents.category_view_thumbnail, media_contents.title FROM media_contents, media_categories, media_categories_join WHERE media_categories.id=media_categories_join.category_id AND media_contents.id=media_categories_join.media_id AND source = 'STL_Garv' AND media_type=? AND category_name=?", nativeQuery = true)
	public List<String> findByMediaTypeSgcCategory(String media_type, String sgcCategory);

//	@Query(value = "SELECT media_contents.category_view_thumbnail, media_contents.title FROM media_contents WHERE source = 'Amar_Chitra_Katha' AND media_type=?", nativeQuery = true)
//	public List<String> findBySgcMediaType1(String media_type);
	
	@Query(value="SELECT category_view_thumbnail, title from media_contents WHERE source='STL_Garv' and media_type=?", nativeQuery=true)
	public List<String> findBySgcMediaType(String sgcMediaType);
	
}
