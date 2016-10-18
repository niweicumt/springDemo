package org.study.spring.ioc.encode;

/**
 * Created by niwei on 16/10/7.
 */
public interface Base64Encodable {

    String getOriginalString();

    void setEncodedString(String str);
}
