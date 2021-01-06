create table VAULT_MASTER_DATA_MANAGEMENT (
    MASTER_CODE varchar(10),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    MASTER_TYPE varchar(500),
    MASTER_DESCRIPTION text,
    --
    primary key (MASTER_CODE)
);