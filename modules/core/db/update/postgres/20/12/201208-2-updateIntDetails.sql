alter table VAULT_INT_DETAILS rename column int_status_id to int_status_id__u33855 ;
alter table VAULT_INT_DETAILS rename column int_lob_id to int_lob_id__u57133 ;
alter table VAULT_INT_DETAILS rename column int_spl_ops_id to int_spl_ops_id__u77614 ;
alter table VAULT_INT_DETAILS rename column int_initiating_sys_id to int_initiating_sys_id__u30972 ;
alter table VAULT_INT_DETAILS rename column int_workstream_id to int_workstream_id__u99569 ;
alter table VAULT_INT_DETAILS rename column int_priority_id to int_priority_id__u92524 ;
alter table VAULT_INT_DETAILS rename column int_complexity_id to int_complexity_id__u13005 ;
alter table VAULT_INT_DETAILS rename column int_design_pattern_id to int_design_pattern_id__u40764 ;
alter table VAULT_INT_DETAILS rename column int_dest_payload_type_id to int_dest_payload_type_id__u91209 ;
alter table VAULT_INT_DETAILS rename column int_dest_protocol_id to int_dest_protocol_id__u95257 ;
alter table VAULT_INT_DETAILS rename column int_dest_app_id to int_dest_app_id__u20508 ;
alter table VAULT_INT_DETAILS rename column int_src_payload_type_id to int_src_payload_type_id__u78112 ;
alter table VAULT_INT_DETAILS rename column int_src_protocol_id to int_src_protocol_id__u01065 ;
alter table VAULT_INT_DETAILS rename column int_platform_version_id to int_platform_version_id__u92961 ;
alter table VAULT_INT_DETAILS rename column int_platform_id to int_platform_id__u69880 ;
alter table VAULT_INT_DETAILS rename column int_country_id to int_country_id__u63324 ;
alter table VAULT_INT_DETAILS rename column int_region_id to int_region_id__u05266 ;
alter table VAULT_INT_DETAILS rename column int_brand_or_bu_id to int_brand_or_bu_id__u51178 ;
alter table VAULT_INT_DETAILS rename column int_payload_secur_class_id to int_payload_secur_class_id__u87430 ;
alter table VAULT_INT_DETAILS rename column int_crud_id to int_crud_id__u84006 ;
alter table VAULT_INT_DETAILS add column INT_CRUD_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_PAYLOAD_SECUR_CLASS_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_BRAND_OR_BU_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_REGION_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_COUNTRY_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_PLATFORM_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_PLATFORM_VERSION_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_SRC_PROTOCOL_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_SRC_PAYLOAD_TYPE_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_DEST_APP_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_DEST_PROTOCOL_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_DEST_PAYLOAD_TYPE_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_DESIGN_PATTERN_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_COMPLEXITY_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_PRIORITY_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_WORKSTREAM_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_INITIATING_SYS_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_SPL_OPS_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_LOB_ID varchar(10) ;
alter table VAULT_INT_DETAILS add column INT_STATUS_ID varchar(10) ;
