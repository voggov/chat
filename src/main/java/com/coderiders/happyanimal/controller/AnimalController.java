package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.exceptions.BadRequestException;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.service.AnimalService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping()
    public ResponseEntity addAnimal(@Valid @RequestBody AnimalDto animalDto, @RequestParam(required = false) Long userId) {
        return Optional.ofNullable(animalService.saveAnimal(animalDto, userId))
                .map(created -> {
                    var url = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(created.getId())
                            .toUri();
                    return ResponseEntity.created(url).body(created);
                })
                .orElseThrow(() -> new BadRequestException("Новое животное не создано"));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalDto> getAllAnimals() {
        return animalService.getAll();
    }

    @GetMapping(path = "/{userId}")
    public List<AnimalDto> getUserAnimals(@PathVariable @Min(0) @Parameter(name = "User Id", example = "1") Long userId) {
        return animalService.getAllByUserId(userId);
    }

    @GetMapping(path = "/{animalId}/tasks")
    public List<TaskRsDto> getAnimalTasks(@PathVariable @Min(0) Long animalId) {
        return animalService.getAnimalTasks(animalId);
    }
}
