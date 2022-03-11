package com.coderiders.happyanimal.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDayDto {
    private String date;
    private double maxTempC;
    private double minTempC;
    private double avgTempC;
    private double maxWindC;
    private double totalPrecipMm;
    private double avgHumidity;
    private String text;
}
