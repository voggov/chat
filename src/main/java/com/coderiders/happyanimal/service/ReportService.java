package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.exceptions.NotFoundException;
import com.coderiders.happyanimal.mapper.ReportMapper;
import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.model.dto.ReportDto;
import com.coderiders.happyanimal.repository.ReportRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final ReportMapper reportMapper;
    private static final String ERROR_MESSAGE_NOT_FOUND_REPORT = "Отчет не найден";
    private static final String ERROR_MESSAGE_NOT_FOUND_USER = "Пользователь не найден";

    @Autowired
    public ReportService(ReportRepository reportRepository, UserRepository userRepository, ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.reportMapper = reportMapper;
    }

    @Transactional
    public ReportDto saveReport(ReportDto reportDto, Long userId) {
        Report report = reportMapper.toReport(reportDto);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_REPORT));
        report.setUser(user);
        return reportMapper.toDto(reportRepository.save(report));
    }

    @Transactional
    public List<ReportDto> getAllReportsDTO() {
        List<Report> allReports = reportRepository.findAll();
        if (allReports.isEmpty()) {
            throw new NotFoundException(ERROR_MESSAGE_NOT_FOUND_REPORT);
        }
        return reportMapper.toDtoList(allReports);
    }

    @Transactional
    public List<ReportDto> getReportDTOByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ERROR_MESSAGE_NOT_FOUND_USER));
        List<Report> reportList = reportRepository.findAllByUser(user);
        if (reportList.isEmpty()) {
            throw new NotFoundException(ERROR_MESSAGE_NOT_FOUND_REPORT);
        }
        return reportMapper.toDtoList(reportList);
    }
}