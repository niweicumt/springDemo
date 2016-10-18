package org.study.spring.ioc.encode;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import sun.misc.BASE64Encoder;

/**
 * base64编码处理器
 * Created by niwei on 16/10/7.
 */
public class Base64EncodePostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof Base64Encodable) {
            String str = ((Base64Encodable) o).getOriginalString();
            BASE64Encoder encoder = new BASE64Encoder();
            ((Base64Encodable) o).setEncodedString(encoder.encode(str.getBytes()));
        }

        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
