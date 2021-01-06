create table VAULT_USER_ACCESS (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    BU_ID bigint,
    USER_ID uuid,
    --
    primary key (ID)
);