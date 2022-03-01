package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/animals", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {
    private AnimalService animalService;

    @GetMapping(path = "/all")
    List<Animal> getAll() {
        return animalService.getAll();
    }

    @GetMapping(path = "/id/{id}")
    Animal getById(@PathVariable Long id) {
        return animalService.getById(id);
    }

}
