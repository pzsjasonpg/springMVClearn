@RequestMapping注解可以在方法和类上注解。

## 参数

### value参数

@RquestMapping注解中value参数，代表url上的路径。

### method参数

代表用什么方法请求。get,post...

```java
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("Test RequestMapping method");
        return SUCCESS;
    }
```



### params和headers参数

http参数```http://www.***?param1=""&param2=""```

params 和 headers**支持简单的表达式**： 

- param1: 表示请求必须包含名为 param1 的请求参数
- !param1: 表示请求不能包含名为 param1 的请求参数
- param1 != value1: 表示请求包含名为 param1 的请求参数，但其值不能为 value1,也可以不包含param1参数
- {“param1=value1”, “param2”}: 请求必须包含名为 param1 和param2 

的两个请求参数，且 param1 参数的值必须为 value1

```java
@RequestMapping(value = "/testParams",params = {"username","age!=10"},headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String testParamsAndHeader() {
        System.out.println("testParamsAndHeader");
        return SUCCESS;
    }
```

## url映射（通配符）

**Ant 风格资源地址支持 3种匹配符**： 

- ?：匹配文件名中的一个字符
- *：匹配文件名中的任意字符
- **：** 匹配多层路径

• @RequestMapping 还支持** Ant风格的 URL**： *

- /user/*/createUser: 匹配

/user/**aaa**/createUser、/user/**bbb**/createUser 等 URL

- /user/**/createUser: 匹配

/user/createUser、/user/**aaa/bbb/**createUser 等 URL

- /user/createUser??: 匹配

/user/createUser**aa**、/user/createUser**bb** 等 URL

```java
@RequestMapping("test/**/ant/*/testAntPath??")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }
```

## @PathVariable映射URL绑定的占位符

- 带占位符的URL 是 **Spring3.0** **新增的功能**，该功能在SpringMVC 向 **REST** 目标挺进发展过程中具有里程碑的意义 
- 通过 @PathVariable可以将URL中占位符参数绑定到控制器处理方法的入参中：URL 中的 {**xxx**} 占位符可以通过 @PathVariable("**xxx**") 绑定到操作方法的入参中。

```java
	@RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable: " + id);
        return SUCCESS;
    }
```



## HiddenHttpMethodFilter过滤器

**HiddenHttpMethodFilter**过滤器起到的作用是将POST请求转成PUT和DELETE方法。

**HiddenHttpMethodFilter**：浏览器 form 表单只支持 GET与 POST 请求，而DELETE、PUT 等 method 并不支 持，Spring3.0 添加了一个过滤器，可以将这些请求转换为标准的 http 方法，使得支持 GET、POST、PUT 与DELETE 请求。

==注意：要将其post方法转成put和delete方法，在请求时要带上一个隐藏参数 **_method=PUT | DELETE**==

rest风格：

- /order/1 HTTP GET ：得到 id = 1 的 order 
- /order/1 HTTP DELETE：删除 id = 1的 order 
- /order/1 HTTP PUT：更新id = 1的 order 
- /order HTTP POST：新增 order



在web.xml文件中添加过滤器配置

```xml
<!-- 
	配置 org.springframework.web.filter.HiddenHttpMethodFilter: 可以把 POST 请求转为 DELETE 或 POST 请求 
	-->
	<filter>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```

控制器中：

```java
/**
	 * Rest 风格的 URL. 以 CRUD 为例: 新增: /order POST 修改: /order/1 PUT update?id=1 获取:
	 * /order/1 GET get?id=1 删除: /order/1 DELETE delete?id=1
	 * 
	 * 如何发送 PUT 请求和 DELETE 请求呢 ? 1. 需要配置 HiddenHttpMethodFilter 2. 需要发送 POST 请求
	 * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
	 * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
	 * 
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
```

index.jsp中

```html
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TestRest PUT"/>
	</form>
	<br><br>
	
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TestRest DELETE"/>
	</form>
	<br><br>
	
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>
	<br><br>
	
	<a href="springmvc/testRest/1">Test Rest Get</a>
	<br><br>
```





