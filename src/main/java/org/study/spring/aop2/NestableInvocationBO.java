package org.study.spring.aop2;

import org.springframework.aop.framework.AopContext;

/**
 * Created by niwei on 16/10/16.
 */
public class NestableInvocationBO {

    public void nestMethod1() {

        //由于spring的aop采用的是代理模式,如果直接调用当前对象上的另一个方法将导致不会将横切逻辑织入该方法中
        //nestMethod2();

        //通过强制调用代理对象的方法强制走横切逻辑
        ((NestableInvocationBO) AopContext.currentProxy()).nestMethod2();
        System.out.println("执行了方法 nestMethod1()");
    }


    public void nestMethod2() {

        System.out.println("执行了方法 nestMethod2()");
    }
}
