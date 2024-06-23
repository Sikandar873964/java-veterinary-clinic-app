package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PET")
public class PetAnimal extends Animal{

    public PetAnimal() {
        setAnimalType(AnimalType.PET);
    }

    @Override
    public Long getPrice() {
        return 15l;
    }
}
