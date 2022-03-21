package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {

    public List<ReportDto> toDtoList(List<Report> reportList) {
        return reportList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ReportDto toDto(Report report) {
        var modelMapper = new ModelMapper();
        TypeMap<Report, ReportDto> typeMap = modelMapper.createTypeMap(Report.class, ReportDto.class);
        typeMap.addMappings(
                mapper -> mapper.map(Report::getUser, ReportDto::setUserRsDto));
        return modelMapper.map(report, ReportDto.class);
    }

    public Report toReport(ReportDto reportDTO) {
        var modelMapper = new ModelMapper();
        TypeMap<ReportDto, Report> typeMap = modelMapper.createTypeMap(ReportDto.class, Report.class);
        typeMap.addMappings(
                mapper -> mapper.map(ReportDto::getUserRsDto, Report::setUser));
        return modelMapper.map(reportDTO, Report.class);
    }
}
