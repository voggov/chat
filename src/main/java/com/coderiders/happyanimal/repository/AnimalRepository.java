package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Optional<Animal> findById(Long id);
    Page<Animal> findAllByUser(User user, Pageable pageable);
    Page<Animal> findAll(Pageable pageable);
}
