package com.ky.springboot.studentservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;
	
	@NotNull
	@Size(min=5, message="Description should have at least 5 characters")
	private String description;
	
	public Course() {}
	
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
	
}
