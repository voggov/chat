package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.service.mapper.AnimalMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService {
    private AnimalRepository animalRepository;
    private AnimalMapper mapper;

    @Transactional
    public AnimalDto saveAnimal(AnimalDto animalDto, Long userId) {
        Animal animal = mapper.toAnimal(animalDto, userId);
        animalRepository.save(animal);
        return mapper.toDto(animalRepository.findFirstById(animal.getId()));
    }

    @Transactional
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public Animal getById(Long id) {
        return animalRepository.findFirstById(id);
    }


}
