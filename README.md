# springDemo
A spring demo project for study.

项目代码结构说明
========

* 按照maven的标准项目目录构建
* 单元测试的例子都在test/java/org/study/spring 目录下
* 为了简化pojo代码编写,引入了lombok,所有pojo的属性编写完之后不需要在写get set方法

ioc 容器
------

* TestIoc spring最基本的ioc容器的例子,包括构造方法注入 属性注入 注解配置的注入

aop
---

* TestAop 基于java的接口代理和基于cglib的类动态代理例子
* TestAop2 基于AspectJ的代理例子

jdbc
----

* TestJdbc spring直接使用jdbc的例子

iBatis
------

* TestIBatis iBatis使用的例子
* TestIBatisSpring spring集成iBatis的例子

事务管理
----

* TestTransaction spring中配置事务管理的例子

spring mvc 例子运行说明
-----------------

按照标准的maven项目目录，所以可以直接在项目根目录下执行mvn clean install命令，将应用打成war包执行
比如发布到本地8080端口，则web项目路径
http://localhost:8080/springDemo/

HelloController的printHello方法访问路径
http://localhost:8080/springDemo/hello
