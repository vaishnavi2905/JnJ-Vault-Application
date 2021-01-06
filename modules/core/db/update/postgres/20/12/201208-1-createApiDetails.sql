create table VAULT_API_DETAILS (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    API_UPL_MASTERCODE varchar(10),
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
);