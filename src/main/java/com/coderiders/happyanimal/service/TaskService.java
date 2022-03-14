package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.dto.TaskRqDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.repository.TaskRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;
    private final TaskMapper taskMapper;

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
        return taskMapper.mapTaskListToRqDto(taskRepository.findAll());
    }

    @Transactional
    public List<List<TaskRqDto>> getByUserId(Long userId) {
        return animalRepository.findAllByUser(userRepository.getById(userId))
                .stream()
                .map(animal -> taskMapper.mapTaskListToRqDto(animal.getTasks()))
                .collect(Collectors.toList());
    }

}
