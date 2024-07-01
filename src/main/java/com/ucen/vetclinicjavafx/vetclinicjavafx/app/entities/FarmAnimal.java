package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * The type Farm animal.
 */
@Entity
@DiscriminatorValue("FARM_ANIMAL")
public class FarmAnimal extends Animal{

    /**
     * Instantiates a new Farm animal.
     */
    public FarmAnimal() {
        setAnimalType(AnimalType.FARM_ANIMAL);
    }
}
