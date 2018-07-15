<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"/>
    <script src="/static/js/plugins/jquery-form/jquery.form.min.js"></script>
    <script src="/static/js/system/recruit.js"></script>
    <script src="/static/js/layui/layui.js"></script>
    <link rel="stylesheet" href="/static/js/layui/css/layui.css">
    <link rel="stylesheet" href="/static/css/admin.css" media="all">
    <style>
        #staff_form td {
            padding: 5px 0px;
        }
    </style>
</head>
<body>
<div id="loading"></div>
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-header">招聘管理</div>
        <div class="layui-card-body" style="height: 750px">
            <%--自己写的管理--%>
            <table id="recruit_datagrid"></table>
            <!--左上方工具栏-->
            <div id="toolbar">
                <div>
                    <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                       data-cmd="add">新增</a>
                    <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
                       data-cmd="edit">编辑</a>
                    <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-reload" plain="true"
                       data-cmd="reload">刷新</a>
                </div>
                <!--高级查询-->
                开始时间: <input type="text" class="easyui-datebox" name="beginDate" prompt="开始日期"/>

                审核人: <input type="text" class="easyui-textbox" name="examine"/>
                <a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
                   data-cmd="query">查询</a><br>
                结束时间: <input type="text" class="easyui-datebox" name="endDate" prompt="结束日期"/>
                制定人: <input type="text" class="easyui-textbox" name="staff"/>

            </div>
        </div>


        <%--<!--模态框-->--%>
        <div id="recruit_dialog" style="display: none">
            <form id="recruit_form" method="post">
                <table style="margin: 20px auto 0px;">
                    <input type="hidden" id="recruitId" name="id"/>
                    <tr>
                        <td>
                            <font size="1">计划类别:</font> <input type="text" editable="false" class="easyui-combobox"
                                                               name="planType.id"
                                                               prompt="计划类别" data-options="
                                        url:'/dataDictionaryItem/queryListByParent?parentId=28',
                                        valueField: 'id',
                                        editable:false,
                                        textField: 'name',
                                        panelHeight:'auto'
                                       "/>
                        </td>
                        <td>
                            <font size="1">计划名称:</font> <input class="easyui-textbox" name="plan"/>
                        </td>
                        <td>
                            <font size="1">制定时间:</font> <input class="easyui-datebox" name="draftTime"/>
                        </td>
                    </tr>
                </table>
                <div style="margin: 20px auto 0px;">
                    <table id="recruititem_datagrid"></table>
                    <div id="recruititem_toolbar">
                        <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                           data-cmd="add_recruititem">新增</a>
                        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
                           data-cmd="remove_recruititem">删除</a>
                        <a class="easyui-linkbutton" iconCls="icon-save" plain="true"
                           data-cmd="accept_recruititem">保存</a>
                        <a href="javascript:" class="easyui-linkbutton"
                           data-options="iconCls:'icon-undo',plain:true" data-cmd="reject_recruititem">撤销</a>
                    </div>
                </div>
            </form>
        </div>
        <%--<!--模态框管理-->--%>
        <div id="form_btns">
            <a id="btn_save" href="javascript:;" class="easyui-linkbutton" iconCls="icon-save" plain="true"
               data-cmd="save">保存</a>
            <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
               data-cmd="cancel">取消</a>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>