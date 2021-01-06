create table VAULT_BUSINESS_UNIT_MASTER (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    BU_NAME varchar(500),
    BU_DESCRIPTION text,
    --
    primary key (ID)
);