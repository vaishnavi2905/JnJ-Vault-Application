alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PLATFORM_VERSION foreign key (INT_PLATFORM_VERSION_ID) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
