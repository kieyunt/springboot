package com.ky.springboot.studentservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.ky.springboot.studentservice.model.Course;
import com.ky.springboot.studentservice.model.Student;

@Component
public class StudentService {

	private static List<Student> students;
	private static List<Course> courses;
	
	public StudentService() {
		if(courses==null) {
			courses = new ArrayList<Course>();
		}
		if(students==null) {
			students = new ArrayList<Student>();
			
			Course course1 = new Course();
			course1.setId(1l);
			course1.setName("History of Islam");
			course1.setDescription("Islamic history since 1400");
			Course course2 = new Course();
			course2.setId(2l);
			course2.setName("Geography");
			course2.setDescription("Earth Geography since 1400");
			Course course3 = new Course();
			course3.setId(3l);
			course3.setName("Chinese");
			course3.setDescription("chinese...");
			Course course4 = new Course();
			course4.setId(4l);
			course4.setName("English");
			course4.setDescription("english lesson...");
			
			courses.add(course1);
			courses.add(course2);
			courses.add(course3);
			courses.add(course4);
			
			Student studentA = new Student();
			studentA.setId(1l);
			studentA.setName("John");
			studentA.setDescription("Son of earth");
			studentA.getCourses().add(course1);
			studentA.getCourses().add(course2);
			students.add(studentA);
			
			Student studentB = new Student();
			studentB.setId(2l);
			studentB.setName("Lennon");
			studentB.setDescription("Son of ocean");
			studentB.getCourses().add(course3);
			studentB.getCourses().add(course4);
			students.add(studentB);
			
			Student studentC = new Student();
			studentC.setId(3l);
			studentC.setName("Taylor");
			studentC.setDescription("Son of forest");
			studentC.getCourses().add(course1);
			studentC.getCourses().add(course3);
			students.add(studentC);
		}
	}
	
	public List<Student> retrieveAllStudents() {
		return students;
	}
	
	public Student retrieveStudent(Long studentId) {
		Predicate<Student> p1 = s -> s.getId() == studentId;  
		for(Student student : students) {
			if(p1.test(student)) {
				return student;
			}
		}
		return null;
	}
	
	public List<Course> retrieveStudentCourses(Long studentId) {
		return retrieveStudent(studentId).getCourses();
	}
	
	public Course retrieveCourse(Long studentId, Long courseId) {
		Predicate<Course> p1 = s -> s.getId() == courseId;
		for(Course course : retrieveStudent(studentId).getCourses()) {
			if(p1.test(course)) {
				return course;
			}
		}
		return null;
	}
	
	public Course retrieveCourse(Long courseId) {
		Predicate<Course> p1 = s -> s.getId() == courseId;
		for(Course course : courses) {
			if(p1.test(course)) {
				return course;
			}
		}
		return null;
	}
	
	public void addCourse(Long studentId, Course course) {
		retrieveStudent(studentId).getCourses().add(course);
	}
	
}
