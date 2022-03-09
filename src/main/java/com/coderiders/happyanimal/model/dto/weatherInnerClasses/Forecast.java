package com.coderiders.happyanimal.model.dto.weatherInnerClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Forecast {
    @JsonProperty("forecastday")
    List<ForecastDay> forecastDay;
}
