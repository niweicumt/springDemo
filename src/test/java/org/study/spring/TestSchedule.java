package org.study.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.time.LocalDateTime;

/**
 * Created by niwei on 16/10/23.
 */
public class TestSchedule {

    private ApplicationContext container;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-schedule.xml");
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(1000 * 20);
    }
}
