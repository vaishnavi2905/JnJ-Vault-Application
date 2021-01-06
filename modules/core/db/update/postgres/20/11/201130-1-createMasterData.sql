create table VAULT_MASTER_DATA (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    MASTER_TYPE text,
    MASTER_CODE varchar(255),
    MASTER_DESCRIPTION text,
    --
    primary key (ID)
);