package com.stl.model;

import java.util.Date;

import com.stl.enums.SourceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="garv_tbl_sources")
public class Sources {
//	source_name varchar(255) 
//	source_image varchar(255) 
//	source_description varchar(255) 
//	source_url tinytext 
//	source_status enum('active','deactive','delete') 
//	isRedirection tinyint(1) 
//	created_at timestamp 
//	updated_at timestamp
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "source_name")
	private String source_name;
	
	@Column(name = "source_image")
	private String source_image;
	
	@Column(name = "source_description")
	private String source_description;
	
	@Column(name = "source_url")
	private String source_url;
	
	@Column(name = "source_status")
	private String source_status;
	
	@Column(name = "is_redirection")
	private int is_redirection;
	
	@Column(name = "created_at")
	private Date created_at;
	
	@Column(name = "updated_at")
	private Date updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}

	public String getSource_image() {
		return source_image;
	}

	public void setSource_image(String source_image) {
		this.source_image = source_image;
	}

	public String getSource_description() {
		return source_description;
	}

	public void setSource_description(String source_description) {
		this.source_description = source_description;
	}

	public String getSource_url() {
		return source_url;
	}

	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}

	public String getSource_status() {
		return source_status;
	}

	public void setSource_status(String source_status) {
		this.source_status = source_status;
	}

	public int getIsRedirection() {
		return is_redirection;
	}

	public void setIsRedirection(int is_redirection) {
		this.is_redirection = is_redirection;
	}

	public Date getCreated_at() {
		return created_at;
	}
	/*
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}*/
	public void setCreated_at(Date date) {
		this.created_at = date;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date date) {
		this.updated_at = date;
	}

	public Sources(int id, String source_name, String source_image, String source_description, String source_url,
			String source_status, int is_redirection, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.source_name = source_name;
		this.source_image = source_image;
		this.source_description = source_description;
		this.source_url = source_url;
		this.source_status = source_status;
		this.is_redirection = is_redirection;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public Sources() {
		
	}

	@Override
	public String toString() {
		return "Sources [id=" + id + ", source_name=" + source_name + ", source_image=" + source_image
				+ ", source_description=" + source_description + ", source_url=" + source_url + ", source_status="
				+ source_status + ", is_redirection=" + is_redirection + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}
	
	
	
}
