package com.ucen.vetclinicjavafx.vetclinicjavafx.app.events.listeners;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.events.models.StageReadyEvent;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.UserLoginScreenController;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.managers.StageManager;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {

    private final FxWeaver fxWeaver;

    private final StageManager stageManager;


    @Autowired
    public PrimaryStageInitializer(FxWeaver fxWeaver, StageManager stageManager) {
        this.fxWeaver = fxWeaver;
        this.stageManager=stageManager;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) { //(2)
        Stage stage = event.getStage();
        stageManager.setStage(stage);
        Scene scene = new Scene(fxWeaver.loadView(UserLoginScreenController.class), 400, 300);
        stage.setScene(scene);
        stage.show();

    }


}
