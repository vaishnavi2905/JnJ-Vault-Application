package com.capgemini.vault.web.screens.apidetails;

import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.ApiDetails;

@UiController("vault_ApiDetails.browse")
@UiDescriptor("api-details-browse.xml")
@LookupComponent("apiDetailsesTable")
@LoadDataBeforeShow
public class ApiDetailsBrowse extends StandardLookup<ApiDetails> {
}