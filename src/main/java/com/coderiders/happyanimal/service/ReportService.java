package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDTO;
import com.coderiders.happyanimal.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

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

    public List<ReportDTO> getAllReportsDTO() {
        return reportRepository.findAll().stream()
                .map(Mapper::mapToReportDTO)
                .collect(Collectors.toList());
    }

    public List<ReportDTO> getReportDTOByDate(String date) {
        return reportRepository.findByDate(date).stream()
                .map(Mapper::mapToReportDTO)
                .collect(Collectors.toList());
    }

    public List<ReportDTO> getReportDTOByUserName(String userName) {
        return reportRepository.findByUserName(userName).stream()
                .map(Mapper::mapToReportDTO)
                .collect(Collectors.toList());
    }

    public ReportDTO getReportDTOById(Long id) {
        return Mapper.mapToReportDTO(Objects.requireNonNull(reportRepository.findFirstById(id).orElse(null)));
    }

    public Report reportDTOToReport(ReportDTO reportDTO) {
        return Mapper.mapToReport(reportDTO);
    }
}
