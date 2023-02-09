package com.pet.clinic.formatters;

import com.pet.clinic.model.PetType;
import com.pet.clinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        return petTypeService.findAll().stream().filter(type -> type.getName().equals(text)).findFirst().orElse(null);
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}
