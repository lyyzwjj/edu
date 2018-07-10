<%--
  Created by IntelliJ IDEA.
  User: WangZhe
  Date: 2018/7/10
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="employee">
    ID:${employee.id}||name:${employee.name}||age:${employee.age} <br>
</c:forEach>
</body>
</html>
