package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import com.coderiders.happyanimal.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AnimalMapper {
    private UserRepository userRepository;
    public Animal toAnimal(AnimalDto dto, Long userId){
        return Animal.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .animalClass(dto.getAnimalClass())
                .squad(dto.getSquad())
                .kind(dto.getKind())
                .location(dto.getLocation())
                .status(dto.getStatus())
                .user(userRepository.getById(userId))
                .build();
    }
    public AnimalDto toDto(Animal animal){
        return AnimalDto.builder()
                .id(animal.getId())
                .name(animal.getName())
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
