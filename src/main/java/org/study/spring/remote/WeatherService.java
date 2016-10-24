package org.study.spring.remote;

import java.time.LocalDate;

/**
 * Created by niwei on 16/10/24.
 */
public class WeatherService implements IWeatherService {

    @Override
    public String queryWeather(String location, LocalDate localDate) {
        if ("Nanjing".equalsIgnoreCase(location)) {
            return "晴天";
        }

        return "未知";
    }
}
