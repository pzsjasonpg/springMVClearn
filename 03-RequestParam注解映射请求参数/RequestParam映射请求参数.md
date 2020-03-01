

之前的@PathVariable注解为一个rest风格注解。

而@RequestParam注解中将请求参数映射到处理方法的入参中。

属性value为参数名；

属性required为是否必须写在url上；

属性defaultValue设置默认值，例如当方法入参类型为int型，required=false时，需要设置默认值才不会出错。

控制层中：

```java
    @RequestMapping("testRequestParams")
    public String testRequestParams(@RequestParam(value = "username") String username, @RequestParam(value = "age",required = false) Integer age) {
        System.out.println("username=" + username + ", age=" + age);
        return SUCCESS;
    }
```

index.jsp中

```html
<a href="springmvc/testRequestParams?username=pzs&age=18">Test RequestParam</a>
```

