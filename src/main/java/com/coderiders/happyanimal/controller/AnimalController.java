package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.service.AnimalService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity addAnimal(@Valid @RequestBody AnimalDto animalDto, @RequestParam(required = false) Long userId) {
        var created = animalService.saveAnimal(animalDto, userId);
        var url = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(url).body(created);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<AnimalDto> getAllAnimals(Pageable pageable) {
        return animalService.getAll(pageable);
    }

    @GetMapping(path = "/{userId}")
    public Page<AnimalDto> getUserAnimals(@PathVariable @Parameter(name = "User Id", example = "1") Long userId,
                                          Pageable pageable) {
        return animalService.getAllByUserId(userId, pageable);
    }

    @GetMapping(path = "/{animalId}/tasks")
    public Page<TaskRsDto> getAnimalTasks(@PathVariable Long animalId,
                                          Pageable pageable) {
        return animalService.getAnimalAllTasks(animalId, pageable);
    }
}
