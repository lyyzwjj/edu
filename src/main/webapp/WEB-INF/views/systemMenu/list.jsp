<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/systemMenu.js"></script>
</head>
<body>
<%--数据字典--%>
<table id="systemMenu_treegrid">
</table>
<div id="tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="delete">删除</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>
</div>
<div id="systemMenu_dialog">
    <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="id" type="hidden">
        <input name="parent.id" type="hidden"/>
        <input name="permission.id" type="hidden"/>
        <input name="permission.resource" type="hidden"/>
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">菜单名称：</font></td>
                <td><input class="easyui-textbox" type="text" name="text"/></td>
            </tr>
            <tr>
                <td><font size="1">菜单路径:</font></td>
                <td><input id="mytextbox" class="easyui-textbox" data-options="prompt:'需选择父级菜单才能输入',value:'null'" type="text" name="url" readonly="readonly" /></td>
            </tr>
            <tr>
            <td><font size="1">父级菜单:</font></td>
            <td><input id="mycombobox" type="text" name="parent.text" /></td>
            </tr>
            <td><font size="1">对应页面:</font></td>
            <td><input id="mycombobox2" type="text" name="permission.text" /></td>
            <tr>

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
