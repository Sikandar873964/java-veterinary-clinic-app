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


/**
 * The type All hospitals screen controller.
 */
@Component
@FxmlView
public class AllHospitalsScreenController extends BaseViewController {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private AccountManager accountManager;

    /**
     * The Hospitals table view.
     */
    @FXML
    protected TableView<Hospital> hospitalsTableView;
    /**
     * The Hospital string table column.
     */
    @FXML
    protected TableColumn<Hospital, String> hospitalStringTableColumn;
    /**
     * The Hospital start time table column.
     */
    @FXML
    protected TableColumn<Hospital, LocalDateTime> hospitalStartTimeTableColumn;
    /**
     * The Hospital end time table column.
     */
    @FXML
    protected TableColumn<Hospital, LocalDateTime> hospitalEndTimeTableColumn;

    private ObservableList<Hospital> hospitalsObservableList = FXCollections.observableArrayList();

    /**
     * Initialize.
     */
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

                    stageManager.changeScene(
                            stageManager.getControllerScene(CreateHospitalBookingScreenController.class));
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

    /**
     * Navigate to my bookings screen.
     */
    @FXML
    public void navigateToMyBookingsScreen() {
        stageManager.changeScene(stageManager.getControllerScene(MyBookingsScreenController.class));
    }

    /**
     * Navigate to all animals screen.
     */
    @FXML
    public void navigateToAllAnimalsScreen() {
        stageManager.changeScene(stageManager.getControllerScene(AllAnimalsScreenController.class));
    }

    /**
     * Navigate to all hospitals screen.
     */
    @FXML
    public void navigateToAllHospitalsScreen() {
        stageManager.changeScene(stageManager.getControllerScene(AllHospitalsScreenController.class));
    }

    /**
     * Navigate to screen.
     *
     * @param <C>             the type parameter
     * @param controllerClass the controller class
     */
    @FXML
    public <C>void navigateToScreen(Class<C> controllerClass) {
        stageManager.changeScene(stageManager.getControllerScene(controllerClass));
    }

    /**
     * Navigate to create screen.
     */
    @FXML
    public void navigateToCreateScreen() {
        stageManager.changeScene(stageManager.getControllerScene(AllHospitalsScreenController.class));
    }
}
