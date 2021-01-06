package com.capgemini.vault.web.screens.intapidetails;

import com.capgemini.vault.entity.ApiDetails;
import com.capgemini.vault.entity.IntDetails;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.actions.list.CreateAction;
import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.IntApiDetails;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Set;

@UiController("vault_ApiIntDetails.browse")
@UiDescriptor("api-int-details-browse.xml")
@LookupComponent("intApiDetailsesTable")
@LoadDataBeforeShow
public class ApiIntDetailsBrowse extends StandardLookup<IntApiDetails> {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private GroupTable<IntApiDetails> intApiDetailsesTable;

    @Named("intApiDetailsesTable.create")
    private CreateAction<IntApiDetails> intApiDetailsesTableCreate;

    @WindowParam
    private Set<ApiDetails> apiDetails;
    @Inject
    private CollectionLoader<IntApiDetails> intApiDetailsesDl;

    @Override
    protected void initActions(InitEvent event) {
        super.initActions(event);
        intApiDetailsesTableCreate.setScreenId("vault_ApiIntDetails.edit");
    }

    @Subscribe("intApiDetailsesTable.create")
    public void onIntApiDetailsesTableCreate(Action.ActionPerformedEvent event) {

        ApiIntDetailsEdit editScreen = screenBuilders.editor(intApiDetailsesTable)
                .newEntity()
                .withScreenClass(ApiIntDetailsEdit.class)
                .withLaunchMode(OpenMode.DIALOG)
                .withAfterCloseListener(e -> doSave())
                .build();
        editScreen.setApiOptionGroup(apiDetails);
        editScreen.setIntDC(intApiDetailsesDl.getContainer().getItems());
        editScreen.show();

    }
    private void doSave(){
        intApiDetailsesDl.load();
    }
}