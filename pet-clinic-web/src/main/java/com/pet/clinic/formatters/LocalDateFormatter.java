package com.pet.clinic.formatters;

import com.pet.clinic.model.PetType;
import com.pet.clinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        if(StringUtils.isEmpty(text))
            return null;
        return LocalDate.parse(text,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return object==null?"":object.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
