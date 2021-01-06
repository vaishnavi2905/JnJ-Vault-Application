package com.capgemini.vault.web.screens;

import com.capgemini.vault.entity.ApiDetails;
import com.capgemini.vault.entity.IntDetails;
import com.capgemini.vault.entity.Status;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.relatedentities.RelatedEntitiesAPI;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@UiController("vault_ApiFragment")
@UiDescriptor("Api-fragment.xml")
public class ApiFragment extends ScreenFragment {

    @Inject
    private CollectionLoader<ApiDetails> apiDetailsesDl;

    @Inject
    private RelatedEntitiesAPI relatedEntitiesAPI;

    @Inject
    private DataGrid<ApiDetails> apiDetailsesTable;

    @Inject
    private Button sAbtn;

    @Inject
    private Button rejBtn;

    @Inject
    private Button AppBtn;
    @Inject
    private CollectionContainer<ApiDetails> apiDetailsesDc;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private UserSession userSession;
    @Inject
    private Filter filter;

    /*@Subscribe(target = Target.PARENT_CONTROLLER)
    public void onInit(Screen.InitEvent event) {

        if(userSession.getRoles().contains("business-unit-admin")){
            AppBtn.setVisible(true);
            rejBtn.setVisible(true);
            sAbtn.setVisible(false);
        }else{
            AppBtn.setVisible(false);
            rejBtn.setVisible(false);
        }

    }*/

    @Install(to = "apiDetailsesTable", subject = "rowStyleProvider")
    private String apiDetailsesTableRowStyleProvider(ApiDetails apiDetails) {
        System.out.println(apiDetails.getApiInternalStatus());
        System.out.println(Status.ERROR);
        return Status.ERROR.equals(apiDetails.getApiInternalStatus()) ? "green-color" : null;
    }

    @Subscribe
    public void onInit(InitEvent event) {
        if(userSession.getRoles().contains("business-unit-admin")){
            AppBtn.setVisible(true);
            rejBtn.setVisible(true);
            sAbtn.setVisible(false);
        }else{
            AppBtn.setVisible(false);
            rejBtn.setVisible(false);
        }

        filter.setCollapsable(false);
        filter.setCaption(null);
       /* apiDetailsesTable.getColumnNN("apiInternalStatus")
                .setStyleProvider(api -> {
                    switch (api.getApiInternalStatus()) {
                        case Status.ERROR:
                            return "premium-grade";
                        case Status.DRAFT:
                            return "high-grade";
                        case Status.APPROVED:
                            return "standard-grade";
                        case Status.PENDING_FOR_APPROVAL:
                            return "standard-grade";
                    }

                    return null;
                });
        apiDetailsesTable*/
    }
    
    


    @Subscribe(target = Target.PARENT_CONTROLLER)
    private void onBeforeShowHost(Screen.BeforeShowEvent event) {
        apiDetailsesDl.load();
    }

    public void onRelatedClick() {

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("apiDetails",apiDetailsesTable.getSelected());

        RelatedEntitiesAPI.RelatedScreenDescriptor relatedScreenDescriptor = new RelatedEntitiesAPI.RelatedScreenDescriptor();


        relatedScreenDescriptor.setOpenType(WindowManager.OpenType.DIALOG);
        relatedScreenDescriptor.setScreenId("vault_ApiIntDetails.browse");
        relatedScreenDescriptor.setScreenParams(paramsMap);



        relatedEntitiesAPI.openRelatedScreen(apiDetailsesTable.getSelected(),
                ApiDetails.class, "intApiDetails",
                relatedScreenDescriptor);
    }

    @Subscribe("textFieldApi")
    public void onTextFieldApiTextChange(TextInputField.TextChangeEvent event) {
        if (event.getText() != null) {
            apiDetailsesDl.setParameter("name", "(?i)%" + event.getText() + "%");
        } else {
            apiDetailsesDl.removeParameter("name");
        }
        apiDetailsesDl.load();
    }

    @Subscribe("lookupFieldStatus")
    public void onLookupFieldStatusValueChange(HasValue.ValueChangeEvent<Status> event) {
        if (event.getValue() != null) {
            apiDetailsesDl.setParameter("status",event.getValue());
        } else {
            apiDetailsesDl.removeParameter("status");
        }
        apiDetailsesDl.load();
    }


    public void onSAbtnClick() {
        Set<ApiDetails> apiDetailsList = apiDetailsesTable.getSelected();
        for(ApiDetails apiDetails : apiDetailsList){
            if(apiDetails.getApiInternalStatus().equals(Status.DRAFT)){
                ApiDetails apiDetail = apiDetailsesDc.getItem(apiDetails);
                apiDetail.setApiInternalStatus(Status.PENDING_FOR_APPROVAL);
                dataManager.commit(apiDetail);
            }
            apiDetailsesDl.load();
        }

        notifications.create(Notifications.NotificationType.TRAY).withCaption("Sent for Approval").show();

    }

    public void onAppBtnClick() {

        Set<ApiDetails> apiDetailsList = apiDetailsesTable.getSelected();
        for(ApiDetails apiDetails : apiDetailsList){
            if(apiDetails.getApiInternalStatus().equals(Status.DRAFT)|| (userSession.getRoles().contains("business-unit-admin"))){
                ApiDetails apiDetail = apiDetailsesDc.getItem(apiDetails);
                apiDetail.setApiInternalStatus(Status.APPROVED);
                dataManager.commit(apiDetail);
            }
            apiDetailsesDl.load();
        }

        notifications.create(Notifications.NotificationType.TRAY).withCaption("Sent for Approval").show();

    }

    public void onRejBtnClick() {

        Set<ApiDetails> apiDetailsList = apiDetailsesTable.getSelected();
        for(ApiDetails apiDetails : apiDetailsList){
            if(apiDetails.getApiInternalStatus().equals(Status.DRAFT)){
                ApiDetails apiDetail = apiDetailsesDc.getItem(apiDetails);
                apiDetail.setApiInternalStatus(Status.DRAFT);
                dataManager.commit(apiDetail);
            }
            apiDetailsesDl.load();
        }

        notifications.create(Notifications.NotificationType.TRAY).withCaption("Rejected").show();

    }
}