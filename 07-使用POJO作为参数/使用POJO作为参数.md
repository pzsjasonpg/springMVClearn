Spring MVC 会按请求参数名和POJO属性名进行自动匹配，自动为该对象填充属性值。支持级联属性。



```java
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
```



```html
<form action="springmvc/testPOJO" method="post">
        name:<input type="text" name="name"/>
        <br>
        password:<input type="password" name="password"/>
        <br>
        email:<input type="text" name="email"/>
        <br>
        age:<input type="text" name="age"/>
        <br>
        province:<input type="text" name="address.province"/>
        <br>
        city:<input type="text" name="address.city"/>
        <input type="submit" value="submit"/>
    </form>
```

