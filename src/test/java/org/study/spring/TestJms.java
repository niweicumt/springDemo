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
public class TestJms {

    private ApplicationContext container;

    private JmsTemplate jmsTemplate;

    private JmsTemplate asyncJmsTemplate;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-jms.xml");

        jmsTemplate = (JmsTemplate) container.getBean("jmsTemplate");

        asyncJmsTemplate = (JmsTemplate) container.getBean("asyncJmsTemplate");
    }

    /**
     * 同步方式发送接收消息
     * @throws JMSException
     */
    @Test
    public void sendAndReciveMessage() throws JMSException {
        int messageNum = 10;//定义发送的消息条数

        StringBuilder payload;
        for (int i = 0; i < messageNum; ++i) {
            payload = new StringBuilder();
            payload.append("Message [").append(i).append("] sent at: ").append(LocalDateTime.now());
            jmsTemplate.convertAndSend(payload.toString());
            System.out.println("Sending message number [" + i + "]");
        }

        // 同步接收消息
        for (int i = 0; i < messageNum; ++i) {
            receiveMessageFromQueue();
        }
    }

    private void receiveMessageFromQueue() throws JMSException {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive();
        System.out.println("Receive message : " + textMessage.getText());
    }

    /**
     * 异步方式发送接收消息
     * @throws JMSException
     */
    @Test
    public void asynchronousSendAndReciveMessage() throws JMSException {
        int messageNum = 10;//定义发送的消息条数

        StringBuilder payload;
        for (int i = 0; i < messageNum; ++i) {
            payload = new StringBuilder();
            payload.append("Asynchronous Message [").append(i).append("] sent at: ").append(LocalDateTime.now());
            asyncJmsTemplate.convertAndSend(payload.toString());
            System.out.println("Sending asynchronous message number [" + i + "]");
        }
    }
}
