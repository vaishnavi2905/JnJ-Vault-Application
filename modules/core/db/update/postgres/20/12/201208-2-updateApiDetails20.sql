alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_DESIGN_PATTERN foreign key (API_DESIGN_PATTERN_ID) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);