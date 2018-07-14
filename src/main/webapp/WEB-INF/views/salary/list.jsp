<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/plugins/jquery-form/jquery.form.min.js"></script>
    <script src="/static/js/system/salary.js"></script>
</head>
<body>
<table id="salary_datagrid">
    <div id="tb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="delete">删除</a>
    </div>
</table>


<div id="salary_dialog">
    <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="salaryId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">工作天数:</font></td>
                <td><input class="easyui-textbox" type="text" name="workDay"/></td>
            </tr>

            <tr>
                <td><font size="1">个人所得税:</font></td>
                <td><input class="easyui-textbox" type="text" name="personIncomeTax"/></td>
            </tr>

            <tr>
                <td><font size="1">银行卡号:</font></td>
                <td><input class="easyui-textbox" type="text" name="bankcardNumber"/></td>
            </tr>
            <tr>
                <td><font size="1">迟到天数:</font></td>
                <td><input class="easyui-textbox" type="text" name="lateday"/></td>
            </tr>

            <tr>
                <td><font size="1">工资月份:</font></td>
                <td><input class="easyui-datebox" type="text" name="month"/></td>
            </tr>
            <tr>
                <td><font size="1">员工:</font></td>
                <td><input class="easyui-combobox" type="text" name="employee.id"
                           data-options="url:'/employee/queryEmployees',
                            valueField:'id',textField:'realname',panelHeight:'auto'"/></td>
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
