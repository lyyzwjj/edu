<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
    <script src="/static/js/system/student.js"></script>
</head>
<body>
<table id="client_datagrid">
    <div id="tb">
        <a class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
        <a class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload">刷新</a>

        <input class="easyui-datetimebox" name="begindate" id="begindate" timeSeparator=":"
               data-options="showSeconds:true" style="width:150px"/>~
        <input class="easyui-datetimebox" name="enddate" id="enddate" timeSeparator=":"
               data-options="showSeconds:true" style="width:150px"/>
        <input class="easyui-textbox" type="text" name="keyword" id="keyword" prompt="请输入关键字"/>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="query">查询</a>
        <div style="float: right;">
            <a class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-edit',text:'流失'" data-cmd="leave">流失</a>
            <a class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-edit',text:'休学'" data-cmd="trend" id="trend_btn">休学</a>
        </div>
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
                <td><input class="easyui-combobox" type="text" name="education.id" prompt="请选择学员学历"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=2',
                    panelHeight:'auto'"/></td>
                <td><font size="1">专业:</font></td>
                <td><input class="easyui-combobox" type="text" name="major.id" prompt="请选择学员专业"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=4',
                    panelHeight:'auto'"/></td>
                <td><font size="1">学员来源:</font></td>
                <td><input class="easyui-combobox" type="text" name="sourceOfClient.id" prompt="请选择学员来源"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=10',
                    panelHeight:'auto'"/></td>

            </tr>
            <tr>

                <%-- <td><font size="1">学校客户:</font></td>
                 <td><input class="easyui-combobox" type="text" name="schoolId" prompt="请选择学校客户"/></td>--%>
                <td><font size="1">学员类型:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientTypeId" prompt="请选择学员类型"
                           data-options="
                    valueField: 'clientTypeId',
                    textField: 'value',
                    data: [{
                        clientTypeId: '1',
                        value: '线上'
                    },{
                        clientTypeId: '0',
                        value: '线下'
                    }],
                    panelHeight:'auto'"/></td>


                <td><font size="1">工作年限:</font></td>
                <td><input class="easyui-combobox" type="text" name="yearsOfWorkExperience.id" prompt="请选择学员工作年限"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=11',
                    panelHeight:'auto'"/></td>
                <td><font size="1">地址:</font></td>
                <td><input class="easyui-combobox" type="text" name="hometown.id" prompt="请选择学员地址"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=14',
                    panelHeight:'auto'"/></td>
            </tr>
            <tr>

                <td><font size="1">意向校区:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionSchool.id" prompt="请选择学员意向校区"
                           data-options="
                    valueField:'id',
                    textField:'name',
                    url:'/dataDictionaryItem/queryListByParent?parentId=16',
                    panelHeight:'auto'"/></td>
                <td><font size="1">意向班级:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionClass.id" prompt="请选择客户意向班级"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=17',
                    panelHeight:'auto'"/></td>
                <td><font size="1">是否携带电脑:</font></td>
                <td><input class="easyui-combobox" type="text" name="withComputer" prompt="客户是否携带电脑"
                           data-options="
                    valueField: 'withComputer',
                    textField: 'value',
                    data: [{
                        withComputer: '1',
                        value: '是'
                    },{
                        withComputer: '0',
                        value: '否'
                    }],
                    panelHeight:'auto'"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="leave_dialog" style="display: none">
    <form id="leave_form" method="post">
        <input type="hidden" id="id" name="client.id"/>
        <table style="margin: 20px auto 0px;">
            <tr>
                <td>学员姓名:</td>
                <td><input class="easyui-textbox" type="text" name="name" prompt="请输入学员姓名"/></td>
            </tr>
            <tr>
            <tr>
                <td>就读班级:</td>
                <td><input class="easyui-combobox" type="text" name="grade.id"
                           data-options="url:'/grade/queryGrades',
                    valueField:'id',textField:'name',panelHeight:'auto'"/></td>
            </tr>
            </tr>
            <tr>
                <td>已读天数:</td>
                <td>
                    <input type="number" class="easyui-textbox" name="day"/>
                </td>
            </tr>
            <tr>
                <td>流失时间:</td>
                <td><input class="easyui-datebox" name="leavetime" data-options=" editable:false"/></td>
            </tr>
            <tr>
                <td>流失阶段:</td>
                <td><input class="easyui-combobox" type="text" name="phase" prompt="流失阶段"
                           data-options="
                    valueField: 'phase',
                    textField: 'value',
                    data: [{
                        phase: '1',
                        value: '大神班'
                    },{
                        phase: '0',
                        value: '基础班'
                    }],
                    panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>是否退款:</td>
                <td>
                    <input class="easyui-combobox" name="reimburse" data-options="
                                        valueField: 'value',
                                        textField: 'text',
                                        editable:false,
                                        data: [{
                                            text: '否',
                                            value: '0'
                                        },{
                                            text: '是',
                                            value: '1'
                                        }]"/>
                </td>
            </tr>
            <tr>
            <tr>
                <td>经办人:</td>
                <td><input class="easyui-combobox" type="text" name="operator.id"
                           data-options="url:'/employee/queryTeachers',
                    valueField:'id',textField:'realname',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>营销人员:</td>
                <td><input class="easyui-combobox" type="text" name="marketer.id"
                           data-options="url:'/employee/queryTeachers',
                    valueField:'id',textField:'realname',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>退学原因:</td>
                <td>  <input name="reason" class="easyui-textbox" data-options="multiline:true" style="width:250px;height:50px"></td>
            </tr>
        </table>
    </form>
</div>

    <div id="leave_form_btns">
        <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-save" plain="true"
           data-cmd="leaveSave">保存</a>
        <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
           data-cmd="leaveCancel">取消</a>
    </div>





<div id="bb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
</div>
</body>
</html>
