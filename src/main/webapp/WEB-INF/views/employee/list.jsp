<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/employee.js"></script>
</head>
<body>
<table id="emp_datagrid">
    <div id="tb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="changeState" id="change_btn">离职</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>
        <!--
        <input class="easyui-textbox" data-options="iconCls:'icon-search'" type="text" style="width:200px"
               name="keyword" id="keyword" prompt="请输入关键字">
        <input class="easyui-combobox" type="text" name="dept.id" id="deptId"
               data-options="url:'/department/queryDepts',
                            valueField:'id',textField:'name',panelHeight:'auto'" prompt="所属部门"/>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" data-cmd="query">查询</a>
        -->
    </div>
</table>

<div id="emp_dialog">
    <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="empId" type="hidden">
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

<div id="bb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
</div>
</body>
</html>
