package com.ucen.vetclinicjavafx.vetclinicjavafx.app.services;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos.CustomerRepo;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * The type Customer service.
 */
@Service
public class CustomerService extends AbstractService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerUtils customerUtils;

    /**
     * Create customer customer.
     *
     * @param customer the customer
     * @return the customer
     */
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    /**
     * Gets customer.
     *
     * @param id the id
     * @return the customer
     */
    public Customer getCustomer(Long id) {
        return customerRepo.getReferenceById(id);
    }

    /**
     * Update customer.
     *
     * @param customer the customer
     */
    public void updateCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    /**
     * Find all customers page.
     *
     * @param page       the page
     * @param pageSize   the page size
     * @param direction  the direction
     * @param properties the properties
     * @return the page
     */
    public Page<Customer> findAllCustomers(int page, int pageSize, Sort.Direction direction, String... properties) {
        return customerRepo.findAll(createPageableRequest(page, pageSize, direction, properties));
    }

    /**
     * Gets or create customer by email id.
     *
     * @param emailId the email id
     * @return the or create customer by email id
     */
    public Customer getOrCreateCustomerByEmailId(String emailId) {
        Customer customer = customerRepo.getByEmailIdIgnoreCase(emailId);
        if (customer == null) {
            customer = customerUtils.createCustomerObject(emailId);
            customer = createCustomer(customer);
        }
        return customer;
    }
}


