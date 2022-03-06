package com.coderiders.happyanimal.service;

import com.coderiders.happyanimal.model.dto.WeatherFromJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private static final String API_KEY = "6c51e668f89345a6a52112444220403";

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherFromJson getWeatherForecast(int countOfDays) {
        return restTemplate.getForObject(
                "http://api.weatherapi.com/v1/forecast.json?key=" +
                        API_KEY +
                        "&q=Penza&" +
                        "hour=0" +
                        "&lang=ru" +
                        "&days=" +
                        countOfDays,
                WeatherFromJson.class);
    }
}