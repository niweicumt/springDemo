package org.study.spring;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.study.spring.aop.Executable;
import org.study.spring.aop.ITask;
import org.study.spring.aop.MockTask;
import org.study.spring.aop.PerformanceMethodInteceptor;
import org.study.spring.aop.introduction.Developer;
import org.study.spring.aop.introduction.IDeveloper;
import org.study.spring.aop.introduction.ITest;
import org.study.spring.aop.introduction.TesterFetureIntroductionInteceptor;

/**
 * Created by niwei on 16/10/14.
 */
public class TestAop {

    /**
     * 基于接口的代理
     * MockTask实现了ITask接口,要对这种实现了接口的目标类代理,可以为ProxyFactory明确指定代理的接口类型
     */
    @Test
    public void baseInterfaceProxy() {
        ProxyFactory weaver = new ProxyFactory(new MockTask());
        weaver.setProxyTargetClass(true);
        weaver.setInterfaces(new Class[]{ITask.class});
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInteceptor());
        weaver.addAdvisor(advisor);
        ITask task = (ITask) weaver.getProxy();
        task.execute();
    }

    /**
     * 目标类没有实现任何接口,基于类的动态代理
     * 因为目标对象类Executable没有实现任何接口,所以ProxyFactory会对其进行基于类的代理
     *
     * 符合以下三种情况之一的,ProxyFactory会对目标类基于类对代理:
     *  1.目标类没有实现任何接口
     *  2.setProxyTargetClass(true)
     *  3.setOptimize(true)
     */
    @Test
    public void baseCglibProxy() {
        ProxyFactory weaver = new ProxyFactory(new Executable());
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInteceptor());
        weaver.addAdvisor(advisor);
        Executable task = (Executable) weaver.getProxy();
        task.execute();
    }

    /**
     * 对象级别的拦截
     */
    @Test
    public void baseIntroduction(){
        ProxyFactory weaver = new ProxyFactory(new Developer());
        weaver.setInterfaces(new Class[]{IDeveloper.class, ITest.class});
        TesterFetureIntroductionInteceptor advice = new TesterFetureIntroductionInteceptor();
        weaver.addAdvice(advice);

        Object proxy = weaver.getProxy();
        ((ITest)proxy).testSoftware();
        ((IDeveloper)proxy).developSoftware();
    }

}
