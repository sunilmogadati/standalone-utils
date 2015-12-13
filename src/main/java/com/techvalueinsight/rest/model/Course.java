package com.techvalueinsight.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Class that holds data for a Course
 *
 */
@XmlRootElement
public class Course {
	private String title;
	private String description;
	private String photo;
	
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Course [title=" + title + ", description=" + description + ", photo=" + photo + "]";
	}
	
}
