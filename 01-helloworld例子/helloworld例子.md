步骤： 

- 加入 jar 包 
- 在 web.xml 中配置 **DispatcherServlet**
- 加入 Spring MVC 的配置文件
- 编写处理请求的处理器，并标识为处理器
- 编写视图



## 1 jar 包

– **commons-logging-1.1.3.jar**

– spring-aop-4.0.0.RELEASE.jar

– spring-beans-4.0.0.RELEASE.jar

– spring-context-4.0.0.RELEASE.jar

– spring-core-4.0.0.RELEASE.jar

– spring-expression-4.0.0.RELEASE.jar

– **spring-web-4.0.0.RELEASE.jar**

– **spring-webmvc-4.0.0.RELEASE.jar**



## 2 在 web.xml 中配置 **DispatcherServlet**

配置初始化参数contextConfigLocation可以定义springMVC配置文件的位置和名称。还有一种方法是默认的配置文件，默认配置文件取名规则为```<servlet-name>-servlet.xml```，文件位置与web.xml同级，在WEB-INF目录下。

```xml
<servlet>
        <servlet-name>springDispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--配置DispatcherServlet的一个初始化参数，配置springMVC配置文件的位置和名称-->
        <!--
        实际上也可以不配置contextConfigLocation来SpringMVC的配置文件，
        默认的配置文件为<servlet-name>-servlet.xml
        -->
        <!--<init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>-->
        <!--DispatcherServlet在应用开启时加载，而不是请求的时候-->
        <load-on-startup>1</load-on-startup>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>springDispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```



## 3 加入 Spring MVC 的配置文件

其中需要**配置视图解析器**，在@Controller注解下的类的@RequestMapping注解的方法返回值为字符串，应该将其转发为什么样的视图界面。视图解析逻辑位置为```/WEB-INF/views/<returnValue>.jsp```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--配置自定义扫描的包-->
    <context:component-scan base-package="com.pzs.springmvc"></context:component-scan>

    <!--配置视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
</beans>
```



## 4 编写处理请求的处理器，并标识为处理器

```java
@Controller
public class HelloWorld {
    /**
     * 返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下的解析：
     * 通过prefix + returnValue + suffix后缀 得到实际的物理视图，然后做转发操作。
     * /WEB-INF/views/success.jsp
     * @return
     */
    @RequestMapping(value = "/helloworld")
    public String hello() {
        System.out.println("hello world");
        return "success";
    }
}
```

