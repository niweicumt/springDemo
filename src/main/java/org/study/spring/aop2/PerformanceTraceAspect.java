package org.study.spring.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.util.StopWatch;

/**
 * Created by niwei on 16/10/14.
 */
@Aspect
public class PerformanceTraceAspect{

    @Pointcut("execution(public void *.method1()) || execution(public void *.method2())")
    public void pointcutName(){}

    @Before("pointcutName()")
    public void before(){
        System.out.println("这是我的 Before 注解");
    }

    @After("pointcutName()")
    public void after(){
        System.out.println("这是我的 After 注解");
    }

    @Around("pointcutName()")
    public Object performance(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            System.out.println("aop2 StopWatch 开始, 代理的实际方法名:" + joinPoint.getSignature().getName());
            watch.start();
            return joinPoint.proceed();
        } finally {
            watch.stop();
            System.out.println("aop2 StopWatch 结束");
            System.out.println("aop2 StopWatch 结果: " + watch.toString());
        }
    }
}
