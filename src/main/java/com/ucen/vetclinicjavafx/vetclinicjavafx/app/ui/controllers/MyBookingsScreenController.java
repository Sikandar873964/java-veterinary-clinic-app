package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBooking;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.HospitalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import javafx.beans.property.SimpleStringProperty;
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

import java.time.LocalDateTime;

@Component
@FxmlView
public class MyBookingsScreenController extends BaseViewController {

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private AccountManager accountManager;

    @FXML
    protected TableView<HospitalBooking> hospitalBookingsTableView;
    @FXML
    protected TableColumn<HospitalBooking, String> customerTableColumn;
    @FXML
    protected TableColumn<HospitalBooking, String> hospitalNameTableColumn;
    @FXML
    protected TableColumn<HospitalBooking, LocalDateTime> hospitalBookingStartTimeTableColumn;
    @FXML
    protected TableColumn<HospitalBooking, LocalDateTime> hospitalBookingEndTimeTableColumn;
    @FXML
    protected TableColumn<HospitalBooking, Double> priceColumn;

    private ObservableList<HospitalBooking> hospitalBookingsObservableList = FXCollections.observableArrayList();

    public void initialize() {
        hospitalBookingsObservableList.clear();
        customerTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getEmailId()));
        hospitalBookingStartTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        hospitalBookingEndTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        hospitalNameTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHospital().getHospitalName()));
        hospitalBookingsTableView.setItems(hospitalBookingsObservableList);

        getHospitalBookingsByCustomer(accountManager.getCurrentCustomer());
    }

    public void getHospitalBookingsByCustomer(Customer customer) {
        Page<HospitalBooking> hospitalBookings =
                hospitalService.getHospitalBookingsByCustomer(customer, null, null, null);
        hospitalBookingsObservableList.addAll(hospitalBookings.getContent());
    }

}
