<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/student.js"></script>
</head>
<body>
<table id="client_datagrid">
    <div id="tb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
        <%--<a class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看'" data-cmd="view">查看</a>--%>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload">刷新</a>

        <input class="easyui-datetimebox" name="begindate" id="begindate" timeSeparator=":"
               data-options="showSeconds:true" style="width:150px"/>~
        <input class="easyui-datetimebox" name="enddate" id="enddate" timeSeparator=":"
               data-options="showSeconds:true" style="width:150px"/>
        <input class="easyui-textbox" type="text" name="keyword" id="keyword" prompt="请输入关键字"/>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="query">查询</a>
    </div>
</table>

<div id="client_dialog">
    <form id="editForm" method="post" style="padding: 40px 0px 0px 30px;">
        <input name="id" id="clientId" type="hidden">

        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="name" prompt="请输入学员姓名"/></td>
                <td><font size="1">年龄:</font></td>
                <td><input class="easyui-textbox" type="text" name="age" prompt="请输入学员年龄"/></td>
                <td><font size="1">性别:</font></td>
                <td><input class="easyui-combobox" type="text" name="gender" prompt="请选择学员性别"
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
            </tr>
            <tr>
                <td><font size="1">电话:</font></td>
                <td><input class="easyui-textbox" type="text" name="tel" prompt="请输入学员联系电话"/></td>
                <td><font size="1">微信:</font></td>
                <td><input class="easyui-textbox" type="text" name="weChatNum" prompt="请输入学员的微信号码"/></td>
                <td><font size="1">QQ:</font></td>
                <td><input class="easyui-textbox" type="text" name="QQNum" prompt="请输入学员的QQ号码"/></td>
            </tr>
            <tr>
                <td><font size="1">邮箱:</font></td>
                <td><input class="easyui-textbox" type="text" name="email" prompt="请输入学员的邮箱地址"/></td>
                <td><font size="1">地址:</font></td>
                <td><input class="easyui-textbox" type="text" name="address" prompt="请输入学员住址"/></td>
                <td><font size="1">学校:</font></td>
                <td><input class="easyui-textbox" type="text" name="school" prompt="请输入学员学校名称"/></td>

            </tr>
            <tr>
                <td><font size="1">学历:</font></td>
                <td><input class="easyui-combobox" type="text" name="educationId" prompt="请选择学员学历"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=2',
                    panelHeight:'auto'"/></td>
                <td><font size="1">专业:</font></td>
                <td><input class="easyui-combobox" type="text" name="majorId" prompt="请选择学员专业"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=4',
                    panelHeight:'auto'"/></td>

            </tr>
            <tr>
                <td><font size="1">学员来源:</font></td>
                <td><input class="easyui-combobox" type="text" name="sourceOfClientId" prompt="请选择学员来源"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=10',
                    panelHeight:'auto'"/></td>
                <%--<td><font size="1">学校客户:</font></td>
                <td><input class="easyui-combobox" type="text" name="school" prompt="请选择学校客户"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=4',
                    panelHeight:'auto'"/></td>--%>
                <td><font size="1">学员类型:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientTypeId" prompt="请选择学员类型"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=9',
                    panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td><font size="1">工作年限:</font></td>
                <td><input class="easyui-combobox" type="text" name="yearsOfWorkExperienceId" prompt="请选择学员工作年限"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=11',
                    panelHeight:'auto'"/></td>
                <td><font size="1">地址:</font></td>
                <td><input class="easyui-combobox" type="text" name="hometownId" prompt="请选择学员地址"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=14',
                    panelHeight:'auto'"/></td>
                <td><font size="1">意向校区:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionSchoolId" prompt="请选择学员意向校区"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=16',
                    panelHeight:'auto'"/></td>
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
