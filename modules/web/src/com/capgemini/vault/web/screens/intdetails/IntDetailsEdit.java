package com.capgemini.vault.web.screens.intdetails;

import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.IntDetails;

@UiController("vault_IntDetails.edit")
@UiDescriptor("int-details-edit.xml")
@EditedEntityContainer("intDetailsDc")
@LoadDataBeforeShow
public class IntDetailsEdit extends StandardEditor<IntDetails> {
}