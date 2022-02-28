package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.enums.UserRole;
import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.UserResponseDTO;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<UserResponseDTO> getAll() {
        return UserMapper.mapUserResponseListToDtoList(userRepository.findAll());
    }

    public User getById(Long id) {
        return userRepository.findFirstById(id).orElse(null);
    }

    public List<User> getByName(String name) {
        return userRepository.getAllByNameContainsIgnoreCase(name);
    }

    public List<User> getAllByRole(UserRole role) {
        return userRepository.getAllByUserRole(role);
    }
}
