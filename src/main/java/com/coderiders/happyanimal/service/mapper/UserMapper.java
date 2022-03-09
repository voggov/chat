package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.enums.UserRole;
import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserRqDto;
import com.coderiders.happyanimal.model.dto.UserRsDto;
import com.coderiders.happyanimal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    private final UserRepository repository;

    @Autowired
    public UserMapper(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserRsDto> mapUserListToDtoList(List<User> users) {
        return users.stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Transactional
    public User mapToUser(UserRsDto dto) {
        return repository.getById(dto.getId());
    }

    public User mapToUser(UserRqDto dto) {
        return User.builder()
                .name(dto.getName())
                .gender(dto.getGender())
                .age(dto.getAge())
                .userRole(dto.getRole())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .userRole(UserRole.EMPLOYEE)
                .build();
    }

    public UserRsDto mapToResponseDto(User user) {
        return UserRsDto.builder()
                .id(user.getId())
                .name(user.getName())
                .gender(user.getGender())
                .age(user.getAge())
                .userRole(user.getUserRole())
                .login(user.getLogin())
                .build();
    }
}
