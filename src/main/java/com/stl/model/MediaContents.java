package com.stl.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "media_contents")
public class MediaContents {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="file_url")
	private String file_url;
	
	@Column(name="media_type", nullable = false)
	private String media_type;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="category_view_thumbnail")
	private String category_view_thumbnail;
	
	@Column(name="detail_view_thumbnail")
	private String detail_view_thumbnail;
	
	@Column(name="trailer_file_url")
	private String trailer_file_url;
	
	@Column(name="price")
	private String price;
	
	@Column(name="downloadable", nullable = false)
	private int downloadable;
	
	@Column(name="status", nullable = false)
	private String status;
	
	@Column(name="source", nullable = false)
	private String source;
	
	@Column(name="region", nullable = false)
	private String region;
	
	@Column(name="created", nullable = false)
	private String created;
	
	@Column(name="max_downloads")
	private int max_downloads;
	
	@Column(name="file_upload_type", nullable = false)
	private String file_upload_type;
	
	@Column(name="trailer_upload_type", nullable = false)
	private String trailer_upload_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory_view_thumbnail() {
		return category_view_thumbnail;
	}

	public void setCategory_view_thumbnail(String category_view_thumbnail) {
		this.category_view_thumbnail = category_view_thumbnail;
	}

	public String getDetail_view_thumbnail() {
		return detail_view_thumbnail;
	}

	public void setDetail_view_thumbnail(String detail_view_thumbnail) {
		this.detail_view_thumbnail = detail_view_thumbnail;
	}

	public String getTrailer_file_url() {
		return trailer_file_url;
	}

	public void setTrailer_file_url(String trailer_file_url) {
		this.trailer_file_url = trailer_file_url;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getDownloadable() {
		return downloadable;
	}

	public void setDownloadable(int downloadable) {
		this.downloadable = downloadable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getMax_downloads() {
		return max_downloads;
	}

	public void setMax_downloads(int max_downloads) {
		this.max_downloads = max_downloads;
	}

	public String getFile_upload_type() {
		return file_upload_type;
	}

	public void setFile_upload_type(String file_upload_type) {
		this.file_upload_type = file_upload_type;
	}

	public String getTrailer_upload_type() {
		return trailer_upload_type;
	}

	public void setTrailer_upload_type(String trailer_upload_type) {
		this.trailer_upload_type = trailer_upload_type;
	}

	public MediaContents(int id, String file_url, String media_type, String title, String description,
			String category_view_thumbnail, String detail_view_thumbnail, String trailer_file_url, String price,
			int downloadable, String status, String source, String region, String created, int max_downloads,
			String file_upload_type, String trailer_upload_type) {
		super();
		this.id = id;
		this.file_url = file_url;
		this.media_type = media_type;
		this.title = title;
		this.description = description;
		this.category_view_thumbnail = category_view_thumbnail;
		this.detail_view_thumbnail = detail_view_thumbnail;
		this.trailer_file_url = trailer_file_url;
		this.price = price;
		this.downloadable = downloadable;
		this.status = status;
		this.source = source;
		this.region = region;
		this.created = created;
		this.max_downloads = max_downloads;
		this.file_upload_type = file_upload_type;
		this.trailer_upload_type = trailer_upload_type;
	}

	public MediaContents() {
		
	}

	@Override
	public String toString() {
		return "MediaContents [id=" + id + ", file_url=" + file_url + ", media_type=" + media_type + ", title=" + title
				+ ", description=" + description + ", category_view_thumbnail=" + category_view_thumbnail
				+ ", detail_view_thumbnail=" + detail_view_thumbnail + ", trailer_file_url=" + trailer_file_url
				+ ", price=" + price + ", downloadable=" + downloadable + ", status=" + status + ", source=" + source
				+ ", region=" + region + ", created=" + created + ", max_downloads=" + max_downloads
				+ ", file_upload_type=" + file_upload_type + ", trailer_upload_type=" + trailer_upload_type + "]";
	}
	
	
	
}
