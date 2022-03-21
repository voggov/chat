package com.coderiders.happyanimal.mapper;

import com.coderiders.happyanimal.model.dto.ForecastDayDto;
import com.coderiders.happyanimal.model.dto.WeatherDto;
import com.coderiders.happyanimal.model.dto.WeatherFromJson;
import com.coderiders.happyanimal.model.dto.weatherInnerClasses.ForecastDay;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WeatherMapper {
    public WeatherDto mapWeatherFromJsonToWeatherDto(WeatherFromJson weatherFromJson) {
        return WeatherDto.builder()
                .country(weatherFromJson.getLocation().getCountry())
                .region(weatherFromJson.getLocation().getRegion())
                .tempC(weatherFromJson.getCurrent().getTempC())
                .text(weatherFromJson.getCurrent().getCondition().getText())
                .windKph(weatherFromJson.getCurrent().getWindKph())
                .pressureMb(weatherFromJson.getCurrent().getPressureMb())
                .precipMm(weatherFromJson.getCurrent().getPrecipMm())
                .humidity(weatherFromJson.getCurrent().getHumidity())
                .forecastDayList(weatherFromJson.getForecast().getForecastDay().stream()
                        .map(this::mapForecastDayToForecastDayDto)
                        .collect(Collectors.toList()))
                .build();
    }

    private ForecastDayDto mapForecastDayToForecastDayDto(ForecastDay forecastDay) {
        return ForecastDayDto.builder()
                .date(forecastDay.getDate())
                .maxTempC(forecastDay.getDay().getMaxTempC())
                .minTempC(forecastDay.getDay().getMinTempC())
                .avgTempC(forecastDay.getDay().getAvgTempC())
                .maxWindC(forecastDay.getDay().getMaxWindC())
                .totalPrecipMm(forecastDay.getDay().getTotalPrecipMm())
                .avgHumidity(forecastDay.getDay().getAvgHumidity())
                .text(forecastDay.getDay().getCondition().getText())
                .build();
    }
}
