# springDemo
A spring demo project for study

## 项目代码结构说明

* 按照maven的标准项目目录构建
* 单元测试的例子都在test/java/org/study/spring 目录下
* 为了简化pojo代码编写,引入了lombok,所有pojo的属性编写完之后不需要在写get set方法

## ioc

* TestIoc spring最基本的ioc容器的例子,包括构造方法注入 属性注入 注解配置的注入

## aop

* TestAop 基于java的接口代理和基于cglib的类动态代理例子
* TestAop2 基于AspectJ的代理例子

## jdbc

* TestJdbc spring直接使用jdbc的例子
* 使用了mysql数据库,所以提供了表结构和数据的初始化脚本,路径为resources/db/init.sql

## iBatis

* TestIBatis iBatis使用的例子
* TestIBatisSpring spring集成iBatis的例子

## transaction

* TestTransaction spring中配置事务管理的例子

## mvc

按照标准的maven项目目录，所以可以直接在项目根目录下执行mvn clean install命令，将应用打成war包执行  
以发布到本地8080端口为例，web项目路径:http://localhost:8080/springDemo/  
由于需要和remote集成http服务区分,所以这里web访问的路径(见web.xml中的springMvc的servlet的url-pattern配置):http://localhost:8080/springDemo/web

* 原始的mvc配置
需要在application-mvc.xml配置BeanNameUrlHandlerMapping,自定义的AbsController,InternalResourceViewResolver  
url访问例子:  
http://localhost:8080/springDemo/web/absController.do?reqParam1=hello

* mvc注解配置,HelloAnnotationController的printHello方法
url访问例子:  
http://localhost:8080/springDemo/web/helloAnnotation/print

* mvc注解配置,包含pojo参数的自动mapping
url访问例子:  
http://localhost:8080/springDemo/web/helloAnnotation/book?selfDefineReqParam=hello&bookName=javasleep&bookPublisher=chinapub

* mvc注解,rest式url,包含service,jdbc的例子
url访问例子:  
http://localhost:8080/springDemo/web/user/id/2976

## jms
使用的ActiveMQ,所以本地测试时需要先安转并启动activemq  
发收消息包含同步和异步两种方式  

## schedule
集成了Quartz作为任务调度的依赖包  
TestSchedule中的测试用例只是将当前睡眠20秒,其间schedule的线程中根据配置,每5秒会唤起一次执行调度任务  

## remote
几种remoting方案共用org.study.spring.remote.IRmiWeatherService接口和org.study.spring.remote.RmiWeatherService的本地服务类

* TestRmi spring基于rmi的remoting方案
* TestHttp 包括spring基于http的remoting方案和集成hessian的方案,需要本地开启web项目  
web项目的http端口我以8080为例子,可以在application-http.xml中修改,见weatherServiceClientProxy的serviceUrl属性配置

## redis
集成了redis作为缓存服务器的功能,需要本地开启redis服务器,端口默认  
TestRedis 里展示了string list set的操作示例

## spring session use redis
使用redis来存放session,需要本地开启redis服务器,端口默认  
TestSpringSessionRedis 里验证redis 中存在spring:session:开头的key