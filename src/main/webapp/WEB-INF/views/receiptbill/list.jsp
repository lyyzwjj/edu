<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>收款管理</title>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/receiptbill.js"></script>
</head>
<body>
    <table id="rep_datagrid"></table>

    <div id="tb">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="add">添加</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-cmd="remove">删除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" data-cmd="ok">审核</a>

        <input class="easyui-datetimebox" name="begindate" id="begindate" timeSeparator=":"
               data-options="required:true,showSeconds:true" style="width:150px"/>~
        <input class="easyui-datetimebox" name="enddate" id="enddate" timeSeparator=":"
               data-options="required:true,showSeconds:true" style="width:150px"/>
        <input class="easyui-textbox" type="text" name="keyword" id="keyword" prompt="请输入关键字"/>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="query">查询</a>
    </div>

    <div id="rep_dialog">
        <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
            <input name="id" id="repId" type="hidden">
            <table style="border-collapse:separate; border-spacing:10px;">
                <tr>
                    <td>学生姓名:</td>
                    <td><input class="easyui-combobox" type="text" id="clientId"
                               data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/client/queryClients',
                    panelHeight:'auto'"/></td>
                </tr>
                <tr>
                    <td><font size="1">班级:</font></td>
                    <td><input class="easyui-combobox" type="text" id="gradeId"
                               data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/grade/queryGrades',
                    panelHeight:'auto'"/></td>
                </tr>
                </tr>
                <tr>
                    <td><font size="1">收款金额:</font></td>
                    <td><input class="easyui-NumberBox" type="text" name="receiptmoney" data-options="precision:2"></td>
                </tr>
                <tr>
                    <td><font size="1">总金额:</font></td>
                    <td><input class="easyui-NumberBox" type="text" name="totalmoney" data-options="precision:2"></td>
                </tr>
                <tr>
                    <td><font size="1">支付方式::</font></td>
                    <td><input class="easyui-combobox" type="text" name="payment.id"
                               data-options="url:'/payment/queryPayments',
                    valueField:'id',textField:'payname',panelHeight:'auto'"/></td>
                </tr>
                <tr>
                    <td><font size="1">收款人:</font></td>
                    <td><input class="easyui-combobox" type="text" id="receipterId"
                               data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/Employee/queryUser',
                    panelHeight:'auto'"/></td>
                </tr>
                <tr>
                    <td><font size="1">单号:</font></td>
                    <td><input class="easyui-textbox" type="text" name="billnum"/></td>
                </tr>
                <tr>
                    <td><font size="1">营销人员:</font></td>
                    <td><input class="easyui-combobox" type="text" id="marketerId"
                               data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/Employee/queryUser',
                    panelHeight:'auto'"/></td>
                </tr>
                <tr>
                    <td><font size="1">备注:</font></td>
                    <td><input class="easyui-textbox" multiline="true" type="text" name="remark"/></td>
                </tr>
            </table>
        </form>
    </div>--%>

    <div id="bb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
    </div>
</body>
</html>
