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

@UiController("vault_ApiIntDetails.edit")
@UiDescriptor("api-int-details-edit.xml")
@EditedEntityContainer("intApiDetailsDc")
@LoadDataBeforeShow
public class ApiIntDetailsEdit extends StandardEditor<IntApiDetails> {

    @Inject
    private OptionsGroup optionGroupApi;

    private List apiList = new ArrayList<>();

    private List intList = new ArrayList<>();

    @Inject
    private CollectionContainer<IntDetails> intDetailsesDc;

    @Inject
    private LinkIntApiDetailsService linkIntApiDetailsService;

    @Inject
    private OptionsGroup optionsGroupInt;

    List<IntDetails> intOptionsList = new ArrayList<>();

    @Subscribe("optionsGroupInt")
    public void onOptionsGroupIntValueChange(HasValue.ValueChangeEvent<Collection<IntDetails>> event) {
        intOptionsList= new ArrayList<>(event.getValue());
    }

    public void setApiOptionGroup(Set<ApiDetails> apiDetails){
        apiList = apiDetails.stream().collect(Collectors.toList());
        optionGroupApi.setOptionsList(apiList);
    }

    public void setIntDC(List<IntApiDetails> intApiDetails){

        intList = intApiDetails.stream().map(e -> e.getIntDetails())
                .collect(Collectors.toList());
    }

    @Subscribe(id = "intDetailsesDl", target = Target.DATA_LOADER)
    public void onIntDetailsesDlPostLoad(CollectionLoader.PostLoadEvent<IntDetails> event) {
        List<IntDetails> intDcList = intDetailsesDc.getItems().stream()
                .filter(e -> !intList.contains(e))
                .collect(Collectors.toList());

        optionsGroupInt.setOptionsList(intDcList);
    }

    public void onOkBtnClick() {
        linkIntApiDetailsService.commitApiIntDetails(intOptionsList,apiList);
        close(WINDOW_CLOSE_ACTION);
    }

    public void onCancelBtnClick() {
        //Close without saving any changes
        close(WINDOW_CLOSE_ACTION);
    }
}