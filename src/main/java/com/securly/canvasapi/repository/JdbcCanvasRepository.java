package com.securly.canvasapi.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.securly.canvasapi.model.CanvasAccount;
import com.securly.canvasapi.model.CanvasCourse;

@Repository
public class JdbcCanvasRepository implements CanvasRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcCanvasRepository.class);
	private static final String CREATE_TABLE_ACCOUNTS = "/accounts.sql";
	private static final String CREATE_TABLE_COURSES = "/courses.sql";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcCanvasRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String readQueryFromFile(String filePath) {
		String query = "";
		try {
			query = Files.readString(new File(getClass().getResource(filePath).getFile()).toPath());

		} catch (IOException e) {
			LOGGER.error("Exception occurred while reading query from file", e);
		}
		return query;
	}

	public int saveAllAccounts(List<CanvasAccount> accounts) {
		LOGGER.info("Saving/Updating {} account entries to db", accounts.size());
		String query = readQueryFromFile(CREATE_TABLE_ACCOUNTS);
		jdbcTemplate.execute(query);
		String sql = "INSERT INTO ACCOUNTS "
				+ "(id,name,uuid,parent_account_id,root_account_id,default_storage_quota_mb,default_user_storage_quota_mb,default_group_storage_quota_mb,default_time_zone,sis_account_id,integration_id,sis_import_id,lti_guid,workflow_state,create_time,create_user,update_time,update_user)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " + "ON CONFLICT (id) DO UPDATE "
				+ "SET update_time = CURRENT_TIMESTAMP";
		int rows[] = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				CanvasAccount account = accounts.get(i);
				ps.setInt(1, account.getId());
				ps.setString(2, account.getName());
				ps.setString(3, account.getUuid());
				ps.setInt(4, account.getParent_account_id());
				ps.setInt(5, account.getRoot_account_id());
				ps.setInt(6, account.getDefault_storage_quota_mb());
				ps.setInt(7, account.getDefault_user_storage_quota_mb());
				ps.setInt(8, account.getDefault_group_storage_quota_mb());
				ps.setString(9, account.getDefault_time_zone());
				ps.setInt(10, account.getSis_account_id());
				ps.setInt(11, account.getIntegration_id());
				ps.setInt(12, account.getSis_import_id());
				ps.setString(13, account.getLti_guid());
				ps.setString(14, account.getWorkflow_state());
				ps.setTimestamp(15, Timestamp.valueOf(LocalDateTime.now()));
				ps.setString(16, account.getName());
				ps.setTimestamp(17, Timestamp.valueOf(LocalDateTime.now()));
				ps.setString(18, account.getName());

			}

			@Override
			public int getBatchSize() {
				return accounts.size();
			}

		});
		return Arrays.stream(rows).sum();
	}

	public int saveAllCourses(List<CanvasCourse> courses) {
		LOGGER.info("Saving/Updating {} course entries to db", courses.size());
		String query = readQueryFromFile(CREATE_TABLE_COURSES);
		jdbcTemplate.execute(query);
		String sql = "INSERT INTO COURSES "
				+ "(id, sis_course_id, uuid, integration_id, sis_import_id, name, course_code, original_name, workflow_state, account_id, root_account_id, enrollment_term_id, grading_periods, grading_standard_id, grade_passback_setting, locale, enrollments, total_students, calendar, default_view, syllabus_body, needs_grading_count, term, course_progress, apply_assignment_group_weights, is_public, is_public_to_auth_users, public_syllabus, public_syllabus_to_auth, public_description, storage_quota_mb, storage_quota_used_mb, hide_final_grades, license, allow_student_assignment_edits, allow_wiki_comments, allow_student_forum_attachments, open_enrollment, self_enrollment, restrict_enrollments_to_course_dates, course_format, access_restricted_by_date, time_zone, blueprint, template, create_time, create_user, update_time, update_user) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
				+ "ON CONFLICT (id) DO UPDATE " + "SET update_time = CURRENT_TIMESTAMP";
		int rows[] = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				CanvasCourse course = courses.get(i);
				ps.setInt(1, course.getId());
				ps.setString(2, course.getSis_course_id());
				ps.setString(3, course.getUuid());
				ps.setString(4, course.getIntegration_id());
				ps.setInt(5, course.getSis_import_id());
				ps.setString(6, course.getName());
				ps.setString(7, course.getCourse_code());
				ps.setString(8, course.getOriginal_name());
				ps.setString(9, course.getWorkflow_state());
				ps.setInt(10, course.getAccount_id());
				ps.setInt(11, course.getRoot_account_id());
				ps.setInt(12, course.getEnrollment_term_id());
				ps.setString(13, course.getGrading_periods());
				ps.setInt(14, course.getGrading_standard_id());
				ps.setString(15, course.getGrade_passback_setting());
				ps.setString(16, course.getLocale());
				ps.setString(17, course.getEnrollments());
				ps.setInt(18, course.getTotal_students());
				ps.setString(19, course.getCalendar());
				ps.setString(20, course.getDefault_view());
				ps.setString(21, course.getSyllabus_body());
				ps.setInt(22, course.getNeeds_grading_count());
				ps.setString(23, course.getTerm());
				ps.setString(24, course.getCourse_progress());
				ps.setString(25, course.getApply_assignment_group_weights());
				ps.setString(26, course.getIs_public());
				ps.setString(27, course.getIs_public_to_auth_users());
				ps.setString(28, course.getPublic_syllabus());
				ps.setString(29, course.getPublic_syllabus_to_auth());
				ps.setString(30, course.getPublic_description());
				ps.setInt(31, course.getStorage_quota_mb());
				ps.setInt(32, course.getStorage_quota_used_mb());
				ps.setString(33, course.getHide_final_grades());
				ps.setString(34, course.getLicense());
				ps.setString(35, course.getAllow_student_assignment_edits());
				ps.setString(36, course.getAllow_wiki_comments());
				ps.setString(37, course.getAllow_student_forum_attachments());
				ps.setString(38, course.getOpen_enrollment());
				ps.setString(39, course.getSelf_enrollment());
				ps.setString(40, course.getRestrict_enrollments_to_course_dates());
				ps.setString(41, course.getCourse_format());
				ps.setString(42, course.getAccess_restricted_by_date());
				ps.setString(43, course.getTime_zone());
				ps.setString(44, course.getBlueprint());
				ps.setString(45, course.getTemplate());
				ps.setTimestamp(46, Timestamp.valueOf(LocalDateTime.now()));
				ps.setString(47, course.getName());
				ps.setTimestamp(48, Timestamp.valueOf(LocalDateTime.now()));
				ps.setString(49, course.getName());

			}

			@Override
			public int getBatchSize() {
				return courses.size();
			}

		});
		return Arrays.stream(rows).sum();
	}
}
