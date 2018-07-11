<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>支出管理</title>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/expendbill.js"></script>
</head>
<body>
    <table id="exp_datagrid"></table>

    <div id="tb">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="add">添加</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-cmd="remove">删除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="search">高级查询</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" data-cmd="ok">审核</a>


    </div>

    <div id="exp_dialog">
        <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
            <input name="id" id="expId" type="hidden">
            <table style="border-collapse:separate; border-spacing:10px;">
                <tr>
                    <td><font size="1">支出金额:</font></td>
                    <td><input class="easyui-NumberBox" type="text" name="payMoney" data-options="precision:2"></td>
                </tr>
                <tr>
                    <td><font size="1">类型:</font></td>
                    <td><input class="easyui-textbox" type="text" name="genre"/></td>
                </tr>
                <tr>
                    <td><font size="1">订单号:</font></td>
                    <td><input class="easyui-textbox" type="text" name="billNumber"/></td>
                </tr>
                <tr>
                    <td><font size="1">归属学院:</font></td>
                    <td><input class="easyui-textbox" type="text" name="affiliationSubject"/></td>
                </tr>
                <tr>
                    <td><font size="1">支付方式::</font></td>
                    <td><input class="easyui-combobox" type="text" name="payment.id"
                               data-options="url:'/payment/queryPayments',
                    valueField:'id',textField:'payname',panelHeight:'auto'"/></td>
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
