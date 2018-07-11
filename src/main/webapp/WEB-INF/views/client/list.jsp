<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>潜在客户管理</title>
    <%@include file="/WEB-INF/views/commons/commons.jsp" %>
    <script src="../../../static/js/system/client.js"></script>
</head>
<body>
<table id="client_datagrid" fit="true"></table>
<div id="tb">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" class="easyui-textbox" name="keyword" prompt="请输入关键字" id="keyword">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    入职时间:<input type="text" id="beginDate" class="easyui-datebox" name="beginDate"prompt="起始时间">~
    <input type="text" id="endDate" class="easyui-datebox" name="endDate" prompt="结束时间">
    <a  class="easyui-linkbutton"data-options="iconCls:'icon-search'"  data-cmd="query">查询</a>
    <br>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'" data-cmd="add"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看'" data-cmd="view">查看</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload">刷新</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'转正'" data-cmd="changeState" id="change_btn"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'跟踪'" data-cmd="trace" ></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'放入资源池'" data-cmd="pushPool" ></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'考试登记'" data-cmd="bookExam" ></a>
</div>
<div id="client_dialog">
    <form id="editForm" method="post" style="padding: 0px 0px 0px 10px;">
        <input name="id" id="clientId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">建档日期:</font></td>
                <td><input class="easyui-datebox" type="text" name="buildDate" prompt="请选择建档日期"/></td>
                <td><font size="1">营销人员:</font></td>
                <td><input class="easyui-combobox" type="text" id="sale_man_id" name="saleMan.id" prompt="请选择营销人员"
                    data-options="
                    valueField: 'id',
                    textField: 'username',
                    url: '/employee/queryEmployee',
                    panelHeight:'auto'"
                    /></td>
                <td><font size="1">录入人:</font></td>
                <td><input class="easyui-combobox" type="text"  id="input_man_id"name="inputMan.id" prompt="请选择录入人"
                           data-options="
                    valueField: 'id',
                    textField: 'username',
                    url: '/employee/queryEmployee',
                    panelHeight:'auto'"
                /></td>
            </tr>
            <tr>
                <td><font size="1">录入时间:</font></td>
                <td><input class="easyui-datebox" type="text" name="buildDate" prompt="请选择录入时间"/></td>
                <td><font size="1">预约日期:</font></td>
                <td><input class="easyui-datebox" type="text" name="bookDate" prompt="请选择预约时间"/></td>
                <td><font size="1">下次跟踪时间:</font></td>
                <td><input class="easyui-datebox" type="text" name="nextTraceDate" prompt="请选择下次跟踪时间"/></td>
            </tr>
            <tr>
                <td><font size="1">姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="name" prompt="请输入客户姓名"/></td>
                <td><font size="1">年龄:</font></td>
                <td><input class="easyui-textbox" type="text" name="age" prompt="请输入客户年龄"/></td>
                <td><font size="1">性别:</font></td>
                <td><input class="easyui-combobox" type="text" name="gender" prompt="请选择客户性别"
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
                <td><input class="easyui-textbox" type="text" name="tel" prompt="请输入客户联系电话"/></td>
                <td><font size="1">微信:</font></td>
                <td><input class="easyui-textbox" type="text" name="weChatNum" prompt="请输入客户的微信号码"/></td>
                <td><font size="1">QQ:</font></td>
                <td><input class="easyui-textbox" type="text" name="QQNum" prompt="请输入客户的QQ号码"/></td>
            </tr>
            <tr>
                <td><font size="1">邮箱:</font></td>
                <td><input class="easyui-textbox" type="text" name="email" prompt="请输入客户的邮箱地址"/></td>
                <td><font size="1">地址:</font></td>
                <td><input class="easyui-textbox" type="text" name="address" prompt="请输入客户住址"/></td>
                <td><font size="1">学校:</font></td>
                <td><input class="easyui-textbox" type="text" name="school" prompt="请输入客户住址"/></td>

            </tr>
            <tr>
                <td><font size="1">学历:</font></td>
                <td><input class="easyui-combobox" type="text" name="education" prompt="请选择客户学历"/></td>
                <td><font size="1">入学时间:</font></td>
                <td><input class="easyui-datebox" type="text" name="collegeAdmissionTime" prompt="请选择客户大学入学时间"/></td>
                <td><font size="1">专业:</font></td>
                <td><input class="easyui-combobox" type="text" name="major" prompt="请选择客户专业"/></td>

            </tr>
            <tr>
                <td><font size="1">客户来源:</font></td>
                <td><input class="easyui-combobox" type="text" name="sourceOfClient" prompt="请选择客户来源"/></td>
                <td><font size="1">学校客户:</font></td>
                <td><input class="easyui-combobox" type="text" name="school" prompt="请选择学校客户"/></td>
                <td><font size="1">客户类型:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientType" prompt="请选择客户类型"/></td>


            </tr>
            <tr>
                <td><font size="1">工作年限:</font></td>
                <td><input class="easyui-combobox" type="text" name="yearsOfWorkExperience" prompt="请选择客户工作年限"/></td>
                <td><font size="1">介绍人:</font></td>
                <td><input class="easyui-combobox" type="text" name="introduceMan" prompt="请选择介绍人"/></td>
                <td><font size="1">地域:</font></td>
                <td><input class="easyui-combobox" type="text" name="hometown" prompt="请选择客户地域"/></td>

            </tr>
            <tr>
                <td><font size="1">意向程度:</font></td>
                <td><input class="easyui-combobox" type="text" name="yearsOfWorkExperience" prompt="请选择客户意向程度"/></td>
                <td><font size="1">意向校区:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionSchool" prompt="请选择客户意向校区"/></td>
                <td><font size="1">意向班级:</font></td>
                <td><input class="easyui-combobox" type="text" name="introduceMan" prompt="请选择客户意向班级"/></td>

            </tr>
            <tr>
                <td><font size="1">付款情况:</font></td>
                <td><input class="easyui-combobox" type="text" name="payStatus" prompt="请选择客户付款情况"/></td>
                <td><font size="1">客户当前状态:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientState" prompt="请选择客户当前状态"/></td>
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
            <tr >
                <td><font size="1">客户关注点:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:680,height:120" type="text" name="clientAttentionWhat" prompt="请输入客户的关注点"/></td>
            </tr>
            <tr >
                <td><font size="1">备注:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:680,height:120" type="text" name="remark" prompt="请输入备注"/></td>
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
