alter table VAULT_INT_DETAILS rename column int_upl_id_id to int_upl_id_id__u25171 ;
alter table VAULT_INT_DETAILS drop constraint FK_VAULT_INT_DETAILS_ON_INT_UPL_ID ;
drop index IDX_VAULT_INT_DETAILS_ON_INT_UPL_ID ;
alter table VAULT_INT_DETAILS add column INT_UPL_ID bigint ;
