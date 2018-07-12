<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/client.js"></script>
</head>
<body>
<table id="client_datagrid">
    <div id="tb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'" data-cmd="add"></a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看'" data-cmd="view">查看</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'转正" data-cmd="changeState" id="change_btn"></a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'跟踪" data-cmd="trace" ></a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'放入资源池" data-cmd="pushPool" ></a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'考试等级" data-cmd="bookExam" ></a>
    </div>
</table>

<div id="client_dialog">
    <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="clientId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">学员姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="name"/></td>
            </tr>
            <tr>
                <td><font size="1">营销人员:</font></td>
                <td><input class="easyui-textbox" type="text" name="saleMan.id"/></td>
            </tr>
            <tr>
                <td><font size="1">预约日期:</font></td>
                <td><input class="easyui-datebox" type="text" name="bookDate"/></td>
            </tr>
            <tr>
                <td><font size="1">下次跟踪时间:</font></td>
                <td><input class="easyui-datebox" type="text" name="nextTraceDate"/></td>
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
