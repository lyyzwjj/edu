<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="/static/js/plugins/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/static/js/plugins/jquery-easyui/themes/icon.css">
    <script src="/static/js/plugins/jquery-easyui/jquery.min.js"></script>
    <script src="/static/js/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="/static/js/system/changePssword.js"></script>
</head>
<body>
<table id="dep_datagrid"></table>
<div id="tb">
    <a  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-man',plain:true" onclick="edit()">修改密码</a>
</div>
<div id="dep_dialog">
    <form id="editfrom" method="post" style="padding: 40px 0px 0px 30px;">

        <input type="hidden" id="id" name="id">
        <table style="border-collapse:separate;border-spacing:10px;">
            <tr>
                <td>用户名:</td>
                <td><input class="easyui-textbox" type="text" name="username"
                >
                </td>
            </tr>
            <tr>
                <td>原密码:</td>
                <td><input class="easyui-textbox" type="text" name="password">
            </tr>
            <tr>
                <td>新密码:</td>
                <td><input class="easyui-textbox" type="text" name="newpassword">
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
