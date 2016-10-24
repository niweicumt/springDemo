package org.study.spring.schedule;

import java.time.LocalDateTime;

/**
 * Created by niwei on 16/10/24.
 */
public class MySpringQuartz {

    private static int counter = 0;

    public void execute()  {
        System.out.println("本次调度开始于:" + LocalDateTime.now());
        System.out.println("(" + counter++ + ")");
    }
}
