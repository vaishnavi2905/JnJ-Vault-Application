alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_UPL foreign key (API_UPL_ID) references VAULT_UPLOAD_SUMMARY(ID);
create index IDX_VAULT_API_DETAILS_ON_API_UPL on VAULT_API_DETAILS (API_UPL_ID);