package com.ucen.vetclinicjavafx.vetclinicjavafx.app.services;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Animal;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * The type Animal service.
 */
@Service
public class AnimalService extends AbstractService {
    @Autowired
    private AnimalRepo animalRepo;

    /**
     * Create animal animal.
     *
     * @param animal the animal
     * @return the animal
     */
    public Animal createAnimal(Animal animal) {
        return animalRepo.save(animal);
    }

    /**
     * Gets animal.
     *
     * @param id the id
     * @return the animal
     */
    public Animal getAnimal(Long id) {
        return animalRepo.getReferenceById(id);
    }

    /**
     * Update animal.
     *
     * @param animal the animal
     */
    public void updateAnimal(Animal animal) {
        animalRepo.save(animal);
    }

    /**
     * Find all animals page.
     *
     * @param page       the page
     * @param pageSize   the page size
     * @param direction  the direction
     * @param properties the properties
     * @return the page
     */
    public Page<Animal> findAllAnimals(Integer page, Integer pageSize, Sort.Direction direction, String... properties) {
        return animalRepo.findAll(createPageableRequest(page, pageSize, direction, String.valueOf(properties)));
    }
}

