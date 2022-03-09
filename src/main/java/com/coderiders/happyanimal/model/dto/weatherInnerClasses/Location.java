package com.coderiders.happyanimal.model.dto.weatherInnerClasses;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String country;
    private String region;
}
