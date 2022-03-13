package com.coderiders.happyanimal.model.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRqDto {
    @NotNull
    private String type;
    @NotNull
    private String dateTime;
    @NotNull
    private String state;
    @NotNull
    private String repeatType;
    @NotNull
    private List<AnimalDto> animalDtoList;
}
