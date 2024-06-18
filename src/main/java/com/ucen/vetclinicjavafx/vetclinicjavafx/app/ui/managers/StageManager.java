package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.managers;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StageManager {
    private Scene scene;
    private Stage stage;
    private Stage previousStage;
    private Scene previousScene;

    @Autowired
    private FxWeaver fxWeaver;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getPreviousStage() {
        return previousStage;
    }

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

    public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    public void changeStage(Stage stage) {
        setPreviousStage(getStage());
        setStage(stage);
        stage.show();
    }

    public void changeScene(Scene scene) {
        setPreviousScene(getScene());
        setScene(scene);
        stage.setScene(scene);
        stage.show();
        ;
    }

    public <C> Scene getControllerScene(Class<C> controllerClass) {
        return getControllerScene(controllerClass, stage.getWidth(), stage.getHeight());
    }

    public <C> Scene getControllerScene(Class<C> controllerClass, double width, double height) {
        Scene scene = new Scene(fxWeaver.loadView(controllerClass), width, height);
        return scene;
    }

    public Scene getControllerScene(Parent parent) {
        Scene scene = new Scene(parent, stage.getWidth(), stage.getHeight());
        return scene;
    }

    public <C, V extends Node> FxControllerAndView<C, V> getControllerAndView(Class<C> controllerClass) {
        return fxWeaver.load(controllerClass);
    }

}
