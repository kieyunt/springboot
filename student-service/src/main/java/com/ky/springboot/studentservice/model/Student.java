package com.ky.springboot.studentservice.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private Long id;
	private String name;
	private String description;
	private List<Course> courses;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Course> getCourses() {
		if(courses==null) {
			courses = new ArrayList<Course>();
		}
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
