package org.study.spring.remote.rmi;

import java.time.LocalDate;

/**
 * Created by niwei on 16/10/24.
 */
public class RmiWeatherService implements IRmiWeatherService {
    /**
     * 根据时间地点查询天气
     *
     * @param location  地点
     * @param localDate 时间
     */
    @Override
    public String queryWeather(String location, LocalDate localDate) {
        if ("Nanjing".equalsIgnoreCase(location)) {
            return "晴天";
        }

        return "未知";
    }
}
