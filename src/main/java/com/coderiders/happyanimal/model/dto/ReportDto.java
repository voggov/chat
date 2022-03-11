package com.coderiders.happyanimal.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private Long id;
    private String date;
    private String text;
    private UserRsDto userRsDto;
}
