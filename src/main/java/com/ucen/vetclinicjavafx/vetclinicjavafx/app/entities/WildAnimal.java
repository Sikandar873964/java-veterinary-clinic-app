package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * The type Wild animal.
 */
@Entity
@DiscriminatorValue("WILD")
public class WildAnimal extends Animal{

    /**
     * Instantiates a new Wild animal.
     */
    public WildAnimal() {
        setAnimalType(AnimalType.WILD);
    }

    @Override
    public Long getPrice() {
        return 40l;
    }
}
