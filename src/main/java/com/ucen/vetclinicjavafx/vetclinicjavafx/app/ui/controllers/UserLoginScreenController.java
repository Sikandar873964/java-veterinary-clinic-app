package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories.AccountManager;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.CustomerService;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class UserLoginScreenController extends BaseViewController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountManager accountManager;

    @FXML
    protected TextField emailId;

    public void initialize() {
        emailId.setText("test@gmail.com");
    }

    @FXML
    public void setUserAccountAndLogin() {
        String email = emailId.getText();
        Customer customer = customerService.getOrCreateCustomerByEmailId(email);
        accountManager.setCurrentCustomer(customer);
    }

}
