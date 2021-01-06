package com.capgemini.vault.web.screens;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.CssLayout;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.gui.components.mainwindow.SideMenu;
import com.haulmont.cuba.gui.components.mainwindow.UserIndicator;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.DefaultApp;
import com.haulmont.cuba.web.app.main.MainScreen;

import javax.inject.Inject;


@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {

    @Inject
    private Button menuHideBtn;

    @Inject
    private Button menuUnhideBtn;

    @Inject
    private CssLayout sideMenuPanel;

    @Inject
    private HBoxLayout menuButtonsHide;

    private int menustatus;

    @Inject
    private SideMenu sideMenu;

    @Inject
    private Notifications notifications;

    @Inject
    private DefaultApp defaultApp;

    @Inject
    private Screens screens;

    @Inject
    private UserIndicator userIndicator;

    @Subscribe
    public void onInit(InitEvent event) {
        menustatus = 0;
        userIndicator.setUserNameFormatter(value -> "Welcome, "+value.getName());
        //Create user Manual Menu
        /*SideMenu.MenuItem helpItem = sideMenu.createMenuItem("UM-em");
        helpItem.setCaption("User Manual");
        helpItem.setIcon("font-icon:BOOK");
        helpItem.setStyleName("debug-icon");
        helpItem.setCommand(selectedItem -> screens.create(UserManual.class).show());
        sideMenu.addMenuItem(helpItem);*/
        sideMenu.getMenuItem("administration").setIcon("branding/setting.png");
        sideMenu.getMenuItem("help").setIcon("branding/help.png");
        //Add logout menu
        SideMenu.MenuItem logoutItem = sideMenu.createMenuItem("logout-em");
        logoutItem.setCaption("Logout");
        logoutItem.setIcon("app/images/exit.png");
        logoutItem.setStyleName("security-icon");
        logoutItem.setCommand(selectedItem -> defaultApp.logout());
        sideMenu.addMenuItem(logoutItem);

        /*List<SideMenu.MenuItem> menuItemList = sideMenu.getMenuItems();

        for(SideMenu.MenuItem menuItem : menuItemList){
            System.out.println(menuItem.getId());
        }
*/
        /*List<SideMenu.MenuItem> menuItemList = sideMenu.getMenuItem("application-test").getChildren();

        for(SideMenu.MenuItem menuItem : menuItemList) {
            if("em_EnvProvWizard".equals(menuItem.getId())) {
                menuItem.setVisible(false);
            }

            if("em_Metrics".equals(menuItem.getId())) {
                menuItem.setVisible(false);
            }
        }*/
    }
    public void onMenuHideClick() {

        if (menustatus == 0)
        {
            sideMenuPanel.setWidth("40px");
            menustatus = 1;
            menuHideBtn.setVisible(false);
            menuUnhideBtn.setVisible(true);
        }
        else
        {
            sideMenuPanel.setWidth("190px");
            menustatus = 0;
            menuHideBtn.setVisible(true);
            menuUnhideBtn.setVisible(false);
        }
    }
}