package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * The type Animal.
 */
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


    /**
     * Gets animal id.
     *
     * @return the animal id
     */
    public Long getAnimalId() {
        return animalId;
    }

    /**
     * Sets animal id.
     *
     * @param animalId the animal id
     */
    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    /**
     * Gets animal name.
     *
     * @return the animal name
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * Sets animal name.
     *
     * @param animalName the animal name
     */
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    /**
     * Gets animal category.
     *
     * @return the animal category
     */
    public String getAnimalCategory() {
        return animalCategory;
    }

    /**
     * Sets animal category.
     *
     * @param animalCategory the animal category
     */
    public void setAnimalCategory(String animalCategory) {
        this.animalCategory = animalCategory;
    }

    /**
     * Gets dangerous level.
     *
     * @return the dangerous level
     */
    public String getDangerousLevel() {
        return dangerousLevel;
    }

    /**
     * Sets dangerous level.
     *
     * @param dangerousLevel the dangerous level
     */
    public void setDangerousLevel(String dangerousLevel) {
        this.dangerousLevel = dangerousLevel;
    }

    /**
     * Gets created time.
     *
     * @return the created time
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets created time.
     *
     * @param createdTime the created time
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Gets last updated time.
     *
     * @return the last updated time
     */
    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * Sets last updated time.
     *
     * @param lastUpdatedTime the last updated time
     */
    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    /**
     * Gets animal type.
     *
     * @return the animal type
     */
    public AnimalType getAnimalType() {
        return animalType;
    }

    /**
     * Sets animal type.
     *
     * @param animalType the animal type
     */
    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    /**
     * Get price long.
     *
     * @return the long
     */
    public Long getPrice(){
        return 24l;
    }
}

