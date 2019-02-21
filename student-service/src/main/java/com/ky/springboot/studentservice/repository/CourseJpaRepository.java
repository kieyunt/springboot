package com.ky.springboot.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ky.springboot.studentservice.model.Course;

@RepositoryRestResource(path="course", collectionResourceRel = "course")
public interface CourseJpaRepository extends JpaRepository<Course, Long> {

}
