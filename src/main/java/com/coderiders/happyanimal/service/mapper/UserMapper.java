package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserRequestDTO;
import com.coderiders.happyanimal.model.dto.UserResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static List<UserResponseDTO> mapUserResponseListToDtoList(Iterable<User> users) {
        List<UserResponseDTO> dtos = new ArrayList<>();
        users.forEach(user -> dtos.add(mapToResponseDto(user)));
        return dtos;
    }

    public static UserRequestDTO mapToRequestDto(User user) {
        return UserRequestDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }

    public static User mapToUser(UserRequestDTO dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .build();
    }

    public static UserResponseDTO mapToResponseDto(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

}
