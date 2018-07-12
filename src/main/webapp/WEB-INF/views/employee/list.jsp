<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>员工管理</title>
    <jsp:include page="/WEB-INF/views/commons/commons.jsp"/>
    <script src="/static/js/plugins/jquery-form/jquery.form.min.js"></script>
    <script src="/static/js/system/employee.js"></script>
    <script src="/static/js/layui/layui.js"></script>
    <link rel="stylesheet" href="/static/js/layui/css/layui.css">
    <link rel="stylesheet" href="/static/css/admin.css" media="all">
    <style>
        #staff_form td {
            padding: 5px 0px;
        }
    </style>
</head>
<body>
<div id="loading"></div>
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-header">员工管理</div>
        <div class="layui-card-body" style="height: 850px">
            <%--自己写的管理--%>
            <table id="staff_datagrid"></table>
            <!--左上方工具栏-->
            <div id="toolbar">
                <div>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" data-cmd="add">添加</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="changeState"
                       id="change_btn">离职</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" data-cmd="delete">删除</a>
                </div>
                <div>
                    <input class="easyui-textbox" data-options="iconCls:'icon-search'" type="text" style="width:200px"
                           name="keyword" id="keyword" prompt="请输入用户名或真实姓名查询">

                    <input class="easyui-combobox" type="text" name="dept.id" id="deptId"
                           data-options="url:'/department/queryDepts',
                            valueField:'id',textField:'name',panelHeight:'auto'" prompt="所属部门"/>
                    通过入职时间查询:
                    <input class="easyui-datebox" data-options="iconCls:'icon-search'" type="text" style="width:200px"
                           name="beginDate" id="beginDate" prompt="开始时间">~
                    <input class="easyui-datebox" data-options="iconCls:'icon-search'" type="text" style="width:200px"
                           name="endDate" id="endDate" prompt="结束时间">


                    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
                       data-cmd="query">查询</a>
                </div>
            </div>

            <%--<!--模态框-->--%>
            <div id="staff_dialog" style="display: none">
                <input id="pageContext" type="hidden" value="${pageContext.request.contextPath}"/>
                <div id="easyui-tabs" class="easyui-tabs">
                    <div title="基本信息" style="padding:10px">
                        <form id="staff_form" method="post">
                            <table style="margin: 20px auto 0px;" cellpadding="10px">
                                <input name="id" id="empId" type="hidden">
                                <tr>
                                    <td><font size="1">员工账号:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="username"/></td>

                                    <td><font size="1">员工密码:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="password"/></td>

                                    <td><font size="1">员工工号:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="employeeId"/></td>
                                </tr>
                                <tr>
                                    <td><font size="1">真实姓名:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="realname"/></td>

                                    <td><font size="1">员工年龄:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="age"/></td>

                                    <td><font size="1">员工性别:</font></td>
                                    <td><input class="easyui-combobox" type="text" name="gender"
                                               data-options="data:[{'value':1, 'text':'男'}
                                ,{'value':0, 'text':'女'}], valueField:'value',
                                textField:'text',panelHeight:'auto'"
                                    /></td>
                                </tr>
                                <tr>
                                    <td><font size="1">出生日期:</font></td>
                                    <td><input class="easyui-datebox" type="text" name="bornDate"/></td>

                                    <td><font size="1">身份证号:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="cardId"/></td>

                                    <td><font size="1">联系电话:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="tel"/></td>
                                </tr>
                                <tr>
                                    <td><font size="1">联系邮箱:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="eamil"/></td>

                                    <td><font size="1">QQ:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="qq"/></td>

                                    <td><font size="1">联系地址:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="address"/></td>
                                </tr>
                                <tr>
                                    <td><font size="1">考勤卡号:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="attendanceId"/></td>

                                    <td><font size="1">入职日期:</font></td>
                                    <td><input class="easyui-datebox" type="text" name="hireDate"/></td>

                                    <td><font size="1">员工工龄:</font></td>
                                    <td><input class="easyui-textbox" type="text" name="seniority"/></td>
                                </tr>
                                <tr>
                                    <td><font size="1">员工状态:</font></td>
                                    <td><input class="easyui-combobox" type="text" name="state" id="stateId"
                                               data-options="data:[{'value':true, 'text':'在职'}
                                ,{'value':false, 'text':'离职'}], valueField:'value',
                                textField:'text',panelHeight:'auto'"
                                    /></td>

                                    <td><font size="1">超级管理员:</font></td>
                                    <td><input class="easyui-combobox" type="text" name="admin" id="adminId"
                                               data-options="data:[{'value':1, 'text':'是'}
                                ,{'value':0, 'text':'否'}], valueField:'value',
                                textField:'text',panelHeight:'auto'"
                                    /></td>
                                    <td><font size="1">所属部门:</font></td>
                                    <td><input class="easyui-combobox" type="text" name="dept.id"
                                               data-options="url:'/department/queryDepts',
                            valueField:'id',textField:'name',panelHeight:'auto'"/></td>
                                </tr>
                                <tr>
                                    <td><font size="1">添加角色:</font></td>
                                    <td><input class="easyui-combobox" type="text" id="rolesId"
                                               data-options="url:'/role/queryRoles',
                            valueField:'id',textField:'name',panelHeight:'auto', multiple:true"/></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div id="div_staff_salary" title="工资信息" style="padding:10px">
                        <form id="staff_salary_form" method="post">
                            <table style="margin: 20px ;border-collapse:separate; border-spacing:0px 10px;">
                                <tr>
                                    <td>
                                        银行卡卡号: <input type="text" editable="false" class="easyui-textbox"
                                                      name="bankcardNumber"/>
                                    </td>
                                    <td>
                                        工作天数: <input type="text" editable="false" class="easyui-textbox"
                                                     name="workday"/>
                                    </td>
                                    <td>
                                        基本工资: <input type="text" editable="false" class="easyui-textbox"
                                                     name="baseSalary"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        五险总金额: <input type="text" editable="false" class="easyui-textbox"
                                                      name="socialInsurance"/>
                                    </td>
                                    <td>
                                        项目奖金: <input type="text" editable="false" class="easyui-textbox" name="bonus"/>
                                    </td>
                                    <td>
                                        加班补贴: <input type="text" editable="false" class="easyui-textbox"
                                                     name="overtime"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        住房公积金: <input type="text" editable="false" class="easyui-textbox"
                                                      name="accumulationFund"/>
                                    </td>

                                    <td>
                                        本月月份: <input type="text" editable="false" class="easyui-textbox" name="month"/>
                                    </td>
                                    <td>
                                        迟到天数: <input type="text" editable="false" class="easyui-textbox"
                                                     name="lateday"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        个人所得税: <input type="text" editable="false" class="easyui-textbox"
                                                      name="personalIncome"/>
                                    </td>
                                    <td>
                                        奖金系数: <input type="text" editable="false" class="easyui-textbox"
                                                     name="coefficient"/>
                                    </td>
                                    <td>
                                        实发工资: <input type="text" editable="false" class="easyui-textbox"
                                                     name="realWages"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div title="家庭情况" style="padding:10px">
                        <table id="staff_family_datagrid"></table>
                        <div id="staff_family_toolbar">
                            <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                               data-cmd="add_family">新增</a>
                            <a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
                               data-cmd="remove_family">删除</a>
                            <a href="javascript:" class="easyui-linkbutton"
                               data-options="iconCls:'icon-save',plain:true" data-cmd="accept_family">保存</a>
                            <a href="javascript:" class="easyui-linkbutton"
                               data-options="iconCls:'icon-undo',plain:true" data-cmd="reject_family">撤销</a>
                        </div>
                    </div>
                    <div title="工作经历" style="padding:10px">
                        <table id="staff_work_datagrid"></table>
                        <div id="staff_work_toolbar">
                            <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                               data-cmd="add_work">新增</a>
                            <a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
                               data-cmd="remove_work">删除</a>
                            <a href="javascript:" class="easyui-linkbutton"
                               data-options="iconCls:'icon-save',plain:true" data-cmd="accept_work">保存</a>
                            <a href="javascript:" class="easyui-linkbutton"
                               data-options="iconCls:'icon-undo',plain:true" data-cmd="reject_work">撤销</a>
                        </div>
                    </div>
                    <div title="教育情况" style="padding:10px">
                        <table id="staff_education_datagrid"></table>
                        <div id="staff_education_toolbar">
                            <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                               data-cmd="add_education">新增</a>
                            <a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
                               data-cmd="remove_education">删除</a>
                            <a href="javascript:" class="easyui-linkbutton"
                               data-options="iconCls:'icon-save',plain:true" data-cmd="accept_education">保存</a>
                            <a href="javascript:" class="easyui-linkbutton"
                               data-options="iconCls:'icon-undo',plain:true" data-cmd="reject_education">撤销</a>
                        </div>
                    </div>
                    <div title="身份证图片" style="padding:10px">
                        <div class="layui-upload" align="center">
                            <button type="button" class="layui-btn" id="upload_pic">上传图片</button>
                            <div class="layui-upload-list">
                                <img class="layui-upload-img" align="center" style="width: 80%">
                                <p id="upload_text" style="margin-top: 10px"></p>
                            </div>
                        </div>
                    </div>
                </div>
                <%--<!--模态框管理-->--%>
                <div id="form_btns">
                    <a id="btn_save" href="javascript:;" class="easyui-linkbutton" iconCls="icon-save" plain="true"
                       data-cmd="save">保存</a>
                    <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
                       data-cmd="cancel">取消</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>