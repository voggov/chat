package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDto;
import com.coderiders.happyanimal.repository.ReportRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.ReportMapper;
import com.coderiders.happyanimal.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportService {
    private ReportRepository reportRepository;
    private UserRepository userRepository;
    private ReportMapper reportMapper;

    @Transactional
    public void saveReport(ReportDto reportDto, Long userId) {
        Report report = reportMapper.mapToReport(reportDto);
        report.setUser(userRepository.getById(userId));
        reportRepository.save(report);
    }

    @Transactional
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Transactional
    public List<Report> getReportByDate(String date) {
        return reportRepository.findByDate(date);
    }

    @Transactional
    public List<Report> getReportByUserName(String userName) {
        return reportRepository.findByUserName(userName);
    }

    @Transactional
    public Report getReportById(Long id) {
        return reportRepository.findFirstById(id).orElse(null);
    }

    @Transactional
    public List<ReportDto> getAllReportsDTO() {
        return reportRepository.findAll().stream()
                .map(report -> reportMapper.mapToReportDTO(report))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ReportDto> getReportDTOByDate(String date) {
        return reportRepository.findByDate(date).stream()
                .map(report -> reportMapper.mapToReportDTO(report))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ReportDto> getReportDTOByUserId(Long userId) {
        return reportRepository.findAllByUser(userRepository.getById(userId))
                .stream()
                .map(report -> reportMapper.mapToReportDTO(report))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ReportDto> getReportDTOByUserName(String userName) {
        return reportRepository.findByUserName(userName).stream()
                .map(report -> reportMapper.mapToReportDTO(report))
                .collect(Collectors.toList());
    }

    @Transactional
    public ReportDto getReportDTOById(Long id) {
        return reportMapper.mapToReportDTO(Objects.requireNonNull(reportRepository.findFirstById(id).orElse(null)));
    }

    @Transactional
    public Report reportDTOToReport(ReportDto reportDTO) {
        return reportMapper.mapToReport(reportDTO);
    }
}
