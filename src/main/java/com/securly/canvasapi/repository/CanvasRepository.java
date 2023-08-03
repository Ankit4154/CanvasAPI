package com.securly.canvasapi.repository;

import java.util.List;

import com.securly.canvasapi.model.CanvasAccount;
import com.securly.canvasapi.model.CanvasCourse;

public interface CanvasRepository {
    
    public int saveAllAccounts(List<CanvasAccount> accounts);
    
    public int saveAllCourses(List<CanvasCourse> courses);
}