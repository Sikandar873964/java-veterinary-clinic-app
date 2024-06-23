package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FARM_ANIMAL")
public class FarmAnimal extends Animal{

    public FarmAnimal() {
        setAnimalType(AnimalType.FARM_ANIMAL);
    }
}
