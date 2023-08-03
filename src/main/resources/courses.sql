CREATE TABLE IF NOT EXISTS courses(
   id                                                     INTEGER  NOT NULL PRIMARY KEY 
  ,sis_course_id                                          VARCHAR(30)
  ,uuid                                                   VARCHAR(40) NOT NULL
  ,integration_id                                         VARCHAR(30)
  ,sis_import_id                                          INTEGER  DEFAULT NULL
  ,name                                                   VARCHAR(50)  NOT NULL
  ,course_code                                            VARCHAR(20) NOT NULL
  ,original_name                                          VARCHAR(100) DEFAULT NULL
  ,workflow_state                                         VARCHAR(9) DEFAULT NULL
  ,account_id                                             INTEGER  NOT NULL
  ,root_account_id                                        INTEGER  DEFAULT NULL
  ,enrollment_term_id                                     INTEGER  DEFAULT NULL
  ,grading_periods                                        VARCHAR(30)
  ,grading_standard_id                                    INTEGER  DEFAULT NULL
  ,grade_passback_setting                                 VARCHAR(12) DEFAULT NULL
  ,locale                                                 VARCHAR(2) DEFAULT NULL
  ,enrollments                                            VARCHAR(30)
  ,total_students                                         INTEGER  DEFAULT NULL
  ,calendar                                               VARCHAR(30)
  ,default_view                                           VARCHAR(4) DEFAULT NULL
  ,syllabus_body                                          VARCHAR(30) DEFAULT NULL
  ,needs_grading_count                                    INTEGER  DEFAULT NULL
  ,term                                                   VARCHAR(30)
  ,course_progress                                        VARCHAR(30)
  ,apply_assignment_group_weights                         VARCHAR(4) DEFAULT NULL
  ,is_public                                              VARCHAR(4) DEFAULT NULL
  ,is_public_to_auth_users                                VARCHAR(4) DEFAULT NULL
  ,public_syllabus                                        VARCHAR(4) DEFAULT NULL
  ,public_syllabus_to_auth                                VARCHAR(4) DEFAULT NULL
  ,public_description                                     VARCHAR(100) DEFAULT NULL
  ,storage_quota_mb                                       INTEGER  DEFAULT NULL
  ,storage_quota_used_mb                                  INTEGER  DEFAULT NULL
  ,hide_final_grades                                      VARCHAR(5) DEFAULT NULL
  ,license                                                VARCHAR(16) DEFAULT NULL
  ,allow_student_assignment_edits                         VARCHAR(5) DEFAULT NULL
  ,allow_wiki_comments                                    VARCHAR(5) DEFAULT NULL
  ,allow_student_forum_attachments                        VARCHAR(5) DEFAULT NULL
  ,open_enrollment                                        VARCHAR(4) DEFAULT NULL
  ,self_enrollment                                        VARCHAR(5) DEFAULT NULL
  ,restrict_enrollments_to_course_dates                   VARCHAR(5) DEFAULT NULL
  ,course_format                                          VARCHAR(6) DEFAULT NULL
  ,access_restricted_by_date                              VARCHAR(5) DEFAULT NULL
  ,time_zone                                              VARCHAR(14) DEFAULT NULL
  ,blueprint                                              VARCHAR(4) DEFAULT NULL
  ,template                                               VARCHAR(4) DEFAULT NULL
  ,create_time 					  						  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ,create_user 					  						  VARCHAR(255) DEFAULT NULL
  ,update_time 					 						  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ,update_user 					  						  VARCHAR(255) DEFAULT NULL
);