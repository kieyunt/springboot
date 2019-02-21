package com.ky.springboot.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ky.springboot.studentservice.model.Course;
import com.ky.springboot.studentservice.repository.CourseJpaRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseJpaRepository.findAll();
	}
}
