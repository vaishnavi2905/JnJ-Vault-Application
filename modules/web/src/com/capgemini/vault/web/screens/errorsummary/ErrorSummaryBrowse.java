package com.capgemini.vault.web.screens.errorsummary;

import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.ErrorSummary;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("vault_ErrorSummary.browse")
@UiDescriptor("error-summary-browse.xml")
@LookupComponent("errorSummariesTable")
@LoadDataBeforeShow
public class ErrorSummaryBrowse extends StandardLookup<ErrorSummary> {
    @Inject
    private CollectionLoader<ErrorSummary> errorSummariesDl;

    @Subscribe("userFilter")
    public void onUserFilterValueChange(HasValue.ValueChangeEvent<User> event) {

        if (event.getValue() != null) {
            errorSummariesDl.setParameter("user",event.getValue().getLogin());
        } else {
            errorSummariesDl.removeParameter("user");
        }
        errorSummariesDl.load();

    }

    @Subscribe("rowFilter")
    public void onRowFilterValueChange(HasValue.ValueChangeEvent<String> event) {
        if (event.getValue() != null) {
            BigDecimal rowNo = new BigDecimal(event.getValue());
            errorSummariesDl.setParameter("row",rowNo);
        } else {
            errorSummariesDl.removeParameter("row");
        }
        errorSummariesDl.load();
    }

    @Subscribe("fileFilter")
    public void onFileFilterTextChange(TextInputField.TextChangeEvent event) {
        if (event.getText() != null) {
            errorSummariesDl.setParameter("file","(?i)%" + event.getText() + "%");
        } else {
            errorSummariesDl.removeParameter("file");
        }
        errorSummariesDl.load();

    }

    @Subscribe("columnFilter")
    public void onColumnFilterValueChange(HasValue.ValueChangeEvent<String> event) {

        if (event.getValue() != null) {
            BigDecimal colNo = new BigDecimal(event.getValue());
            errorSummariesDl.setParameter("col",colNo);
        } else {
            errorSummariesDl.removeParameter("col");
        }
        errorSummariesDl.load();

    }


}