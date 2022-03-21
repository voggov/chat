package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.enums.UserRole;
import com.coderiders.happyanimal.exceptions.NotFoundException;
import com.coderiders.happyanimal.mapper.UserMapper;
import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserRqDto;
import com.coderiders.happyanimal.model.dto.UserRsDto;
import com.coderiders.happyanimal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private static final String ERROR_MESSAGE_NOT_FOUND = "Пользователь не найден";

    @Autowired
    public UserService(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Transactional
    public UserRsDto saveUser(UserRqDto userRqDto) {
        var user = mapper.mapToUser(userRqDto);
        userRepository.save(user);
        return mapper.mapToResponseDto(user);
    }

    @Transactional
    public List<UserRsDto> getAll() {
        List<User> users = Optional.ofNullable(userRepository.findAll()).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND));
        return mapper.mapUserListToDtoList(users);
    }

    @Transactional
    public UserRsDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND));
        return mapper.mapToResponseDto(user);
    }

    @Transactional
    public List<UserRsDto> getByName(String name) {
        List<User> users = userRepository.getAllByNameContainsIgnoreCase(name);
        if (users.isEmpty()) {
            throw new NotFoundException(ERROR_MESSAGE_NOT_FOUND);
        }
        return mapper.mapUserListToDtoList(users);
    }

    @Transactional
    public List<UserRsDto> getAllByRole(UserRole role) {
        List<User> users = userRepository.getAllByUserRole(role);
        if (users.isEmpty()) {
            throw new NotFoundException(ERROR_MESSAGE_NOT_FOUND);
        }
        return mapper.mapUserListToDtoList(users);
    }
}
