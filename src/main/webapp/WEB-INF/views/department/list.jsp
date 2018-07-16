<%--
  Created by IntelliJ IDEA.
  User: 990015
  Date: 2018/7/11
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门管理</title>
   <%-- <jsp:include page="commons/commons.jsp"></jsp:include>--%>
    <link rel="stylesheet" href="/static/js/plugins/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/static/js/plugins/jquery-easyui/themes/icon.css">
    <script src="/static/js/plugins/jquery-easyui/jquery.min.js"></script>
    <script src="/static/js/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="/static/js/system/department.js"></script>
</head>
<body>
<table id="dep_datagrid"></table>
<div id="tb">
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add()">添加</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="edit()">编辑</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="changeState()">改变状态</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="reload()">刷新</a>
    <input class="easyui-textbox" type="text" name="keyword" id="keyword" prompt="请输入想要搜索的部门">
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">搜索</a>
</div>
<div id="dep_dialog">
    <form id="editfrom" method="post" style="padding: 40px 0px 0px 30px;">

        <input type="hidden" id="id" name="id">
        <table style="border-collapse:separate;border-spacing:10px;">
            <tr>
                <td>部门编码:</td>
                <td><input class="easyui-combobox" type="text" name="sn"
                >
                </td>
            </tr>
            <tr>
                <td>部门名称:</td>
                <td><input class="easyui-combobox" type="text" name="name">
            </tr>
            <tr>
                </td>
                <td>状态:</td>
                <td><input class="easyui-combobox" type="text" name="state" id="change_btn"
                    data-options="data:[{'value':'0','text':'已停用'},{'value':'1','text':'正常'}],valueField:'value',textField:'text',paneHeight:'auto'">
                </td>
            </tr>

        </table>
    </form>
</div>
<div id="bb">
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="save()">保存</a>
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="cancel()">取消</a>
</div>
</body>
</html>
