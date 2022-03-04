package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.Task;
import com.coderiders.happyanimal.model.dto.TaskRqDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TaskMapper {
    private TaskRepository taskRepository;
    private AnimalMapper animalMapper;

    public TaskRqDto toRqDto(Task task) {
        return TaskRqDto.builder()
                .type(task.getType())
                .dateTime(task.getDateTime())
                .state(task.getState())
                .repeatType(task.getRepeatType())
                .animalDtoList(animalMapper.toDtoList(task.getAnimals()))
                .build();
    }

    public List<TaskRqDto> mapTaskListToDto(List<Task> taskList) {
        return taskList.stream().map(this::toRqDto).collect(Collectors.toList());
    }

    @Transactional
    public Task mapToTask(TaskRqDto dto) {
        return Task.builder()
                .type(dto.getType())
                .dateTime(dto.getDateTime())
                .state(dto.getState())
                .repeatType(dto.getRepeatType())
                .animals(animalMapper.toAnimalList(dto.getAnimalDtoList()))
                .build();
    }

    @Transactional
    public TaskRsDto toRsDto(Task task){
        return TaskRsDto.builder()
                .type(task.getType())
                .dateTime(task.getDateTime())
                .state(task.getState())
                .repeatType(task.getRepeatType())
                .build();
    }
}
