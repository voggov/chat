package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.model.dto.weatherInnerClasses.Current;
import com.coderiders.happyanimal.model.dto.weatherInnerClasses.Forecast;
import com.coderiders.happyanimal.model.dto.weatherInnerClasses.Location;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherFromJson {
    private Location location;
    private Current current;
    private Forecast forecast;
}

