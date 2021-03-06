package org.study.spring.ioc.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by niwei on 16/10/7.
 */
@Component
@Data
public class Employee {

    @Autowired
    private Men man;

    @Autowired
    private Company company;
}
