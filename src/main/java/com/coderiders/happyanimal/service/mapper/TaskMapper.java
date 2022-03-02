package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.Task;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.model.dto.TaskDto;
import com.coderiders.happyanimal.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class TaskMapper {
    private TaskRepository taskRepository;
    private AnimalMapper animalMapper;

    public TaskDto mapToDto(Task task) {
        return TaskDto.builder()
                .type(task.getType())
                .dateTime(task.getDateTime())
                .state(task.getState())
                .repeatType(task.getRepeatType())
                .animalDtoList(animalMapper.toDtoList(task.getAnimals()))
                .build();
    }
    @Transactional
    public List<Task> mapDtoListToTask(List<TaskDto> taskDtoList){
        List<Task> tasks = new ArrayList<>();
        taskDtoList.forEach(dto-> tasks.add(mapToTask(dto)));
        return tasks;
    }

    public List<TaskDto> mapTaskListToDto(List<Task> taskList){
        List<TaskDto> dtos = new ArrayList<>();
        taskList.forEach(task-> dtos.add(mapToDto(task)));
        return dtos;
    }

    @Transactional
    public Task mapToTask(TaskDto dto) {
        return Task.builder()
                .type(dto.getType())
                .dateTime(dto.getDateTime())
                .state(dto.getState())
                .repeatType(dto.getRepeatType())
                .animals(animalMapper.toAnimalList(dto.getAnimalDtoList()))
                .build();
    }
}
