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

@Table(name = "VAULT_INT_DETAILS")
@Entity(name = "vault_IntDetails")
@NamePattern("%s|intName")
public class IntDetails extends BaseIdentityIdEntity implements Creatable, Updatable {
    private static final long serialVersionUID = -1352469103991516846L;

    @NotNull
    @Column(name = "INT_ASSET_ID", nullable = false, unique = true)
    private String intAssetId;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_UPL_ID")
    private UploadSummary intUpl;

    @NotNull
    @Column(name = "INT_NAME", nullable = false, length = 500)
    private String intName;

    @Lob
    @Column(name = "INT_DESCRIPTION")
    private String intDescription;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_CRUD_MASTERCODE")
    private MasterDataManagement intCrud;

    @Lob
    @Column(name = "INT_PAYLOAD")
    private String intPayload;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_PAYLOAD_SECUR_CLASS_MASTERCODE")
    private MasterDataManagement intPayloadSecurClass;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_BRAND_OR_BU_MASTERCODE")
    private MasterDataManagement intBrandOrBu;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_REGION_MASTERCODE")
    private MasterDataManagement intRegion;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_COUNTRY_MASTERCODE")
    private MasterDataManagement intCountry;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_PLATFORM_MASTERCODE")
    private MasterDataManagement intPlatform;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_PLATFORM_VERSION_MASTERCODE")
    private MasterDataManagement intPlatformVersion;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_SRC_PROTOCOL_MASTERCODE")
    private MasterDataManagement intSrcProtocol;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_SRC_PAYLOAD_TYPE_MASTERCODE")
    private MasterDataManagement intSrcPayloadType;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_DEST_APP_MASTERCODE")
    private MasterDataManagement intDestApp;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_DEST_PROTOCOL_MASTERCODE")
    private MasterDataManagement intDestProtocol;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_DEST_PAYLOAD_TYPE_MASTERCODE")
    private MasterDataManagement intDestPayloadType;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_DESIGN_PATTERN_MASTERCODE")
    private MasterDataManagement intDesignPattern;

    @Column(name = "INT_IMPL_PATTERN", length = 500)
    private String intImplPattern;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_COMPLEXITY_MASTERCODE")
    private MasterDataManagement intComplexity;

    @Column(name = "INT_THROUGHPUT_IN_SECONDS")
    private String intThroughputInSeconds;

    @Column(name = "INT_MSG_SIZE_IN_KB", length = 1000)
    private String intMsgSizeInKb;

    @Column(name = "INT_OWNER")
    private String intOwner;

    @Column(name = "INT_BA")
    private String intBa;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_PROJECT_MASTERCODE")
    private MasterDataManagement intProject;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_PRIORITY_MASTERCODE")
    private MasterDataManagement intPriority;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_WORKSTREAM_MASTERCODE")
    private MasterDataManagement intWorkstream;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_PROCESSING_TYPE_MASTERCODE")
    private MasterDataManagement intProcessingType;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_INITIATING_SYS_MASTERCODE")
    private MasterDataManagement intInitiatingSys;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_SPL_OPS_MASTERCODE")
    private MasterDataManagement intSplOps;

    @Column(name = "INT_DEPENDENCY")
    private String intDependency;

    @Column(name = "INT_BUSINESS_OWNER")
    private String intBusinessOwner;

    @Lob
    @Column(name = "INT_REMARKS")
    private String intRemarks;

    @Column(name = "INT_F_SPEC_LOC", length = 500)
    private String intFSpecLoc;

    @Column(name = "TECHNICAL_SPEC_LOCATION", length = 500)
    private String technicalSpecLocation;

    @Column(name = "SOURCE_CODE_REPOSITORY", length = 500)
    private String sourceCodeRepository;

    @Column(name = "REPO_LOCATION", length = 500)
    private String repoLocation;

    @Column(name = "LINK", length = 500)
    private String link;

    @Column(name = "INT_LOB", length = 500)
    private String intLob;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INT_STATUS_MASTERCODE")
    private MasterDataManagement intStatus;

    @Column(name = "INT_INTERNAL_STATUS")
    private String intInternalStatus;

