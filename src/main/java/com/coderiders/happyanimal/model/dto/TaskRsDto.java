package com.coderiders.happyanimal.model.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRsDto {
    @NotNull
    private String type;
    @NotNull
    private String dateTime;
    @NotNull
    private String state;
    @NotNull
    private String repeatType;
}