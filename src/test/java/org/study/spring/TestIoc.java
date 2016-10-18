package org.study.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.study.spring.ioc.ExamplePlaceHolder;
import org.study.spring.ioc.FXNewsProvider;
import org.study.spring.ioc.annotation.Employee;
import org.study.spring.ioc.encode.Base64Bean;

import java.io.IOException;

/**
 * Created by niwei on 16/10/5.
 */
public class TestIoc {

    private ApplicationContext container;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-ioc.xml");
    }

    @Test
    public void newsProvider() {
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");

        newsProvider.getAndPersistNews();
    }

    @Test
    public void annotationTest() {
        Employee employee = (Employee) container.getBean("employee");
        System.out.println(employee.getMan().getName());
        System.out.println(employee.getMan().getSex());
        System.out.println(employee.getCompany().getName());
        System.out.println(employee.getCompany().getAddress());
    }

    @Test
    public void placeHolder() {
        ExamplePlaceHolder examplePlaceHolder = (ExamplePlaceHolder) container.getBean("examplePlaceHolder");
        System.out.println("senderAddress : " + examplePlaceHolder.getSenderAddress());
        System.out.println("receiverAddress : " + examplePlaceHolder.getReceiverAddress());
        System.out.println("subject : " + examplePlaceHolder.getSubject());
    }

    @Test
    public void beanPostProcessor() {
        Base64Bean base64Bean = (Base64Bean) container.getBean("base64Bean");
        System.out.println(base64Bean.getOriginalStr());
        System.out.println(base64Bean.getEncodeStr());
    }

    @Test
    public void defaultResourceLoader() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fakeFileResource = resourceLoader.getResource("//Users/niwei/setup/NOT_EXISTS_FILE");
        /**
         * DefaultResourceLoader的默认处理逻辑是:如果无法根据资源路径定位指定的资源则构造ClassPathResource类型的资源并返回
         */
        Assert.assertTrue(fakeFileResource instanceof ClassPathResource);
        Assert.assertFalse(fakeFileResource.exists());

        Resource urlResource1 = resourceLoader.getResource("file://Users/niwei/setup/apache-tomcat-8.0.37.tar.gz");
        Assert.assertTrue(urlResource1 instanceof UrlResource);

        Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
        Assert.assertTrue(urlResource2 instanceof UrlResource);

        try {
            fakeFileResource.getFile();
            Assert.fail("no such file with path[" + fakeFileResource.getFilename() + "] exists in classpath");
        } catch (IOException e) {

        }

        try {
            urlResource1.getFile();
        } catch (IOException e) {
            Assert.fail();
        }
    }

    @Test
    public void fileSystemResourceLoader() {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource fileResource = resourceLoader.getResource("//Users/niwei/setup/apache-tomcat-8.0.37.tar.gz");
        Assert.assertTrue(fileResource instanceof FileSystemResource);
        Assert.assertTrue(fileResource.exists());

        Resource urlResource = resourceLoader.getResource("file://Users/niwei/setup/apache-tomcat-8.0.37.tar.gz");
        Assert.assertTrue(urlResource instanceof UrlResource);
        Assert.assertTrue(fileResource.exists());
    }
}
