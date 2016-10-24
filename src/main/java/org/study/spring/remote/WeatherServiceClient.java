package org.study.spring.remote;

import lombok.Data;

/**
 * Created by niwei on 16/10/24.
 */
@Data
public class WeatherServiceClient {

    private IWeatherService weatherService;

    public String doMyWork() {
        return weatherService.queryWeather("Nanjing", null);
    }
}
