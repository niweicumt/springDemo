package org.study.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**
 * Created by niwei on 16/10/14.
 */
public class PerformanceMethodInteceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            System.out.println("StopWatch 开始");
            watch.start();
            return invocation.proceed();
        } finally {
            watch.stop();
            System.out.println("StopWatch 结束");
            System.out.println("StopWatch 结果: " + watch.toString());
        }
    }
}
