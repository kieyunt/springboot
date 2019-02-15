package com.ky.springboot.studentservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ky.springboot.studentservice.model.Student;

@RepositoryRestResource(path="studentrs", collectionResourceRel = "studentrs")
public interface StudentDataRestRepository extends PagingAndSortingRepository<Student, Long> {

}
