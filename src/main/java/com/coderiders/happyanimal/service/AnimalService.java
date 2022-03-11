package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.exceptions.NotFoundException;
import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.AnimalMapper;
import com.coderiders.happyanimal.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final AnimalMapper animalMapper;
    private final TaskMapper taskMapper;
    private static final String ERROR_MESSAGE_NOT_FOUND = "Зверь не найден";

    @Autowired
    public AnimalService(AnimalRepository animalRepository,
                         UserRepository userRepository,
                         AnimalMapper animalMapper,
                         TaskMapper taskMapper) {
        this.animalRepository = animalRepository;
        this.userRepository = userRepository;
        this.animalMapper = animalMapper;
        this.taskMapper = taskMapper;
    }

    @Transactional
    public void saveAnimal(AnimalDto animalDto, Long userId) {
        Animal animal = animalMapper.toAnimal(animalDto);
        animal.setUser(Optional.ofNullable(userRepository.getById(userId)).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND)));
        animalRepository.save(animal);
    }

    @Transactional
    public List<AnimalDto> getAllByUserId(Long userId) {
        return animalMapper.toDtoList(
                animalRepository.findAllByUser(Optional.ofNullable(userRepository.getById(userId)).orElseThrow(
                        () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND))));
    }

    @Transactional
    public List<AnimalDto> getAll() {
        return animalMapper.toDtoList(Optional.ofNullable(animalRepository.findAll()).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND)));
    }

    @Transactional
    public List<TaskRsDto> getAnimalTasks(Long animalId) {
        return taskMapper.mapTaskListToRsDto(
                Optional.ofNullable(Optional.ofNullable(getById(animalId)).orElseThrow(
                        () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND)
                ).getTasks()).orElseThrow(
                        () -> new NotFoundException("Задач для этого животного не существует")
                )
        );
    }

    @Transactional
    public Animal getById(Long id) {
        return animalRepository.findFirstById(id).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND));
    }
}
