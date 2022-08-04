package com.example.animals.validation.validator;

import com.example.animals.model.Animal;
import com.example.animals.service.BaseService;
import com.example.animals.validation.annotation.DoubleNameInDb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleNameInDbValidator implements ConstraintValidator<DoubleNameInDb, String> {

    private final BaseService<Animal> animalService;

    public DoubleNameInDbValidator(BaseService<Animal> animalService) {
        this.animalService = animalService;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name == null)
            return true;
        else
            return !animalService.existsByName(name);
    }
}
