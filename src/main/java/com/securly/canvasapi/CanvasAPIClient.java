package com.securly.canvasapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securly.canvasapi.model.CanvasAccount;
import com.securly.canvasapi.model.CanvasCourse;

@Component
public class CanvasAPIClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(CanvasAPIClient.class);
	private static final String BASE_URL = "http://3.231.151.15";
	private static final String ACCOUNTS_DATA_END_POINT = "/accounts";
	private static final String COURSES_DATA_END_POINT = "/courses";
	private static final String BASE_END_POINT = "/api/v1/";
	private static final String ACCESS_TOKEN = "w9TfSeHKrezobmgYDIjNKcCAUxxIqNNk7Kj4arO2J2vTRyPayufeCC9P2GGMEGd2";
	private static final String ACCOUNTS_JSON_FILE = "/accounts.json";
	private static final String COURSES_JSON_FILE = "/courses.json";
	private final RestTemplate restTemplate;

	@Autowired
	public CanvasAPIClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<CanvasAccount> getAccounts() {
		LOGGER.info("getAccounts endpoint called");
		ArrayList<CanvasAccount> accountsList = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		HttpHeaders headers = new HttpHeaders();
//		headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + ACCESS_TOKEN);
//		HttpEntity<Void> entity = new HttpEntity<>(headers);

//		 ResponseEntity<CanvasAccount[]> response = restTemplate.exchange(
//		 BASE_URL + BASE_END_POINT + ACCOUNTS_DATA_END_POINT, HttpMethod.GET, entity,
//		 CanvasAccount[].class);
		try {
			CanvasAccount[] accounts = mapper.readValue(getClass().getResource(ACCOUNTS_JSON_FILE),
					CanvasAccount[].class);
			accountsList = new ArrayList<>(Arrays.asList(accounts));
		} catch (IOException e) {
			LOGGER.error("Exception occurred while reading account values ", e);
		}
		return accountsList;
	}

	public List<CanvasCourse> getCourses() {
		LOGGER.info("getCourses endpoint called");
		ArrayList<CanvasCourse> coursesList = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//		HttpHeaders headers = new HttpHeaders();
//		headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + ACCESS_TOKEN);
//		HttpEntity<Void> entity = new HttpEntity<>(headers);

//		 ResponseEntity<CanvasCourse[]> response = restTemplate.exchange(
//		 BASE_URL + BASE_END_POINT + COURSES_DATA_END_POINT, HttpMethod.GET, entity,
//		 CanvasCourse[].class);
		try {
			CanvasCourse[] courses = mapper.readValue(getClass().getResource(COURSES_JSON_FILE), CanvasCourse[].class);
			coursesList = new ArrayList<>(Arrays.asList(courses));
		} catch (IOException e) {
			LOGGER.error("Exception occurred while reading course values ", e);
		}
		return coursesList;
	}
}
