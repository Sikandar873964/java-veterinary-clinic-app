package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.HospitalBookingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Hospital booking item repo.
 */
@Repository
public interface HospitalBookingItemRepo extends JpaRepository<HospitalBookingItem, Long> {


}

