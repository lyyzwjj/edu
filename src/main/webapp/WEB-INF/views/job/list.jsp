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
        <input name="id" id="jobId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">职务名称:</font></td>
                <td><input class="easyui-textbox" type="text" name="jobName"/></td>
            </tr>

            <tr>
                <td><font size="1">基本工资:</font></td>
                <td><input class="easyui-textbox" type="text" name="baseSalary"/></td>
            </tr>

            <tr>
                <td><font size="1">公积金缴存基数:</font></td>
                <td><input class="easyui-textbox" type="text" name="accumulationFund"/></td>
            </tr>
            <tr>
                <td><font size="1">公积金缴存比例:</font></td>
                <td><input class="easyui-textbox" type="text" name="proportion"/></td>
            </tr>

            <tr>
                <td><font size="1">社保缴存金额:</font></td>
                <td><input class="easyui-textbox" type="text" name="socialInsurance"/></td>
            </tr>

            <tr>
                <td><font size="1">加班补贴:</font></td>
                <td><input class="easyui-textbox" type="text" name="overtimeAllowance"/></td>
            </tr>

            <tr>
                <td><font size="1">奖金:</font></td>
                <td><input class="easyui-textbox" type="text" name="bonus"/></td>
            </tr>

            <tr>
                <td><font size="1">奖金系数:</font></td>
                <td><input class="easyui-textbox" type="text" name="coefficient"/></td>
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
