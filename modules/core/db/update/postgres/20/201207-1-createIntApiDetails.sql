create table VAULT_INT_API_DETAILS (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    INT_DETAILS_ID bigint,
    API_DETAILS_ID bigint,
    --
    primary key (ID)
);