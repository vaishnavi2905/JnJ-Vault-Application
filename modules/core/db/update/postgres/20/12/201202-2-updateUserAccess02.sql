alter table VAULT_USER_ACCESS rename column bu_id to bu_id__u79014 ;
alter table VAULT_USER_ACCESS drop constraint FK_VAULT_USER_ACCESS_ON_BU ;
drop index IDX_VAULT_USER_ACCESS_ON_BU ;
