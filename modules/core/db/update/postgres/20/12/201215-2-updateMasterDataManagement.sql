update VAULT_MASTER_DATA_MANAGEMENT set MASTER_TYPE = '' where MASTER_TYPE is null ;
alter table VAULT_MASTER_DATA_MANAGEMENT alter column MASTER_TYPE set not null ;
