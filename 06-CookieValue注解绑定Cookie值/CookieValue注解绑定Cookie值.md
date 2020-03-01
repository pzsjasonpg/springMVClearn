CookieValue注解绑定Cookie值，与之前的@RequestParam和@RequestHeader一样。

控制器中：

```java
	@RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String jSessionId) {
        System.out.println("testCookieValue: JSESSIONID=" + jSessionId);
        return SUCCESS;
    }
```

index.jsp中：

```html
<a href="springmvc/testCookieValue">testCookieValue</a>
```

