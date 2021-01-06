alter table VAULT_API_DETAILS rename column supported_operations_id to supported_operations_id__u87046 ;
alter table VAULT_API_DETAILS drop constraint FK_VAULT_API_DETAILS_ON_SUPPORTED_OPERATIONS ;
drop index IDX_VAULT_API_DETAILS_ON_SUPPORTED_OPERATIONS ;
alter table VAULT_API_DETAILS add column SUPPORTED_OPERATIONS varchar(255) ;
