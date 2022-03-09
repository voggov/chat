package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDto;
import com.coderiders.happyanimal.repository.ReportRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final ReportMapper reportMapper;

    @Autowired
    public ReportService(ReportRepository reportRepository, UserRepository userRepository, ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.reportMapper = reportMapper;
    }

    @Transactional
    public void saveReport(ReportDto reportDto, Long userId) {
        Report report = reportMapper.toReport(reportDto);
        report.setUser(userRepository.getById(userId));
        reportRepository.save(report);
    }
    @Transactional
    public List<ReportDto> getAllReportsDTO() {
        return reportMapper.toDtoList(reportRepository.findAll());
    }

    @Transactional
    public List<ReportDto> getReportDTOByUserId(Long userId) {
        return reportMapper.toDtoList(
                reportRepository.findAllByUser(userRepository.getById(userId))
        );
    }
}
