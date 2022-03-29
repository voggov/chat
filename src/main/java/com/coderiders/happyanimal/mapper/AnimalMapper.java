package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.Animal;
import com.coderiders.happyanimal.model.dto.AnimalRqDto;
import com.coderiders.happyanimal.model.dto.AnimalRsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {

    public Animal mapToAnimal(AnimalRsDto dto) {
        var mapper = new ModelMapper();
        return mapper.map(dto, Animal.class);
    }

    public Animal mapToAnimal(AnimalRqDto dto) {
        var mapper = new ModelMapper();
        return mapper.map(dto, Animal.class);
    }

    public AnimalRsDto mapToDto(Animal animal) {
        var mapper = new ModelMapper();
        return mapper.map(animal, AnimalRsDto.class);
    }
}
