package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.exceptions.NotFoundException;
import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.Task;
import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.mapper.AnimalMapper;
import com.coderiders.happyanimal.mapper.TaskMapper;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
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
        Animal animal = animalMapper.toAnimal(animalDto);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_USER));
        animal.setUser(user);
        return animalMapper.toDto(animalRepository.save(animal));
    }

    @Transactional
    public List<AnimalDto> getAllByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL));
        List<Animal> allByUser = Optional.ofNullable(animalRepository.findAllByUser(user)).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL));
        return animalMapper.toDtoList(allByUser);
    }

    @Transactional
    public List<AnimalDto> getAll() {
        List<Animal> allAnimals = Optional.ofNullable(animalRepository.findAll()).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL));
        return animalMapper.toDtoList(allAnimals);
    }

    @Transactional
    public List<TaskRsDto> getAnimalTasks(Long animalId) {
        Animal animal = getById(animalId);
        List<Task> taskList = Optional.ofNullable(animal.getTasks()).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_TASKS));
        return taskMapper.mapTaskListToRsDto(taskList);
    }

    @Transactional
    public Animal getById(Long id) {
        return animalRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL));
    }
}
