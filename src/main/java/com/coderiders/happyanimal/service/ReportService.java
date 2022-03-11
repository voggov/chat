package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.exceptions.BadRequestException;
import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.dto.ReportDto;
import com.coderiders.happyanimal.repository.ReportRepository;
import com.coderiders.happyanimal.repository.UserRepository;
import com.coderiders.happyanimal.service.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final ReportMapper reportMapper;
    private static final String ERROR_MESSAGE_BAD_REQUEST_REPORT = "Отчет не найден";
    private static final String ERROR_MESSAGE_BAD_REQUEST_USER = "Пользователь не найден";

    @Autowired
    public ReportService(ReportRepository reportRepository, UserRepository userRepository, ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.reportMapper = reportMapper;
    }

    @Transactional
    public void saveReport(ReportDto reportDto, Long userId) {
        Report report = reportMapper.toReport(reportDto);
        report.setUser(Optional.ofNullable(userRepository.getById(userId)).orElseThrow(
                () -> new BadRequestException(ERROR_MESSAGE_BAD_REQUEST_REPORT)
        ));
        reportRepository.save(report);
    }

    @Transactional
    public List<ReportDto> getAllReportsDTO() {
        return reportMapper.toDtoList(Optional.ofNullable(reportRepository.findAll()).orElseThrow(
                () -> new BadRequestException(ERROR_MESSAGE_BAD_REQUEST_REPORT)));
    }

    @Transactional
    public List<ReportDto> getReportDTOByUserId(Long userId) {
        return reportMapper.toDtoList(
                Optional.ofNullable(reportRepository.findAllByUser(
                        Optional.ofNullable(userRepository.getById(userId)).orElseThrow(
                                () -> new BadRequestException(ERROR_MESSAGE_BAD_REQUEST_USER)))).orElseThrow(
                        () -> new BadRequestException(ERROR_MESSAGE_BAD_REQUEST_REPORT)));
    }
}
