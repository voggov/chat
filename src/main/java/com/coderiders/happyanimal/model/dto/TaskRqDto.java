package com.coderiders.happyanimal.model.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    private List<@Valid AnimalDto> animalDtoList;
}
