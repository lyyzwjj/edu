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
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="delete">删除</a>

        <input class="easyui-textbox" data-options="iconCls:'icon-search'" type="text" style="width:200px"
               name="keyword" id="keyword" prompt="请输入用户名或真实姓名查询">

        <input class="easyui-combobox" type="text" name="dept.id" id="deptId"
               data-options="url:'/department/queryDepts',
                            valueField:'id',textField:'name',panelHeight:'auto'" prompt="所属部门"/>
        通过入职时间查询:
        <input class="easyui-datebox" data-options="iconCls:'icon-search'" type="text" style="width:150px"
               name="beginDate" id="beginDate" prompt="开始时间">~
        <input class="easyui-datebox" data-options="iconCls:'icon-search'" type="text" style="width:150px"
               name="endDate" id="endDate" prompt="结束时间">


        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" data-cmd="query">查询</a>
    </div>
</table>

<div id="emp_dialog">
    <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="empId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">员工账号:</font></td>
                <td><input class="easyui-textbox" type="text" name="username"/></td>

                <td><font size="1">员工密码:</font></td>
                <td><input class="easyui-textbox" type="text" name="password"/></td>

                <td><font size="1">员工工号:</font></td>
                <td><input class="easyui-textbox" type="text" name="employeeId"/></td>
            </tr>
            <tr>
                <td><font size="1">真实姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="realname"/></td>

                <td><font size="1">员工年龄:</font></td>
                <td><input class="easyui-textbox" type="text" name="age"/></td>

                <td><font size="1">员工性别:</font></td>
                <td><input class="easyui-combobox" type="text" name="gender"
                           data-options="data:[{'value':1, 'text':'男'}
                                ,{'value':0, 'text':'女'}], valueField:'value',
                                textField:'text',panelHeight:'auto'"
                /></td>
            </tr>
            <tr>
                <td><font size="1">出生日期:</font></td>
                <td><input class="easyui-datebox" type="text" name="bornDate"/></td>

                <td><font size="1">身份证号:</font></td>
                <td><input class="easyui-textbox" type="text" name="cardId"/></td>

                <td><font size="1">联系电话:</font></td>
                <td><input class="easyui-textbox" type="text" name="tel"/></td>
            </tr>
            <tr>
                <td><font size="1">联系邮箱:</font></td>
                <td><input class="easyui-textbox" type="text" name="eamil"/></td>

                <td><font size="1">QQ:</font></td>
                <td><input class="easyui-textbox" type="text" name="qq"/></td>

                <td><font size="1">联系地址:</font></td>
                <td><input class="easyui-textbox" type="text" name="address"/></td>
            </tr>
            <tr>
                <td><font size="1">考勤卡号:</font></td>
                <td><input class="easyui-textbox" type="text" name="attendanceId"/></td>

                <td><font size="1">入职日期:</font></td>
                <td><input class="easyui-datebox" type="text" name="hireDate"/></td>

                <td><font size="1">员工工龄:</font></td>
                <td><input class="easyui-textbox" type="text" name="seniority"/></td>
            </tr>
            <tr>
                <td><font size="1">员工状态:</font></td>
                <td><input class="easyui-combobox" type="text" name="state" id="stateId"
                           data-options="data:[{'value':true, 'text':'在职'}
                                ,{'value':false, 'text':'离职'}], valueField:'value',
                                textField:'text',panelHeight:'auto'"
                /></td>

                <td><font size="1">超级管理员:</font></td>
                <td><input class="easyui-combobox" type="text" name="admin" id="adminId"
                           data-options="data:[{'value':1, 'text':'是'}
                                ,{'value':0, 'text':'否'}], valueField:'value',
                                textField:'text',panelHeight:'auto'"
                /></td>
                <td><font size="1">所属部门:</font></td>
                <td><input class="easyui-combobox" type="text" name="dept.id"
                           data-options="url:'/department/queryDepts',
                            valueField:'id',textField:'name',panelHeight:'auto'"/></td>
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
