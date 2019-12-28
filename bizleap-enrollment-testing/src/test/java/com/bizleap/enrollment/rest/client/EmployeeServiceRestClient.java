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

import com.bizleap.enrollment.domain.simple.SimpleEmployee;
import com.bizleap.enrollment.domain.simple.SimpleSection;

public class EmployeeServiceRestClient {
	

	private static final Logger logger = Logger.getLogger(EmployeeServiceRestClient.class);

	private final static String SERVICEURL = "http://localhost:8080/bizleap-enrollment-application";

	public void getAllEmployee() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		logger.info("Request is: " + entity);

		String url = SERVICEURL + "/employees/list";
		logger.info("Service url is: " + url);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		logger.info("Calling webservice..." + builder);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<List> response = null;

		try {
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, List.class);
			logger.info("Employee List: " + response.getBody());

		} catch (Exception e) {
			logger.error("ERRROR - " + e.getMessage() + ", " + response);
		}
	}

	public void findByEmployeeBoId(String boId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		logger.info("Request is: " + entity);
		String url = SERVICEURL + "/employees/find/" + boId;
		logger.info("service url is: " + url);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		RestTemplate restTemplate = new RestTemplate();
		logger.info("calling webservice..." + builder);

		HttpEntity<String> response = null;

		try {
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
			logger.info("Find Employee: " + response.getBody());
		} catch (Exception e) {
			logger.error("ERRROR - " + e.getMessage() + ", " + response);
		}
	}

	
	public void authorize(String email,String password) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		logger.info("Request is: " + entity);
		String url = SERVICEURL + "/employees/authorize/" + email + "/" +password;
		logger.info("service url is: " + url);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		RestTemplate restTemplate = new RestTemplate();
		logger.info("calling webservice..." + builder);

		HttpEntity<String> response = null;

		try {
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
			logger.info("authorize Employee: " + response.getBody());
		} catch (Exception e) {
			logger.error("ERRROR - " + e.getMessage() + ", " + response);
		}
	}
	
	public void saveEmployee(SimpleEmployee simpleEmployee) {

		// Prepare the header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<SimpleEmployee> entityHeader = new HttpEntity<SimpleEmployee>(simpleEmployee, headers);
		logger.info("Request is: " + entityHeader);

		// Prepare the URL
		String url = SERVICEURL + "/employees/create";
		logger.info("service url is: " + url);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		logger.info("calling webservice..." + builder);

		// RESTTemplate to call the service
		RestTemplate restTemplate = new RestTemplate();

		// Data type for response
		HttpEntity<String> response = null;
		try {
			logger.info("Before calling resource.");
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, entityHeader,
					String.class);
		} catch (Exception e) {
			logger.error("ERRROR is - " + e.getMessage() + ", " + response);
		}

	}
}


