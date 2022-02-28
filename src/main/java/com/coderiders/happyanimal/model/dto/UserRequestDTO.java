package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.enums.UserRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO implements UserDTO {
    private Long id;
    private String name;
    private UserRole userRole;
    private int age;
    private String login;
    private String password;
}
