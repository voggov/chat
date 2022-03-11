package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.exceptions.BadRequestException;
import com.coderiders.happyanimal.model.dto.WeatherFromJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private static final String API_KEY = "6c51e668f89345a6a52112444220403";
    private static final String ERROR_MESSAGE_BAD_REQUEST = "Ошибка получения прогноза погоды";

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherFromJson getWeatherForecast(int countOfDays) {
        return Optional.ofNullable(restTemplate.getForObject(
                "http://api.weatherapi.com/v1/forecast.json?key=" +
                        API_KEY +
                        "&q=Penza&" +
                        "hour=0" +
                        "&lang=ru" +
                        "&days=" +
                        countOfDays,
                WeatherFromJson.class)).orElseThrow(
                () -> new BadRequestException(ERROR_MESSAGE_BAD_REQUEST));
    }
}