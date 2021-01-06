-- alter table VAULT_API_DETAILS add column API_ID varchar(255) ^
-- update VAULT_API_DETAILS set API_ID = <default_value> ;
-- alter table VAULT_API_DETAILS alter column API_ID set not null ;
alter table VAULT_API_DETAILS add column API_ID varchar(255) ;
