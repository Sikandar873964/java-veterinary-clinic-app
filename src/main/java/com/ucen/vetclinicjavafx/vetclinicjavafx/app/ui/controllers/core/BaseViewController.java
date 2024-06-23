package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.MyBookingsScreenController;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.managers.StageManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.DateTimeUtils;
import jakarta.annotation.PostConstruct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseViewController {

    @Autowired
    protected StageManager stageManager;
    @Autowired
    protected DateTimeUtils dateTimeUtils;

    @PostConstruct
    public void initializeController() {

    }

    @FXML
    public void navigateToScreen(ActionEvent event){
        Node node = (Node) event.getSource() ;
        String screenTypeString = (String) node.getUserData();
        ScreenType screenType = ScreenType.valueOf(screenTypeString);
        stageManager.changeScene(stageManager.getControllerScene(screenType.getController()));
    }

}
