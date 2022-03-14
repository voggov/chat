package com.coderiders.happyanimal.model.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    @NotNull
    private Long id;
    @NotNull
    private String date;
    @NotNull
    private String text;
    @NotNull
    private UserRsDto userRsDto;
}
