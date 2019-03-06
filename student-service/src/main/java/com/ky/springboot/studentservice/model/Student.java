package com.ky.springboot.studentservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;
	
	@NotNull
	@Size(min=5, message="Description should have at least 5 characters.")
	private String description;
	
	@OneToMany
	private List<Course> courses;
	
	public Student() {}
	
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