    @Composition
    @OneToMany(mappedBy = "intDetails")
    private List<IntApiDetails> intApiDetails;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATE_TS")
    private Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    public UploadSummary getIntUpl() {
        return intUpl;
    }

    public void setIntUpl(UploadSummary intUpl) {
        this.intUpl = intUpl;
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

    public List<IntApiDetails> getIntApiDetails() {
        return intApiDetails;
    }

    public void setIntApiDetails(List<IntApiDetails> intApiDetails) {
        this.intApiDetails = intApiDetails;
    }

    public void setIntThroughputInSeconds(String intThroughputInSeconds) {
        this.intThroughputInSeconds = intThroughputInSeconds;
    }

    public String getIntThroughputInSeconds() {
        return intThroughputInSeconds;
    }

    public void setIntDependency(String intDependency) {
        this.intDependency = intDependency;
    }

    public String getIntDependency() {
        return intDependency;
    }

    public Status getIntInternalStatus() {
        return intInternalStatus == null ? null : Status.fromId(intInternalStatus);
    }

    public void setIntInternalStatus(Status intInternalStatus) {
        this.intInternalStatus = intInternalStatus == null ? null : intInternalStatus.getId();
    }

    public MasterDataManagement getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(MasterDataManagement intStatus) {
        this.intStatus = intStatus;
    }

    public String getIntLob() {
        return intLob;
    }

    public void setIntLob(String intLob) {
        this.intLob = intLob;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRepoLocation() {
        return repoLocation;
    }

    public void setRepoLocation(String repoLocation) {
        this.repoLocation = repoLocation;
    }

    public String getSourceCodeRepository() {
        return sourceCodeRepository;
    }

    public void setSourceCodeRepository(String sourceCodeRepository) {
        this.sourceCodeRepository = sourceCodeRepository;
    }

    public String getTechnicalSpecLocation() {
        return technicalSpecLocation;
    }

    public void setTechnicalSpecLocation(String technicalSpecLocation) {
        this.technicalSpecLocation = technicalSpecLocation;
    }

    public String getIntFSpecLoc() {
        return intFSpecLoc;
    }

    public void setIntFSpecLoc(String intFSpecLoc) {
        this.intFSpecLoc = intFSpecLoc;
    }

    public String getIntRemarks() {
        return intRemarks;
    }

    public void setIntRemarks(String intRemarks) {
        this.intRemarks = intRemarks;
    }

    public String getIntBusinessOwner() {
        return intBusinessOwner;
    }

    public void setIntBusinessOwner(String intBusinessOwner) {
        this.intBusinessOwner = intBusinessOwner;
    }

    public MasterDataManagement getIntSplOps() {
        return intSplOps;
    }

    public void setIntSplOps(MasterDataManagement intSplOps) {
        this.intSplOps = intSplOps;
    }

    public MasterDataManagement getIntInitiatingSys() {
        return intInitiatingSys;
    }

    public void setIntInitiatingSys(MasterDataManagement intInitiatingSys) {
        this.intInitiatingSys = intInitiatingSys;
    }

    public MasterDataManagement getIntProcessingType() {
        return intProcessingType;
    }

    public void setIntProcessingType(MasterDataManagement intProcessingType) {
        this.intProcessingType = intProcessingType;
    }

    public MasterDataManagement getIntWorkstream() {
        return intWorkstream;
    }

    public void setIntWorkstream(MasterDataManagement intWorkstream) {
        this.intWorkstream = intWorkstream;
    }

    public MasterDataManagement getIntPriority() {
        return intPriority;
    }

    public void setIntPriority(MasterDataManagement intPriority) {
        this.intPriority = intPriority;
    }

    public MasterDataManagement getIntProject() {
        return intProject;
    }

    public void setIntProject(MasterDataManagement intProject) {
        this.intProject = intProject;
    }

    public String getIntBa() {
        return intBa;
    }

    public void setIntBa(String intBa) {
        this.intBa = intBa;
    }

    public String getIntOwner() {
        return intOwner;
    }

    public void setIntOwner(String intOwner) {
        this.intOwner = intOwner;
    }

    public String getIntMsgSizeInKb() {
        return intMsgSizeInKb;
    }

    public void setIntMsgSizeInKb(String intMsgSizeInKb) {
        this.intMsgSizeInKb = intMsgSizeInKb;
    }

    public MasterDataManagement getIntComplexity() {
        return intComplexity;
    }

    public void setIntComplexity(MasterDataManagement intComplexity) {
        this.intComplexity = intComplexity;
    }

    public String getIntImplPattern() {
        return intImplPattern;
    }

    public void setIntImplPattern(String intImplPattern) {
        this.intImplPattern = intImplPattern;
    }

    public MasterDataManagement getIntDesignPattern() {
        return intDesignPattern;
    }

    public void setIntDesignPattern(MasterDataManagement intDesignPattern) {
        this.intDesignPattern = intDesignPattern;
    }

    public MasterDataManagement getIntDestPayloadType() {
        return intDestPayloadType;
    }

    public void setIntDestPayloadType(MasterDataManagement intDestPayloadType) {
        this.intDestPayloadType = intDestPayloadType;
    }

    public MasterDataManagement getIntDestProtocol() {
        return intDestProtocol;
    }

    public void setIntDestProtocol(MasterDataManagement intDestProtocol) {
        this.intDestProtocol = intDestProtocol;
    }

    public MasterDataManagement getIntDestApp() {
        return intDestApp;
    }

    public void setIntDestApp(MasterDataManagement intDestApp) {
        this.intDestApp = intDestApp;
    }

    public MasterDataManagement getIntSrcPayloadType() {
        return intSrcPayloadType;
    }

    public void setIntSrcPayloadType(MasterDataManagement intSrcPayloadType) {
        this.intSrcPayloadType = intSrcPayloadType;
    }

    public MasterDataManagement getIntSrcProtocol() {
        return intSrcProtocol;
    }

    public void setIntSrcProtocol(MasterDataManagement intSrcProtocol) {
        this.intSrcProtocol = intSrcProtocol;
    }

    public MasterDataManagement getIntPlatformVersion() {
        return intPlatformVersion;
    }

    public void setIntPlatformVersion(MasterDataManagement intPlatformVersion) {
        this.intPlatformVersion = intPlatformVersion;
    }

    public MasterDataManagement getIntPlatform() {
        return intPlatform;
    }

    public void setIntPlatform(MasterDataManagement intPlatform) {
        this.intPlatform = intPlatform;
    }

    public MasterDataManagement getIntCountry() {
        return intCountry;
    }

    public void setIntCountry(MasterDataManagement intCountry) {
        this.intCountry = intCountry;
    }

    public MasterDataManagement getIntRegion() {
        return intRegion;
    }

    public void setIntRegion(MasterDataManagement intRegion) {
        this.intRegion = intRegion;
    }

    public MasterDataManagement getIntBrandOrBu() {
        return intBrandOrBu;
    }

    public void setIntBrandOrBu(MasterDataManagement intBrandOrBu) {
        this.intBrandOrBu = intBrandOrBu;
    }

    public MasterDataManagement getIntPayloadSecurClass() {
        return intPayloadSecurClass;
    }

    public void setIntPayloadSecurClass(MasterDataManagement intPayloadSecurClass) {
        this.intPayloadSecurClass = intPayloadSecurClass;
    }

    public String getIntPayload() {
        return intPayload;
    }

    public void setIntPayload(String intPayload) {
        this.intPayload = intPayload;
    }

    public MasterDataManagement getIntCrud() {
        return intCrud;
    }

    public void setIntCrud(MasterDataManagement intCrud) {
        this.intCrud = intCrud;
    }

    public String getIntDescription() {
        return intDescription;
    }

    public void setIntDescription(String intDescription) {
        this.intDescription = intDescription;
    }

    public String getIntName() {
        return intName;
    }

    public void setIntName(String intName) {
        this.intName = intName;
    }

    public String getIntAssetId() {
        return intAssetId;
    }

    public void setIntAssetId(String intAssetId) {
        this.intAssetId = intAssetId;
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