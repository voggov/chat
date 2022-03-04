package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.service.AnimalService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping()
    public AnimalDto addAnimal(@RequestBody AnimalDto animalDto, @RequestParam(required = false) Long userId) {
        return animalService.saveAnimal(animalDto, userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalDto> getAllAnimals() {
        return animalService.getAll();
    }

    @GetMapping
    public List<AnimalDto> getUserAnimals(@RequestParam @Parameter(name = "User Id", example = "1")
                                                      Long userId) {
        return animalService.getAllByUserId(userId);
    }

    @GetMapping(path = "/{animalId}/tasks")
    public List<TaskRsDto> getAnimalTasks(@PathVariable Long animalId) {
        return animalService.getAnimalTasks(animalId);
    }
}
