package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import org.modelmapper.ModelMapper;
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
        var mapper = new ModelMapper();
        return mapper.map(dto, Animal.class);
    }

    public AnimalDto toDto(Animal animal) {
        var mapper = new ModelMapper();
        return mapper.map(animal, AnimalDto.class);
    }
}
