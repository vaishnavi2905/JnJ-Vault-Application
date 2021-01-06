package com.capgemini.vault.web.screens;


import com.capgemini.vault.entity.IntDetails;
import com.capgemini.vault.entity.Status;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.WindowManager;

import com.haulmont.cuba.gui.actions.list.ExcelAction;
import com.haulmont.cuba.gui.components.*;

import com.haulmont.cuba.gui.export.ExportDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.relatedentities.RelatedEntitiesAPI;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UiController("vault_StagingFragment")
@UiDescriptor("Staging-fragment.xml")
public class StagingFragment extends ScreenFragment {
    @Inject
    private CollectionLoader<IntDetails> intDetailsesDl;

    @Inject
    private CollectionContainer<IntDetails> intDetailsesDc;

    @Inject
    private RelatedEntitiesAPI relatedEntitiesAPI;

    @Inject
    private DataGrid<IntDetails> intDetailsesTable;

    @Inject
    private DataManager dataManager;

    @Inject
    private Notifications notifications;

    @Inject
    private Button approveBtn;

    @Inject
    private Button rejectBtn;

    @Inject
    private UserSession userSession;

    @Inject
    private Button sendBtn;

    @Inject
    private Filter filter;


    /*@Named("intDetailsesTable.excel")
    private ExcelAction customersTableExcel;*/

    @Subscribe("intDetailsesTable.excel")
    public void onCustomersTableExcel(Action.ActionPerformedEvent event) throws FileNotFoundException {
        System.out.println("HI");

    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    private void onBeforeShowHost(Screen.BeforeShowEvent event) {
        intDetailsesDl.load();
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onInit(Screen.InitEvent event) {

        if(userSession.getRoles().contains("business-unit-admin")){
            approveBtn.setVisible(true);
            rejectBtn.setVisible(true);
            sendBtn.setVisible(false);
        }else{
            approveBtn.setVisible(false);
            rejectBtn.setVisible(false);
        }

        filter.setCollapsable(false);
        filter.setCaption(null);

    }


    @Subscribe("nameFilter")
    public void onNameFilterValueChange(HasValue.ValueChangeEvent<String> event) {
        if (event.getValue() != null) {
            intDetailsesDl.setParameter("name", "(?i)%" + event.getValue() + "%");
        } else {
            intDetailsesDl.removeParameter("name");
        }
        intDetailsesDl.load();
    }


    public void onRelatedApiClick() {

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intDetails",intDetailsesTable.getSelected());

        RelatedEntitiesAPI.RelatedScreenDescriptor relatedScreenDescriptor = new RelatedEntitiesAPI.RelatedScreenDescriptor();


        relatedScreenDescriptor.setOpenType(WindowManager.OpenType.DIALOG);
        relatedScreenDescriptor.setScreenId("vault_IntApiDetails.browse");
        relatedScreenDescriptor.setScreenParams(paramsMap);

        relatedEntitiesAPI.openRelatedScreen(intDetailsesTable.getSelected(),
                IntDetails.class, "intApiDetails", relatedScreenDescriptor);
/*
        relatedEntitiesAPI.openRelatedScreen(intDetailsesTable.getSelected(),
                IntDetails.class, "intApiDetails",
                new RelatedEntitiesAPI.RelatedScreenDescriptor("vault_IntApiDetails.browse", WindowManager.OpenType.DIALOG));*/
    }

    @Subscribe("lookupFieldStatus")
    public void onLookupFieldStatusValueChange(HasValue.ValueChangeEvent<Status> event) {
        if (event.getValue() != null) {
            intDetailsesDl.setParameter("status",event.getValue());
        } else {
            intDetailsesDl.removeParameter("status");
        }
        intDetailsesDl.load();
    }

    public void onSendBtnClick() {

        Set<IntDetails> intDetailsList = intDetailsesTable.getSelected();
        for(IntDetails intDetails : intDetailsList){
            if(intDetails.getIntInternalStatus().equals(Status.DRAFT)){
                IntDetails intDetail = intDetailsesDc.getItem(intDetails);
                intDetail.setIntInternalStatus(Status.PENDING_FOR_APPROVAL);
                dataManager.commit(intDetail);
            }
            intDetailsesDl.load();
        }

        notifications.create(Notifications.NotificationType.TRAY).withCaption("Sent for Approval").show();

    }

    public void onApproveBtnClick() {

        Set<IntDetails> intDetailsList = intDetailsesTable.getSelected();
        for(IntDetails intDetails : intDetailsList){
            if(intDetails.getIntInternalStatus().equals(Status.PENDING_FOR_APPROVAL) || (userSession.getRoles().contains("business-unit-admin"))){
                IntDetails intDetail = intDetailsesDc.getItem(intDetails);
                intDetail.setIntInternalStatus(Status.APPROVED);
                dataManager.commit(intDetail);
            }
            intDetailsesDl.load();
        }

        notifications.create(Notifications.NotificationType.TRAY).withCaption("Approved").show();

    }

    public void onRejectBtnClick() {

        Set<IntDetails> intDetailsList = intDetailsesTable.getSelected();
        for(IntDetails intDetails : intDetailsList){
            if(intDetails.getIntInternalStatus().equals(Status.PENDING_FOR_APPROVAL)){
                IntDetails intDetail = intDetailsesDc.getItem(intDetails);
                intDetail.setIntInternalStatus(Status.DRAFT);
                dataManager.commit(intDetail);
            }
            intDetailsesDl.load();
        }

        notifications.create(Notifications.NotificationType.TRAY).withCaption("Rejected").show();
    }
}