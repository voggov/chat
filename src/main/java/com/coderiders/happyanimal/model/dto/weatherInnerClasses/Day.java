package com.coderiders.happyanimal.model.dto.weatherInnerClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Day {
    @JsonProperty("maxtemp_c")
    private double maxTempC;
    @JsonProperty("mintemp_c")
    private double minTempC;
    @JsonProperty("avgtemp_c")
    private double avgTempC;
    @JsonProperty("maxwind_kph")
    private double maxWindC;
    @JsonProperty("totalprecip_mm")
    private double totalPrecipMm;
    @JsonProperty("avghumidity")
    private double avgHumidity;
    private Condition condition;
}
