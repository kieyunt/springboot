package com.ky.springboot.studentservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description="all about student details. version 2")
public class StudentV2 {

	private Long id;
	
	@NotNull
	private Name name;
	
	@NotNull
	@Size(min=5, message="Description should have at least 5 characters.")
	private String description;
	
	@OneToMany
	private List<Course> courses;
	
	public StudentV2() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
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
