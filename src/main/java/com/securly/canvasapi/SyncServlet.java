package com.securly.canvasapi;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.securly.canvasapi.controller.CanvasSyncController;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SyncServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CanvasSyncController canvasSyncController;

	@Autowired
	public SyncServlet(CanvasSyncController canvasSyncController) {
		this.canvasSyncController = canvasSyncController;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rows = canvasSyncController.sync();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Canvas Sync API</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Canvas Sync API</h1>");
		writer.println("<p>Sync completed! Inserted/Updated : " + rows +" entries </p>");
		writer.println("</body>");
		writer.println("</html>");
	}
}