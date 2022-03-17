package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.ReportDto;
import com.coderiders.happyanimal.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDto> getAllReports() {
        return reportService.getAllReportsDTO();
    }

    @PostMapping
    public void addReport(@RequestBody ReportDto reportDto, @RequestParam Long userId) {
        reportService.saveReport(reportDto, userId);
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDto> getReportsByUserId(@PathVariable Long userId) {
        return reportService.getReportDTOByUserId(userId);
    }
}
