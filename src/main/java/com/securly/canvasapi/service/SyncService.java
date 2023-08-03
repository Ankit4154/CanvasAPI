package com.securly.canvasapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securly.canvasapi.model.CanvasAccount;
import com.securly.canvasapi.model.CanvasCourse;
import com.securly.canvasapi.repository.JdbcCanvasRepository;

@Service
public class SyncService implements CanvasService{
	
    private JdbcCanvasRepository jdbcCanvasRepository;

    @Autowired
    public SyncService(JdbcCanvasRepository jdbcCanvasRepository) {
        this.jdbcCanvasRepository = jdbcCanvasRepository;
    }

    public int syncAccounts(List<CanvasAccount> accounts) {
    	return jdbcCanvasRepository.saveAllAccounts(accounts);
    }

    public int syncCourses(List<CanvasCourse> courses) {
    	return jdbcCanvasRepository.saveAllCourses(courses);
    }
    
}
