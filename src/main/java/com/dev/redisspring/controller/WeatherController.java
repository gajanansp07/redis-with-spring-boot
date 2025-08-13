package com.dev.redisspring.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.redisspring.dto.WeatherData;
import com.dev.redisspring.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> test(){
//    	ResponseEntity<String> re =
    	return  new ResponseEntity<String>("Weather Health Check: "+new Date(), HttpStatus.OK);
    }
    @GetMapping("/{city}")
    public WeatherData getWeather(@PathVariable String city) {
    	if(city==null) {
    		city = "Secunderabad";
    	}
    	System.out.println("City: "+city);
        return weatherService.getWeatherForCity(city);
    }
}