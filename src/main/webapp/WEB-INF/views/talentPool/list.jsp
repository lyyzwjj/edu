<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
<html>
<head>
    <title>人才储备库</title>
    <script type="text/javascript" src="/static/js/system/talentPool.js"></script>
</head>
<body>
<table id="talentPool_datagrid"></table>

<div id="tb">
    <div>
        <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-add" plain="true"
           data-cmd="add">新增</a>
        <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
           data-cmd="edit">编辑</a>
        <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-reload" plain="true"
           data-cmd="reload">刷新</a>

        开始时间: <input class="easyui-datebox" name="beginDate" id="beginDate"
                     data-options="required:true,showSeconds:true" style="width:150px"/>~
        结束时间: <input class="easyui-datebox" name="endDate" id="endDate"
                     data-options="required:true,showSeconds:true" style="width:150px"/>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="query">按日期段查询</a>
    </div>
</div>

<div id="talentPool_dialog">
    <form id="editForm" method="post" style="padding: 35px 0px 0px 35px">
        <input type="hidden" id="talentPoolId" name="id">
        <table style="border-collapse: separate; border-spacing: 10px;">
            <tr>
                <td>
                    应聘姓名: <input type="text" class="easyui-textbox" name="name"
                                 prompt="请输入姓名"/>
                </td>
                <td>
                    应聘日期: <input class="easyui-datebox" name="employDate"/>
                </td>

            </tr>
            <tr>
                <td>
                    应聘职务: <input type="text" class="easyui-combobox" name="duty.id" data-options="
                                        url:'/dataDictionaryItem/queryListByParent?parentId=1',
                                        valueField: 'id',
                                        textField: 'name'
                                       "/>
                </td>
                <td>
                    聘用类型: <input class="easyui-combobox" name="hireType.id" data-options="
                                        url:'/dataDictionaryItem/queryListByParent?parentId=21',
                                        valueField: 'id',
                                        textField: 'name'
                                       "/>
                </td>
            </tr>
            <tr>
                <td>
                    工作年数: <input type="text" class="easyui-combobox" name="workYear.id" data-options="
                                        url:'/dataDictionaryItem/queryListByParent?parentId=11',
                                        valueField: 'id',
                                        textField: 'name'
                                       "/>
                </td>
                <td>
                    学历要求: <input class="easyui-combobox" name="education.id" data-options="
                                        url:'/dataDictionaryItem/queryListByParent?parentId=2',
                                        valueField: 'id',
                                        textField: 'name'
                                       "/>
                </td>
            </tr>
            <tr>
                <td>
                    相关技能: <input type="text" class="easyui-textbox" name="recruitrequired"
                                 prompt="请输入特长"/>
                </td>
                <td>
                    薪资要求: <input class="easyui-combobox" name="recruitSalary.id" data-options="
                                        url:'/dataDictionaryItem/queryListByParent?parentId=26',
                                        valueField: 'id',
                                        textField: 'name'
                                       "/>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    备注: <input type="text" class="easyui-textbox" name="remark"
                               multiline="true"/>
                </td>
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
