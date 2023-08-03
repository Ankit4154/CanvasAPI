package com.securly.canvasapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.securly.canvasapi.CanvasAPIClient;
import com.securly.canvasapi.model.CanvasAccount;
import com.securly.canvasapi.model.CanvasCourse;
import com.securly.canvasapi.service.SyncService;

@Controller
public class CanvasSyncController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CanvasSyncController.class);
	private SyncService syncService;
	private CanvasAPIClient canvasAPIClient;

	@Autowired
	public CanvasSyncController(SyncService syncService, CanvasAPIClient canvasAPIClient) {
		this.syncService = syncService;
		this.canvasAPIClient = canvasAPIClient;
	}

	@RequestMapping(value = "/sync", method = RequestMethod.GET)
	public int sync() {
		LOGGER.info("Start Sync method called");
		int numOfAccountsInserted = 0;
		int numOfCoursesInserted = 0;
		List<CanvasAccount> accounts = canvasAPIClient.getAccounts();
		if (accounts.isEmpty()) {
			LOGGER.info("No records found for accounts api");
		} else {
			numOfAccountsInserted = syncService.syncAccounts(accounts);
			LOGGER.info("Total rows inserted/updated in accounts : {}",numOfAccountsInserted);
		}
		List<CanvasCourse> courses = canvasAPIClient.getCourses();
		if (courses.isEmpty()) {
			LOGGER.info("No records found for courses api");
		} else {
			numOfCoursesInserted = syncService.syncCourses(courses);
			LOGGER.info("Total rows inserted/updated in courses : {}", numOfCoursesInserted);
		}
		return numOfAccountsInserted + numOfCoursesInserted;
	}

}
