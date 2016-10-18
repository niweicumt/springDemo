package org.study.spring.aop;

/**
 * Created by niwei on 16/10/14.
 */
public class MockTask implements ITask {

    public void execute() {
        System.out.println("MockTask is executed.");
    }
}
