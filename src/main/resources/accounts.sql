CREATE TABLE IF NOT EXISTS accounts(
   id                             INTEGER  NOT NULL PRIMARY KEY 
  ,name                           VARCHAR(14) NOT NULL
  ,uuid                           VARCHAR(40) NOT NULL
  ,parent_account_id              INTEGER  DEFAULT NULL
  ,root_account_id                INTEGER  DEFAULT NULL
  ,default_storage_quota_mb       INTEGER  DEFAULT NULL
  ,default_user_storage_quota_mb  INTEGER  DEFAULT NULL
  ,default_group_storage_quota_mb INTEGER  DEFAULT NULL
  ,default_time_zone              VARCHAR(14) DEFAULT NULL
  ,sis_account_id                 INTEGER DEFAULT NULL
  ,integration_id                 INTEGER DEFAULT NULL
  ,sis_import_id                  INTEGER  DEFAULT NULL
  ,lti_guid                       VARCHAR(6) DEFAULT NULL
  ,workflow_state                 VARCHAR(6) DEFAULT NULL
  ,create_time 					  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ,create_user 					  VARCHAR(255) DEFAULT NULL
  ,update_time 					  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  ,update_user 					  VARCHAR(255) DEFAULT NULL
);