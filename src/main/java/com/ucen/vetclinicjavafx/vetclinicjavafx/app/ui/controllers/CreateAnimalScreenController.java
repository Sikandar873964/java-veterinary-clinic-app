package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Animal;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.AnimalType;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.AnimalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.AnimalUtils;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@FxmlView
public class CreateAnimalScreenController extends BaseViewController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalUtils animalUtils;

    @FXML
    private TextField animalName;
    @FXML
    private ChoiceBox<String> animalCategory;


    @FXML
    protected void createAnimal() {
        Animal animal =
                animalUtils.createAnimalObject(animalName.getText(), AnimalType.valueOf(animalCategory.getValue()));
        animal = animalService.createAnimal(animal);

        stageManager.changeScene(stageManager.getControllerScene(AllAnimalsScreenController.class));
    }
}
