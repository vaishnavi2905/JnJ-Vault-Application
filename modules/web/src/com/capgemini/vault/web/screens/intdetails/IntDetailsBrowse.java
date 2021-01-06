package com.capgemini.vault.web.screens.intdetails;

import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.IntDetails;

@UiController("vault_IntDetails.browse")
@UiDescriptor("int-details-browse.xml")
@LookupComponent("intDetailsesTable")
@LoadDataBeforeShow
public class IntDetailsBrowse extends StandardLookup<IntDetails> {

}