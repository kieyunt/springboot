package com.ky.springboot.studentservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ky.springboot.studentservice.model.Course;
import com.ky.springboot.studentservice.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=StudentController.class, secure=false)
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;
	
	Course mockCourse = new Course();
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {
		mockCourse.setId(1l);
		mockCourse.setName("History of Islam");
		mockCourse.setDescription("Islamic history since 1400");
		
		Mockito.when(studentService.retrieveCourse(Mockito.anyLong(), Mockito.anyLong())).thenReturn(mockCourse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/1/courses/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"name\":\"History of Islam\",\"description\":\"Islamic history since 1400\",\"id\":1}"; 
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}
