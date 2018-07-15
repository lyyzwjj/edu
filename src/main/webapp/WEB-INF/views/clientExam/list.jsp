<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>客户考试管理</title>
    <%@include file="/WEB-INF/views/commons/commons.jsp" %>
    <script src="../../../static/js/system/clientExam.js"></script>
</head>
<body>
<table id="clientExam_datagrid" fit="true"></table>
<div id="tb">
    <div>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'" data-cmd="add"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',text:'删除'" data-cmd="remove"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-man',text:'审核'" data-cmd="changeState" id="change_btn"></a>
    </div>
    <div>
        <!--高级查询-->
        学校: <input type="text" class="easyui-textbox" name="keyword" id="keyword"
                   prompt="请输入学生名称"/>
        意向学科: <input class="easyui-combobox" id="subjectId" data-options="
                                         url:'/dataDictionaryItem/queryListByParent?parentId=17',
                                        valueField: 'id',
                                        panelHeight:'auto',
                                        textField: 'name'
                                       "/>
        <a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
           data-cmd="query">查询</a><br>
    </div>
</div>



<div id="clientExam_dialog">

    <form id="clientExam_form" method="post" style="padding: 0px 0px 0px 10px;">
        <input type="hidden" name="id" id="clientExamId" >
        <table style="border-collapse:separate; border-spacing:10px;">
            <tr>
                <td><font size="1">客户姓名:</font></td>
                <td><input class="easyui-combobox" type="text" name="name.id"
                           data-options="
                    valueField: 'id',
                    textField: 'name',
                    url:'/client/queryClients',
                    panelHeight:'auto'"/></td>
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
            <tr >
                <td><font size="1">备注:</font></td>
                <td colspan="5"><input class="easyui-textbox" multiline="true"
                                       data-options="width:210,height:60" type="text" name="remark1" prompt="备注"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="bb_exam">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="saveExam">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
</div>

</div>
</body>
</html>
