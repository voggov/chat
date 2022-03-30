package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.AnimalKindDto;
import com.coderiders.happyanimal.service.AnimalKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/animalKinds")
public class AnimalKindController {

    AnimalKindService service;

    @Autowired
    public AnimalKindController(AnimalKindService service) {
        this.service = service;
    }

    @PostMapping
    public void createAll() throws IOException {
        service.createAll();
    }

    @GetMapping(path = "/all")
    public List<AnimalKindDto> getAllKinds() {
        return service.getAll();
    }

    @GetMapping
    public List<String> getAllKindnames() {
        return service.getAllOnlyKinds();
    }

    @GetMapping(path = "/{kindname}")
    public AnimalKindDto getOneByKindName(@PathVariable String kindname){
        return service.getByKindName(kindname);
    }

    @DeleteMapping
    public void deleteAll(){
        service.deleteAll();
    }
}
