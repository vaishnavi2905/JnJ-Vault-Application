package com.capgemini.vault.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIdentityIdEntity;
import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Table(name = "VAULT_API_DETAILS")
@Entity(name = "vault_ApiDetails")
@NamePattern("%s|apiName")
public class ApiDetails extends BaseIdentityIdEntity implements Creatable, Updatable {
    private static final long serialVersionUID = -2015144270303369744L;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_UPL_ID")
    private UploadSummary apiUpl;

    @Column(name = "INT_ASSET_ID")
    private String intAssetId;

    @NotNull
    @Column(name = "API_ID", nullable = false, unique = true)
    private String apiId;

    @NotNull
    @Column(name = "API_NAME", nullable = false, length = 500)
    private String apiName;

    @Lob
    @Column(name = "API_DESCRIPTION")
    private String apiDescription;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_CLASSIFICATION_MASTERCODE")
    private MasterDataManagement apiClassification;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_SUPPORTED_OPS_MASTERCODE")
    private MasterDataManagement apiSupportedOps;

    @Column(name = "API_ENTITY_NAME")
    private String apiEntityName;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_PAYLOAD_SECUR_CLASS_MASTERCODE")
    private MasterDataManagement apiPayloadSecurClass;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_BRAND_OR_BU_MASTERCODE")
    private MasterDataManagement apiBrandOrBu;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_REGION_MASTERCODE")
    private MasterDataManagement apiRegion;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_COUNTRY_MASTERCODE")
    private MasterDataManagement apiCountry;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_PROJECT_MASTERCODE")
    private MasterDataManagement apiProject;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_PRIORITY_MASTERCODE")
    private MasterDataManagement apiPriority;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_STATUS_MASTERCODE")
    private MasterDataManagement apiStatus;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_PROCESSING_TYPE_MASTERCODE")
    private MasterDataManagement apiProcessingType;

    @Column(name = "API_BUSINESS_OWNER")
    private String apiBusinessOwner;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_WORKSTREAM_MASTERCODE")
    private MasterDataManagement apiWorkstream;

