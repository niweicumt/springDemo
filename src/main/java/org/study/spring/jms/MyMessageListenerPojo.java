package org.study.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by niwei on 16/10/23.
 */
public class MyMessageListenerPojo implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            System.out.println("接收到异步消息: " + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
