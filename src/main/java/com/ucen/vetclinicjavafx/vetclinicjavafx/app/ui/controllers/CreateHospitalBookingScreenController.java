package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Animal;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBooking;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBookingItem;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.AnimalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.HospitalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.HospitalUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Component
@FxmlView
public class CreateHospitalBookingScreenController extends BaseViewController {

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private AccountManager accountManager;

    @Autowired
    private HospitalUtils hospitalUtils;

    private Hospital hospital;

    @FXML
    private DatePicker startDatePicker;
    @FXML
    private Spinner<Integer> startTimeHourSpinner;
    @FXML
    private Spinner<Integer> startTimeMinuteSpinner;

    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Spinner<Integer> endTimeHourSpinner;
    @FXML
    private Spinner<Integer> endTimeMinuteSpinner;

    @FXML
    private ChoiceBox<Animal> animalChoiceBox;
    @FXML
    private TextArea reasonTextArea;
    @FXML
    private CheckBox needsAdditionalAssistant;
    @FXML
    private CheckBox additionalSurCharge;
    @FXML
    private CheckBox longDistance;

    @FXML
    private TableView<HospitalBookingItem> hospitalBookingItemsTable;
    @FXML
    private TableColumn<HospitalBookingItem, String> animalColumn;
    @FXML
    private TableColumn<HospitalBookingItem, String> reasonColumn;
    @FXML
    private TableColumn<HospitalBookingItem, Boolean> needsAdditionalAssistantColumn;
    @FXML
    private TableColumn<HospitalBookingItem, Boolean> additionalSurChargeColumn;
    @FXML
    private TableColumn<HospitalBookingItem, Boolean> longDistanceColumn;
    @FXML
    private TableColumn<HospitalBookingItem, Double> priceColumn;

    private List<HospitalBookingItem> hospitalBookingItems = new ArrayList<>();

    private ObservableList<Animal> animalsObservableList = FXCollections.observableArrayList();
    private ObservableList<HospitalBookingItem> hospitalBookingItemObservableList = FXCollections.observableArrayList();

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void initialize() {
        setHospital(accountManager.getCurrentHospital());

        SpinnerValueFactory<Integer> startTimeHourFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, LocalTime.now().getHour());
        startTimeHourSpinner.setValueFactory(startTimeHourFactory);

        // Initialize the minute spinner (0-59)
        SpinnerValueFactory<Integer> startTimeMinuteFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, LocalTime.now().getMinute());
        startTimeMinuteSpinner.setValueFactory(startTimeMinuteFactory);

        SpinnerValueFactory<Integer> endTimeHourFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, LocalTime.now().getHour());
        endTimeHourSpinner.setValueFactory(endTimeHourFactory);

        // Initialize the minute spinner (0-59)
        SpinnerValueFactory<Integer> endTimeMinuteFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, LocalTime.now().getMinute());
        endTimeMinuteSpinner.setValueFactory(endTimeMinuteFactory);


        animalChoiceBox.setItems(animalsObservableList);
        animalChoiceBox.setConverter(new StringConverter<Animal>() {
            @Override
            public String toString(Animal object) {
                if (object != null) {
                    return StringUtils.defaultIfEmpty(object.getAnimalName(), "Unknown");
                }
                return "";
            }

            @Override
            public Animal fromString(String string) {
                Animal animal = new Animal();
                animal.setAnimalName(string);
                return animal;
            }
        });

        needsAdditionalAssistantColumn.setCellValueFactory(new PropertyValueFactory<>("needsAdditionalAssistant"));
        longDistanceColumn.setCellValueFactory(new PropertyValueFactory<>("longDistance"));
        additionalSurChargeColumn.setCellValueFactory(new PropertyValueFactory<>("additionalSurCharge"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
//        reasonColumn.setCellFactory(new MultilineTextCellFactory());
        hospitalBookingItemsTable.setItems(hospitalBookingItemObservableList);
        animalColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAnimal().getAnimalName()));
        hospitalBookingItemObservableList.setAll(hospitalBookingItems);

        getALlAnimals();
    }

    private LocalDateTime getLocalDateTimeFromPickers(DatePicker datePicker, Spinner<Integer> hourSpinner,
                                                      Spinner<Integer> minuteSpinner) {
        LocalDate date = datePicker.getValue();
        int hour = hourSpinner.getValue();
        int minute = minuteSpinner.getValue();

        LocalDateTime dateTime = null;

        if (date != null) {
            dateTime = LocalDateTime.of(date, LocalTime.of(hour, minute));

        }
        return dateTime;
    }

    protected void getALlAnimals() {
        Page<Animal> animals = animalService.findAllAnimals(null, null, null);
        animalsObservableList.addAll(animals.getContent());
    }

    @FXML
    protected void createHospitalBooking() {
        HospitalBooking hospitalBooking = hospitalUtils.createHospitalBooking(accountManager.getCurrentHospital(),
                accountManager.getCurrentCustomer(),
                getLocalDateTimeFromPickers(startDatePicker, startTimeHourSpinner, startTimeMinuteSpinner),
                getLocalDateTimeFromPickers(endDatePicker, endTimeHourSpinner, endTimeMinuteSpinner));
        hospitalBooking = hospitalService.createHospitalBooking(hospitalBooking);

        if (CollectionUtils.isNotEmpty(hospitalBookingItems)) {
            HospitalBooking finalHospitalBooking = hospitalBooking;
            hospitalBookingItems.forEach(hospitalBookingItem -> hospitalBookingItem.setHospitalBooking(
                    finalHospitalBooking));
            hospitalService.createHospitalBookingItems(hospitalBookingItems);
        }

        hospitalBooking.setPrice(hospitalUtils.getTotalItemPriceForBooking(hospitalBookingItems));
        hospitalService.updateHospitalBooking(hospitalBooking);

        stageManager.changeScene(stageManager.getControllerScene(MyBookingsScreenController.class));
    }

    @FXML
    protected void addHospitalBookingItem() {
        boolean needsAdditionalAssistantValue = needsAdditionalAssistant.isSelected();
        boolean longDistanceValue = longDistance.isSelected();
        boolean additionalSurChargeValue = additionalSurCharge.isSelected();
        Animal animal = animalChoiceBox.getSelectionModel().getSelectedItem();
        String reason = reasonTextArea.getText();

        HospitalBookingItem hospitalBookingItem =
                hospitalUtils.createHospitalBookingItemObject(animal, reason, longDistanceValue,
                        additionalSurChargeValue, needsAdditionalAssistantValue);

        hospitalBookingItemObservableList.add(hospitalBookingItem);
        hospitalBookingItems.add(hospitalBookingItem);

        clearItemForm();
    }

    protected void clearItemForm() {
        longDistance.setSelected(false);
        additionalSurCharge.setSelected(false);
        animalChoiceBox.setValue(null);
        needsAdditionalAssistant.setSelected(false);
    }
}
