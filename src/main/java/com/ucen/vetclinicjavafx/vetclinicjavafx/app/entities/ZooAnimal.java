package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * The type Zoo animal.
 */
@Entity
@DiscriminatorValue("ZOO")
public class ZooAnimal extends Animal{

    /**
     * Instantiates a new Zoo animal.
     */
    public ZooAnimal() {
        setAnimalType(AnimalType.ZOO);
    }

    @Override
    public Long getPrice() {
        return 30l;
    }
}
