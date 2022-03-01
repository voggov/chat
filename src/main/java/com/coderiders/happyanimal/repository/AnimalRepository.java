package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>, CrudRepository<Animal, Long> {

    Animal findFirstById(Long id);

}
