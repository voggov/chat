package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.exceptions.NotFoundException;
import com.coderiders.happyanimal.mapper.AnimalMapper;
import com.coderiders.happyanimal.mapper.TaskMapper;
import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.Task;
import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final AnimalMapper animalMapper;
    private final TaskMapper taskMapper;
    private static final String ERROR_MESSAGE_NOT_FOUND_ANIMAL = "Зверь не найден";
    private static final String ERROR_MESSAGE_NOT_FOUND_USER = "Пользователь не найден";
    private static final String ERROR_MESSAGE_NOT_FOUND_TASKS = "Задач для этого животного не существует";

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
    public AnimalDto saveAnimal(AnimalDto animalDto, Long userId) {
        Animal animal = animalMapper.mapToAnimal(animalDto);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_USER));
        animal.setUser(user);
        return animalMapper.mapToDto(animalRepository.save(animal));
    }

    @Transactional
    public Page<AnimalDto> getAllByUserId(Long userId, Pageable pageable) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL));
        Page<Animal> allByUser = animalRepository.findAllByUser(user, pageable);
        if (allByUser.isEmpty()) {
            throw new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL);
        }
        return allByUser.map(animalMapper::mapToDto);
    }

    @Transactional
    public Page<AnimalDto> getAll(Pageable pageable) {
        Page<Animal> allAnimals = animalRepository.findAll(pageable);
        return allAnimals.map(animalMapper::mapToDto);
    }

    @Transactional
    public Page<TaskRsDto> getAnimalAllTasks(Long animalId, Pageable pageable) {
        Animal animal = getById(animalId);
        List<Task> taskList = animal.getTasks();
        return new PageImpl<>(taskList.stream()
                .map(taskMapper::mapToRsDto)
                .collect(Collectors.toList()),
                pageable, pageable.getOffset());
    }

    @Transactional
    public Animal getById(Long id) {
        return animalRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL));
    }
}
