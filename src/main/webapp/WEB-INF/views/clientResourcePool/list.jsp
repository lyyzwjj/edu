<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>客户资源池</title>
    <%@include file="/WEB-INF/views/commons/commons.jsp" %>
    <script src="../../../static/js/system/clientResourcePool.js"></script>
</head>
<body>
<table id="clientResourcePool_datagrid" fit="true"></table>
<div id="tb">

    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'指派给某人'" data-cmd="send"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'接收他/她'" data-cmd="accept"></a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" class="easyui-textbox" name="keyword" prompt="请输入关键字" id="keyword">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    输入时间查询:<input type="text" id="beginDate" class="easyui-datebox" name="begindate" prompt="起始时间">~
    <input type="text" id="endDate" class="easyui-datebox" name="enddate" prompt="结束时间">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" data-cmd="query">查询</a>
</div>

<div id="client_dialog">
    <form id="editForm" method="post" style="padding: 0px 0px 0px 10px;">
        <input name="id" id="clientId" type="hidden">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">建档日期:</font></td>
                <td><input class="easyui-datebox" type="text" name="buildDate" prompt="请选择建档日期"/></td>
                <td><font size="1">营销人员:</font></td>
                <td><input class="easyui-combobox" type="text" name="saleMan.id" prompt="请选择营销人员"
                           data-options="
                    valueField: 'id',
                    textField: 'username',
                    url: '/employee/queryTeachers',
                    panelHeight:'auto'"
                /></td>
                <td><font size="1">录入人:</font></td>
                <td><input class="easyui-combobox" type="text" name="inputMan.id" prompt="请选择录入人"
                           data-options="
                    valueField: 'id',
                    textField: 'username',
                    url: '/employee/queryTeachers',
                    panelHeight:'auto'"
                /></td>
            </tr>
            <tr>
                <td><font size="1">录入时间:</font></td>
                <td><input class="easyui-datebox" type="text" name="inputDate" prompt="请选择录入时间"/></td>
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
                <td><input class="easyui-textbox" type="text" name="qq" prompt="请输入客户的QQ号码"/></td>
            </tr>
            <tr>
                <td><font size="1">邮箱:</font></td>
                <td><input class="easyui-textbox" type="text" name="email" prompt="请输入客户的邮箱地址"/></td>
                <td><font size="1">地址:</font></td>
                <td><input class="easyui-textbox" type="text" name="address" prompt="请输入客户住址"/></td>
                <td><font size="1">学校:</font></td>
                <td><input class="easyui-textbox" type="text" name="school" prompt="请输入客户学校"/></td>

            </tr>
            <tr>
                <td><font size="1">学历:</font></td>
                <td><input class="easyui-combobox" type="text" name="education.id" prompt="请选择客户学历"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=2',
                    panelHeight:'auto'"/></td>
                <td><font size="1">入学时间:</font></td>
                <td><input class="easyui-datebox" type="text" name="collegeAdmissionTime" prompt="请选择客户大学入学时间"/></td>
                <td><font size="1">专业:</font></td>
                <td><input class="easyui-combobox" type="text" name="major.id" prompt="请选择客户专业"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=4',
                    panelHeight:'auto'"/></td>

            </tr>
            <tr>
                <td><font size="1">客户来源:</font></td>
                <td><input class="easyui-combobox" type="text" name="sourceOfClient.id" prompt="请选择客户来源"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=10',
                    panelHeight:'auto'"/></td>
                <td><font size="1">学校客户:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientMajor.id" prompt="请选择学校客户"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/clientMajor/querySchoolName',
                    panelHeight:'auto'"/></td>
                <td><font size="1">客户类型:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientTypeId" prompt="请选择客户类型"
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


            </tr>
            <tr>
                <td><font size="1">工作年限:</font></td>
                <td><input class="easyui-combobox" type="text" name="yearsOfWorkExperience.id" prompt="请选择客户工作年限"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=11',
                    panelHeight:'auto'"/></td>
                <td><font size="1">介绍人:</font></td>
                <td><input class="easyui-textbox" type="text" name="introduceManId" prompt="请选择介绍人"/></td>
                <td><font size="1">地域:</font></td>
                <td><input class="easyui-combobox" type="text" name="hometown.id" prompt="请选择客户地域"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=14',
                    panelHeight:'auto'"/></td>

            </tr>
            <tr>
                <td><font size="1">意向程度:</font></td>
                <td><input class="easyui-combobox" type="text" name="degreeOfIntention.id" prompt="请选择客户意向程度"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=15',
                    panelHeight:'auto'"/></td>
                <td><font size="1">意向校区:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionSchool.id"
                           prompt="请选择客户意向校区"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=16',
                    panelHeight:'auto'"/></td>
                <td><font size="1">意向班级:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionClass.id" prompt="请选择客户意向班级"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=17',
                    panelHeight:'auto'"/></td>

            </tr>
            <tr>
                <td><font size="1">付款情况:</font></td>
                <td><input class="easyui-combobox" type="text" name="payStatusId" prompt="请选择客户付款情况"
                           data-options="
                    valueField: 'payStatusId',
                    textField: 'value',
                    data: [{
                        payStatusId: '1',
                        value: '已付款'
                    },{
                        payStatusId: '0',
                        value: '零支付'
                    }],
                    panelHeight:'auto'"/></td>
                <td><font size="1">客户当前状态:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientState.id" prompt="请选择客户当前状态"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=18',
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
            <tr>
                <td><font size="1">客户关注点:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:680,height:120" type="text" name="clientAttentionWhat"
                                       prompt="请输入客户的关注点"/></td>
            </tr>
            <tr>
                <td><font size="1">备注:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:680,height:120" type="text" name="remark" prompt="请输入备注"/>
                </td>
            </tr>
        </table>

        <div id="bb_client">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="saveClient">保存</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
        </div>
    </form>
</div>
<%--指派给某人的弹框--%>
<div id="send_dialog">

    <form id="send_form" method="post" style="padding: 0px 0px 0px 10px;">
        <input type="hidden" id="id" name="client.id"/>
        <input class="easyui-textbox" type="hidden" name="tel" />
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">客户姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="name"/></td>
            </tr>
            <tr>
                <td><font size="1">客户QQ:</font></td>
                <td><input class="easyui-textbox" type="text" name="qq" /></td>
            </tr>

            <tr>
                <%--接收人员显示在转移记录中--%>
                <td><font size="1">接收人员:</font></td>
                <td><input class="easyui-combobox" type="text" name="currentTraceMan.id"  prompt="请选择接收人员"
                           data-options="
                    valueField: 'id',
                    textField: 'username',
                    url: '/employee/queryTeachers',
                    panelHeight:'auto'"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="bb2">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" data-cmd="saveSend">提交</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
</div>



</body>
</html>
