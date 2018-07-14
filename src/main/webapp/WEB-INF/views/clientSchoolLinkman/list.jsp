<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>学校联系人</title>
    <%@include file="/WEB-INF/views/commons/commons.jsp" %>
    <script src="../../../static/js/system/clientSchoolLinkman.js"></script>
</head>
<body>
<table id="clientSchoolLinkman_datagrid" fit="true"></table>
<div id="tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'" data-cmd="add"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',text:'删除'" data-cmd="remove"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload"></a>
</div>



<div id="clientSchoolLinkman_dialog">

    <form id="clientSchoolLinkman_form" method="post" style="padding: 0px 0px 0px 10px;">
        <input type="hidden" name="id" id="clientSchoolLinkmanId" >
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="name" /></td>
                <td><font size="1">学校名称:</font></td>
                <td><input class="easyui-combobox" type="text" name="schoolName.id" prompt="请选择学校名称"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/clientMajor/querySchoolName',
                    panelHeight:'auto'"/></td></tr>
                <tr><td><font size="1">性别:</font></td>
                <td><input class="easyui-combobox" type="text" name="gender" prompt="请选择性别"
                           data-options="
                    valueField: 'gender',
                    textField: 'value',
                    data: [{
                        gender: '1',
                        value: '男'
                    },{
                        gender: '0',
                        value: '女'
                    }],
                    panelHeight:'auto'"
                /></td>

                <td><font size="1">电话:</font></td>
                <td><input class="easyui-textbox" type="text" name="tel" prompt="请输入客户联系电话"/></td></tr>
            <tr><td><font size="1">微信:</font></td>
                <td><input class="easyui-textbox" type="text" name="weChat" prompt="请输入客户的微信号码"/></td>
            <td><font size="1">QQ:</font></td>
                <td><input class="easyui-textbox" type="text" name="qq" prompt="请输入客户的QQ号码"/></td></tr>
            <tr>
                <td><font size="1">邮箱:</font></td>
                <td><input class="easyui-textbox" type="text" name="email" prompt="请输入客户的QQ号码"/></td>
                <td><font size="1">生日:</font></td>
                <td><input class="easyui-datebox" type="text" name="birthday" prompt="请输入客户的生日"/></td></tr>
            <tr><td><font size="1">部门:</font></td>
                <td><input class="easyui-textbox" type="text" name="department" prompt="请输入部门"/></td>
           <td><font size="1">职务:</font></td>
            <td><input class="easyui-textbox" type="text" name="job" prompt="请输入职务"/></td></tr>
                <tr><td><font size="1">主联系人:</font></td>
                <td><input class="easyui-combobox" type="text" name="isMajorLinkman" prompt="是否为主联系人"
                          data-options="
                    valueField: 'linkman',
                    textField: 'value',
                    data: [{
                        linkman: '1',
                        value: '是'
                    },{
                        linkman: '0',
                        value: '否'
                    }],
                    panelHeight:'auto'"
                /></td>

            </tr>
            <tr >
                <td><font size="1">简介:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:400,height:120" type="text" name="introduce" prompt="请输入介绍"/></td>
            </tr>
        </table>
    </form>
</div>
<%--底部工具按钮--%>
<div id="bb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
</div>
</body>
</html>