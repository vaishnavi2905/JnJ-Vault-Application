package com.capgemini.vault.web.screens.masterdatamanagement;

import com.capgemini.vault.entity.MasterDataManagement;
import com.google.common.base.Strings;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.EntityCombinedScreen;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Map;

public class MasterDataManagementBrowse extends EntityCombinedScreen {

    @Inject
    private CollectionDatasource<MasterDataManagement, String> masterDataManagementsDs;

    @Inject
    private LookupField<MasterDataManagement> codeFilter;

    @Inject
    private TextField<String> typeFilter;

    String value;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        /*codeFilter.addValueChangeListener(e -> applyCodeFilter(e.getValue()));
        typeFilter.addValueChangeListener(e -> applyTypeFilter(e.getValue()));*/
        codeFilter.addValueChangeListener(e -> {
            MasterDataManagement masterData = e.getValue();
            if(masterData!=null){
                masterDataManagementsDs.refresh();
            }else{
                masterDataManagementsDs.refresh(ParamsMap.empty());
            }
        });
        typeFilter.addValueChangeListener(e -> {
            value = e.getValue();
            masterDataManagementsDs.refresh(ParamsMap.empty());
            if(value!=null){
                masterDataManagementsDs.refresh(ParamsMap.of("type",value));

            }
        });
    }

    private void applyTypeFilter(String value) {

        if(Strings.isNullOrEmpty(value)){
            masterDataManagementsDs.setQuery("select e from vault_MasterData e order by e.updateTs desc, e.createTs desc");
            masterDataManagementsDs.refresh();
        }else{
            System.out.println(value);
            masterDataManagementsDs.setQuery("select e from vault_MasterData e where lower(e.masterType) LIKE lower(CONCAT('%',:custom$value,'%')) order by e.updateTs desc, e.createTs desc");
            //masterDatasDs.setQuery("select e from vault_MasterData e where e.masterType = :custom$value order by e.updateTs desc, e.createTs desc");
            masterDataManagementsDs.refresh(ParamsMap.of("value",value));
        }
    }

    private void applyCodeFilter(MasterDataManagement value) {

        if(value == null || Strings.isNullOrEmpty(value.getMasterCode())){
            masterDataManagementsDs.setQuery("select e from vault_MasterData e order by e.updateTs desc, e.createTs desc");
            masterDataManagementsDs.refresh();
        }else{
            masterDataManagementsDs.setQuery("select e from vault_MasterData e where e.masterCode = :custom$code order by e.updateTs desc, e.createTs desc");
            masterDataManagementsDs.refresh(ParamsMap.of("code",value.getMasterCode()));
        }
    }
}