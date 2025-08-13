package com.dev.redisspring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev.redisspring.dto.WeatherData;

// WeatherService.java
@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherForCity(String city) {
        String url = String.format("%s?location=%s&appid=%s", apiUrl, city, apiKey);
        System.out.println("Final URL: "+url);
        return restTemplate.getForObject(url, WeatherData.class);
    }
}

// WeatherController.java
