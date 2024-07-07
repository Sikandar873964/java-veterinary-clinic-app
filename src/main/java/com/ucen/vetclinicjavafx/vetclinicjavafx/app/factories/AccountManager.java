package com.ucen.vetclinicjavafx.vetclinicjavafx.app.factories;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import org.springframework.stereotype.Component;

/**
 * The type Account manager.
 */
@Component
public class AccountManager {
    private Customer currentCustomer;
    private Hospital currentHospital;

    /**
     * Gets current customer.
     *
     * @return the current customer
     */
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    /**
     * Sets current customer.
     *
     * @param currentCustomer the current customer
     */
    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    /**
     * Gets current hospital.
     *
     * @return the current hospital
     */
    public Hospital getCurrentHospital() {
        return currentHospital;
    }

    /**
     * Sets current hospital.
     *
     * @param currentHospital the current hospital
     */
    public void setCurrentHospital(Hospital currentHospital) {
        this.currentHospital = currentHospital;
    }
}
