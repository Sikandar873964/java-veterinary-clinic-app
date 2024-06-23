package com.ucen.vetclinicjavafx.vetclinicjavafx.app.services;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.Animal;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.repos.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AnimalService extends AbstractService {
    @Autowired
    private AnimalRepo animalRepo;

    public Animal createAnimal(Animal animal) {
        return animalRepo.save(animal);
    }

    public Animal getAnimal(Long id) {
        return animalRepo.getReferenceById(id);
    }

    public void updateAnimal(Animal animal) {
        animalRepo.save(animal);
    }

    public Page<Animal> findAllAnimals(Integer page, Integer pageSize, Sort.Direction direction, String... properties) {
        return animalRepo.findAll(createPageableRequest(page, pageSize, direction, String.valueOf(properties)));
    }
}

