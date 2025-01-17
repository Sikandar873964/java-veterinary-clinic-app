package com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities.*;
import org.springframework.stereotype.Component;

/**
 * The type Animal utils.
 */
@Component
public class AnimalUtils {

    /**
     * Create animal object animal.
     *
     * @param animalName the animal name
     * @param animalType the animal type
     * @return the animal
     */
    public Animal createAnimalObject(String animalName, AnimalType animalType) {
        Animal animal;
        switch (animalType) {
            case PET:
                animal = new PetAnimal();
                break;
            case ZOO:
                animal = new ZooAnimal();
                break;
            case WILD:
                animal = new WildAnimal();
                break;
            case FARM_ANIMAL:
                animal = new FarmAnimal();
                break;
            default:
                throw new RuntimeException("unknown animal type " + animalType);
        }
        animal.setAnimalName(animalName);
        return animal;
    }
}
