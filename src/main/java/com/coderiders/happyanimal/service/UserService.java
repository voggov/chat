package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.enums.UserRole;
import com.coderiders.happyanimal.model.dto.UserRqDto;
import com.coderiders.happyanimal.model.dto.UserRsDto;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

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
        return mapper.mapUserListToDtoList(userRepository.findAll());
    }

    @Transactional
    public UserRsDto getById(Long id) {
        return mapper.mapToResponseDto(userRepository.findFirstById(id).orElse(null));
    }

    @Transactional
    public List<UserRsDto> getByName(String name) {
        return mapper.mapUserListToDtoList(userRepository.getAllByNameContainsIgnoreCase(name));
    }

    @Transactional
    public List<UserRsDto> getAllByRole(UserRole role) {
        return mapper.mapUserListToDtoList(userRepository.getAllByUserRole(role));
    }
}
