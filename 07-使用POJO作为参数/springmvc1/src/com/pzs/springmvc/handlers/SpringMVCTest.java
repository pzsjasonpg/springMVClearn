package com.pzs.springmvc.handlers;

import com.pzs.springmvc.handlers.com.pzs.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    /**
     * 测试POJO作为参数，SpringMVC会按照请求参数名自动与POJO属性匹配，
     * 并填充属性值，支持在页面上级联属性，
     * @param user
     * @return
     */
    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println(user);
        return SUCCESS;
    }


    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String jSessionId) {
        System.out.println("testCookieValue: JSESSIONID=" + jSessionId);
        return SUCCESS;
    }

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String acceptLanguage) {
        System.out.println("Content-Language: " + acceptLanguage);
        return SUCCESS;
    }

    @RequestMapping("testRequestParams")
    public String testRequestParams(@RequestParam(value = "username") String username, @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("username=" + username + ", age=" + age);
        return SUCCESS;
    }


    /**
     * Rest 风格的 URL. 以 CRUD 为例: 新增: /order POST 修改: /order/1 PUT update?id=1 获取:
     * /order/1 GET get?id=1 删除: /order/1 DELETE delete?id=1
     * <p>
     * 如何发送 PUT 请求和 DELETE 请求呢 ? 1. 需要配置 HiddenHttpMethodFilter 2. 需要发送 POST 请求
     * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
     * <p>
     * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
     */
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest Put: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("testRest Delete: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest() {
        System.out.println("testRest POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable Integer id) {
        System.out.println("testRest GET: " + id);
        return SUCCESS;
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable: " + id);
        return SUCCESS;
    }

    @RequestMapping("test/**/ant/*/testAntPath??")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    @RequestMapping(value = "/testParams", params = {"username", "age!=10"}, headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String testParamsAndHeader() {
        System.out.println("testParamsAndHeader");
        return SUCCESS;
    }

    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("Test RequestMapping method");
        return SUCCESS;
    }

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("Test RquestMapping");
        return SUCCESS;
    }

}
