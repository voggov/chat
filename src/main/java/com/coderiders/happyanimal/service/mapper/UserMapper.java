package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserRqDto;
import com.coderiders.happyanimal.model.dto.UserRsDto;
import com.coderiders.happyanimal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UserMapper {
    private final UserRepository repository;

    public List<UserRsDto> mapUserListToDtoList(Iterable<User> users) {
        List<UserRsDto> dtos = new ArrayList<>();
        users.forEach(user -> dtos.add(mapToResponseDto(user)));
        return dtos;
    }

    public UserRqDto mapToRequestDto(User user) {
        return UserRqDto.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }

    public User mapToUser(UserRsDto dto) {
        return repository.getById(dto.getId());
    }

    public UserRsDto mapToResponseDto(User user) {
        return UserRsDto.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .userRole(user.getUserRole())
                .login(user.getLogin())
                .build();
    }

}
