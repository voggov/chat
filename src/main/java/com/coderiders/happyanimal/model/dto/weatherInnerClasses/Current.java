package com.coderiders.happyanimal.model.dto.weatherInnerClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Current {
    @JsonProperty("temp_c")
    private double tempC;
    private Condition condition;
    @JsonProperty("wind_kph")
    private double windKph;
    @JsonProperty("pressure_mb")
    private double pressureMb;
    @JsonProperty("precip_mm")
    private double precipMm;
    private int humidity;
}
