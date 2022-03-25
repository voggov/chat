package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnimalMapper {

    public Animal mapToAnimal(AnimalDto dto) {
        var mapper = new ModelMapper();
        return mapper.map(dto, Animal.class);
    }

    public AnimalDto mapToDto(Animal animal) {
        var mapper = new ModelMapper();
        return mapper.map(animal, AnimalDto.class);
    }
}
