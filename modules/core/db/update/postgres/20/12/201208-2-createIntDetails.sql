alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_UPL_ID foreign key (INT_UPL_ID_ID) references VAULT_UPLOAD_SUMMARY(ID);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_CRUD_MASTERCODE foreign key (INT_CRUD_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PAYLOAD_SECUR_CLASS_MASTERCODE foreign key (INT_PAYLOAD_SECUR_CLASS_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_BRAND_OR_BU_MASTERCODE foreign key (INT_BRAND_OR_BU_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_REGION_MASTERCODE foreign key (INT_REGION_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_COUNTRY_MASTERCODE foreign key (INT_COUNTRY_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PLATFORM_MASTERCODE foreign key (INT_PLATFORM_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PLATFORM_VERSION_MASTERCODE foreign key (INT_PLATFORM_VERSION_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_SRC_PROTOCOL_MASTERCODE foreign key (INT_SRC_PROTOCOL_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_SRC_PAYLOAD_TYPE_MASTERCODE foreign key (INT_SRC_PAYLOAD_TYPE_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_DEST_APP_MASTERCODE foreign key (INT_DEST_APP_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_DEST_PROTOCOL_MASTERCODE foreign key (INT_DEST_PROTOCOL_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_DEST_PAYLOAD_TYPE_MASTERCODE foreign key (INT_DEST_PAYLOAD_TYPE_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_DESIGN_PATTERN_MASTERCODE foreign key (INT_DESIGN_PATTERN_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_COMPLEXITY_MASTERCODE foreign key (INT_COMPLEXITY_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PROJECT_MASTERCODE foreign key (INT_PROJECT_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PRIORITY_MASTERCODE foreign key (INT_PRIORITY_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_WORKSTREAM_MASTERCODE foreign key (INT_WORKSTREAM_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_PROCESSING_TYPE_MASTERCODE foreign key (INT_PROCESSING_TYPE_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_INITIATING_SYS_MASTERCODE foreign key (INT_INITIATING_SYS_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_SPL_OPS_MASTERCODE foreign key (INT_SPL_OPS_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
alter table VAULT_INT_DETAILS add constraint FK_VAULT_INT_DETAILS_ON_INT_STATUS_MASTERCODE foreign key (INT_STATUS_MASTERCODE) references VAULT_MASTER_DATA_MANAGEMENT(MASTER_CODE);
create unique index IDX_VAULT_INT_DETAILS_UK_INT_ASSET_ID on VAULT_INT_DETAILS (INT_ASSET_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_UPL_ID on VAULT_INT_DETAILS (INT_UPL_ID_ID);
create index IDX_VAULT_INT_DETAILS_ON_INT_CRUD_MASTERCODE on VAULT_INT_DETAILS (INT_CRUD_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_PAYLOAD_SECUR_CLASS_MASTERCODE on VAULT_INT_DETAILS (INT_PAYLOAD_SECUR_CLASS_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_BRAND_OR_BU_MASTERCODE on VAULT_INT_DETAILS (INT_BRAND_OR_BU_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_REGION_MASTERCODE on VAULT_INT_DETAILS (INT_REGION_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_COUNTRY_MASTERCODE on VAULT_INT_DETAILS (INT_COUNTRY_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_PLATFORM_MASTERCODE on VAULT_INT_DETAILS (INT_PLATFORM_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_PLATFORM_VERSION_MASTERCODE on VAULT_INT_DETAILS (INT_PLATFORM_VERSION_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_SRC_PROTOCOL_MASTERCODE on VAULT_INT_DETAILS (INT_SRC_PROTOCOL_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_SRC_PAYLOAD_TYPE_MASTERCODE on VAULT_INT_DETAILS (INT_SRC_PAYLOAD_TYPE_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_DEST_APP_MASTERCODE on VAULT_INT_DETAILS (INT_DEST_APP_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_DEST_PROTOCOL_MASTERCODE on VAULT_INT_DETAILS (INT_DEST_PROTOCOL_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_DEST_PAYLOAD_TYPE_MASTERCODE on VAULT_INT_DETAILS (INT_DEST_PAYLOAD_TYPE_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_DESIGN_PATTERN_MASTERCODE on VAULT_INT_DETAILS (INT_DESIGN_PATTERN_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_COMPLEXITY_MASTERCODE on VAULT_INT_DETAILS (INT_COMPLEXITY_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_PROJECT_MASTERCODE on VAULT_INT_DETAILS (INT_PROJECT_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_PRIORITY_MASTERCODE on VAULT_INT_DETAILS (INT_PRIORITY_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_WORKSTREAM_MASTERCODE on VAULT_INT_DETAILS (INT_WORKSTREAM_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_PROCESSING_TYPE_MASTERCODE on VAULT_INT_DETAILS (INT_PROCESSING_TYPE_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_INITIATING_SYS_MASTERCODE on VAULT_INT_DETAILS (INT_INITIATING_SYS_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_SPL_OPS_MASTERCODE on VAULT_INT_DETAILS (INT_SPL_OPS_MASTERCODE);
create index IDX_VAULT_INT_DETAILS_ON_INT_STATUS_MASTERCODE on VAULT_INT_DETAILS (INT_STATUS_MASTERCODE);
