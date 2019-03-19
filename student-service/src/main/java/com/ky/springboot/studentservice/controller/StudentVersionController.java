package com.ky.springboot.studentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ky.springboot.studentservice.model.Name;
import com.ky.springboot.studentservice.model.Student;
import com.ky.springboot.studentservice.model.StudentV2;

@RestController
public class StudentVersionController {

	@GetMapping("v1/student")
	public Student studentV1() {
		Student studentA = new Student();
		studentA.setId(1l);
		studentA.setName("John");
		studentA.setDescription("Son of earth");
		return studentA;
	}
	
	@GetMapping("v2/student")
	public StudentV2 studentV2() {
		StudentV2 student = new StudentV2();
		student.setId(2l);
		student.setName(new Name());
		student.getName().setFirstName("Nicholas");
		student.getName().setLastName("Fury");
		student.setDescription("Captain of Marvel");
		return student;
	}
	
	@GetMapping(value="/student/param", params="version=1") 
	public Student paramV1() {
		Student studentA = new Student();
		studentA.setId(1l);
		studentA.setName("John");
		studentA.setDescription("Son of earth");
		return studentA;
	}
	
	@GetMapping(value="/student/param", params="version=2")
	public StudentV2 paramV2() {
		StudentV2 student = new StudentV2();
		student.setId(2l);
		student.setName(new Name());
		student.getName().setFirstName("Nicholas");
		student.getName().setLastName("Fury");
		student.setDescription("Captain of Marvel");
		return student;
	}

	@GetMapping(value="/student/header", headers="version=1") 
	public Student headerV1() {
		Student studentA = new Student();
		studentA.setId(1l);
		studentA.setName("John");
		studentA.setDescription("Son of earth");
		return studentA;
	}
	
	@GetMapping(value="/student/header", headers="version=2")
	public StudentV2 headerV2() {
		StudentV2 student = new StudentV2();
		student.setId(2l);
		student.setName(new Name());
		student.getName().setFirstName("Nicholas");
		student.getName().setLastName("Fury");
		student.setDescription("Captain of Marvel");
		return student;
	}
}
