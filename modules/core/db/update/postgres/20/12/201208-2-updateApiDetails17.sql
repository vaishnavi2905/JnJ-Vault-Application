alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_DEST_APP foreign key (API_DEST_APP_ID) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
