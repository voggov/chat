package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserRequestDTO;
import com.coderiders.happyanimal.model.dto.UserResponseDTO;
import com.coderiders.happyanimal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {
    private static UserRepository repository;

    public UserMapper(UserRepository repository) {
        UserMapper.repository = repository;
    }

    public static List<UserResponseDTO> mapUserListToDtoList(Iterable<User> users) {
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

    public static User mapToUser(UserResponseDTO dto) {
        return repository.getById(dto.getId());
    }

    public static UserResponseDTO mapToResponseDto(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

}
