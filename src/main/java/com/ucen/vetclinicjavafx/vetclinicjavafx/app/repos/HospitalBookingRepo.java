package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBooking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Hospital booking repo.
 */
@Repository
public interface HospitalBookingRepo extends JpaRepository<HospitalBooking, Long> {

    /**
     * Gets by hospital.
     *
     * @param hospital the hospital
     * @param pageable the pageable
     * @return the by hospital
     */
    Page<HospitalBooking> getByHospital(Hospital hospital, Pageable pageable);

    /**
     * Gets by customer.
     *
     * @param customer the customer
     * @param pageable the pageable
     * @return the by customer
     */
    Page<HospitalBooking> getByCustomer(Customer customer, Pageable pageable);
}

