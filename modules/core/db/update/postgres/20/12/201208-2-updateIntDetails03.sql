alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_BRAND_OR_BU foreign key (INT_BRAND_OR_BU_ID) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
