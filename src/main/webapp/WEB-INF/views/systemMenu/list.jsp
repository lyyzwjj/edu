<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/systemMenu.js"></script>
</head>
<%--系统菜单--%>
<table id="systemMenu_treegrid">
    <%--    <div id="mtb">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="madd">添加</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="medit">编辑</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="mdelete">删除</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="mreload">刷新</a>
        </div>--%>
</table>
<%--<div id="systemMenu_dialog">
    <form id="meditForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="mId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">菜单名称：</font></td>
                <td><input class="easyui-textbox" type="text" name="sn"/></td>
            </tr>
            <tr>
                <td><font size="1">菜单路劲：</font></td>
                <td><input class="easyui-textbox" type="text" name="sn"/></td>
            </tr>
            <tr>
                <td><font size="1">根菜单:</font></td>
                <td><input class="easyui-textbox" type="text" name="name"/></td>
            </tr>
            <tr>
                <td><font size="1">父菜单:</font></td>
                <td><input class="easyui-textbox" type="text" name="intro"/></td>
            </tr>
        </table>
    </form>
    <div id="mbb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="msave">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="mcancel">取消</a>
    </div>
</div>--%>
</body>
</html>
