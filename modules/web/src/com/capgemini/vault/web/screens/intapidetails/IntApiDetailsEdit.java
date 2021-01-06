package com.capgemini.vault.web.screens.intapidetails;

import com.capgemini.vault.entity.ApiDetails;
import com.capgemini.vault.entity.IntDetails;
import com.capgemini.vault.service.LinkIntApiDetailsService;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.OptionsGroup;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.IntApiDetails;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@UiController("vault_IntApiDetails.edit")
@UiDescriptor("int-api-details-edit.xml")
@EditedEntityContainer("intApiDetailsDc")
@LoadDataBeforeShow
public class IntApiDetailsEdit extends StandardEditor<IntApiDetails> {

    @Inject
    private OptionsGroup optionsGroupInt;
    @Inject
    private OptionsGroup optionsGroupAPI;
    @Inject
    private CollectionContainer<ApiDetails> apiDetailsesDc;

    List<ApiDetails> apiList = new ArrayList<>();

    List<IntDetails> list = new ArrayList<>();

    List<ApiDetails> apiOtionsList = new ArrayList<>();;

    @Inject
    private LinkIntApiDetailsService linkIntApiDetailsService;


    @Subscribe("optionsGroupAPI")
    public void onOptionsGroupAPIValueChange(HasValue.ValueChangeEvent<Collection<ApiDetails>> event) {
        apiOtionsList = new ArrayList<>(event.getValue());
    }

    public void setIntLookupField(Set<IntDetails> intDetails){

        list = intDetails.stream().collect(Collectors.toList());
        optionsGroupInt.setOptionsList(list);
    }

    public void setApiDC(List<IntApiDetails> intApiDetails){

        apiList = intApiDetails.stream().map(e -> e.getApiDetails())
                .collect(Collectors.toList());
    }

    @Subscribe(id = "apiDetailsesDl", target = Target.DATA_LOADER)
    public void onApiDetailsesDlPostLoad(CollectionLoader.PostLoadEvent<ApiDetails> event) {
        List<ApiDetails> apiDcList = apiDetailsesDc.getItems().stream()
                .filter(e -> !apiList.contains(e))
                .collect(Collectors.toList());
        optionsGroupAPI.setOptionsList(apiDcList);
    }


    public void onOkBtnClick() {
        linkIntApiDetailsService.commitIntApiDetails(list,apiOtionsList);
        close(WINDOW_CLOSE_ACTION);
    }

    public void onCancelBtnClick() {
        //Close without saving any changes
        close(WINDOW_CLOSE_ACTION);
    }
}