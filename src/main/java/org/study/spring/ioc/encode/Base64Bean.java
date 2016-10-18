package org.study.spring.ioc.encode;

import lombok.Data;

/**
 * Created by niwei on 16/10/7.
 */
@Data
public class Base64Bean implements Base64Encodable {

    private String originalStr;

    private String encodeStr;

    public String getOriginalString() {
        return getOriginalStr();
    }

    public void setEncodedString(String str) {
        setEncodeStr(str);
    }
}
