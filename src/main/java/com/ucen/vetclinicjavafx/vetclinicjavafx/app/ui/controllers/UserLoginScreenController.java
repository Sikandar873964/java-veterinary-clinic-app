package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.CustomerService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AccountManager accountManager;

    /**
     * The Email id.
     */
    @FXML
    protected TextField emailId;

    /**
     * Initialize.
     */
    public void initialize() {
        emailId.setText("test@gmail.com");
    }


    /**
     * Sets user account and login.
     */
    @FXML
    public void setUserAccountAndLogin() {
        String email = emailId.getText();
        Customer customer = customerService.getOrCreateCustomerByEmailId(email);
        accountManager.setCurrentCustomer(customer);
        stageManager.changeScene(stageManager.getControllerScene(AllHospitalsScreenController.class));
    }


}
