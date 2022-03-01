package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.repository.UserRepository;
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
    private UserRepository userRepository;
    private AnimalMapper mapper;

    @Transactional
    public AnimalDto saveAnimal(AnimalDto animalDto, Long userId) {
        Animal animal = mapper.toAnimal(animalDto, userId);
        animalRepository.save(animal);
        return mapper.toDto(animalRepository.findFirstById(animal.getId()).orElse(null));
    }

    @Transactional
    public List<AnimalDto> getAllByUserId(Long userId) {
        List<Animal> found = animalRepository.findAllByUser(userRepository.getById(userId));
        return mapper.toDtoList(found);
    }

    @Transactional
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public Animal getById(Long id) {
        return animalRepository.findFirstById(id).orElse(null);
    }
}
