<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>登录系统</title>
    <link href="/static/css/login.css" rel="stylesheet" type="text/css"/>
    <script>

        function login() {
        $("#loginForm").form("submit",{
            url:"/login",
            success: function (data) {
                data = $.parseJSON(data);
                if(data.success){
                    window.location.href ="/index";
                } else {
                    $.messager.alert("温馨提示", data.msg);
                }
            }

        })
    }
    </script>
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="/static/images/login-img.png"/></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="/static/images/login_logo.png"/></a></div>
        <div class="login_name">
            <p>登陆系统</p>
        </div>
        <form method="post" id="loginForm">
            <p><input type="text" name="username" value="charles" placeholder="账号"></p>
            <p><input type="password" name="password" value="312948" placeholder="密码"></p>
            <p class="submit">
            <input value="登录" style="width:100%;" type="button" onclick="login()">
            </p>
        </form>
    </div>
    <div class="copyright">叩丁狼有限公司 @版权所有王吉吉小组</div>
</div>

</body>
</html>
