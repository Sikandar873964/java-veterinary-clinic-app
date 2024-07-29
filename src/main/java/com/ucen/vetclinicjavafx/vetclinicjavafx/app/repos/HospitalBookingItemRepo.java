package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBooking;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBookingItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Hospital booking item repo.
 */
@Repository
public interface HospitalBookingItemRepo extends JpaRepository<HospitalBookingItem, Long> {

    /**
     * Gets hospital booking item by hospital booking.
     *
     * @param hospitalBooking the hospital booking
     * @param pageable        the pageable
     * @return the hospital booking item by hospital booking
     */
    List<HospitalBookingItem> getHospitalBookingItemByHospitalBooking(HospitalBooking hospitalBooking, Pageable pageable);

}

