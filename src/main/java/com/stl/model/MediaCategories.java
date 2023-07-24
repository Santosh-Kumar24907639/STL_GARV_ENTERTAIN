package com.stl.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "media_categories")
public class MediaCategories {
//	id int AI PK 
//	category_name varchar(100) 
//	slug varchar(100) 
//	parent_id int 
//	created timestamp 
//	status varchar(20) 
//	featured varchar(100)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="category_name", nullable = false)
	private String category_name;
	
	@Column(name="slug", nullable = false)
	private String slug;
	
	@Column(name="parent_id", nullable = false)
	private int parent_id;
	
	@Column(name="created", nullable = false)
	private String created;
	
	@Column(name="status", nullable = false)
	private String status;
	
	@Column(name="featured", nullable = false)
	private String featured;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeatured() {
		return featured;
	}

	public void setFeatured(String featured) {
		this.featured = featured;
	}

	public MediaCategories(int id, String category_name, String slug, int parent_id, String created, String status,
			String featured) {
		super();
		this.id = id;
		this.category_name = category_name;
		this.slug = slug;
		this.parent_id = parent_id;
		this.created = created;
		this.status = status;
		this.featured = featured;
	}
	
	
	public MediaCategories() {
		
	}

	@Override
	public String toString() {
		return "MediaCategories [id=" + id + ", category_name=" + category_name + ", slug=" + slug + ", parent_id="
				+ parent_id + ", created=" + created + ", status=" + status + ", featured=" + featured + "]";
	}

	
	
}
