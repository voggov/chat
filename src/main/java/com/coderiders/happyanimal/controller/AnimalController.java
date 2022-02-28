package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.repository.AnimalRepository;
import com.coderiders.happyanimal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping(value = "api/animals", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {
    @Autowired
    private AnimalService animalService;


    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String  addAnimal(@RequestBody Animal animal1){
        Animal animal = new Animal();
        animal.setName("Test");
        animal.setAge(200);
        animal.setHeight(300);
        animal.setStatus("ok");
        animal.setKind("test");
        animal.setWeight(500);
        animal.setSquad("test");
        animal.setLocation("test");

        animalService.saveAnimal(animal);
        return "ok";

    }

    @GetMapping(path = "/all")
    List<Animal> getAll(){
        return animalService.getAll();
    }

    @GetMapping(path = "/id/{id}")
    Animal getById(@PathVariable Long id){
        return animalService.getById(id);
    }

}
