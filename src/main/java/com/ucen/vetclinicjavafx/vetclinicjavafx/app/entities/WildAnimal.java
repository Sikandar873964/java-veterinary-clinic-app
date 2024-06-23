package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("WILD")
public class WildAnimal extends Animal{

    public WildAnimal() {
        setAnimalType(AnimalType.WILD);
    }

    @Override
    public Long getPrice() {
        return 30l;
    }
}
