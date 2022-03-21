package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.ReportDto;
import com.coderiders.happyanimal.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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

    @PostMapping()
    public ResponseEntity<ReportDto> addReport(@Valid @RequestBody ReportDto reportDto, @RequestParam Long userId) {
        var created = reportService.saveReport(reportDto, userId);
        var url = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(url).body(created);
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDto> getReportsByUserId(@PathVariable Long userId) {
        return reportService.getReportDTOByUserId(userId);
    }
}
