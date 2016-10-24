package org.study.spring.remote.rmi;

import lombok.Data;

/**
 * Created by niwei on 16/10/24.
 */
@Data
public class RmiWeatherServiceClient {

    private IRmiWeatherService weatherService;

    public String doMyWork() {
        return weatherService.queryWeather("Nanjing", null);
    }
}
