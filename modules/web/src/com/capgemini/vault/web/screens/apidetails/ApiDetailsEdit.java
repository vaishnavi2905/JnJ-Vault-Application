package com.capgemini.vault.web.screens.apidetails;

import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.ApiDetails;

@UiController("vault_ApiDetails.edit")
@UiDescriptor("api-details-edit.xml")
@EditedEntityContainer("apiDetailsDc")
@LoadDataBeforeShow
public class ApiDetailsEdit extends StandardEditor<ApiDetails> {
}