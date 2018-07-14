<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/plugins/jquery-form/jquery.form.min.js"></script>
    <script src="/static/js/system/job.js"></script>
</head>
<body>
<table id="job_datagrid">
    <div id="tb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="delete">删除</a>
    </div>
</table>

<div id="job_dialog">
    <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="empId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">员工账号:</font></td>
                <td><input class="easyui-textbox" type="text" name="username"/></td>
            </tr>

            <tr>
                <td><font size="1">真实姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="realname"/></td>
            </tr>

            <tr>
                <td><font size="1">出生日期:</font></td>
                <td><input class="easyui-datebox" type="text" name="bornDate"/></td>
            </tr>

            <tr>
                <td><font size="1">联系邮箱:</font></td>
                <td><input class="easyui-textbox" type="text" name="eamil"/></td>
            </tr>

            <tr>
                <td><font size="1">考勤卡号:</font></td>
                <td><input class="easyui-textbox" type="text" name="attendanceId"/></td>
            </tr>

            <tr>
                <td><font size="1">考勤卡号:</font></td>
                <td><input class="easyui-textbox" type="text" name="attendanceId"/></td>
            </tr>

            <tr>
                <td><font size="1">考勤卡号:</font></td>
                <td><input class="easyui-textbox" type="text" name="attendanceId"/></td>
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
