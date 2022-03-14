package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.enums.TaskType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRqDto {
    private String type;
    private LocalDate date;
    private LocalTime time;
    private String state;
    private String repeatType;
    private List<AnimalDto> animalDtoList;
}
