package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDTO;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    static ReportDTO mapToReportDTO(Report report) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setId(report.getId());
        reportDTO.setDate(report.getDate());
        reportDTO.setText(report.getText());
        reportDTO.setUser(report.getUser());
        return reportDTO;
    }

    static Report mapToReport(ReportDTO reportDTO) {
        Report report = new Report();
        report.setId(reportDTO.getId());
        report.setDate(reportDTO.getDate());
        report.setText(reportDTO.getText());
        report.setUser(reportDTO.getUser());
        return report;
    }
}
