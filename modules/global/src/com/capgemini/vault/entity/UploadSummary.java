package com.capgemini.vault.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIdentityIdEntity;
import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.cuba.core.entity.Updatable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "VAULT_UPLOAD_SUMMARY")
@Entity(name = "vault_UploadSummary")
@NamePattern("%s|createdBy")
public class UploadSummary extends BaseIdentityIdEntity implements Creatable, Updatable {
    private static final long serialVersionUID = -1288378155858850471L;

    @Column(name = "UPL_FILENAME")
    private String uplFilename;

    @Column(name = "UPL_DATATYPE", length = 500)
    private String uplDatatype;

    @Column(name = "UPL_SUCCESS_RECORDS")
    private Integer uplSuccessRecords;

    @Column(name = "UPL_ERROR_RECORDS")
    private Integer uplErrorRecords;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATE_TS")
    private Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    public String getUplDatatype() {
        return uplDatatype;
    }

    public void setUplDatatype(String uplDatatype) {
        this.uplDatatype = uplDatatype;
    }

    public Integer getUplErrorRecords() {
        return uplErrorRecords;
    }

    public void setUplErrorRecords(Integer uplErrorRecords) {
        this.uplErrorRecords = uplErrorRecords;
    }

    public Integer getUplSuccessRecords() {
        return uplSuccessRecords;
    }

    public void setUplSuccessRecords(Integer uplSuccessRecords) {
        this.uplSuccessRecords = uplSuccessRecords;
    }

    public String getUplFilename() {
        return uplFilename;
    }

    public void setUplFilename(String uplFilename) {
        this.uplFilename = uplFilename;
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