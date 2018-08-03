package ua.antonio.spring4sample.utils;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_DATE;

public class LocalDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setValue(LocalDate.parse(text, ISO_DATE));
    }

}
