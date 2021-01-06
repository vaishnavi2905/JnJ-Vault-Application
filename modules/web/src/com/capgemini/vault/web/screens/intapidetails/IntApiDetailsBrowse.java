package com.capgemini.vault.web.screens.intapidetails;

import com.capgemini.vault.entity.IntDetails;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.ActionsAwareDialogFacet;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.IntApiDetails;

import javax.inject.Inject;
import java.util.Map;
import java.util.Set;


@UiController("vault_IntApiDetails.browse")
@UiDescriptor("int-api-details-browse.xml")
@LookupComponent("intApiDetailsesTable")
@LoadDataBeforeShow
public class  IntApiDetailsBrowse extends StandardLookup<IntApiDetails> {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private GroupTable<IntApiDetails> intApiDetailsesTable;

    @WindowParam
    private Set<IntDetails> intDetails;
    @Inject
    private CollectionLoader<IntApiDetails> intApiDetailsesDl;

    @Subscribe("intApiDetailsesTable.create")
    public void onIntApiDetailsesTableCreate(Action.ActionPerformedEvent event) {
        IntApiDetailsEdit editScreen = screenBuilders.editor(intApiDetailsesTable)
                .newEntity()
                .withScreenClass(IntApiDetailsEdit.class)
                .withLaunchMode(OpenMode.DIALOG)
                .withAfterCloseListener(e -> doSave())
                .build();
        editScreen.setIntLookupField(intDetails);
        editScreen.setApiDC(intApiDetailsesDl.getContainer().getItems());
        editScreen.show();


    }

    private void doSave(){
        intApiDetailsesDl.load();
    }
}