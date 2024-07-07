package com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import org.springframework.stereotype.Component;

/**
 * The type Customer utils.
 */
@Component
public class CustomerUtils {

    /**
     * Create customer object customer.
     *
     * @param emailId the email id
     * @return the customer
     */
    public Customer createCustomerObject(String emailId){
        Customer customer=new Customer();
        customer.setEmailId(emailId);

        return customer;
    }
}
