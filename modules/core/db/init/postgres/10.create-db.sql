-- begin VAULT_ERROR_SUMMARY
create table VAULT_ERROR_SUMMARY (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    ERR_UPL_ID bigint,
    ERR_ROW_NO integer,
    ERR_COL_NO integer,
    ERR_DATATYPE varchar(500),
    ERR_DESCRIPTION text,
    --
    primary key (ID)
)^
-- end VAULT_ERROR_SUMMARY

-- begin VAULT_UPLOAD_SUMMARY
create table VAULT_UPLOAD_SUMMARY (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    UPL_FILENAME varchar(255),
    UPL_DATATYPE varchar(500),
    UPL_SUCCESS_RECORDS integer,
    UPL_ERROR_RECORDS integer,
    --
    primary key (ID)
)^
-- end VAULT_UPLOAD_SUMMARY

-- begin VAULT_MASTER_DATA_MANAGEMENT
create table VAULT_MASTER_DATA_MANAGEMENT (
    MASTER_CODE varchar(20),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MASTER_TYPE varchar(500) not null,
    MASTER_DESCRIPTION text,
    --
    primary key (MASTER_CODE)
)^
-- end VAULT_MASTER_DATA_MANAGEMENT
-- begin VAULT_INT_DETAILS
create table VAULT_INT_DETAILS (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    INT_ASSET_ID varchar(255) not null,
    INT_UPL_ID bigint,
    INT_NAME varchar(500) not null,
    INT_DESCRIPTION text,
    INT_CRUD_MASTERCODE varchar(10),
    INT_PAYLOAD text,
    INT_PAYLOAD_SECUR_CLASS_MASTERCODE varchar(10),
    INT_BRAND_OR_BU_MASTERCODE varchar(10),
    INT_REGION_MASTERCODE varchar(10),
    INT_COUNTRY_MASTERCODE varchar(10),
    INT_PLATFORM_MASTERCODE varchar(10),
    INT_PLATFORM_VERSION_MASTERCODE varchar(10),
    INT_SRC_PROTOCOL_MASTERCODE varchar(10),
    INT_SRC_PAYLOAD_TYPE_MASTERCODE varchar(10),
    INT_DEST_APP_MASTERCODE varchar(10),
    INT_DEST_PROTOCOL_MASTERCODE varchar(10),
    INT_DEST_PAYLOAD_TYPE_MASTERCODE varchar(10),
    INT_DESIGN_PATTERN_MASTERCODE varchar(10),
    INT_IMPL_PATTERN varchar(500),
    INT_COMPLEXITY_MASTERCODE varchar(10),
    INT_THROUGHPUT_IN_SECONDS varchar(255),
    INT_MSG_SIZE_IN_KB varchar(1000),
    INT_OWNER varchar(255),
    INT_BA varchar(255),
    INT_PROJECT_MASTERCODE varchar(10),
    INT_PRIORITY_MASTERCODE varchar(10),
    INT_WORKSTREAM_MASTERCODE varchar(10),
    INT_PROCESSING_TYPE_MASTERCODE varchar(10),
    INT_INITIATING_SYS_MASTERCODE varchar(10),
    INT_SPL_OPS_MASTERCODE varchar(10),
    INT_DEPENDENCY varchar(255),
    INT_BUSINESS_OWNER varchar(255),
    INT_REMARKS text,
    INT_F_SPEC_LOC varchar(500),
    TECHNICAL_SPEC_LOCATION varchar(500),
    SOURCE_CODE_REPOSITORY varchar(500),
    REPO_LOCATION varchar(500),
    LINK varchar(500),
    INT_LOB varchar(500),
    INT_STATUS_MASTERCODE varchar(10),
    INT_INTERNAL_STATUS varchar(50),
    --
    primary key (ID)
)^
-- end VAULT_INT_DETAILS
-- begin VAULT_INT_API_DETAILS
create table VAULT_INT_API_DETAILS (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    INT_DETAILS_ID bigint not null,
    API_DETAILS_ID bigint not null,
    --
    primary key (ID)
)^
-- end VAULT_INT_API_DETAILS
-- begin VAULT_API_DETAILS
create table VAULT_API_DETAILS (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    API_UPL_ID bigint,
    INT_ASSET_ID varchar(255),
    API_ID varchar(255) not null,
    API_NAME varchar(500) not null,
    API_DESCRIPTION text,
    API_CLASSIFICATION_MASTERCODE varchar(10),
    API_SUPPORTED_OPS_MASTERCODE varchar(10),
    API_ENTITY_NAME varchar(255),
    API_PAYLOAD_SECUR_CLASS_MASTERCODE varchar(10),
    API_BRAND_OR_BU_MASTERCODE varchar(10),
    API_REGION_MASTERCODE varchar(10),
    API_COUNTRY_MASTERCODE varchar(10),
    API_PROJECT_MASTERCODE varchar(10),
    API_PRIORITY_MASTERCODE varchar(10),
    API_STATUS_MASTERCODE varchar(10),
    API_PROCESSING_TYPE_MASTERCODE varchar(10),
    API_BUSINESS_OWNER varchar(255),
    API_WORKSTREAM_MASTERCODE varchar(10),
    API_RELEASE varchar(255),
    API_PLATFORM_MASTERCODE varchar(10),
    API_PLATFORM_VERSION_MASTERCODE varchar(10),
    API_SRC_PROTOCOL_MASTERCODE varchar(10),
    API_SRC_PAYLOAD_TYPE_MASTERCODE varchar(10),
    API_DEST_APP_MASTERCODE varchar(10),
    API_DEST_PROTOCOL_MASTERCODE varchar(10),
    API_DEST_PAYLOAD_TYPE_MASTERCODE varchar(10),
    API_DESIGN_PATTERN_MASTERCODE varchar(10),
    API_COMPLEXITY_MASTERCODE varchar(10),
    API_THROUPUT_IN_SEC varchar(255),
    API_INT_MESSAGE_SIZE_IN_KB varchar(255),
    API_DEPENDENCY varchar(255),
    API_INT_OWNER varchar(255),
    API_REMARKS text,
    API_LOB varchar(500),
    API_INTERNAL_STATUS varchar(50),
    --
    primary key (ID)
)^
-- end VAULT_API_DETAILS
