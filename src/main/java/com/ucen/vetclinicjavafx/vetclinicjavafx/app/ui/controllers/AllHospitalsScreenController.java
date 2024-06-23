package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.HospitalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@FxmlView
public class AllHospitalsScreenController extends BaseViewController {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private AccountManager accountManager;

    @FXML
    protected TableView<Hospital> hospitalsTableView;
    @FXML
    protected TableColumn<Hospital, String> hospitalStringTableColumn;
    @FXML
    protected TableColumn<Hospital, LocalDateTime> hospitalStartTimeTableColumn;
    @FXML
    protected TableColumn<Hospital, LocalDateTime> hospitalEndTimeTableColumn;

    private ObservableList<Hospital> hospitalsObservableList = FXCollections.observableArrayList();

    public void initialize() {
        hospitalsObservableList.clear();
        hospitalStartTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalStartTime"));
        hospitalEndTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalEndTime"));
        hospitalStringTableColumn.setCellValueFactory(new PropertyValueFactory<>("hospitalName"));
        hospitalsTableView.setItems(hospitalsObservableList);

        hospitalsTableView.setRowFactory(tv -> {
            TableRow<Hospital> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Hospital rowData = row.getItem();
                    accountManager.setCurrentHospital(rowData);
                }
            });
            return row;
        });

        getAllHospitals();
    }

    private void getAllHospitals() {
        Page<Hospital> hospitals = hospitalService.findAllHospitals(null, null, null);
        System.out.println("Total hospitals: " + hospitals.getNumberOfElements());
        hospitalsObservableList.addAll(hospitals.getContent());
    }


    @FXML
    public void navigateToAllHospitalsScreen() {
        stageManager.changeScene(stageManager.getControllerScene(AllHospitalsScreenController.class));
    }

    @FXML
    public <C>void navigateToScreen(Class<C> controllerClass) {
        stageManager.changeScene(stageManager.getControllerScene(controllerClass));
    }

    @FXML
    public void navigateToCreateScreen() {
        stageManager.changeScene(stageManager.getControllerScene(AllHospitalsScreenController.class));
    }
}
