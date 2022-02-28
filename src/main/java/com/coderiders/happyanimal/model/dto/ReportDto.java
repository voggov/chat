package com.coderiders.happyanimal.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private Long id;
    private String date;
    private String text;
    private UserRsDto userDTO;
}
