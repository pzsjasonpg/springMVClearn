<%--
  Created by IntelliJ IDEA.
  User: 28256
  Date: 2020/3/1
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

    <br>
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

    <br>
    <a href="springmvc/testCookieValue">testCookieValue</a>
    <br>

    <a href="springmvc/testRequestHeader">Test RequestHeader</a>
    <br>

    <a href="springmvc/testRequestParams?username=pzs&age=18">Test RequestParam</a>
    <br>

    <form action="springmvc/testRest/1" method="post">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="submit" value="TestRest PUT"/>
    </form>
    <br>

    <form action="springmvc/testRest/1" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <input type="submit" value="TestRest DELETE"/>
    </form>
    <br>

    <form action="springmvc/testRest" method="post">
        <input type="submit" value="TestRest POST"/>
    </form>
    <br>

    <a href="springmvc/testRest/1">Test Rest Get</a>
    <br>

    <br>
    <a href="springmvc/testPathVariable/1">Test PathVariable</a>
    <br>

    <a href="springmvc/test/1/2/ant/1/testAntPathaa">Test AntPath</a>
    <br>

    <a href="springmvc/testParams?username=pzs&age=11">Test paramsAndHeader</a>
    <br>

    <%-- test RequestMapping method--%>
    <form action="springmvc/testMethod" method="post">
        <input type="submit" value="submit"/>
    </form>
    <br>

    <a href="springmvc/testRequestMapping">Test RequestMapping</a>
    <br>

   <a href="helloworld">Hello World</a>
</body>
</html>
