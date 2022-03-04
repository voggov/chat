package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReportMapper {
    private UserMapper userMapper;
    public ReportDto mapToReportDTO(Report report) {
        return ReportDto.builder()
                .id(report.getId())
                .date(report.getDate())
                .text(report.getText())
                .userRsDto(userMapper.mapToResponseDto(report.getUser()))
                .build();
    }

    public Report mapToReport(ReportDto reportDTO) {
        return Report.builder()
                .id(reportDTO.getId())
                .date(reportDTO.getDate())
                .text(reportDTO.getText())
                .user(userMapper.mapToUser(reportDTO.getUserRsDto()))
                .build();
    }
}