    @Column(name = "API_RELEASE")
    private String apiRelease;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_PLATFORM_MASTERCODE")
    private MasterDataManagement apiPlatform;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_PLATFORM_VERSION_MASTERCODE")
    private MasterDataManagement apiPlatformVersion;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_SRC_PROTOCOL_MASTERCODE")
    private MasterDataManagement apiSrcProtocol;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_SRC_PAYLOAD_TYPE_MASTERCODE")
    private MasterDataManagement apiSrcPayloadType;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_DEST_APP_MASTERCODE")
    private MasterDataManagement apiDestApp;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_DEST_PROTOCOL_MASTERCODE")
    private MasterDataManagement apiDestProtocol;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_DEST_PAYLOAD_TYPE_MASTERCODE")
    private MasterDataManagement apiDestPayloadType;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_DESIGN_PATTERN_MASTERCODE")
    private MasterDataManagement apiDesignPattern;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "API_COMPLEXITY_MASTERCODE")
    private MasterDataManagement apiComplexity;

    @Column(name = "API_THROUPUT_IN_SEC")
    private String apiThrouputInSec;

    @Column(name = "API_INT_MESSAGE_SIZE_IN_KB")
    private String apiIntMessageSizeInKb;

    @Column(name = "API_DEPENDENCY")
    private String apiDependency;

    @Column(name = "API_INT_OWNER")
    private String apiIntOwner;

    @Lob
    @Column(name = "API_REMARKS")
    private String apiRemarks;

    @Column(name = "API_LOB", length = 500)
    private String apiLob;

    @Column(name = "API_INTERNAL_STATUS")
    private String apiInternalStatus;

    @Composition
    @OneToMany(mappedBy = "apiDetails")
    private List<IntApiDetails> intApiDetails;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATE_TS")
    private Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    public UploadSummary getApiUpl() {
        return apiUpl;
    }

    public void setApiUpl(UploadSummary apiUpl) {
        this.apiUpl = apiUpl;
    }

    public List<IntApiDetails> getIntApiDetails() {
        return intApiDetails;
    }

    public void setIntApiDetails(List<IntApiDetails> intApiDetails) {
        this.intApiDetails = intApiDetails;
    }

    public Status getApiInternalStatus() {
        return apiInternalStatus == null ? null : Status.fromId(apiInternalStatus);
    }

    public void setApiInternalStatus(Status apiInternalStatus) {
        this.apiInternalStatus = apiInternalStatus == null ? null : apiInternalStatus.getId();
    }

    public String getApiLob() {
        return apiLob;
    }

    public void setApiLob(String apiLob) {
        this.apiLob = apiLob;
    }

    public String getApiRemarks() {
        return apiRemarks;
    }

    public void setApiRemarks(String apiRemarks) {
        this.apiRemarks = apiRemarks;
    }

    public String getApiIntOwner() {
        return apiIntOwner;
    }

    public void setApiIntOwner(String apiIntOwner) {
        this.apiIntOwner = apiIntOwner;
    }

    public String getApiDependency() {
        return apiDependency;
    }

    public void setApiDependency(String apiDependency) {
        this.apiDependency = apiDependency;
    }

    public String getApiIntMessageSizeInKb() {
        return apiIntMessageSizeInKb;
    }

    public void setApiIntMessageSizeInKb(String apiIntMessageSizeInKb) {
        this.apiIntMessageSizeInKb = apiIntMessageSizeInKb;
    }

    public String getApiThrouputInSec() {
        return apiThrouputInSec;
    }

    public void setApiThrouputInSec(String apiThrouputInSec) {
        this.apiThrouputInSec = apiThrouputInSec;
    }

    public MasterDataManagement getApiComplexity() {
        return apiComplexity;
    }

    public void setApiComplexity(MasterDataManagement apiComplexity) {
        this.apiComplexity = apiComplexity;
    }

    public MasterDataManagement getApiDesignPattern() {
        return apiDesignPattern;
    }

    public void setApiDesignPattern(MasterDataManagement apiDesignPattern) {
        this.apiDesignPattern = apiDesignPattern;
    }

    public MasterDataManagement getApiDestPayloadType() {
        return apiDestPayloadType;
    }

    public void setApiDestPayloadType(MasterDataManagement apiDestPayloadType) {
        this.apiDestPayloadType = apiDestPayloadType;
    }

    public MasterDataManagement getApiDestProtocol() {
        return apiDestProtocol;
    }

    public void setApiDestProtocol(MasterDataManagement apiDestProtocol) {
        this.apiDestProtocol = apiDestProtocol;
    }

    public MasterDataManagement getApiDestApp() {
        return apiDestApp;
    }

    public void setApiDestApp(MasterDataManagement apiDestApp) {
        this.apiDestApp = apiDestApp;
    }

    public MasterDataManagement getApiSrcPayloadType() {
        return apiSrcPayloadType;
    }

    public void setApiSrcPayloadType(MasterDataManagement apiSrcPayloadType) {
        this.apiSrcPayloadType = apiSrcPayloadType;
    }

    public MasterDataManagement getApiSrcProtocol() {
        return apiSrcProtocol;
    }

    public void setApiSrcProtocol(MasterDataManagement apiSrcProtocol) {
        this.apiSrcProtocol = apiSrcProtocol;
    }

    public MasterDataManagement getApiPlatformVersion() {
        return apiPlatformVersion;
    }

    public void setApiPlatformVersion(MasterDataManagement apiPlatformVersion) {
        this.apiPlatformVersion = apiPlatformVersion;
    }

    public MasterDataManagement getApiPlatform() {
        return apiPlatform;
    }

    public void setApiPlatform(MasterDataManagement apiPlatform) {
        this.apiPlatform = apiPlatform;
    }

    public String getApiRelease() {
        return apiRelease;
    }

    public void setApiRelease(String apiRelease) {
        this.apiRelease = apiRelease;
    }

    public MasterDataManagement getApiWorkstream() {
        return apiWorkstream;
    }

    public void setApiWorkstream(MasterDataManagement apiWorkstream) {
        this.apiWorkstream = apiWorkstream;
    }

    public String getApiBusinessOwner() {
        return apiBusinessOwner;
    }

    public void setApiBusinessOwner(String apiBusinessOwner) {
        this.apiBusinessOwner = apiBusinessOwner;
    }

    public MasterDataManagement getApiProcessingType() {
        return apiProcessingType;
    }

    public void setApiProcessingType(MasterDataManagement apiProcessingType) {
        this.apiProcessingType = apiProcessingType;
    }

    public MasterDataManagement getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(MasterDataManagement apiStatus) {
        this.apiStatus = apiStatus;
    }

    public MasterDataManagement getApiPriority() {
        return apiPriority;
    }

    public void setApiPriority(MasterDataManagement apiPriority) {
        this.apiPriority = apiPriority;
    }

    public MasterDataManagement getApiProject() {
        return apiProject;
    }

    public void setApiProject(MasterDataManagement apiProject) {
        this.apiProject = apiProject;
    }

    public MasterDataManagement getApiCountry() {
        return apiCountry;
    }

    public void setApiCountry(MasterDataManagement apiCountry) {
        this.apiCountry = apiCountry;
    }

    public MasterDataManagement getApiRegion() {
        return apiRegion;
    }

    public void setApiRegion(MasterDataManagement apiRegion) {
        this.apiRegion = apiRegion;
    }

    public MasterDataManagement getApiBrandOrBu() {
        return apiBrandOrBu;
    }

    public void setApiBrandOrBu(MasterDataManagement apiBrandOrBu) {
        this.apiBrandOrBu = apiBrandOrBu;
    }

    public MasterDataManagement getApiPayloadSecurClass() {
        return apiPayloadSecurClass;
    }

    public void setApiPayloadSecurClass(MasterDataManagement apiPayloadSecurClass) {
        this.apiPayloadSecurClass = apiPayloadSecurClass;
    }

    public String getApiEntityName() {
        return apiEntityName;
    }

    public void setApiEntityName(String apiEntityName) {
        this.apiEntityName = apiEntityName;
    }

    public MasterDataManagement getApiSupportedOps() {
        return apiSupportedOps;
    }

    public void setApiSupportedOps(MasterDataManagement apiSupportedOps) {
        this.apiSupportedOps = apiSupportedOps;
    }

    public MasterDataManagement getApiClassification() {
        return apiClassification;
    }

    public void setApiClassification(MasterDataManagement apiClassification) {
        this.apiClassification = apiClassification;
    }

    public String getApiDescription() {
        return apiDescription;
    }

    public void setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getIntAssetId() {
        return intAssetId;
    }

    public void setIntAssetId(String intAssetId) {
        this.intAssetId = intAssetId;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }
}