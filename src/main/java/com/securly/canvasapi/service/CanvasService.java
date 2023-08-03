package com.securly.canvasapi.service;

import java.util.List;

import com.securly.canvasapi.model.CanvasAccount;
import com.securly.canvasapi.model.CanvasCourse;

public interface CanvasService {
	 public int syncAccounts(List<CanvasAccount> accounts);
	 public int syncCourses(List<CanvasCourse> courses);
}
