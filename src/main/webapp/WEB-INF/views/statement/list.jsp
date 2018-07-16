<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"/>
    <script src="/static/js/plugins/jquery-form/jquery.form.min.js"></script>
    <script src="/static/js/system/statement.js"></script>
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
        <div class="layui-card-body" style="height: 850px">
            <%--自己写的管理--%>
            <table id="sta_datagrid"></table>
            <!--左上方工具栏-->
            <div id="toolbar">

                <div>
                    <input class="easyui-textbox"  type="text" style="width:200px"
                           name="keyword" id="keyword" prompt="正式成员姓名">

                    通过付款时间查询:
                    <input class="easyui-datebox" type="text" style="width:200px"
                           name="beginDate" id="beginDate" prompt="开始时间">~
                    <input class="easyui-datebox"  type="text" style="width:200px"
                           name="endDate" id="endDate" prompt="结束时间">
                    分组类型：<input class="easyui-combobox" name="groupByType" id="groupByType" panelHeight="auto"
                                data-options="url:'/statement/queryGroupType',
                              editable:false,
                              valueField: 'groupByType',
                              textField: 'value'"
                                prompt="请选择分组条件查询" />
                    <a class="easyui-linkbutton" data-options="toggle:false,plain:true" iconCls="icon-search"
                       id="query" data-cmd="query">查询</a>
                    <a class="easyui-linkbutton" data-options="toggle:false,plain:true" iconCls="icon-reload" id="reload"
                       data-cmd="reload">刷新</a>
                    <a class="easyui-linkbutton" data-options="toggle:false,plain:true"
                       id="openBar">柱状图</a>

                    <a class="easyui-linkbutton" data-options="toggle:false,plain:true"
                       id="openPie" >饼状图</a>

                </div>
            </div>
            </div>
        </div>
    </div>
</div>
<div id="mydialog"></div>
</body>
</html>