<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/role.js"></script>
</head>
<body>
<table id="role_datagrid">
    <div id="tb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="delete">删除</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>
    </div>
</table>
<div id="alltb">
    <a id="all_all_a">全选</a>
    <a id="all_cancel_a">取消多选</a>
    <a id="all_part_a">批量选择</a>
</div>
<div id="selftb">
    <a id="self_all_a">全选</a>
    <a id="self_cancel_a">取消多选</a>
    <a id="self_part_a">批量选择</a>
</div>

<div id="role_dialog">
    <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="id" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td>角色编号:</td>
                <td><input class="easyui-textbox" type="text" name="sn"/></td>
                <td>角色全称:</td>
                <td><input class="easyui-textbox" type="text" name="name"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="allPermissions"></div>
                </td>
                <td colspan="2">
                    <div id="selfPermissions"></div>
                </td>
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
