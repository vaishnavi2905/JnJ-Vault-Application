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
);