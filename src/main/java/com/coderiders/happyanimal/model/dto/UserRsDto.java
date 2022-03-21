package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.enums.Gender;
import com.coderiders.happyanimal.enums.UserRole;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRsDto {
    @NotNull
    @Min(1)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Gender gender;
    @NotNull
    private UserRole userRole;
    @NotNull
    private int age;
    @NotNull
    private String login;
}
