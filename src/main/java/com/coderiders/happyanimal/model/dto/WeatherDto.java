package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.model.dto.weatherInnerClasses.ForecastDayDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {
    private String country;
    private String region;
    private double tempC;
    private String text;
    private double windKph;
    private double pressureMb;
    private double precipMm;
    private int humidity;
    private List<ForecastDayDto> forecastDayList;
}
