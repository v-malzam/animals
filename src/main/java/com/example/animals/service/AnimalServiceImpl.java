package com.example.animals.service;

import com.example.animals.model.Animal;
import com.example.animals.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements BaseService<Animal> {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal create(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void deleteById(int id) {
        animalRepository.deleteById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getById(int id) {
        return animalRepository.findById(id).get();
    }

    @Override
    public boolean existsById(int id) {
        return animalRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return animalRepository.existsByName(name);
    }

}
