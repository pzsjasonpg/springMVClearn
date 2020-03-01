package com.pzs.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

    /**
     * 返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下的解析：
     * 通过prefix + returnValue + suffix后缀 得到实际的物理视图，然后做转发操作。
     *
     * /WEB-INF/views/success.jsp
     *
     * @return
     */
    @RequestMapping(value = "/helloworld")
    public String hello() {
        System.out.println("hello world");
        return "success";
    }
}
