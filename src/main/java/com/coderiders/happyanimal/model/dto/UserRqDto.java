package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.enums.Gender;
import com.coderiders.happyanimal.enums.UserRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRqDto {
    private String name;
    private Gender gender;
    private int age;
    private String login;
    private String password;
    private UserRole role;
}
