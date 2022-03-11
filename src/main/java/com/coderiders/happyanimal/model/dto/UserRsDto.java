package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.enums.Gender;
import com.coderiders.happyanimal.enums.UserRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRsDto {
    private Long id;
    private String name;
    private Gender gender;
    private UserRole userRole;
    private int age;
    private String login;
}