<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>大客户管理</title>
    <%@include file="/WEB-INF/views/commons/commons.jsp" %>
    <script src="../../../static/js/system/clientMajor.js"></script>
</head>
<body>
<table id="clientMajor_datagrid" fit="true"></table>
<div id="tb">
    <div>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加'" data-cmd="add"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑'" data-cmd="edit"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看'" data-cmd="view"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',text:'删除'" data-cmd="remove"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新'" data-cmd="reload"></a>
    </div>
    <div>
        <!--高级查询-->
        学校: <input type="text" class="easyui-textbox" name="keyword" id="keyword"
                   prompt="请输入学校名称"/>
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



<div id="clientMajor_dialog" style="display: none">
    <form id="clientMajor_form" method="post">
        <div class="easyui-tabs">
            <div title="客户信息" style="padding:10px">
                <table style="margin: 5px auto 0px;">
                    <input type="hidden" id="clientMajorId" name="id"/>
                    <tr>
                        <td>
                            学校名称: <input type="text" class="easyui-textbox" name="name" prompt="请输入学校"/>
                        </td>
                        <td>
                            营销人员: <input class="easyui-combobox" name="saleMan.id" data-options="
                                            url:'/employee/queryTeachers',
                                            valueField: 'id',
                                            editable:false,
                                             panelHeight:'auto',
                                            textField: 'username'
                                       "/>
                        </td>
                        <td>
                            跟进人员: <input class="easyui-combobox" name="traceMan.id" data-options="
                                            url:'/employee/queryTeachers',
                                            valueField: 'id',
                                            editable:false,
                                            panelHeight:'auto',
                                            textField: 'username'
                                       "/>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            意向程度: <input class="easyui-combobox" name="intentionDegree.id" data-options="
                                            url:'/dataDictionaryItem/queryListByParent?parentId=15',
                                            valueField: 'id',
                                            editable:false,
                                             panelHeight:'auto',
                                            textField: 'name'
                                       "/>
                        </td>
                        <td>
                            意向学科: <input class="easyui-combobox" name="intentionClass.id" data-options="
                                            url:'/dataDictionaryItem/queryListByParent?parentId=17',
                                            valueField: 'id',
                                            editable:false,
                                            textField: 'name',
                                             panelHeight:'auto'
                                       "/>
                        </td>
                        <td>
                            意向校区: <input class="easyui-combobox" name="intentionSchool.id" data-options="
                                            url:'/dataDictionaryItem/queryListByParent?parentId=16',
                                            valueField: 'id',
                                            editable:false,
                                            textField: 'name',
                                             panelHeight:'auto'
                                       "/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            重要程度: <input class="easyui-combobox" name="importantDegree.id" data-options="
                                                    url:'/dataDictionaryItem/queryListByParent?parentId=8',
                                                    valueField: 'id',
                                                    editable:false,
                                                     panelHeight:'auto',
                                                    textField: 'name'
                                                   "/>
                        </td>
                        <td>
                            客户状态: <input class="easyui-combobox" name="clientState" data-options="
                                                valueField: 'value',
                                                editable:false,
                                                textField: 'text',
                                                 panelHeight:'auto',
                                                data: [{
                                                text: '未签约',
                                                value: '0'
                                                },{
                                                text: '已签约',
                                                value: '1'
                                                }]"/>
                        </td>
                        <td>
                            跟进状态: <input class="easyui-combobox" name="traceState" data-options="
                                                    valueField: 'value',
                                                    textField: 'text',
                                                     editable:false,
                                                     panelHeight:'auto',
                                                    data: [{
                                                    text: '未跟进',
                                                    value: '0'
                                                    },{
                                                    text: '已跟进',
                                                    value: '1'
                                                }]"/>
                        </td>


                    </tr>
                    <tr>
                        <td>
                            联系人员: <input class="easyui-combobox" name="contactPerson.id" data-options="
                                            url:'/clientSchoolLinkman/queryLinkman',
                                             panelHeight:'auto',
                                            valueField: 'id',
                                            textField: 'name'
                                       "/>
                        </td>
                       <%-- <td>
                            联系人员电话: <input class="easyui-textbox" name="contactPerson.d" data-options="
                                            url:'/clientSchoolLinkman/queryLinkman',
                                            valueField: 'id',
                                            textField: 'tel'
                                       "/>
                        </td>--%>
                        <td>
                            客户优惠: <input class="easyui-textbox" name="preferentialPolicy"/>
                        </td>

                    </tr>
                    <tr>
                        <td colspan="3">
                            上次跟进时间: <input class="easyui-datebox" data-options="editable:false" name="pervTraceDate" id="prevTraceDate"/>
                            下次跟进时间: <input class="easyui-datebox" data-options="editable:false"name="nextTraceTime" id="nextTraceTime"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="easyui-tabs">
            <div title="学校信息" style="padding:10px">
                <table style="margin: 5px auto 0px;">
                    <tr>
                        <td>
                            学校地址: <input type="text" class="easyui-textbox" name="address"/>
                        </td>
                        <td>
                            学校电话: <input type="text" class="easyui-textbox" name="tel"/>
                        </td>
                        <td>
                            学校邮箱: <input type="text" class="easyui-textbox" name="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            办学性质:  <input class="easyui-combobox" name="natureOfSchool.id" data-options="
                                                    url:'/dataDictionaryItem/queryListByParent?parentId=25',
                                                    valueField: 'id',
                                                     panelHeight:'auto',
                                                    editable:false,
                                                    textField: 'name'
                                                   "/>
                        </td>
                        <td>
                            规定学历:  <input class="easyui-combobox" name="academicDiplomas.id" data-options="
                                                    url:'/dataDictionaryItem/queryListByParent?parentId=23',
                                                    valueField: 'id',
                                                     panelHeight:'auto',
                                                    editable:false,
                                                    textField: 'name'
                                                   "/>
                        </td>
                        <td>
                            学校体制:  <input class="easyui-combobox" name="schoolSystem.id" data-options="
                                                    url:'/dataDictionaryItem/queryListByParent?parentId=24',
                                                    valueField: 'id',
                                                     panelHeight:'auto',
                                                    editable:false,
                                                    textField: 'name'
                                                   "/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            邮政编码: <input type="text" class="easyui-textbox" name="postcode"/>
                        </td>
                        <td>
                            官网: <input type="text" class="easyui-textbox" name="website"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            学生人数: <input type="text" class="easyui-textbox" name="studentTotal"/>
                            IT专业学生人数: <input type="text" class="easyui-textbox" name="stuentTotalIT"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            学校简介:
                            <input name="schooIntroduce" class="easyui-textbox" data-options="multiline:true"
                                   style="width:650px;height:50px">
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="easyui-tabs">
            <div title="其他信息" style="padding:10px">
                <table >
                    <td colspan="3">
                        备注详情:
                        <input name="remark" class="easyui-textbox" data-options="multiline:true"
                               style="width:650px;height:50px">
                    </td>
                </table>
            </div>
        </div>

        <div id="off_mask"></div>
    </form>

    <div id="bb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
    </div>
    </div>

</div>
</body>
</html>
