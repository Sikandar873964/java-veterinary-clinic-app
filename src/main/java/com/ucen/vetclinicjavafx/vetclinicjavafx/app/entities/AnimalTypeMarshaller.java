package com.ucen.vetclinicjavafx.vetclinicjavafx.app.entities;

import jakarta.persistence.AttributeConverter;

/**
 * The type Animal type marshaller.
 */
public class AnimalTypeMarshaller implements AttributeConverter<AnimalType, String> {

    @Override
    public String convertToDatabaseColumn(AnimalType arg0) {
        return arg0.name();
    }

    @Override
    public AnimalType convertToEntityAttribute(String arg0) {
        return AnimalType.valueOf(arg0);
    }
}
