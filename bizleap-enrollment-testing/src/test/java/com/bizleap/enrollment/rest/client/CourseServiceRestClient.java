package com.bizleap.enrollment.rest.client;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bizleap.enrollment.domain.simple.SimpleCourse;

public class CourseServiceRestClient {
	private static final Logger logger = Logger.getLogger(CourseServiceRestClient.class);

	private final static String SERVICEURL = "http://localhost:8080/bizleap-enrollment-application";

	public void getAllCourse() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		logger.info("Request is: " + entity);

		String url = SERVICEURL + "/courses/list";
		logger.info("Service url is: " + url);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		logger.info("Calling webservice..." + builder);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<List> response = null;

		try {
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, List.class);
			logger.info("Course List: " + response.getBody());

		} catch (Exception e) {
			logger.error("ERRROR - " + e.getMessage() + ", " + response);
		}
	}

	public void findByCourseBoId(String boId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		logger.info("Request is: " + entity);
		String url = SERVICEURL + "/courses/find/" + boId;
		logger.info("service url is: " + url);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		RestTemplate restTemplate = new RestTemplate();
		logger.info("calling webservice..." + builder);

		HttpEntity<String> response = null;

		try {
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
			logger.info("Find Course: " + response.getBody());
		} catch (Exception e) {
			logger.error("ERRROR - " + e.getMessage() + ", " + response);
		}
	}

	public void saveCourse(SimpleCourse simpleCourse) {

		// Prepare the header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<SimpleCourse> entityHeader = new HttpEntity<SimpleCourse>(simpleCourse, headers);
		logger.info("Request is: " + entityHeader);

		// Prepare the URL
		String url = SERVICEURL + "/courses/create";
		logger.info("service url is: " + url);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		logger.info("calling webservice..." + builder);

		// RESTTemplate to call the service
		RestTemplate restTemplate = new RestTemplate();

		// Data type for response
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, entityHeader,
					String.class);
			logger.info("after service");

		} catch (Exception e) {
			logger.error("ERRROR is - " + e.getMessage() + ", " + response);
		}

	}
}

