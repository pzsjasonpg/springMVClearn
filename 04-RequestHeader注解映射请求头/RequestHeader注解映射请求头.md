@RequestHeader注解映射请求头，与@RequestParam注解类似。

控制器中：

```java
@RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String acceptLanguage) {
        System.out.println("Content-Language: " + acceptLanguage);
        return SUCCESS;
    }
```

index.jsp中

```html
<a href="springmvc/testRequestHeader">Test RequestHeader</a>
```

如果有请求头，则不会出错，如果没有请求头，会报错。

