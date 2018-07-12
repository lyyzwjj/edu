$(function () {
    var grade_datagrid = $("#grade_datagrid");
    var grade_dialog = $("#grade_dialog");
    grade_datagrid.datagrid({
        url: "/grade/list",
        fit: true,
        //单选
        singleSelect: true,
        //是否显示分页栏
        pagination: true,
        //按比例分配宽度
        fitColumns: true,
        toolbar: "#tb",
        columns: [[
            {field: 'id', title: '编号', width: 100},
            {field: 'name', title: '班级名称', width: 100},
            {field: 'classTeacher', title: '班主任', width: 100,formatter:function(value,row,index){
                if(value){
                    return value.realname;
                }
            }},
            {field:"state",title:"状态",width:100,formatter:function(value,row,index){
                if(value==1){
                    return "<font color='green'>毕业</font>"
                }else if(value==0){
                    return "<font color='red'>未毕业</font>"
                }
            }}
        ]], onClickRow: function (index, row) {
            //根据班级的状态修改可用/不可用的显示
            if (row.state == 1) {
                $("#change_btn").linkbutton({
                    text: "毕业"
                })
            } else {
                $("#change_btn").linkbutton({
                    text: "未毕业"
                })
            }
        }
    })


//工具栏初始
    grade_dialog.dialog(
        {
            width: 500,
            height: 500,
            buttons: "#bb",
            closed: true
        }
    );

//响应函数集合对象
    var cmdObj = {
        //工具栏的刷新
        reload: function () {
            grade_datagrid.datagrid("load");
        },
        add: function () {
            //保存之前清空数据
            $("#editForm").form("clear");
            grade_dialog.dialog("open");
            grade_dialog.dialog("setTitle", "班级保存");
        },
        cancel: function () {
            grade_dialog.dialog("close");
        },query: function () {
            var keyword = $("#keyword").textbox("getValue");
            var empId = $("#empId").textbox("getValue");
            grade_datagrid.datagrid("load", {
                keyword: keyword,
                empId: empId
            });
        },
        save: function () {
            var id = $("#gradeId").val();
            controller = "/grade/save";
            if (id) {
                var controller = "/grade/update";
            }
            $("#editForm").form("submit", {
                url: controller,
                onSubmit: function (param) {
                    var ids = $("#courseId").combobox("getValues");
                    for (var i = 0; i < ids.length; i++) {
                        param["course[" + i + "].id"] = ids[i];
                    }
                },
                success: function (data) {
                    data = $.parseJSON(data);
                    console.log(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        grade_dialog.dialog("close");
                        grade_datagrid.datagrid("reload");
                    }
                }
            })
        },
        edit: function () {
            //在操作之前将表单的数据清空
            $("#editForm").form("clear");
            //从datagrid中获取当前被选中的数据
            var row = grade_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要编辑的行");
            } else {
                //打开编辑对话框
                grade_dialog.dialog("open");
                //设置标题
                grade_dialog.dialog("setTitle", "班级编辑");
                if(row.dept){
                    row["classTeacher.id"] =row.classTeacher.id;
                }
                //将选中row数据加载的对话框中form表单中,用于回显
                //form加载原理,根据同名匹配原则
                if(row.classTeacher){
                    row["classTeacher.id"] =row.classTeacher.id;
                }
                //将数据加载到form表单中
                $("#editForm").form("load", row);

                //强制设置回显
                $("#adminId").combobox('setValue', row.admin);

                //角色数据的回显
                $.get("/course/queryCourseIdsByGradeId?gradeId="+row.id,function(data){
                    $("#courseId").combobox("setValues",data);
                });
            }
        },
        reload: function () {
            grade_datagrid.datagrid("reload");
        },
        changeState: function () {
            //获取选中的那一行的数据
            var row = grade_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要操作的行");
            }

            $.messager.confirm("确认", "您确认想要执行这个操作吗", function (r) {
                if (r) {
                    $.get("/grade/changeState", {id: row.id}, function (data) {
                        if (data.success) {
                            //刷新列表数据
                            grade_datagrid.datagrid("reload");
                        } else {
                            $.messager.alert('温馨提示', data.errorMsg);
                        }

                    });
                }
            });
        },
    }

//调用
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})

