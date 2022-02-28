package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.enums.UserRole;
import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserRsDto;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private UserMapper mapper;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<UserRsDto> getAll() {
        return mapper.mapUserListToDtoList(userRepository.findAll());
    }

    public UserRsDto getById(Long id) {
        return mapper.mapToResponseDto(userRepository.findFirstById(id).orElse(null));
    }

    public List<UserRsDto> getByName(String name) {
        return mapper.mapUserListToDtoList(userRepository.getAllByNameContainsIgnoreCase(name));
    }

    public List<UserRsDto> getAllByRole(UserRole role) {
        return mapper.mapUserListToDtoList(userRepository.getAllByUserRole(role));
    }
}
