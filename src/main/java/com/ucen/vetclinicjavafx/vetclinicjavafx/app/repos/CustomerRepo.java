package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Customer repo.
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    /**
     * Gets by email id ignore case.
     *
     * @param emailId the email id
     * @return the by email id ignore case
     */
    Customer getByEmailIdIgnoreCase(String emailId);
}

