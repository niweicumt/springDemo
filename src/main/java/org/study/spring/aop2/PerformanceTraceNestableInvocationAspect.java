package org.study.spring.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * Created by niwei on 16/10/16.
 */
@Aspect()
public class PerformanceTraceNestableInvocationAspect {

    @Pointcut("execution(public void *.nestMethod1())")
    public void nestMethod1() {
    }


    @Pointcut("execution(public void *.nestMethod2())")
    public void nestMethod2() {
    }

    @Pointcut("nestMethod1() || nestMethod2()")
    public void compositePointcut() {
    }

    @Around("compositePointcut()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        System.out.println("拦截了方法[" + joinPoint.getSignature() + "]");
        try {
            stopWatch.start();
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();

            System.out.println("在方法[" + joinPoint.getSignature() + "]中执行了>>>>>>>>" + stopWatch.toString());
        }
    }
}
