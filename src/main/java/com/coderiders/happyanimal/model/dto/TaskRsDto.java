package com.coderiders.happyanimal.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRsDto {
    private String type;
    private String dateTime;
    private String state;
    private String repeatType;
}