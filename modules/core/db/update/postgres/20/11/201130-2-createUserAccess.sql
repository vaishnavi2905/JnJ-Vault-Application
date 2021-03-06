alter table VAULT_USER_ACCESS add constraint FK_VAULT_USER_ACCESS_ON_BU foreign key (BU_ID) references VAULT_BUSINESS_UNIT_MASTER(ID) on delete CASCADE;
alter table VAULT_USER_ACCESS add constraint FK_VAULT_USER_ACCESS_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_VAULT_USER_ACCESS_ON_BU on VAULT_USER_ACCESS (BU_ID);
create index IDX_VAULT_USER_ACCESS_ON_USER on VAULT_USER_ACCESS (USER_ID);
