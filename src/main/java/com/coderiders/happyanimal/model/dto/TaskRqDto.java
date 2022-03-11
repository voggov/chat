package com.coderiders.happyanimal.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRqDto {
    private String type;
    private String dateTime;
    private String state;
    private String repeatType;
    private List<AnimalDto> animalDtoList;
}