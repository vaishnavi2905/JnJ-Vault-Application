alter table VAULT_API_DETAILS rename column api_upl_mastercode to api_upl_mastercode__u96143 ;
alter table VAULT_API_DETAILS drop constraint FK_VAULT_API_DETAILS_ON_API_UPL_MASTERCODE ;
drop index IDX_VAULT_API_DETAILS_ON_API_UPL_MASTERCODE ;
alter table VAULT_API_DETAILS add column API_UPL_ID bigint ;
