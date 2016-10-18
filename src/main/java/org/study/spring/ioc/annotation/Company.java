package org.study.spring.ioc.annotation;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by niwei on 16/10/7.
 */
@Component
@Data
public class Company {

    private String name;

    private String address;

    private String ceo;

}
