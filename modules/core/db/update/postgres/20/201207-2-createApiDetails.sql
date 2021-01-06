alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_UPL foreign key (API_UPL_ID) references VAULT_UPLOAD_SUMMARY(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_CLASSIFICATION foreign key (API_CLASSIFICATION_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_SUPPORTED_OPS foreign key (API_SUPPORTED_OPS_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_PAYLOAD_SECUR_CLASS foreign key (API_PAYLOAD_SECUR_CLASS_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_BRAND_OR_BU foreign key (API_BRAND_OR_BU_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_REGION foreign key (API_REGION_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_COUNTRY foreign key (API_COUNTRY_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_PROJECT foreign key (API_PROJECT_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_STATUS foreign key (API_STATUS_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_WORKSTREAM foreign key (API_WORKSTREAM_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_PLATFORM foreign key (API_PLATFORM_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_PLATFORM_VERSION foreign key (API_PLATFORM_VERSION_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_SRC_PROTOCOL foreign key (API_SRC_PROTOCOL_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_SRC_PAYLOAD_TYPE foreign key (API_SRC_PAYLOAD_TYPE_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_DEST_APP foreign key (API_DEST_APP_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_DEST_PROOCOL foreign key (API_DEST_PROOCOL_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_DEST_PAYLOAD_TYPE foreign key (API_DEST_PAYLOAD_TYPE_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_DESIGN_PATTERN foreign key (API_DESIGN_PATTERN_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_COMPLEXITY foreign key (API_COMPLEXITY_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_LOB foreign key (API_LOB_ID) references VAULT_MASTER_DATA(ID);
alter table VAULT_API_DETAILS add constraint FK_VAULT_API_DETAILS_ON_API_PRIORITY foreign key (API_PRIORITY_ID) references VAULT_MASTER_DATA(ID);
create index IDX_VAULT_API_DETAILS_ON_API_UPL on VAULT_API_DETAILS (API_UPL_ID);
create index IDX_VAULT_API_DETAILS_ON_API_CLASSIFICATION on VAULT_API_DETAILS (API_CLASSIFICATION_ID);
create index IDX_VAULT_API_DETAILS_ON_API_SUPPORTED_OPS on VAULT_API_DETAILS (API_SUPPORTED_OPS_ID);
create index IDX_VAULT_API_DETAILS_ON_API_PAYLOAD_SECUR_CLASS on VAULT_API_DETAILS (API_PAYLOAD_SECUR_CLASS_ID);
create index IDX_VAULT_API_DETAILS_ON_API_BRAND_OR_BU on VAULT_API_DETAILS (API_BRAND_OR_BU_ID);
create index IDX_VAULT_API_DETAILS_ON_API_REGION on VAULT_API_DETAILS (API_REGION_ID);
create index IDX_VAULT_API_DETAILS_ON_API_COUNTRY on VAULT_API_DETAILS (API_COUNTRY_ID);
create index IDX_VAULT_API_DETAILS_ON_API_PROJECT on VAULT_API_DETAILS (API_PROJECT_ID);
create index IDX_VAULT_API_DETAILS_ON_API_STATUS on VAULT_API_DETAILS (API_STATUS_ID);
create index IDX_VAULT_API_DETAILS_ON_API_WORKSTREAM on VAULT_API_DETAILS (API_WORKSTREAM_ID);
create index IDX_VAULT_API_DETAILS_ON_API_PLATFORM on VAULT_API_DETAILS (API_PLATFORM_ID);
create index IDX_VAULT_API_DETAILS_ON_API_PLATFORM_VERSION on VAULT_API_DETAILS (API_PLATFORM_VERSION_ID);
create index IDX_VAULT_API_DETAILS_ON_API_SRC_PROTOCOL on VAULT_API_DETAILS (API_SRC_PROTOCOL_ID);
create index IDX_VAULT_API_DETAILS_ON_API_SRC_PAYLOAD_TYPE on VAULT_API_DETAILS (API_SRC_PAYLOAD_TYPE_ID);
create index IDX_VAULT_API_DETAILS_ON_API_DEST_APP on VAULT_API_DETAILS (API_DEST_APP_ID);
create index IDX_VAULT_API_DETAILS_ON_API_DEST_PROOCOL on VAULT_API_DETAILS (API_DEST_PROOCOL_ID);
create index IDX_VAULT_API_DETAILS_ON_API_DEST_PAYLOAD_TYPE on VAULT_API_DETAILS (API_DEST_PAYLOAD_TYPE_ID);
create index IDX_VAULT_API_DETAILS_ON_API_DESIGN_PATTERN on VAULT_API_DETAILS (API_DESIGN_PATTERN_ID);
create index IDX_VAULT_API_DETAILS_ON_API_COMPLEXITY on VAULT_API_DETAILS (API_COMPLEXITY_ID);
create index IDX_VAULT_API_DETAILS_ON_API_LOB on VAULT_API_DETAILS (API_LOB_ID);
create index IDX_VAULT_API_DETAILS_ON_API_PRIORITY on VAULT_API_DETAILS (API_PRIORITY_ID);
