package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBooking;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBookingItem;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.HospitalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type My bookings screen controller.
 */
@Component
@FxmlView
public class MyBookingsScreenController extends BaseViewController {

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private AccountManager accountManager;

    /**
     * The Hospital bookings table view.
     */
    @FXML
    protected TableView<HospitalBooking> hospitalBookingsTableView;

    /**
     * The Holder first name table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> holderFirstNameTableColumn;
    /**
     * The Holder last name table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> holderLastNameTableColumn;
    /**
     * The Holder address table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> holderAddressTableColumn;
    /**
     * The Hospital name table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> hospitalNameTableColumn;
    /**
     * The Hospital booking start time table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, LocalDateTime> hospitalBookingStartTimeTableColumn;
    /**
     * The Animal names table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> animalNamesTableColumn;
    /**
     * The Actions column.
     */
    @FXML
    protected TableColumn<HospitalBooking, Void> actionsColumn;
    /**
     * The Price column.
     */
    @FXML
    protected TableColumn<HospitalBooking, Double> priceColumn;

    /**
     * The Past hospital bookings table view.
     */
    @FXML
    protected TableView<HospitalBooking> pastHospitalBookingsTableView;
    /**
     * The Past holder first name table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> pastHolderFirstNameTableColumn;
    /**
     * The Past holder last name table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> pastHolderLastNameTableColumn;
    /**
     * The Past holder address table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> pastHolderAddressTableColumn;
    /**
     * The Past hospital name table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> pastHospitalNameTableColumn;
    /**
     * The Past hospital booking start time table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, LocalDateTime> pastHospitalBookingStartTimeTableColumn;
    /**
     * The Past animal names table column.
     */
    @FXML
    protected TableColumn<HospitalBooking, String> pastAnimalNamesTableColumn;
    /**
     * The Past price column.
     */
    @FXML
    protected TableColumn<HospitalBooking, Double> pastPriceColumn;

    /**
     * The Booking tab pane.
     */
    @FXML
    protected TabPane bookingTabPane;

    private ObservableList<HospitalBooking> hospitalBookingsObservableList = FXCollections.observableArrayList();
    private ObservableList<HospitalBooking> pastHospitalBookingsObservableList = FXCollections.observableArrayList();

    /**
     * Initialize.
     */
    public void initialize() {
        holderFirstNameTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHolderFirstName()));
        holderLastNameTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHolderLastName()));
        holderAddressTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHolderAddress()));
        hospitalBookingStartTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        animalNamesTableColumn.setCellValueFactory(cell -> {
            List<HospitalBookingItem> hospitalBookingItemList = hospitalService.getHospitalBookingItemsByHospitalBooking(cell.getValue(), null, null, null);
            String finalName = "";
            if (CollectionUtils.isNotEmpty(hospitalBookingItemList)) {
                finalName = StringUtils.join(hospitalBookingItemList.stream().filter(hospitalBookingItem -> StringUtils.isNotEmpty(hospitalBookingItem.getAnimalName())).map(HospitalBookingItem::getAnimalName).collect(
                        Collectors.toList()), ",");
            }
            return new SimpleStringProperty(finalName);
        });
        // Define the cell factory for the actionColumn
        actionsColumn.setCellFactory(new Callback<TableColumn<HospitalBooking, Void>, TableCell<HospitalBooking, Void>>() {
            @Override
            public TableCell<HospitalBooking, Void> call(TableColumn<HospitalBooking, Void> param) {
                return new TableCell<HospitalBooking, Void>() {
                    private final Button button = new Button("Remove");

                    {
                        button.setOnAction(event -> {
                            HospitalBooking data = getTableView().getItems().get(getIndex());
                            hospitalService.deleteHospitalBookingComplete(data);
                            hospitalBookingsObservableList.remove(data);
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        });

        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        hospitalNameTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHospital().getHospitalName()));
        hospitalBookingsTableView.setItems(hospitalBookingsObservableList);

        pastHolderFirstNameTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHolderFirstName()));
        pastHolderLastNameTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHolderLastName()));
        pastHolderAddressTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHolderAddress()));
        pastHospitalBookingStartTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        pastAnimalNamesTableColumn.setCellValueFactory(cell -> {
            List<HospitalBookingItem> hospitalBookingItemList = hospitalService.getHospitalBookingItemsByHospitalBooking(cell.getValue(), null, null, null);
            String finalName = "";
            if (CollectionUtils.isNotEmpty(hospitalBookingItemList)) {
                finalName = StringUtils.join(hospitalBookingItemList.stream().filter(hospitalBookingItem -> StringUtils.isNotEmpty(hospitalBookingItem.getAnimalName())).map(HospitalBookingItem::getAnimalName).collect(Collectors.toList()), ",");
            }
            return new SimpleStringProperty(finalName);
        });
        pastPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        pastHospitalNameTableColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getHospital().getHospitalName()));
        pastHospitalBookingsTableView.setItems(pastHospitalBookingsObservableList);

        getHospitalBookingsByCustomer(accountManager.getCurrentCustomer());
        getPastHospitalBookingsByCustomer(accountManager.getCurrentCustomer());

        bookingTabPane.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            int selectedIndex = newValue.intValue();
            if (selectedIndex == 0) {
                getHospitalBookingsByCustomer(accountManager.getCurrentCustomer());
            }
            if (selectedIndex == 1) {
                getPastHospitalBookingsByCustomer(accountManager.getCurrentCustomer());
            }
            //where index of the first tab is 0, while that of the second tab is 1 and so on.
        });
    }

    /**
     * Gets hospital bookings by customer.
     *
     * @param customer the customer
     */
    public void getHospitalBookingsByCustomer(Customer customer) {
        hospitalBookingsObservableList.clear();
        Page<HospitalBooking> hospitalBookings =
                hospitalService.getHospitalBookingsByCustomerAndStartTimeAfter(customer, LocalDateTime.now(), null, null, Sort.Direction.DESC,"startTime");
        hospitalBookingsObservableList.addAll(hospitalBookings.getContent());
    }

    /**
     * Gets past hospital bookings by customer.
     *
     * @param customer the customer
     */
    public void getPastHospitalBookingsByCustomer(Customer customer) {
        pastHospitalBookingsObservableList.clear();
        Page<HospitalBooking> hospitalBookings =
                hospitalService.getHospitalBookingsByCustomerAndStartTimeBefore(customer, LocalDateTime.now(), null, null, Sort.Direction.DESC,"startTime");
        pastHospitalBookingsObservableList.addAll(hospitalBookings.getContent());
    }

}
