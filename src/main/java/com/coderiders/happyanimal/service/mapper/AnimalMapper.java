package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AnimalMapper {
    public List<AnimalDto> toDtoList(Iterable<Animal> animalList) {
        List<AnimalDto> dtoList = new ArrayList<>();
        animalList.forEach(animal -> dtoList.add(toDto(animal)));
        return dtoList;
    }

    public List<Animal> toAnimalList(Iterable<AnimalDto> dtos) {
        List<Animal> animals = new ArrayList<>();
        dtos.forEach(animalDto -> animals.add(toAnimal(animalDto)));
        return animals;
    }

    public Animal toAnimal(AnimalDto dto) {
        return Animal.builder()
                .id(dto.getId())
                .name(dto.getName())
                .gender(dto.getGender())
                .age(dto.getAge())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .animalClass(dto.getAnimalClass())
                .squad(dto.getSquad())
                .kind(dto.getKind())
                .location(dto.getLocation())
                .status(dto.getStatus())
                .build();
    }

    public AnimalDto toDto(Animal animal) {
        return AnimalDto.builder()
                .id(animal.getId())
                .name(animal.getName())
                .gender(animal.getGender())
                .age(animal.getAge())
                .height(animal.getHeight())
                .weight(animal.getWeight())
                .animalClass(animal.getAnimalClass())
                .squad(animal.getSquad())
                .kind(animal.getKind())
                .location(animal.getLocation())
                .status(animal.getStatus())
                .build();
    }
}
