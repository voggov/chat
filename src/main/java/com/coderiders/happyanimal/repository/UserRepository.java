package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

    User findFirstById(Long id);
}
