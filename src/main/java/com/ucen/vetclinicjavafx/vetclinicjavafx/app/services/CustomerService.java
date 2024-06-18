package com.ucen.vetclinicjavafx.vetclinicjavafx.app.services;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos.CustomerRepo;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerUtils customerUtils;

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepo.getReferenceById(id);
    }

    public void updateCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public Page<Customer> findAllCustomers(int page, int pageSize, Sort.Direction direction, String... properties) {
        return customerRepo.findAll(createPageableRequest(page, pageSize, direction, properties));
    }

    public Customer getOrCreateCustomerByEmailId(String emailId) {
        Customer customer = customerRepo.getByEmailIdIgnoreCase(emailId);
        if (customer == null) {
            customer = customerUtils.createCustomerObject(emailId);
            customer = createCustomer(customer);
        }
        return customer;
    }
}


