package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity(name = "animals")
@DiscriminatorColumn(name = "animal_type", discriminatorType = DiscriminatorType.STRING)
public class Animal {
    @Id
    @GeneratedValue
    @Column(name = "animal_id")
    private Long animalId;
    private String animalName;
    private String animalCategory;
    private String dangerousLevel;
    @Column(name = "animal_type", insertable = false, updatable = false)
    @Convert(converter = AnimalTypeMarshaller.class)
    private AnimalType animalType;
    @CreatedDate
    private LocalDateTime createdTime;
    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;


    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(String animalCategory) {
        this.animalCategory = animalCategory;
    }

    public String getDangerousLevel() {
        return dangerousLevel;
    }

    public void setDangerousLevel(String dangerousLevel) {
        this.dangerousLevel = dangerousLevel;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public Long getPrice(){
        return 10l;
    }
}

