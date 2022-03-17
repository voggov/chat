package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.exceptions.NotFoundException;
import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.Task;
import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.TaskRqDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.repository.TaskRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;
    private final TaskMapper taskMapper;
    private static final String ERROR_MESSAGE_NOT_FOUND_TASK = "Задачка не найдена";
    private static final String ERROR_MESSAGE_NOT_FOUND_ANIMAL = "Зверь не найден";
    private static final String ERROR_MESSAGE_NOT_FOUND_USER = "Пользователь не найден";

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository, AnimalRepository animalRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.animalRepository = animalRepository;
        this.taskMapper = taskMapper;
    }

    @Transactional
    public TaskRsDto saveTask(TaskRqDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        return taskMapper.toRsDto(taskRepository.save(task));
    }

    @Transactional
    public List<TaskRqDto> getAll() {
        List<Task> allTasks = Optional.ofNullable(taskRepository.findAll()).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_TASK));
        return taskMapper.mapTaskListToRqDto(allTasks);
    }

    @Transactional
    public List<List<TaskRqDto>> getByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_USER));
        List<Animal> animals = Optional.ofNullable(animalRepository.findAllByUser(user)).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL));
        return animals
                .stream()
                .map(animal -> {
                    List<Task> taskList = Optional.ofNullable(animal.getTasks()).orElseThrow(
                            () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_TASK));
                    return taskMapper.mapTaskListToRqDto(taskList);
                })
                .collect(Collectors.toList());
    }
}