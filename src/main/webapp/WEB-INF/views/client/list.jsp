<%@ page import="com.sun.xml.internal.rngom.ast.builder.Include" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    入职时间:<input type="text" id="beginDate" class="easyui-datebox" name="beginDate" prompt="起始时间">~
    <input type="text" id="endDate" class="easyui-datebox" name="endDate" prompt="结束时间">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" data-cmd="query">查询</a>
    <br>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'" data-cmd="add"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看'" data-cmd="view">查看</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload">刷新</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'转正'" data-cmd="changeState"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'客户跟踪'" data-cmd="trace"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'放入资源池'" data-cmd="pushPool"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'考试登记'" data-cmd="bookExam"></a>
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


<%--客户跟踪--%>
<div id="clientTrace_dialog">

    <form id="clientTrace_form" method="post" style="padding: 0px 0px 0px 10px;">
        <input type="hidden" name="id">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">客户姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="name"/></td>
                <td><font size="1">客户当前状态:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientState" prompt="请选择客户当前状态"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=18',
                    panelHeight:'auto'"/></td>
                <td><font size="1">跟踪人:</font></td>
                <td><input class="easyui-combobox" type="text" name="inputMan.id" prompt="请选择当前跟踪人员"
                           data-options="
                    valueField: 'id',
                    textField: 'username',
                    url: '/employee/queryTeachers',
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
                <td><font size="1">上次跟踪时间:</font></td>
                <td><input class="easyui-textbox" type="text" name="lastTraceDate" prompt="请输入最新跟踪时间"/></td>
                <td><font size="1">下次跟踪时间:</font></td>
                <td><input class="easyui-textbox" type="text" name="nextTraceDate" prompt="请输入下次跟踪时间"/></td>
                <td><font size="1">跟踪次数:</font></td>
                <td><input class="easyui-textbox" type="text" name="traceTimes" prompt="请输入跟踪次数"/></td>
            </tr>
            <tr>
                <td><font size="1">重要程度:</font></td>
                <td><input class="easyui-combobox" type="text" name="importantDegreeId" prompt="请选择客户重要程度"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=8',
                    panelHeight:'auto'"/></td>
                <td><font size="1">意向校区:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionSchoolId"
                           prompt="请选择客户意向校区"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=16',
                    panelHeight:'auto'"/></td>
                <td><font size="1">意向班级:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionClassId" prompt="请选择客户意向班级"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=17',
                    panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td><font size="1">交流目的:</font></td>
                <td><input class="easyui-textbox" type="text" name="communicativePurposeId" prompt="请输入最新跟踪时间"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=19',
                    panelHeight:'auto'"/></td>
                <td><font size="1">交流方式:</font></td>
                <td><input class="easyui-textbox" type="text" name="communicativeWayId" prompt="请输入下次跟踪时间"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=20',
                    panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td colspan="3"><input class="easyui-filebox" style="width:300px" buttonText="请选择文件"
                                       buttonAlign="left" prompt="请选择需要上传的文件">
            </tr>
            <tr>
                <td><font size="1">交流内容:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:680,height:120" type="text" name="communicationContent"
                                       prompt="请输入与客户交流的内容"/></td>
            </tr>
            <tr>
                <td><font size="1">摘要:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:680,height:120" type="text" name="abstract"
                                       prompt="本次跟踪的摘要"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="bb_trace">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="saveTrace">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancelTrace">取消</a>
</div>

<%--考试登记表--%>
<div id="clientExam_dialog">

    <form id="clientExam_form" method="post" style="padding: 0px 0px 0px 10px;">
        <input type="hidden" name="id" id="clientTraceId">
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">客户姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="name"/></td>
            </tr>
            <tr>
                <td><font size="1">考试类型:</font></td>
                <td><input class="easyui-combobox" type="text" name="examType.id" prompt="请选择客户考试类型"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=27',
                    panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td><font size="1">意向班级:</font></td>
                <td><input class="easyui-combobox" type="text" name="intentionClass.id" prompt="请选择客户意向班级"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=17',
                    panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td><font size="1">考试时间:</font></td>
                <td><input class="easyui-datebox" type="text" name="examDate" prompt="请输入考试时间"/></td>
            </tr>
            <tr>
                <td><font size="1">备注:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:210,height:60" type="text" name="remark" prompt="备注"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="bb_exam">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="saveExam">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancelExam">取消</a>
</div>
</body>
</html>
