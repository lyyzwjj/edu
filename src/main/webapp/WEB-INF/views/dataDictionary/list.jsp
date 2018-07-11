<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/dataDictionary.js"></script>
</head>
<%--数据字典--%>
<div class="easyui-layout" style="width:600px;height:400px;" fit="true">
    <div data-options="region:'west',title:'字典目录',split:true" style="width:500px;">
        <table id="dataDictionary_datagrid">
            <div id="mtb">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="madd">添加</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="medit">编辑</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="mdelete">删除</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="mreload">刷新</a>
            </div>
        </table>
        <div id="dataDictionary_dialog">
            <form id="meditForm" method="post" style="padding: 40px 0px 0px 30px;">
                <input name="id" id="mId" type="hidden">
                <table style="border-collapse:separate; border-spacing:10px;">
                    <tr>
                        <td><font size="1">字典编号：</font></td>
                        <td><input class="easyui-textbox" type="text" name="sn"/></td>
                    </tr>
                    <tr>
                        <td><font size="1">字典名称:</font></td>
                        <td><input class="easyui-textbox" type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td><font size="1">字典简介:</font></td>
                        <td><input class="easyui-textbox" type="text" name="intro"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="mbb">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="msave">保存</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="mcancel">取消</a>
        </div>
        <table>
            <tr>
                <td>

                </td>
            </tr>
        </table>
    </div>
    <%--数据字典明细--%>
    <div data-options="region:'center',title:'字典目录明细'" style="padding:5px;background:#eee;">
        <table id="dataDictionaryItem_datagrid">
            <div id="tb">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="ban">禁用</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>
            </div>
        </table>
        <div id="dataDictionaryItem_dialog">
            <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
                <input name="id" id="itemId" type="hidden">
                <input name="parent.id" type="hidden">
                <table style="border-collapse:separate; border-spacing:10px;">
                    <tr>
                        <td><font size="1">字典目录：</font></td>
                        <td><input class="easyui-textbox" type="text" readonly="readonly" name="parent.name"/></td>
                    </tr>
                    <tr>
                        <td><font size="1">字典明细名称:</font></td>
                        <td><input class="easyui-textbox" type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td><font size="1">字典明细简介:</font></td>
                        <td><input class="easyui-textbox" type="text" name="intro"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="bb">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
        </div>
        <table>
            <tr>
                <td>

                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
