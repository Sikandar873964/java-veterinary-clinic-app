package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.MyBookingsScreenController;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.UserLoginScreenController;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.managers.StageManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.DateTimeUtils;
import jakarta.annotation.PostConstruct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Base view controller.
 */
public abstract class BaseViewController {

    /**
     * The Stage manager.
     */
    @Autowired
    protected StageManager stageManager;
    /**
     * The Date time utils.
     */
    @Autowired
    protected DateTimeUtils dateTimeUtils;
    @Autowired
    private AccountManager accountManager;

    /**
     * Initialize controller.
     */
    @PostConstruct
    public void initializeController() {

    }

    /**
     * Navigate to screen.
     *
     * @param event the event
     */
    @FXML
    public void navigateToScreen(ActionEvent event){
        Node node = (Node) event.getSource() ;
        String screenTypeString = (String) node.getUserData();
        ScreenType screenType = ScreenType.valueOf(screenTypeString);
        stageManager.changeScene(stageManager.getControllerScene(screenType.getController()));
    }

    /**
     * Logout.
     */
    public void logout(){
        accountManager.setCurrentCustomer(null);
        stageManager.changeScene(stageManager.getControllerScene(UserLoginScreenController.class));
    }
}
