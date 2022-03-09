package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.WeatherDto;
import com.coderiders.happyanimal.service.WeatherService;
import com.coderiders.happyanimal.service.mapper.WeatherMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private WeatherService weatherService;
    private WeatherMapper weatherMapper;

    @GetMapping(path = "/forecastWeather", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherDto getWeatherDto(int countOfDays) {
        return weatherMapper.mapWeatherFromJsonToWeatherDto(weatherService.getWeatherForecast(countOfDays));
    }
}