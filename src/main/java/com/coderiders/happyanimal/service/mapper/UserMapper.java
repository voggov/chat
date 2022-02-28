package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserDTO;
public class UserMapper {

    static UserDTO mapToDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

    static User mapToUser(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .age(userDTO.getAge())
                .login(userDTO.getLogin())
                //.password() TODO!
                .build();
    }
}
