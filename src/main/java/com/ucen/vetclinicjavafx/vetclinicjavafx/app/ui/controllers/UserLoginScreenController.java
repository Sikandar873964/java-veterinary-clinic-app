package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.CustomerService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.HospitalService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * The type User login screen controller.
 */
@Component
@FxmlView
public class UserLoginScreenController extends BaseViewController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private AccountManager accountManager;

    /**
     * The Email id.
     */
    @FXML
    protected TextField emailId;
    /**
     * The Hospital name label.
     */
    @FXML
    protected Label hospitalNameLabel;

    /**
     * Initialize.
     */
    public void initialize() {
        emailId.setText("test@gmail.com");
        initializeDefaultHospital();
    }

    /**
     * Sets user account and login.
     */
    @FXML
    public void setUserAccountAndLogin() {
        String email = emailId.getText();
        Customer customer = customerService.getOrCreateCustomerByEmailId(email);
        accountManager.setCurrentCustomer(customer);
        stageManager.changeScene(stageManager.getControllerScene(MyBookingsScreenController.class));
    }

    /**
     * Navigate to create hospital screen.
     */
    @FXML
    public void navigateToCreateHospitalScreen() {
        stageManager.changeScene(stageManager.getControllerScene(CreateHospitalScreenController.class));
    }

    /**
     * Navigate to create animal screen.
     */
    @FXML
    public void navigateToCreateAnimalScreen() {
        stageManager.changeScene(stageManager.getControllerScene(CreateAnimalScreenController.class));
    }

    /**
     * Initialize default hospital.
     */
    public void initializeDefaultHospital() {
        Page<Hospital> hospitals = hospitalService.findAllHospitals(null, null, null);
        if (CollectionUtils.isNotEmpty(hospitals.getContent())) {
            hospitalNameLabel.setText(IterableUtils.first(hospitals.getContent()).getHospitalName()+" Login");
        }
    }
}
