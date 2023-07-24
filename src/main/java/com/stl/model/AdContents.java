package com.stl.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ad_contents")
public class AdContents {
	/*
	id int AI PK 
	placement varchar(20) 
	img_url varchar(1000) 
	created timestamp 
	status varchar(20) 
	region varchar(100)
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="placement", nullable = false)
	String placement;
	
	@Column(name="img_url", nullable = false)
	String img_url;
	
	@Column(name="created", nullable = false)
	String created;
	
	@Column(name="status", nullable = false)
	String status;
	
	@Column(name="region", nullable = false)
	String region;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public AdContents(int id, String placement, String img_url, String created, String status, String region) {
		super();
		this.id = id;
		this.placement = placement;
		this.img_url = img_url;
		this.created = created;
		this.status = status;
		this.region = region;
	}
	
	public AdContents() {
		
	}

	@Override
	public String toString() {
		return "AdContents [id=" + id + ", placement=" + placement + ", img_url=" + img_url + ", created=" + created
				+ ", status=" + status + ", region=" + region + "]";
	}
	
	

}
