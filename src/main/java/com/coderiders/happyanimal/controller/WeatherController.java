package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.WeatherDto;
import com.coderiders.happyanimal.service.WeatherService;
import com.coderiders.happyanimal.mapper.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    @Autowired
    public WeatherController(WeatherService weatherService, WeatherMapper weatherMapper) {
        this.weatherService = weatherService;
        this.weatherMapper = weatherMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherDto getWeatherDto(int countOfDays) {
        return weatherMapper.mapWeatherFromJsonToWeatherDto(weatherService.getWeatherForecast(countOfDays));
    }
}