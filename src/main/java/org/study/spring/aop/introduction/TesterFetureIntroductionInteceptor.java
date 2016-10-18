package org.study.spring.aop.introduction;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by niwei on 16/10/14.
 */
public class TesterFetureIntroductionInteceptor extends DelegatingIntroductionInterceptor implements ITest, IDeveloper{

    public void testSoftware() {
        System.out.println("拦截器在测试");
    }

    public void developSoftware() {
        System.out.println("拦截器在开发");
    }
}
