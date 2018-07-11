<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>支出管理</title>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/expendbill.js"></script>
</head>
<body>
    <table id="exp_datagruid"></table>

    <div id="tb">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="add">添加</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-cmd="remove">删除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="search">高级查询</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" data-cmd="ok">审核</a>
    </div>

    <div id="exp_dialog">
        <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
            <input name="id" id="expId" type="hidden">
            <table style="border-collapse:separate; border-spacing:10px;">
                <tr>
                    <td><font size="1">用户名:</font></td>
                    <td><input class="easyui-textbox" type="text" name="username"/></td>
                </tr>
                <tr>
                    <td><font size="1">真实姓名:</font></td>
                    <td><input class="easyui-textbox" type="text" name="realname"/></td>
                </tr>
                <tr>
                    <td><font size="1">密码:</font></td>
                    <td><input class="easyui-textbox" type="text" name="password"/></td>
                </tr>
                <tr>
                    <td><font size="1">电话:</font></td>
                    <td><input class="easyui-textbox" type="text" name="tel"/></td>
                </tr>
                <tr>
                    <td><font size="1">邮箱:</font></td>
                    <td><input class="easyui-textbox" type="text" name="email"/></td>
                </tr>
                <tr>
                    <td><font size="1">入职日期:</font></td>
                    <td><input class="easyui-datebox" type="text" name="hiredate"/></td>
                </tr>
                <tr>
                    <td><font size="1">是否为超级管理员:</font></td>
                    <td><input class="easyui-combobox" type="text" name="admin" id="adminId"
                               data-options="data:[{'value':1, 'text':'是'}
                                ,{'value':0, 'text':'否'}], valueField:'value',
                                textField:'text',panelHeight:'auto'"
                    /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
