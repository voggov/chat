package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.enums.UserRole;
import com.coderiders.happyanimal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findFirstById(Long id);
    List<User> getAllByNameContainsIgnoreCase(String name);
    List<User> getAllByUserRole(UserRole role);
}
