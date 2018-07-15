<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/js/plugins/jquery-easyui/themes/gray/easyui.css">
    <link rel="stylesheet" href="/static/js/plugins/jquery-easyui/themes/icon.css">
    <script src="/static/js/plugins/jquery-easyui/jquery.min.js"></script>
    <script src="/static/js/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="/static/js/system/index.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false" style="height:80px;" >
    <h1 align="center">叩丁狼员工管理系统</h1>
</div>
<div data-options="region:'south',split:false" style="height:60px;">
    <h3 align="center">@版权归狼码教育科技有限公司所有</h3>
</div>
<div data-options="region:'west',split:false" style="width:250px;">
    <div id="aa" class="easyui-accordion" style="width:300px;height:200px;" fit="true">
        <div title="系统菜单" data-options="iconCls:'icon-save',selected:true">
            <ul id="main_tree" ></ul>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-reload' ">
            系统管理
        </div>
        <div title="系统公告" data-options="iconCls:'icon-edit'">
            系统公告
        </div>
    </div>
</div>
<div data-options="region:'center'" >
    <div id="main_tabs" fit="true">
        <div title="首页" closable="true">welcome</div>
    </div>
</div>
</body>
</html>
