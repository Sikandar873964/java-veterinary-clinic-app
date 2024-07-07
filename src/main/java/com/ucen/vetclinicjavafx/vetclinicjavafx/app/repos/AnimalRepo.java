package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Animal repo.
 */
@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {

}


