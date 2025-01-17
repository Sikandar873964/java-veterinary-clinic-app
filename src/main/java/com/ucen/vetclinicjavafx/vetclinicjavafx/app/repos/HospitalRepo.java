package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Hospital repo.
 */
@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Long> {

}
