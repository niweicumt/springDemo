package org.study.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.remote.rmi.RmiWeatherServiceClient;

/**
 * Created by niwei on 16/10/24.
 */
public class TestRemote {

    private ApplicationContext container;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-remote.xml");
    }

    @Test
    public void remote(){
        RmiWeatherServiceClient client = (RmiWeatherServiceClient)container.getBean("rmiClient");
        Assert.assertNotNull(client);
        Assert.assertEquals(client.doMyWork(), "晴天");
    }
}
