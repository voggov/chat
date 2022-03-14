package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.exceptions.NotFoundException;
import com.coderiders.happyanimal.model.dto.TaskRqDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.repository.TaskRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.TaskMapper;
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
    public void saveTask(TaskRqDto taskDto) {
        taskRepository.save(taskMapper.mapToTask(taskDto));
    }

    @Transactional
    public List<TaskRqDto> getAll() {
        return taskMapper.mapTaskListToRqDto(Optional.ofNullable(taskRepository.findAll()).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_TASK)));
    }

    @Transactional
    public List<List<TaskRqDto>> getByUserId(Long userId) {
        return Optional.ofNullable(animalRepository.findAllByUser(Optional.ofNullable(userRepository.getById(userId)).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_USER)))).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_ANIMAL))
                .stream()
                .map(animal -> Optional.ofNullable(taskMapper.mapTaskListToRqDto(animal.getTasks())).orElseThrow(
                        () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_TASK)))
                .collect(Collectors.toList());
    }
}
