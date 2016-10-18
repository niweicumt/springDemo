package org.study.spring.ioc;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by niwei on 16/10/7.
 */
@Data
public class ExamplePlaceHolder {

    private String senderAddress;

    private String receiverAddress;

    private String subject;

    private String content;

    private LocalDateTime senderTime;

}
