package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findFirstById(Long id);
}
