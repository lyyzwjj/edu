<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>转移记录</title>
    <%@include file="/WEB-INF/views/commons/commons.jsp" %>
    <script src="../../../static/js/system/clientTransferRecord.js"></script>
</head>
<body>
<table id="clientTransferRecord_datagrid" fit="true"></table>
<div id="tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'查看'" data-cmd="edit"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload"></a>
</div>

<%--指派给某人的弹框--%>

<%--学员跟踪--%>
<div id="clientTrace_dialog">

    <form id="clientTrace_form" method="post" style="padding: 0px 0px 0px 10px;">
        <input type="hidden" name="id" >
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">客户姓名:</font></td>
                <td><input class="easyui-textbox" type="text" name="name" /></td>
                <td><font size="1">客户当前状态:</font></td>
                <td><input class="easyui-combobox" type="text" name="clientState" prompt="请选择客户当前状态"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url: '/dataDictionaryItem/queryListByParent?parentId=18',
                    panelHeight:'auto'"/></td>
                <td><font size="1">跟踪人:</font></td>
                <td><input class="easyui-combobox" type="text"  name="inputMan.id" prompt="请选择当前跟踪人员"
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
            <%--<tr>
                <td colspan="3"><input class="easyui-filebox" style="width:300px" buttonText="请选择文件"
                                       buttonAlign="left" prompt="请选择需要上传的文件">
            </tr>--%>
            <tr >
                <td><font size="1">交流内容:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:680,height:120" type="text" name="communicationContent" prompt="请输入与客户交流的内容"/></td>
            </tr>
            <tr >
                <td><font size="1">摘要:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:680,height:120" type="text" name="abstract" prompt="本次跟踪的摘要"/></td>
            </tr>
        </table>
    </form>
    </div>
<%--底部工具按钮--%>
<div id="bb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="saveTrace">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
</div>


</body>
</html>
