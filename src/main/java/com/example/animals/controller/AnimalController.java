package com.example.animals.controller;

import com.example.animals.model.Animal;
import com.example.animals.service.BaseService;
import com.example.animals.validation.annotation.IdExistsInDb;
import com.example.animals.validation.group.Create;
import com.example.animals.validation.group.Update;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("animal")
@Validated
public class AnimalController {

    private final BaseService<Animal> animalService;

    public AnimalController(BaseService<Animal> animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAll() {
        return animalService.getAll();
    }

    @GetMapping("{id}")
    public Animal getById(
            @IdExistsInDb
            @PathVariable Integer id) {
        return animalService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal add(@Validated(Create.class) @RequestBody Animal animal) {
        return animalService.create(animal);
    }

    @PutMapping
    public Animal update(@Validated(Update.class) @RequestBody Animal animal) {
        return animalService.update(animal);
    }

    @DeleteMapping("{id}")
    public void delete(
            @IdExistsInDb
            @PathVariable Integer id) {
        animalService.deleteById(id);
    }

}
