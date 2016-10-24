package org.study.spring.remote.rmi;

import java.time.LocalDate;

/**
 * Created by niwei on 16/10/24.
 */
public interface IRmiWeatherService {

    /**
     * 根据时间地点查询天气
     *
     * @param location  地点
     * @param localDate 时间
     * @return 天气信息描述
     */
    String queryWeather(String location, LocalDate localDate);
}
