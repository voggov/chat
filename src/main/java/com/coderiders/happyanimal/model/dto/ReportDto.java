package com.coderiders.happyanimal.model.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

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
