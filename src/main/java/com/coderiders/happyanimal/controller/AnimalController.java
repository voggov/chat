package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.service.AnimalService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

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
    public void addAnimal(@Valid @RequestBody AnimalDto animalDto, @RequestParam(required = false) Long userId) {
        animalService.saveAnimal(animalDto, userId);
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
