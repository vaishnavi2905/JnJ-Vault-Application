create table VAULT_UPLOAD_SUMMARY (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    UPL_FILENAME varchar(255),
    UPL_SUCCESS_RECORDS integer,
    UPL_ERROR_RECORDS integer,
    --
    primary key (ID)
);