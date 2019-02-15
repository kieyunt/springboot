package com.ky.springboot.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ky.springboot.studentservice.model.Course;
import com.ky.springboot.studentservice.model.Student;
import com.ky.springboot.studentservice.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> retrieveStudents() {
		return studentService.retrieveAllStudents();
	}
	
	@GetMapping("/students/{studentId}")
	public Student retrieveStudent(@PathVariable Long studentId) {
		return studentService.retrieveStudent(studentId);
	}
	
	@GetMapping("/students/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable Long studentId) {
		return studentService.retrieveStudentCourses(studentId);
	}
	
	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
		return studentService.retrieveCourse(studentId, courseId);
	}
	
	@PutMapping("/students/{studentId}/courses/{courseId}")
	public boolean addCourseForStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
		studentService.addCourse(studentId, studentService.retrieveCourse(courseId));
		return true;
	}
}
