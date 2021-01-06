package com.capgemini.vault.entity;

import com.haulmont.cuba.core.entity.BaseIdentityIdEntity;
import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;

@Table(name = "VAULT_INT_API_DETAILS")
@Entity(name = "vault_IntApiDetails")
public class IntApiDetails extends BaseIdentityIdEntity implements Creatable, Updatable {
    private static final long serialVersionUID = -5195438986207745028L;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATE_TS")
    private Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INT_DETAILS_ID")
    private IntDetails intDetails;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "API_DETAILS_ID")
    private ApiDetails apiDetails;

    public ApiDetails getApiDetails() {
        return apiDetails;
    }

    public void setApiDetails(ApiDetails apiDetails) {
        this.apiDetails = apiDetails;
    }

    public IntDetails getIntDetails() {
        return intDetails;
    }

    public void setIntDetails(IntDetails intDetails) {
        this.intDetails = intDetails;
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