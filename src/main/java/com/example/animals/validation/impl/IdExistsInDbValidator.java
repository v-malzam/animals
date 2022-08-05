package com.example.animals.validation.impl;

import com.example.animals.model.Animal;
import com.example.animals.service.BaseService;
import com.example.animals.validation.IdExistsInDb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdExistsInDbValidator implements ConstraintValidator<IdExistsInDb, Integer> {

    private final BaseService<Animal> animalService;

    public IdExistsInDbValidator(BaseService<Animal> animalService) {
        this.animalService = animalService;
    }

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {
        if (id == null)
            return true;
        else
            return animalService.existsById(id);
    }
}
