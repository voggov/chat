package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.ExhibitionRqDto;
import com.coderiders.happyanimal.model.dto.ExhibitionRsDto;
import com.coderiders.happyanimal.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Validated
@RestController
@RequestMapping("/exhibitions")
public class ExhibitionController {
    private final ExhibitionService exhibitionService;

    @Autowired
    public ExhibitionController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @PostMapping
    public ResponseEntity<ExhibitionRsDto> addExhibition(ExhibitionRqDto exhibitionRqDto) {
        var created = exhibitionService.saveExhibition(exhibitionRqDto);
        var url = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(url).body(created);
    }

    @GetMapping
    public Page<ExhibitionRsDto> getAllExhibitions(Pageable pageable) {
        return exhibitionService.getAll(pageable);
    }

    @GetMapping(path = "/{date}")
    public ResponseEntity<ExhibitionRsDto> getExhibitionByDate(@PathVariable String date) {
        var created = exhibitionService.findByDate(date);
        var url = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(url).body(created);
    }
}
