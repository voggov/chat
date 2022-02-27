package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return getReportByDate(date);
    }

    public List<Report> getReportByUserName(String userName) {
        return getReportByUserName(userName);
    }

    public Report getReportById(Long id) {
        return reportRepository.findFirstById(id).orElse(null);
    }
}
