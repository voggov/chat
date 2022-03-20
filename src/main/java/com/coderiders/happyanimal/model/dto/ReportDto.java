package com.coderiders.happyanimal.model.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    @NotNull
    @Min(1)
    private Long id;
    @NotNull
    private String date;
    @NotNull
    private String text;
    @NotNull
    private UserRsDto userRsDto;
}
