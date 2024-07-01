package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.HospitalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.HospitalUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


/**
 * The type Create hospital screen controller.
 */
@Component
@FxmlView
public class CreateHospitalScreenController extends BaseViewController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalUtils hospitalUtils;

    @FXML
    private Spinner<Integer> startTimeHourSpinner;
    @FXML
    private Spinner<Integer> startTimeMinuteSpinner;

    @FXML
    private Spinner<Integer> endTimeHourSpinner;
    @FXML
    private Spinner<Integer> endTimeMinuteSpinner;
    @FXML
    private TextField hospitalDescription;
    @FXML
    private TextField hospitalName;

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

        SpinnerValueFactory<Integer> endTimeHourFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, LocalTime.now().getHour());
        endTimeHourSpinner.setValueFactory(endTimeHourFactory);

        // Initialize the minute spinner (0-59)
        SpinnerValueFactory<Integer> endTimeMinuteFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, LocalTime.now().getMinute());
        endTimeMinuteSpinner.setValueFactory(endTimeMinuteFactory);

    }

    /**
     * Create hospital.
     */
    @FXML
    protected void createHospital() {
        Hospital hospital = hospitalUtils.createHospital(hospitalName.getText(), hospitalDescription.getText(),
                getLocalTimeFromPickers(startTimeHourSpinner, startTimeMinuteSpinner),
                getLocalTimeFromPickers(endTimeHourSpinner, endTimeMinuteSpinner));
        hospital = hospitalService.createHospital(hospital);

        stageManager.changeScene(stageManager.getControllerScene(AllHospitalsScreenController.class));
    }

    private LocalTime getLocalTimeFromPickers(Spinner<Integer> hourSpinner,
                                              Spinner<Integer> minuteSpinner) {
        int hour = hourSpinner.getValue();
        int minute = minuteSpinner.getValue();


        return LocalTime.of(hour, minute);


    }
}
