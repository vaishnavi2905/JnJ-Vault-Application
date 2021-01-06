package com.capgemini.vault.entity;

import com.haulmont.cuba.core.entity.BaseIdentityIdEntity;
import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;

@Table(name = "VAULT_ERROR_SUMMARY")
@Entity(name = "vault_ErrorSummary")
public class ErrorSummary extends BaseIdentityIdEntity implements Creatable, Updatable {
    private static final long serialVersionUID = 861435360940937464L;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ERR_UPL_ID")
    private UploadSummary errUpl;

    @Column(name = "ERR_ROW_NO")
    private Integer errRowNo;

    @Column(name = "ERR_COL_NO")
    private Integer errColNo;

    @Column(name = "ERR_DATATYPE", length = 500)
    private String errDatatype;

    @Lob
    @Column(name = "ERR_DESCRIPTION")
    private String errDescription;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATE_TS")
    private Date updateTs;

    public ErrorSummary(Integer errRowNo, Integer errColNo, String errDatatype, String errDescription) {
        this.errRowNo = errRowNo;
        this.errColNo = errColNo;
        this.errDatatype = errDatatype;
        this.errDescription = errDescription;
    }
    public ErrorSummary() {

    }

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    public String getErrDescription() {
        return errDescription;
    }

    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }

    public String getErrDatatype() {
        return errDatatype;
    }

    public void setErrDatatype(String errDatatype) {
        this.errDatatype = errDatatype;
    }

    public Integer getErrColNo() {
        return errColNo;
    }

    public void setErrColNo(Integer errColNo) {
        this.errColNo = errColNo;
    }

    public Integer getErrRowNo() {
        return errRowNo;
    }

    public void setErrRowNo(Integer errRowNo) {
        this.errRowNo = errRowNo;
    }

    public UploadSummary getErrUpl() {
        return errUpl;
    }

    public void setErrUpl(UploadSummary errUpl) {
        this.errUpl = errUpl;
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