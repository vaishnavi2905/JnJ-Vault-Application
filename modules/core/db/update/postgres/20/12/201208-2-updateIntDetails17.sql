alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_INITIATING_SYS foreign key (INT_INITIATING_SYS_ID) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
