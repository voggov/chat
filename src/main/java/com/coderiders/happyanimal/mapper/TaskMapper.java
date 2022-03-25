package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.Task;
import com.coderiders.happyanimal.model.dto.TaskRqDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public TaskRqDto mapToRqDto(Task task) {
        var modelMapper = new ModelMapper();
        TypeMap<Task, TaskRqDto> typeMap = modelMapper.createTypeMap(Task.class, TaskRqDto.class);
        typeMap.addMappings(
                mapper -> mapper.map(Task::getAnimal, TaskRqDto::setAnimalDto));
        return modelMapper.map(task, TaskRqDto.class);
    }

    @Transactional
    public Task mapToTask(TaskRqDto dto) {
        var modelMapper = new ModelMapper();
        TypeMap<TaskRqDto, Task> typeMap = modelMapper.createTypeMap(TaskRqDto.class, Task.class);
        typeMap.addMappings(
                mapper -> mapper.map(TaskRqDto::getAnimalDto, Task::setAnimal));
        return modelMapper.map(dto, Task.class);
    }

    @Transactional
    public TaskRsDto mapToRsDto(Task task) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(task, TaskRsDto.class);
    }
}
