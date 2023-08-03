package com.securly.canvasapi;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.securly.canvasapi.controller.CanvasSyncController;

public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	private static final int PORT = 8080;

	private static final String CONTEXT_PATH = "/";
	private static final String CONFIG_LOCATION_PACKAGE = "com.securly.canvasapi";
	private static final String MAPPING_URL = "/sync";
	private static final String WEBAPP_DIRECTORY = "./src/main/resources";

	public static void main(String[] args) throws Exception {
		new Application().startServer(PORT);
	}

	private void startServer(int port) throws Exception {
		LOGGER.info("Starting server at port {}", port);
		Server server = new Server(port);

		server.setHandler(getServletContextHandler());

		addRuntimeShutdownHook(server);

		server.start();
		LOGGER.info("Server started at port {}", port);
		server.join();
	}

	private static ServletContextHandler getServletContextHandler() throws IOException {

		ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		contextHandler.setErrorHandler(null);

		contextHandler.setResourceBase(new ClassPathResource(WEBAPP_DIRECTORY).getPath().toString());
		contextHandler.setContextPath(CONTEXT_PATH);

		contextHandler.setClassLoader(Thread.currentThread().getContextClassLoader());

		WebApplicationContext webAppContext = getWebApplicationContext();
		contextHandler.addServlet(DefaultServlet.class, CONTEXT_PATH);
		contextHandler.addServlet(new ServletHolder(new SyncServlet(webAppContext.getBean(CanvasSyncController.class))),
				MAPPING_URL);
		return contextHandler;
	}

	private static WebApplicationContext getWebApplicationContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(CONFIG_LOCATION_PACKAGE);
		context.registerShutdownHook();
		context.refresh();
		return context;
	}

	private static void addRuntimeShutdownHook(final Server server) {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				if (server.isStarted()) {
					server.setStopAtShutdown(true);
					try {
						server.stop();
					} catch (Exception e) {
						System.out.println("Error while stopping jetty server: " + e.getMessage());
						LOGGER.error("Error while stopping jetty server: " + e.getMessage(), e);
					}
				}
			}
		}));
	}
}