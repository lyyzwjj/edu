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
    <script type="text/javascript" src="/static/js/system/grade.js"></script>
</head>
<body>
<table id="grade_datagrid"></table>

<div id="tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="changeState" id="change_btn">毕业</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>

    <input class="easyui-textbox" type="text" name="keyword" id="keyword" prompt="按照班级名称查询"/>
    <input class="easyui-textbox" type="text" name="empId" id="empId" prompt="按照班主任名称查询"/>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="query">查询</a>
</div>

<div id="grade_dialog">
    <form id="editForm" method="post" style="padding: 35px 0px 0px 35px">
        <input type="hidden" id="gradeId" name="id">
        <table style="border-collapse: separate; border-spacing: 10px;">
            <tr>
                <td>班级名称</td>
                <td><input type="text" class="easyui-textbox" name="name"></td>
            </tr>
            <tr>
                <td>班主任</td>
                <td><input type="text" class="easyui-combobox" name="classTeacher.id"
                           data-options="url:'/employee/queryTeachers',valueField:'id',textField:'realname',panelHeight:'auto',required:true">
                </td>
            </tr>
            <tr>
                <td>课程表</td>
                <td><input type="text" class="easyui-combobox"  id="courseNameId"
                           data-options="url:'/courseName/queryCours',valueField:'id',textField:'name',panelHeight:'auto',required:true,multiple:true">
                </td>
            </tr>

            <tr>
                <td>状态</td>
                <td><input type="text" class="easyui-combobox" name="state"
                           data-options="data:[{'value':'1','text':'毕业'},{'value':'0','text':'未毕业'}],
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
