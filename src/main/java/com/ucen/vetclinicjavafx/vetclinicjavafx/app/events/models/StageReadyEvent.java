package com.ucen.vetclinicjavafx.vetclinicjavafx.app.events.models;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

public class StageReadyEvent extends ApplicationEvent {
    private Stage stage;

   public StageReadyEvent(Stage stage){
       super(stage);
       this.stage = stage;
   }

    public Stage getStage() {
        return stage;
    }
}
