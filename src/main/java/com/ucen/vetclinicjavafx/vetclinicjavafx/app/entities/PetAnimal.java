package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * The type Pet animal.
 */
@Entity
@DiscriminatorValue("PET")
public class PetAnimal extends Animal{

    /**
     * Instantiates a new Pet animal.
     */
    public PetAnimal() {
        setAnimalType(AnimalType.PET);
    }

    @Override
    public Long getPrice() {
        return 15l;
    }
}
