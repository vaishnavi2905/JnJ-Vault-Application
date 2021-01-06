alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_UPL foreign key (INT_UPL_ID) references VAULT_UPLOAD_SUMMARY(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_CRUD foreign key (INT_CRUD_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PAYLOAD_SECUR_CLASS foreign key (INT_PAYLOAD_SECUR_CLASS_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_BRAND_OR_BU foreign key (INT_BRAND_OR_BU_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_REGION foreign key (INT_REGION_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_COUNTRY foreign key (INT_COUNTRY_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PLATFORM foreign key (INT_PLATFORM_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PLATFORM_VERSION foreign key (INT_PLATFORM_VERSION_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_SRC_PROTOCOL foreign key (INT_SRC_PROTOCOL_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_SRC_PAYLOAD_TYPE foreign key (INT_SRC_PAYLOAD_TYPE_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_DEST_APP foreign key (INT_DEST_APP_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_DEST_PROTOCOL foreign key (INT_DEST_PROTOCOL_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_DEST_PAYLOAD_TYPE foreign key (INT_DEST_PAYLOAD_TYPE_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_DESIGN_PATTERN foreign key (INT_DESIGN_PATTERN_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_COMPLEXITY foreign key (INT_COMPLEXITY_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PRIORITY foreign key (INT_PRIORITY_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_WORKSTREAM foreign key (INT_WORKSTREAM_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_INITIATING_SYS foreign key (INT_INITIATING_SYS_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_SPL_OPS foreign key (INT_SPL_OPS_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_LOB foreign key (INT_LOB_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_STATUS foreign key (INT_STATUS_ID) references VAULT_MASTER_DATA(ID);
create unique index IDX_VAULT_INT_DETAILS_UK_INT_NAME on VAULT_INT_DETAILS (INT_NAME);
create unique index IDX_VAULT_INT_DETAILS_UK_INT_ASSET_ID on VAULT_INT_DETAILS (INT_ASSET_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_UPL on VAULT_INT_DETAILS (INT_UPL_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_CRUD on VAULT_INT_DETAILS (INT_CRUD_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_PAYLOAD_SECUR_CLASS on VAULT_INT_DETAILS (INT_PAYLOAD_SECUR_CLASS_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_BRAND_OR_BU on VAULT_INT_DETAILS (INT_BRAND_OR_BU_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_REGION on VAULT_INT_DETAILS (INT_REGION_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_COUNTRY on VAULT_INT_DETAILS (INT_COUNTRY_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_PLATFORM on VAULT_INT_DETAILS (INT_PLATFORM_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_PLATFORM_VERSION on VAULT_INT_DETAILS (INT_PLATFORM_VERSION_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_SRC_PROTOCOL on VAULT_INT_DETAILS (INT_SRC_PROTOCOL_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_SRC_PAYLOAD_TYPE on VAULT_INT_DETAILS (INT_SRC_PAYLOAD_TYPE_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_DEST_APP on VAULT_INT_DETAILS (INT_DEST_APP_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_DEST_PROTOCOL on VAULT_INT_DETAILS (INT_DEST_PROTOCOL_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_DEST_PAYLOAD_TYPE on VAULT_INT_DETAILS (INT_DEST_PAYLOAD_TYPE_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_DESIGN_PATTERN on VAULT_INT_DETAILS (INT_DESIGN_PATTERN_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_COMPLEXITY on VAULT_INT_DETAILS (INT_COMPLEXITY_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_PRIORITY on VAULT_INT_DETAILS (INT_PRIORITY_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_WORKSTREAM on VAULT_INT_DETAILS (INT_WORKSTREAM_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_INITIATING_SYS on VAULT_INT_DETAILS (INT_INITIATING_SYS_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_SPL_OPS on VAULT_INT_DETAILS (INT_SPL_OPS_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_LOB on VAULT_INT_DETAILS (INT_LOB_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_STATUS on VAULT_INT_DETAILS (INT_STATUS_ID);