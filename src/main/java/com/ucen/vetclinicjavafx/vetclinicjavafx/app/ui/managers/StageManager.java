package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.managers;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The type Stage manager.
 */
@Component
public class StageManager {
    private Scene scene;
    private Stage stage;
    private Stage previousStage;
    private Scene previousScene;

    @Autowired
    private FxWeaver fxWeaver;

    /**
     * Gets scene.
     *
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Sets scene.
     *
     * @param scene the scene
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Gets stage.
     *
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Sets stage.
     *
     * @param stage the stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Gets previous stage.
     *
     * @return the previous stage
     */
    public Stage getPreviousStage() {
        return previousStage;
    }

    /**
     * Sets previous stage.
     *
     * @param previousStage the previous stage
     */
    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

    /**
     * Gets previous scene.
     *
     * @return the previous scene
     */
    public Scene getPreviousScene() {
        return previousScene;
    }

    /**
     * Sets previous scene.
     *
     * @param previousScene the previous scene
     */
    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    /**
     * Change stage.
     *
     * @param stage the stage
     */
    public void changeStage(Stage stage) {
        setPreviousStage(getStage());
        setStage(stage);
        stage.show();
    }

    /**
     * Change scene.
     *
     * @param scene the scene
     */
    public void changeScene(Scene scene) {
        setPreviousScene(getScene());
        setScene(scene);
        stage.setScene(scene);
        stage.show();
        ;
    }

    /**
     * Gets controller scene.
     *
     * @param <C>             the type parameter
     * @param controllerClass the controller class
     * @return the controller scene
     */
    public <C> Scene getControllerScene(Class<C> controllerClass) {
        return getControllerScene(controllerClass, stage.getWidth(), stage.getHeight());
    }

    /**
     * Gets controller scene.
     *
     * @param <C>             the type parameter
     * @param controllerClass the controller class
     * @param width           the width
     * @param height          the height
     * @return the controller scene
     */
    public <C> Scene getControllerScene(Class<C> controllerClass, double width, double height) {
        Scene scene = new Scene(fxWeaver.loadView(controllerClass), width, height);
        return scene;
    }

    /**
     * Gets controller scene.
     *
     * @param parent the parent
     * @return the controller scene
     */
    public Scene getControllerScene(Parent parent) {
        Scene scene = new Scene(parent, stage.getWidth(), stage.getHeight());
        return scene;
    }

    /**
     * Gets controller and view.
     *
     * @param <C>             the type parameter
     * @param <V>             the type parameter
     * @param controllerClass the controller class
     * @return the controller and view
     */
    public <C, V extends Node> FxControllerAndView<C, V> getControllerAndView(Class<C> controllerClass) {
        return fxWeaver.load(controllerClass);
    }

}
