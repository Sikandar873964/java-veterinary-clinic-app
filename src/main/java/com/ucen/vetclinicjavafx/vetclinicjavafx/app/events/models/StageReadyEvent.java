package com.ucen.vetclinicjavafx.vetclinicjavafx.app.events.models;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

/**
 * The type Stage ready event.
 */
public class StageReadyEvent extends ApplicationEvent {
    private Stage stage;

    /**
     * Instantiates a new Stage ready event.
     *
     * @param stage the stage
     */
    public StageReadyEvent(Stage stage){
       super(stage);
       this.stage = stage;
   }

    /**
     * Gets stage.
     *
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }
}
