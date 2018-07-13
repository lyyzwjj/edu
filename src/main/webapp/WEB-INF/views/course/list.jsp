<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/commons/commons.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/system/course.js"></script>
    <script>
        $(function(){
            $('#cc').calendar({
                onSelect: function(date){
                    data = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                    $("#course_datagrid").datagrid({
                        url: "/course/today?data="+data,
                        fit: true,
                        //单选
                        singleSelect: true,
                        //是否显示分页栏
                        pagination: true,
                        //按比例分配宽度
                        fitColumns: true,
                        toolbar: "#tb",
                        columns: [[
                            {field: 'sequence', title: '顺序', width: 100},
                            {field:"courseDate",title:"日期",width:100,sortable:true,order:"desc"},
                            {field: 'week', title: '星期', width: 100},
                            {field:"grade",title:"班级",width:100,formatter:function(value,row,index){
                                if(value){
                                    return value.name;
                                }
                                console.log(value);
                            }},
                            {field:"courseName",title:"课程名称",width:100,formatter:function(value,row,index){
                                if(value){
                                    return value.name;
                                }
                            }},
                            {field:"classTeacher",title:"班主任",width:100,formatter:function(value,row,index){
                                if(value){
                                    return value.realname;
                                }
                            }},
                            {field:"courseTeacher",title:"上课教师",width:100,formatter:function(value,row,index){
                                if(value){
                                    return value.realname;
                                }
                            }},
                            {field:"classroom",title:"教室",width:100,formatter:function(value,row,index){
                                if(value){
                                    return value.name;
                                }
                            }},
                            {field: 'remark', title: '备注', width: 100},
                            {field:"state",title:"状态",width:100,formatter:function(value,row,index){
                                if(value==1){
                                    return "<font color='green'>已上</font>"
                                }else if(value==0){
                                    return "<font color='red'>未上</font>"
                                }
                            }}
                        ]]
                });
                }
            });
        })
    </script>

</head>

<body class="easyui-layout">

<div data-options="region:'west',split:true" style="width:230px;">
    <div id="cc" class="easyui-calendar" name="study_date" style="width:220px;height:280px;" ></div>
</div>

<div data-options="region:'center'" style="padding:5px;">
    <div id="tb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" data-cmd="edit">编辑</a>
        <input  class="easyui-combobox" name="grade.id" prompt="班级" id="gradeId"
                data-options="width:100,valueField:'id',textField:'name',url:'/grade/queryGrades'"/>

        <input  class="easyui-combobox" name="classTeacher.id" prompt="老师" id="empId"
                data-options="width:100,valueField:'id',textField:'realname',url:'/employee/queryTeachers' " />

        <input  class="easyui-combobox" name="classRoom.id" prompt="教室" id="classRoomId"
                data-options="width:100,valueField:'id',textField:'name',url:'/classRoom/queryClassRooms' " />
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="queryfast">快查</a>

        <input class="easyui-datebox" name="begindate" id="begindate"
               data-options="required:true,showSeconds:true" style="width:150px"/>~
        <input class="easyui-datebox" name="enddate" id="enddate"
               data-options="required:true,showSeconds:true" style="width:150px"/>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="query">按日期段查询</a>

    </div>


    <table id="course_datagrid"></table>



    <div id="course_dialog">
        <form id="editForm" method="post" style="padding: 35px 0px 0px 35px">
            <input type="hidden" id="courseId" name="id">
            <table style="border-collapse: separate; border-spacing: 10px;">
                <tr>
                    <td>备注</td>
                    <td><input type="text" class="easyui-textbox" name="remark" multiline="true"></td>
                </tr>
            </table>
        </form>
    </div>

    <div id="bb">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" data-cmd="cancel">取消</a>
    </div>
</div>
</body>

</html>
