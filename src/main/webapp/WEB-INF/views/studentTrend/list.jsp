<%@ page import="com.sun.xml.internal.rngom.ast.builder.Include" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学员班级转换</title>
    <%@include file="/WEB-INF/views/commons/commons.jsp" %>
    <script src="../../../static/js/system/studentTrend.js"></script>
</head>
<body>
<table id="studentTrend_datagrid" fit="true"></table>
<div id="tb">

    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'" data-cmd="add">添加</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',text:'删除'" data-cmd="remove">删除</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload">刷新</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'审核'" data-cmd="changeState">审核</a>


    <input type="text" class="easyui-textbox" name="keyword" prompt="请输入关键字" id="keyword">
    换班时间:<input type="text" id="begindate" class="easyui-datebox" name="begindate" prompt="起始时间">~
    <input type="text" id="enddate" class="easyui-datebox" name="enddate" prompt="结束时间">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" data-cmd="query">查询</a>
</div>
<div id="studentTrend_dialog">
    <form id="editForm" method="post" style="padding: 0px 0px 0px 10px;">
        <input name="id" id="stId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">学员姓名:</font></td>
                <td>
                    <input id="studentTrend_combogrid" name="receiptbill.id"/>
                </td>
            </tr>
            <tr>
                <td><font size="1">类型:</font></td>
                <td><input class="easyui-combobox" type="text" name="gendre"
                           data-options="data:[{'value':1, 'text':'大神班'}
                                ,{'value':0, 'text':'基础班'}], valueField:'value',
                                textField:'text',panelHeight:'auto'"
                /></td>
            </tr>
            <tr>
                <td><font size="1">以前的班级:</font></td>
                <td><input class="easyui-combobox" type="text" name="oldclass.id"
                           data-options="url:'/grade/queryGrades',
                    valueField:'id',textField:'name',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td><font size="1">转换的班级:</font></td>
                <td><input class="easyui-combobox" type="text" name="newclass.id"
                           data-options="url:'/grade/queryGrades',
                    valueField:'id',textField:'name',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td><font size="1">营销人员:</font></td>
                <td><input class="easyui-combobox" type="text" name="marketer.id"
                           data-options="url:'/employee/queryTeachers',
                    valueField:'id',textField:'realname',panelHeight:'auto'"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="bb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
</div>

</html>
