package com.securly.canvasapi;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import com.securly.canvasapi.controller.CanvasSyncController;
import com.securly.canvasapi.repository.JdbcCanvasRepository;
import com.securly.canvasapi.service.SyncService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.securly.canvasapi")
public class AppConfig {
	
	private static final String DB_PORT = "5432";
	private static final String DATABASE = "canvasapi";
	private static final String JDBC_URL = "jdbc:postgresql://localhost:" + DB_PORT +"/" +DATABASE;
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "postgres";


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CanvasAPIClient canvasAPIClient() {
		return new CanvasAPIClient(restTemplate());
	}

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(JDBC_URL);
		config.setUsername(DB_USERNAME);
		config.setPassword(DB_PASSWORD);
		config.setMaximumPoolSize(3);
		return new HikariDataSource(config);
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public SyncService syncService() {
		return new SyncService(jdbcCanvasRepository(jdbcTemplate()));
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public JdbcCanvasRepository jdbcCanvasRepository(JdbcTemplate jdbcTemplate) {
		return new JdbcCanvasRepository(jdbcTemplate);
	}

	@Bean
	public SyncService syncService(JdbcCanvasRepository jdbcCanvasRepository) {
		return new SyncService(jdbcCanvasRepository);
	}

	@Bean
	public CanvasSyncController canvasSyncController(SyncService syncService, CanvasAPIClient canvasAPIClient) {
		return new CanvasSyncController(syncService, canvasAPIClient);
	}
	
}