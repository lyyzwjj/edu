$(function () {
    var course_datagrid = $("#course_datagrid");
    var course_dialog = $("#course_dialog");
    course_datagrid.datagrid({
        url: "/course/list",
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
                    return "<font color='green'>毕业</font>"
                }else if(value==0){
                    return "<font color='red'>未毕业</font>"
                }
            }}
        ]]
    });


//工具栏初始
    course_dialog.dialog(
        {
            width: 300,
            height: 300,
            buttons: "#bb",
            closed: true
        }
    );

//响应函数集合对象
    var cmdObj = {
        //工具栏的刷新
        reload: function () {
            course_datagrid.datagrid("load");
        },
        cancel: function () {
            course_dialog.dialog("close");
        },
        reload: function () {
            course_datagrid.datagrid("reload");
        },query: function () {
            var begindate = $("#begindate").datetimebox("getValue");
            var enddate = $("#enddate").datetimebox("getValue");
        course_datagrid.datagrid("load", {
            begindate:begindate,
            enddate:enddate
        });
    },save: function () {
            var id = $("#courseId").val();
            controller = "/course/save";
            if (id) {
                var controller = "/course/update";
            }
            $("#editForm").form("submit", {
                url: controller,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        course_dialog.dialog("close");
                        course_datagrid.datagrid("reload");
                    }
                }
            })
        },
        queryfast: function () {
        var gradeId = $("#gradeId").textbox("getValue");
        var classRoomId = $("#classRoomId").textbox("getValue");
        var empId = $("#empId").textbox("getValue");
        course_datagrid.datagrid("load", {
            gradeId:gradeId,
            classRoomId:classRoomId,
            empId: empId
        });
    }, edit: function () {
            //在操作之前将表单的数据清空
            $("#editForm").form("clear");
            //从datagrid中获取当前被选中的数据
            var row = course_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要编辑的行");
            } else {
                //打开编辑对话框
                course_dialog.dialog("open");
                //设置标题
                course_dialog.dialog("setTitle", "备注编辑");
                //将数据加载到form表单中
                $("#editForm").form("load", row);

                //强制设置回显
                $("#adminId").combobox('setValue', row.admin);
            }
        },
    }

//调用
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})

