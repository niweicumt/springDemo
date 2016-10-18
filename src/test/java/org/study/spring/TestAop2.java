package org.study.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.aop2.Foo;
import org.study.spring.aop2.NestableInvocationBO;
import org.study.spring.aop2.PerformanceTraceAspect;
import org.study.spring.aop2.PerformanceTraceNestableInvocationAspect;

/**
 * Created by niwei on 16/10/14.
 */
public class TestAop2 {

    private ApplicationContext container;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-aop2.xml");
    }

    /**
     * spring2.0开始的Aspect注解
     */
    @Test
    public void aspectJProxyFactory(){
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Foo());
        weaver.addAspect(PerformanceTraceAspect.class);

        Object proxy = weaver.getProxy();
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }

    /**
     * 基于XSD的AspectJ形式自动代理
     */
    @Test
    public void xsdAspectJProxy(){
        Object proxy = container.getBean("foo");
        ((Foo)proxy).method1();
        System.out.println("----------------------");
        ((Foo)proxy).method2();
    }

    /**
     * 基于XSD的AspectJ形式自动代理
     */
    @Test
    public void nestableInvocation(){
        AspectJProxyFactory weaver = new AspectJProxyFactory(new NestableInvocationBO());
        weaver.setProxyTargetClass(true);
        weaver.setExposeProxy(true);
        weaver.addAspect(PerformanceTraceNestableInvocationAspect.class);

        Object proxy = weaver.getProxy();
        ((NestableInvocationBO)proxy).nestMethod2();
        System.out.println("----------------------");
        ((NestableInvocationBO)proxy).nestMethod1();
    }
}
