package com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Animal;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.AnimalType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Animal repo.
 */
@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {

    /**
     * Gets by animal type.
     *
     * @param animalType the animal type
     * @param pageable   the pageable
     * @return the by animal type
     */
    Page<Animal> getByAnimalType(AnimalType animalType, Pageable pageable);
}


