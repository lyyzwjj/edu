<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/7/11
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/system/courseName.js"></script>
</head>
<body>
<table id="cn_datagrid"></table>

<div id="tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="changeState" id="change_btn">非会员课程</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>

    <input class="easyui-textbox" type="text" name="keyword" id="keyword" prompt="按照课程名称或者课程所属系列查询"/>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="query">search</a>
</div>

<div id="cn_dialog">
    <form id="editForm" method="post" style="padding: 35px 0px 0px 35px">
        <input type="hidden" id="cnId" name="id">
        <table style="border-collapse: separate; border-spacing: 10px;">
            <tr>
                <td>课程名称</td>
                <td><input type="text" class="easyui-textbox" name="name"></td>
            </tr>
            <tr>
                <td>课程所属系列</td>
                <td><input type="text" class="easyui-textbox" name="series">
                </td>
            </tr>
            <tr>
                <td>编码</td>
                <td><input type="text" class="easyui-textbox" name="sn">
                </td>
            </tr>
            <tr>
                <td>状态</td>
                <td><input type="text" class="easyui-combobox" name="state"
                           data-options="data:[{'value':'1','text':'非会员课程'},{'value':'0','text':'会员课程'}],
				valueField:'value',textField:'text',panelHeight:'auto'"></td>
            </tr>
        </table>
    </form>
</div>

<div id="bb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
</div>
</body>
</html>
