package com.example.animals.validation.impl;

import com.example.animals.validation.Enum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidator implements ConstraintValidator<Enum, CharSequence> {
    private List<String> acceptedValues;

    @Override
    public void initialize(Enum annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(java.lang.Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return acceptedValues.contains(value.toString());
    }
}
