create table VAULT_ERROR_TABLE (
    ID bigserial,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    ERR_UPL_ID bigint,
    ERR_COL_NO integer,
    ERR_DATATYPE varchar(255),
    ERR_ROW_NO integer,
    ERR_DESC text,
    --
    primary key (ID)
);