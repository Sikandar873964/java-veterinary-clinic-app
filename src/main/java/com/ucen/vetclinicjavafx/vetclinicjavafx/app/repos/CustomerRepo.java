package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer getByEmailIdIgnoreCase(String emailId);
}

