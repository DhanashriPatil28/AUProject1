package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String categoryName;
	private String courseName;
	private String courseRequirements;
	private String courseDescription;
	private String courseContents;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseRequirements() {
		return courseRequirements;
	}
	public void setCourseRequirements(String courseRequirements) {
		this.courseRequirements = courseRequirements;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseContents() {
		return courseContents;
	}
	public void setCourseContents(String courseContents) {
		this.courseContents = courseContents;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", courseName=" + courseName
				+ ", courseRequirements=" + courseRequirements + ", courseDescription=" + courseDescription
				+ ", courseContents=" + courseContents + "]";
	}
	
}
