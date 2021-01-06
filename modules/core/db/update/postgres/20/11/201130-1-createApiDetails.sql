create table VAULT_API_DETAILS (
    API_ID varchar(10),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    NAME varchar(255),
    DESCRIPTION text,
    CLASSIFICATION_ID bigint,
    SUPPORTED_OPERATIONS_ID bigint,
    ENTITY_NAME_ID bigint,
    SECURITY_CLASSIFICATION_ID bigint,
    BUSINESS_UNIT_ID bigint,
    REGION_ID bigint,
    COUNTRY_ID bigint,
    PROJECT_ID bigint,
    WORKSTREAM_ID bigint,
    RELEASE_NO varchar(255),
    PRIORITY_ID bigint,
    STATUS_ID bigint,
    PLATFORM varchar(500),
    PLATFORM_VERSION varchar(255),
    --
    primary key (API_ID)
);