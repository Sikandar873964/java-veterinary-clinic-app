package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ZOO")
public class ZooAnimal extends Animal{

    public ZooAnimal() {
        setAnimalType(AnimalType.ZOO);
    }

    @Override
    public Long getPrice() {
        return 30l;
    }
}
