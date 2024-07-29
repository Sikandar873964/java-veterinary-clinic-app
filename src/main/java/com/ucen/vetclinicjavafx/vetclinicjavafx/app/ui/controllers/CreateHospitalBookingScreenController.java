package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.*;
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
import javafx.util.Callback;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * The type Create hospital booking screen controller.
 */
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
    private Label hospitalBookingLabel;
    @FXML
    private TextField holderFirstName;
    @FXML
    private TextField holderLastName;
    @FXML
    private TextField holderAddress;

    @FXML
    private DatePicker startDatePicker;
    @FXML
    private Spinner<Integer> startTimeHourSpinner;
    @FXML
    private Spinner<Integer> startTimeMinuteSpinner;

    @FXML
    private ChoiceBox<AnimalType> animalTypeChoiceBox;
    @FXML
    private ChoiceBox<Animal> animalChoiceBox;
    @FXML
    private TextField animalNameTextField;
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
    private TableColumn<HospitalBookingItem, String> animalNameColumn;
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
    @FXML
    private TableColumn<HospitalBookingItem, Void> actionsColumn;

    private List<HospitalBookingItem> hospitalBookingItems = new ArrayList<>();

    private ObservableList<AnimalType> animalTypeObservableList = FXCollections.observableArrayList(AnimalType.values());
    private ObservableList<Animal> animalsObservableList = FXCollections.observableArrayList();
    private ObservableList<HospitalBookingItem> hospitalBookingItemObservableList = FXCollections.observableArrayList();

    /**
     * Gets hospital.
     *
     * @return the hospital
     */
    public Hospital getHospital() {
        return hospital;
    }

    /**
     * Sets hospital.
     *
     * @param hospital the hospital
     */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Initialize.
     */
    public void initialize() {

        SpinnerValueFactory<Integer> startTimeHourFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, LocalTime.now().getHour());
        startTimeHourSpinner.setValueFactory(startTimeHourFactory);

        // Initialize the minute spinner (0-59)
        SpinnerValueFactory<Integer> startTimeMinuteFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, LocalTime.now().getMinute());
        startTimeMinuteSpinner.setValueFactory(startTimeMinuteFactory);

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

        animalTypeChoiceBox.setItems(animalTypeObservableList);
        animalTypeChoiceBox.setConverter(new StringConverter<AnimalType>() {
            @Override
            public String toString(AnimalType object) {
                if (object != null) {
                    return object.name();
                }
                return "";
            }

            @Override
            public AnimalType fromString(String string) {
                if (StringUtils.isNotEmpty(string)) {
                    return AnimalType.valueOf(string);
                }
                return AnimalType.FARM_ANIMAL;
            }
        });
        animalTypeChoiceBox.setOnAction((value) -> this.getAnimalsByAnimalType());

        needsAdditionalAssistantColumn.setCellValueFactory(new PropertyValueFactory<>("needsAdditionalAssistant"));
        longDistanceColumn.setCellValueFactory(new PropertyValueFactory<>("longDistance"));
        additionalSurChargeColumn.setCellValueFactory(new PropertyValueFactory<>("additionalSurCharge"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("animalName"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
//        reasonColumn.setCellFactory(new MultilineTextCellFactory());
        hospitalBookingItemsTable.setItems(hospitalBookingItemObservableList);
        animalColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAnimal().getAnimalName()));
        hospitalBookingItemObservableList.setAll(hospitalBookingItems);

        // Define the cell factory for the actionColumn
        actionsColumn.setCellFactory(new Callback<TableColumn<HospitalBookingItem, Void>, TableCell<HospitalBookingItem, Void>>() {
            @Override
            public TableCell<HospitalBookingItem, Void> call(TableColumn<HospitalBookingItem, Void> param) {
                return new TableCell<HospitalBookingItem, Void>() {
                    private final Button button = new Button("Remove");

                    {
                        button.setOnAction(event -> {
                            HospitalBookingItem data = getTableView().getItems().get(getIndex());
                            hospitalBookingItems.remove(data);
                            hospitalBookingItemObservableList.remove(data);
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

//        getALlAnimals();
        getAllHospitals();
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

    /**
     * Gets a ll animals.
     */
    protected void getALlAnimals() {
        Page<Animal> animals = animalService.findAllAnimals(null, null, null);
        animalsObservableList.addAll(animals.getContent());
    }

    /**
     * Gets animals by animal type.
     */
    protected void getAnimalsByAnimalType() {
        animalsObservableList.clear();
        Page<Animal> animals = animalService.getAnimalsByAnimalType(animalTypeChoiceBox.getValue(), null, null, null);
        animalsObservableList.addAll(animals.getContent());
    }

    /**
     * Gets all hospitals.
     */
    protected void getAllHospitals() {
        Page<Hospital> hospitals = hospitalService.findAllHospitals(null, null, null);
        if (CollectionUtils.isNotEmpty(hospitals.getContent())) {
            hospital = IterableUtils.first(hospitals);
            hospitalBookingLabel.setText(hospital.getHospitalName() + " Booking");
        }
    }

    /**
     * Show validation error dialog.
     *
     * @param message the message
     */
    protected void showValidationErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);

        Optional<ButtonType> result = alert.showAndWait();
    }

    /**
     * Validate hospital booking item and add.
     */
    @FXML
    protected void validateHospitalBookingItemAndAdd() {
        boolean isError = true;
        String message = "Error in details";
        Animal animal = animalChoiceBox.getSelectionModel().getSelectedItem();
        String reason = reasonTextArea.getText();
        String animalName = animalNameTextField.getText();
        if (animal == null) {
            message = "Please select animal";
        } else if (StringUtils.isEmpty(reason)) {
            message = "Please provide reason for animal";
        } else if (StringUtils.isEmpty(animalName)) {
            message = "Please provide animal name";
        } else {
            isError = false;
        }
        if (isError) {
            showValidationErrorDialog(message);
        } else {
            addHospitalBookingItem();
        }
    }

    /**
     * Validate and confirm hospital booking.
     */
    @FXML
    protected void validateAndConfirmHospitalBooking() {
        LocalDateTime startTime = getLocalDateTimeFromPickers(startDatePicker, startTimeHourSpinner, startTimeMinuteSpinner);
        String holderFirstNameText = holderFirstName.getText();
        String holderLastNameText = holderLastName.getText();
        String holderAddressText = holderAddress.getText();
        boolean isError = true;
        String message = "Error in details";
        if (startTime == null) {
            message = "Start time cannot be empty";
        }  else if (startTime.isBefore(LocalDateTime.now())) {
            message = "Start time should be in future date";
        } else if (CollectionUtils.isEmpty(hospitalBookingItems)) {
            message = "You should add atleast one animal";
        } else if (StringUtils.isEmpty(holderFirstNameText)) {
            message = "Holder first name should not be empty";
        } else if (StringUtils.isEmpty(holderLastNameText)) {
            message = "Holder last name should not be empty";
        } else if (StringUtils.isEmpty(holderAddressText)) {
            message = "Holder address should not be empty";
        } else {
            isError = false;
        }
        if (isError) {
            showValidationErrorDialog(message);
        } else {
            confirmHospitalBooking();

        }
    }

    /**
     * Confirm hospital booking.
     */
    @FXML
    protected void confirmHospitalBooking() {
        // Create a Confirmation Alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Do you want to proceed with booking?");

        // Show the alert and wait for a response
        Optional<ButtonType> result = alert.showAndWait();
        // Check the user's response
        if (result.isPresent() && result.get() == ButtonType.OK) {
            createHospitalBooking();
        }

    }

    /**
     * Create hospital booking.
     */
    @FXML
    protected void createHospitalBooking() {

        HospitalBooking hospitalBooking = HospitalBooking.HospitalBookingBuilder.aHospitalBooking()
                .withHospital(hospital)
                .withHolderFirstName(holderFirstName.getText())
                .withHolderLastName(holderLastName.getText())
                .withHolderAddress(holderAddress.getText())
                .withCustomer(accountManager.getCurrentCustomer())
                .withStartTime(getLocalDateTimeFromPickers(startDatePicker, startTimeHourSpinner, startTimeMinuteSpinner))
                .build();

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

    /**
     * Add hospital booking item.
     */
    @FXML
    protected void addHospitalBookingItem() {
        boolean needsAdditionalAssistantValue = needsAdditionalAssistant.isSelected();
        boolean longDistanceValue = longDistance.isSelected();
        boolean additionalSurChargeValue = additionalSurCharge.isSelected();
        Animal animal = animalChoiceBox.getSelectionModel().getSelectedItem();
        String reason = reasonTextArea.getText();
        String animalName = animalNameTextField.getText();
        HospitalBookingItem hospitalBookingItem =
                HospitalBookingItem.HospitalBookingItemBuilder.aHospitalBookingItem()
                        .withAnimal(animal)
                        .withAnimalName(animalName)
                        .withReason(reason)
                        .withLongDistance(longDistanceValue)
                        .withAdditionalSurCharge(additionalSurChargeValue)
                        .withNeedsAdditionalAssistant(needsAdditionalAssistantValue)
                        .build();
        hospitalBookingItemObservableList.add(hospitalBookingItem);
        hospitalBookingItems.add(hospitalBookingItem);

        clearItemForm();
    }

    /**
     * Clear item form.
     */
    protected void clearItemForm() {
        longDistance.setSelected(false);
        additionalSurCharge.setSelected(false);
        animalChoiceBox.setValue(null);
        needsAdditionalAssistant.setSelected(false);
        reasonTextArea.setText(null);
    }

    /**
     * Initialize default hospital.
     */
    public void initializeDefaultHospital() {
        Page<Hospital> hospitals = hospitalService.findAllHospitals(null, null, null);

    }

}
