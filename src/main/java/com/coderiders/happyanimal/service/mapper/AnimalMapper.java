package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnimalMapper {

    public List<AnimalDto> toDtoList(List<Animal> animalList) {
        return animalList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Animal> toAnimalList(List<AnimalDto> dtos) {
        return dtos.stream().map(this::toAnimal).collect(Collectors.toList());
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
