package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.AnimalKind;
import com.coderiders.happyanimal.model.dto.AnimalKindDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AnimalKindMapper {

    public AnimalKind mapToAnimalKind(AnimalKindDto dto) {
        var mapper = new ModelMapper();
        return mapper.map(dto, AnimalKind.class);
    }

    public AnimalKindDto mapToDto(AnimalKind kind) {
        var mapper = new ModelMapper();
        return mapper.map(kind, AnimalKindDto.class);
    }
}
