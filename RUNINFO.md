# how to run this project

本段描述项目应该如何运行

项目使用Spring Boot框架编写，使用maven进行依赖管理和搭建工作，提供了如下几种运行方式：

1. （推荐） 首先进入src/resources文件下，修改application.properties文件，将其中的

```yaml
spring.datasource.username = root
spring.datasource.password = MysqlRoot
```

配置为本机的设置，具体的配置可以参考 [Spring 官方文档](http://spring.io/guides/gs/accessing-data-mysql/)

接着运行mvn clean package或者mvn install 安装依赖并打包项目，再使用java -jar \<packageName\> 方法运行该程序，请尽量保持8080端口通常，否则我们可能需要修改部分代码来更改运行端口

该方法可以具体参考 [Spring 官方文献](http://spring.io/guides/gs/rest-service/)

2. （不推荐，很麻烦） 可以将本项目打包成war包方便部署，但是需要在pom.xml和web.xml做出相应的修改，修改过程相对麻烦不在这里描述，请参考链接 [spring-boot项目 war包发布](http://blog.csdn.net/r28_11/article/details/50802336)