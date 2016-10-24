package org.study.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.remote.WeatherServiceClient;

/**
 * Created by niwei on 16/10/24.
 */
public class TestHttp {

    private ApplicationContext container;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-remote-http.xml");
    }

    @Test
    public void http(){
        WeatherServiceClient client = (WeatherServiceClient)container.getBean("httpClient");
        Assert.assertNotNull(client);
        Assert.assertEquals(client.doMyWork(), "晴天");
    }

    @Test
    public void hessian(){
        WeatherServiceClient client = (WeatherServiceClient)container.getBean("hessianClient");
        Assert.assertNotNull(client);
        Assert.assertEquals(client.doMyWork(), "晴天");
    }
}
