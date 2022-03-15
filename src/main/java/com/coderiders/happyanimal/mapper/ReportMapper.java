package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {
    private final UserMapper userMapper;

    @Autowired
    public ReportMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<ReportDto> toDtoList(List<Report> reportList) {
        return reportList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ReportDto toDto(Report report) {
        return ReportDto.builder()
                .id(report.getId())
                .date(report.getDate())
                .text(report.getText())
                .userRsDto(userMapper.mapToResponseDto(report.getUser()))
                .build();
    }

    public Report toReport(ReportDto reportDTO) {
        return Report.builder()
                .id(reportDTO.getId())
                .date(reportDTO.getDate())
                .text(reportDTO.getText())
                .user(userMapper.mapToUser(reportDTO.getUserRsDto()))
                .build();
    }
}
