create table VAULT_INT_DETAILS (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    --
    INT_UPL_ID_ID bigint,
    INT_ASSET_ID varchar(255) not null,
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
);