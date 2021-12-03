package br.com.desfio.projuris.utils;

import java.util.Optional;

import javax.persistence.AttributeConverter;

public class BooleanAttributeConverter implements AttributeConverter<Boolean, Character> {
    
    @Override
    public Character convertToDatabaseColumn(Boolean aBoolean) {
        return Optional.ofNullable(aBoolean)
            .map(value -> value ? 'S' : 'N')
            .orElse('N');
    }
    
    @Override
    public Boolean convertToEntityAttribute(Character character) {
        return Optional.ofNullable(character)
            .map(value -> value == 'S')
            .orElse(false);
    }
}

