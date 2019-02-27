package com.ky.springboot.studentservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ky.springboot.studentservice.StudentServiceApplication;
import com.ky.springboot.studentservice.model.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=StudentServiceApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testRetrieveStudentCourses() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/students/1/courses/2"), HttpMethod.GET, entity, String.class);
		String expected = "{\"id\":2,\"name\":\"Geography\",\"description\":\"Earth Geography since 1400\"}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void addCourse() {
		Course mockCourse = new Course();
		mockCourse.setId(5l);
		mockCourse.setName("Springboot tutorial step 1");
		mockCourse.setDescription("Step A - Z");
		
		HttpEntity<Course> entity = new HttpEntity<Course>(mockCourse, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/students/1/courses"), HttpMethod.POST, entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		System.out.println(actual);
		assertTrue(actual.contains("/students/1/courses/"));
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:"+port+uri;
	}
}
