package com.ky.springboot.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable Long courseId) throws Exception {
		if(!courseJpaRepository.existsById(courseId)) {
			throw new Exception("Course not found. id-"+courseId);
		}
		return courseJpaRepository.findById(courseId).get();
	}
}
