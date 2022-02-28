package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDto;
import org.springframework.stereotype.Service;

@Service
public class ReportMapper {
    private UserMapper userMapper;
    public ReportDto mapToReportDTO(Report report) {
        ReportDto reportDTO = new ReportDto();
        reportDTO.setId(report.getId());
        reportDTO.setDate(report.getDate());
        reportDTO.setText(report.getText());
        reportDTO.setUserDTO(userMapper.mapToResponseDto(report.getUser()));
        return reportDTO;
    }

    public Report mapToReport(ReportDto reportDTO) {
        Report report = new Report();
        report.setId(reportDTO.getId());
        report.setDate(reportDTO.getDate());
        report.setText(reportDTO.getText());
        report.setUser(userMapper.mapToUser(reportDTO.getUserDTO()));
        return report;
    }
}
