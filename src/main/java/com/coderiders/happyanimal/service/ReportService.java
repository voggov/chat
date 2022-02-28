package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDto;
import com.coderiders.happyanimal.repository.ReportRepository;
import com.coderiders.happyanimal.service.mapper.ReportMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportService {
    private ReportRepository reportRepository;

    private ReportMapper reportMapper;

    public void saveReport(Report report) {
        reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public List<Report> getReportByDate(String date) {
        return reportRepository.findByDate(date);
    }

    public List<Report> getReportByUserName(String userName) {
        return reportRepository.findByUserName(userName);
    }

    public Report getReportById(Long id) {
        return reportRepository.findFirstById(id).orElse(null);
    }

    public List<ReportDto> getAllReportsDTO() {
        return reportRepository.findAll().stream()
                .map(report -> reportMapper.mapToReportDTO(report))
                .collect(Collectors.toList());
    }

    public List<ReportDto> getReportDTOByDate(String date) {
        return reportRepository.findByDate(date).stream()
                .map(report -> reportMapper.mapToReportDTO(report))
                .collect(Collectors.toList());
    }

    public List<ReportDto> getReportDTOByUserName(String userName) {
        return reportRepository.findByUserName(userName).stream()
                .map(report -> reportMapper.mapToReportDTO(report))
                .collect(Collectors.toList());
    }

    public ReportDto getReportDTOById(Long id) {
        return reportMapper.mapToReportDTO(Objects.requireNonNull(reportRepository.findFirstById(id).orElse(null)));
    }

    public Report reportDTOToReport(ReportDto reportDTO) {
        return reportMapper.mapToReport(reportDTO);
    }
}
