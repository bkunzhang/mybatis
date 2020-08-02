## sql见
work-project-study

## 问题
### logback在这里好像不起作用，debug级别，但是没有打印mybatis查询sql，logback没被加载？
是因为没有maven引入logback，引入了，会起作用的。还在mybatis的源码中发现了日志相关的单元测试，
可以在单元测试中学习。

org.apache.ibatis.logging.LogFactory源码

可以看到在静态块中先后尝试设置几种日志类，先尝试的是Slf4j，如果没有设置成功`if (logConstructor == null)`，就不在尝试其他的

![image-20200725222717135](readme.assets/image-20200725222717135.png)

![image-20200725222806682](readme.assets/image-20200725222806682.png)



![image-20200725222736579](readme.assets/image-20200725222736579.png)



![image-20200725222823415](readme.assets/image-20200725222823415.png)

调试Slf4j的源码可以看到会先检测org/slf4j/impl/StaticLoggerBinder.class是否存在，如果存在会调用StaticLoggerBinder.getSingleton().getLoggerFactory()，而logback实现了org.slf4j.impl.StaticLoggerBinder类，在getLoggerFactory()把logback的日志工厂返回，这样就使用logback，使用哪种日志，关键在于哪个日志包实现了StaticLoggerBinder。把对于的日志库依赖引入即可。

![image-20200725231125508](readme.assets/image-20200725231125508.png)

logback实现ch.qos.logback.classic.LoggerContext implements  org.slf4j.ILoggerFactory

ch.qos.logback.classic.logger也实现了org.slf4j.Logger接口

