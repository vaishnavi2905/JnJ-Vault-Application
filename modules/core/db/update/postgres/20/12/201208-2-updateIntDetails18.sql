alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_SPL_OPS foreign key (INT_SPL_OPS_ID) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);