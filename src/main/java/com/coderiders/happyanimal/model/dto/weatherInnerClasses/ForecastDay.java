package com.coderiders.happyanimal.model.dto.weatherInnerClasses;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDay {
    private String date;
    private Day day;
}
