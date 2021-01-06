package com.capgemini.vault.web.screens.uploadsummary;

import com.capgemini.vault.service.ReadFileService;
import com.capgemini.vault.web.screens.StagingScreen;
import com.capgemini.vault.web.screens.errorsummary.ErrorSummaryBrowse;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.capgemini.vault.entity.UploadSummary;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.cuba.security.entity.User;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.inject.Inject;
import java.io.File;

@UiController("vault_UploadSummary.browse")
@UiDescriptor("upload-summary-browse.xml")
@LookupComponent("uploadSummariesTable")
@LoadDataBeforeShow
public class UploadSummaryBrowse extends StandardLookup<UploadSummary>{

    @Inject
    private Notifications notifications;
    @Inject
    private FileUploadField upload;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private ReadFileService readFileService;
    @Inject
    private CollectionLoader<UploadSummary> uploadSummariesDl;
    @Inject
    private ScreenBuilders screenBuilders;
    DataManager dataManager = AppBeans.get(DataManager.class);

    UserSessionSource uss = AppBeans.get(UserSessionSource.class);


    @Subscribe("upload")
    public void onUploadFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) throws Exception{
        File fileid=fileUploadingAPI.getFile(upload.getFileId());  //use exceptions.

        notifications.create().withCaption(readFileService.readVault(fileid,upload.getFileName(),uss.getUserSession().getUser())).show();
        uploadSummariesDl.load();
    }


    @Subscribe("FileNameFilter")
    public void onFileNameFilterValueChange(HasValue.ValueChangeEvent<String> event) {
        if (event.getValue() != null) {
            System.out.println(event.getValue());
            uploadSummariesDl.setParameter("name", "(?i)%" + event.getValue() + "%");
        } else {
            uploadSummariesDl.removeParameter("name");
        }
        uploadSummariesDl.load();
    }

    @Subscribe("UserFilter")
    public void onUserFilterValueChange(HasValue.ValueChangeEvent<User> event) {
        if (event.getValue() != null) {
            System.out.println(event.getValue().getLogin());
            uploadSummariesDl.setParameter("User",event.getValue().getLogin());
        } else {
            uploadSummariesDl.removeParameter("User");
        }
        uploadSummariesDl.load();
    }

    

    public void openStagingScreen(Entity item, String columnId) {
        StagingScreen screen = screenBuilders.screen(this)
                .withScreenClass(StagingScreen.class)
                .withLaunchMode(OpenMode.NEW_TAB)
                .build();
        screen.show();
    }

    public void openErrorScreen(Entity item, String columnId) {
        ErrorSummaryBrowse screen = screenBuilders.screen(this)
                .withScreenClass(ErrorSummaryBrowse.class)
                .withLaunchMode(OpenMode.NEW_TAB)
                .build();
        screen.show();

    }
}