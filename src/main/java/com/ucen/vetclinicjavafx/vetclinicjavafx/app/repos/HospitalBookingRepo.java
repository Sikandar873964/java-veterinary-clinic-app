package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Customer;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBooking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalBookingRepo extends JpaRepository<HospitalBooking, Long> {

    Page<HospitalBooking> getByHospital(Hospital hospital, Pageable pageable);

    Page<HospitalBooking> getByCustomer(Customer customer, Pageable pageable);
}
