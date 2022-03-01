package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.enums.UserRole;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRsDto {
    private Long id;
    private String name;
    private UserRole userRole;
    private int age;
    private String login;
    List<ReportDto> reportDtos;
}
