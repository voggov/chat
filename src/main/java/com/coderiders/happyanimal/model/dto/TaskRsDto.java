package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.enums.TaskType;
import lombok.*;

import java.util.List;

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