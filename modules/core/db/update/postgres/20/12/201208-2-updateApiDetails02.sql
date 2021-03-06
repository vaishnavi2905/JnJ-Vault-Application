alter table VAULT_API_DETAILS rename column api_lob_id to api_lob_id__u92801 ;
alter table VAULT_API_DETAILS rename column api_complexity_id to api_complexity_id__u98746 ;
alter table VAULT_API_DETAILS rename column api_design_pattern_id to api_design_pattern_id__u46255 ;
alter table VAULT_API_DETAILS rename column api_dest_payload_type_id to api_dest_payload_type_id__u30850 ;
alter table VAULT_API_DETAILS rename column api_dest_protocol_id to api_dest_protocol_id__u59431 ;
alter table VAULT_API_DETAILS rename column api_dest_app_id to api_dest_app_id__u27965 ;
alter table VAULT_API_DETAILS rename column api_src_payload_type_id to api_src_payload_type_id__u79339 ;
alter table VAULT_API_DETAILS rename column api_src_protocol_id to api_src_protocol_id__u94043 ;
alter table VAULT_API_DETAILS rename column api_platform_version_id to api_platform_version_id__u02055 ;
alter table VAULT_API_DETAILS rename column api_platform_id to api_platform_id__u68190 ;
alter table VAULT_API_DETAILS rename column api_workstream_id to api_workstream_id__u36218 ;
alter table VAULT_API_DETAILS rename column api_status_id to api_status_id__u58299 ;
alter table VAULT_API_DETAILS rename column api_priority_id to api_priority_id__u62971 ;
alter table VAULT_API_DETAILS rename column api_project_id to api_project_id__u23787 ;
alter table VAULT_API_DETAILS rename column api_country_id to api_country_id__u59695 ;
alter table VAULT_API_DETAILS rename column api_region_id to api_region_id__u17110 ;
alter table VAULT_API_DETAILS rename column api_brand_or_bu_id to api_brand_or_bu_id__u25831 ;
alter table VAULT_API_DETAILS rename column api_payload_secur_class_id to api_payload_secur_class_id__u80525 ;
alter table VAULT_API_DETAILS rename column api_supported_ops_id to api_supported_ops_id__u80145 ;
alter table VAULT_API_DETAILS rename column api_classification_id to api_classification_id__u82953 ;
alter table VAULT_API_DETAILS add column API_CLASSIFICATION_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_SUPPORTED_OPS_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_PAYLOAD_SECUR_CLASS_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_BRAND_OR_BU_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_REGION_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_COUNTRY_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_PROJECT_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_PRIORITY_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_STATUS_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_WORKSTREAM_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_PLATFORM_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_PLATFORM_VERSION_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_SRC_PROTOCOL_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_SRC_PAYLOAD_TYPE_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_DEST_APP_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_DEST_PROTOCOL_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_DEST_PAYLOAD_TYPE_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_DESIGN_PATTERN_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_COMPLEXITY_ID varchar(10) ;
alter table VAULT_API_DETAILS add column API_LOB_ID varchar(10) ;
-- update VAULT_API_DETAILS set API_ID = <default_value> where API_ID is null ;
alter table VAULT_API_DETAILS alter column API_ID set not null ;
