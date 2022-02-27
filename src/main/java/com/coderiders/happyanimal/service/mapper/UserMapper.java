package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserDTO;
import com.coderiders.happyanimal.repository.UserRepository;

public class UserMapper {
    static UserRepository userRepository;

    static UserDTO mapToDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

    static User mapToUser(UserDTO userDTO){
        return userRepository.getById(userDTO.getId());
    }
}
