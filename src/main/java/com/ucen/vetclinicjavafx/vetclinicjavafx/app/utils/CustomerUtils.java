package com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtils {

    public Customer createCustomerObject(String emailId){
        Customer customer=new Customer();
        customer.setEmailId(emailId);

        return customer;
    }
}
