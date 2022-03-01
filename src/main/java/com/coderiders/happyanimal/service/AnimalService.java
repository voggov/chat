package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public Animal getById(Long id) {
        return animalRepository.findFirstById(id);
    }


}
