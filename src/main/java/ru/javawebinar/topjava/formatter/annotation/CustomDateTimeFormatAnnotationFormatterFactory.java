package ru.javawebinar.topjava.formatter.annotation;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;
import ru.javawebinar.topjava.formatter.CustomDateFormatter;
import ru.javawebinar.topjava.formatter.CustomTimeFormatter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CustomDateTimeFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<CustomDateTimeFormat> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<>(List.of(LocalDate.class, LocalTime.class));
    }

    @Override
    public Printer<?> getPrinter(CustomDateTimeFormat annotation, Class<?> fieldType) {
        return getFormatter(annotation, fieldType);
    }

    @Override
    public Parser<?> getParser(CustomDateTimeFormat annotation, Class<?> fieldType) {
        return getFormatter(annotation, fieldType);
    }

    private Formatter<?> getFormatter(CustomDateTimeFormat annotation, Class<?> fieldType) {
        switch (annotation.type()) {
            case DATE -> {
                CustomDateFormatter n = new CustomDateFormatter();
                return n;
            }
            case TIME -> {
                CustomTimeFormatter t = new CustomTimeFormatter();
                return t;
            }
        }
        return null;
    }
}