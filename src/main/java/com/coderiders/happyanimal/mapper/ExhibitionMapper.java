package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.Exhibition;
import com.coderiders.happyanimal.model.dto.ExhibitionRqDto;
import com.coderiders.happyanimal.model.dto.ExhibitionRsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ExhibitionMapper {

    public Exhibition mapToExhibition(ExhibitionRqDto dto) {
        var mapper = new ModelMapper();
        return mapper.map(dto, Exhibition.class);
    }

    public ExhibitionRsDto mapToDto(Exhibition animal) {
        var mapper = new ModelMapper();
        return mapper.map(animal, ExhibitionRsDto.class);
    }
}
