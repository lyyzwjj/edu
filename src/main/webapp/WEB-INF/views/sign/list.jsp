<%@ page import="com.sun.xml.internal.rngom.ast.builder.Include" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人签到</title>
    <%@include file="/WEB-INF/views/commons/commons.jsp" %>
    <script src="../../../static/js/system/sign.js"></script>
</head>
<body>
<table id="sign_datagrid" fit="true"></table>
</body>

</html>
