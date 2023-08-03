package com.securly.canvasapi.model;

public class CanvasAccount {
	private Integer id;
	private String name;
	private String uuid;
	private Integer parent_account_id;
	private Integer root_account_id;
	private Integer default_storage_quota_mb;
	private Integer default_user_storage_quota_mb;
	private Integer default_group_storage_quota_mb;
	private String default_time_zone;
	private Integer sis_account_id;
	private Integer integration_id;
	private Integer sis_import_id;
	private String lti_guid;
	private String workflow_state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getParent_account_id() {
		return parent_account_id;
	}

	public void setParent_account_id(Integer parent_account_id) {
		this.parent_account_id = parent_account_id;
	}

	public Integer getRoot_account_id() {
		return root_account_id;
	}

	public void setRoot_account_id(Integer root_account_id) {
		this.root_account_id = root_account_id;
	}

	public Integer getDefault_storage_quota_mb() {
		return default_storage_quota_mb;
	}

	public void setDefault_storage_quota_mb(Integer default_storage_quota_mb) {
		this.default_storage_quota_mb = default_storage_quota_mb;
	}

	public Integer getDefault_user_storage_quota_mb() {
		return default_user_storage_quota_mb;
	}

	public void setDefault_user_storage_quota_mb(Integer default_user_storage_quota_mb) {
		this.default_user_storage_quota_mb = default_user_storage_quota_mb;
	}

	public Integer getDefault_group_storage_quota_mb() {
		return default_group_storage_quota_mb;
	}

	public void setDefault_group_storage_quota_mb(Integer default_group_storage_quota_mb) {
		this.default_group_storage_quota_mb = default_group_storage_quota_mb;
	}

	public String getDefault_time_zone() {
		return default_time_zone;
	}

	public void setDefault_time_zone(String default_time_zone) {
		this.default_time_zone = default_time_zone;
	}

	public Integer getSis_account_id() {
		return sis_account_id;
	}

	public void setSis_account_id(Integer sis_account_id) {
		this.sis_account_id = sis_account_id;
	}

	public Integer getIntegration_id() {
		return integration_id;
	}

	public void setIntegration_id(Integer integration_id) {
		this.integration_id = integration_id;
	}

	public Integer getSis_import_id() {
		return sis_import_id;
	}

	public void setSis_import_id(Integer sis_import_id) {
		this.sis_import_id = sis_import_id;
	}

	public String getLti_guid() {
		return lti_guid;
	}

	public void setLti_guid(String lti_guid) {
		this.lti_guid = lti_guid;
	}

	public String getWorkflow_state() {
		return workflow_state;
	}

	public void setWorkflow_state(String workflow_state) {
		this.workflow_state = workflow_state;
	}

}