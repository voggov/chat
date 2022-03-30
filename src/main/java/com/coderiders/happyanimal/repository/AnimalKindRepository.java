package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.model.AnimalKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalKindRepository extends JpaRepository<AnimalKind, String> {
}
