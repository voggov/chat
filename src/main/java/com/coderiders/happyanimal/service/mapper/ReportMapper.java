package com.coderiders.happyanimal.service.mapper;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDTO;
import com.coderiders.happyanimal.model.dto.UserRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class ReportMapper {
    public static ReportDTO mapToReportDTO(Report report) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setId(report.getId());
        reportDTO.setDate(report.getDate());
        reportDTO.setText(report.getText());
        reportDTO.setUserDTO(UserMapper.mapToResponseDto(report.getUser()));
        return reportDTO;
    }

    public static Report mapToReport(ReportDTO reportDTO) {
        Report report = new Report();
        report.setId(reportDTO.getId());
        report.setDate(reportDTO.getDate());
        report.setText(reportDTO.getText());
        report.setUser(UserMapper.mapToUser((UserRequestDTO) reportDTO.getUserDTO()));
        return report;
    }
}
