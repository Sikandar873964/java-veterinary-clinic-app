package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Animal;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.AnimalType;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.AnimalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.HospitalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


@Component
@FxmlView
public class AllAnimalsScreenController extends BaseViewController {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private AccountManager accountManager;
    @Autowired
    private AnimalService animalService;

    @FXML
    protected TableView<Animal> animalsTableView;
    @FXML
    protected TableColumn<Animal, String> animalNameColumn;
    @FXML
    protected TableColumn<Animal, AnimalType> animalTypeColumn;


    private ObservableList<Animal> animalsObservableList = FXCollections.observableArrayList();

    public void initialize() {
        animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("animalName"));
        animalTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        animalsTableView.setItems(animalsObservableList);

        getAllAnimals();
    }

    private void getAllAnimals() {
        Page<Animal> animals = animalService.findAllAnimals(null, null, null);
        animalsObservableList.addAll(animals.getContent());
    }



}
