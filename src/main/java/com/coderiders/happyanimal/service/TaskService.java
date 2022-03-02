package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Task;
import com.coderiders.happyanimal.model.dto.TaskDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.repository.TaskRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private AnimalRepository animalRepository;
    private TaskMapper mapper;

    @Transactional
    public void saveTask(TaskDto taskDto) {
        taskRepository.save(mapper.mapToTask(taskDto));
    }

    @Transactional
    public List<TaskDto> getAll() {
        return mapper.mapTaskListToDto(taskRepository.findAll());
    }

    @Transactional
    public List<List<TaskDto>> getByUserId(Long userId) {
        List<List<TaskDto>> taskSuperList = new ArrayList<>();
        animalRepository.findAllByUser(userRepository.getById(userId))
                .forEach(animal -> taskSuperList.add(mapper.mapTaskListToDto(animal.getTasks())));
        return taskSuperList;
    }
}
