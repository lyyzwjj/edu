$(function () {
    var cn_datagrid = $("#cn_datagrid");
    var cn_dialog = $("#cn_dialog");
    cn_datagrid.datagrid({
        url: "/courseName/list",
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
            {field: 'name', title: '课程名称', width: 100},
            {field: 'series', title: '课程所属系列', width:100},
            {field: 'sn', title: '课程编码', width:100},
            {field:"state",title:"状态",width:100,formatter:function(value,row,index){
                if(value==1){
                    return "<font color='green'>非会员课程</font>"
                }else if(value==0){
                    return "<font color='red'>会员课程</font>"
                }
            }}
        ]], onClickRow: function (index, row) {
            //根据班级的状态修改可用/不可用的显示
            if (row.state == 1) {
                $("#change_btn").linkbutton({
                    text: "非会员课程"
                })
            } else {
                $("#change_btn").linkbutton({
                    text: "会员课程"
                })
            }
        }
    })


//工具栏初始
    cn_dialog.dialog(
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
            cn_datagrid.datagrid("load");
        },
        add: function () {
            //保存之前清空数据
            $("#editForm").form("clear");
            cn_dialog.dialog("open");
            cn_dialog.dialog("setTitle", "班级保存");
        },
        cancel: function () {
            cn_dialog.dialog("close");
        },query: function () {
            var keyword = $("#keyword").textbox("getValue");
            cn_datagrid.datagrid("load", {
                keyword: keyword
            });
        },
        save: function () {
            var id = $("#cnId").val();
            controller = "/courseName/save";
            if (id) {
                var controller = "/courseName/update";
            }
            $("#editForm").form("submit", {
                url: controller,
                success: function (data) {
                    data = $.parseJSON(data);
                    console.log(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        cn_dialog.dialog("close");
                        cn_datagrid.datagrid("reload");
                    }
                }
            })
        },
        edit: function () {
            //在操作之前将表单的数据清空
            $("#editForm").form("clear");
            //从datagrid中获取当前被选中的数据
            var row = cn_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要编辑的行");
            } else {
                //打开编辑对话框
                cn_dialog.dialog("open");
                //设置标题
                cn_dialog.dialog("setTitle", "班级编辑");
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
                $.get("/course/queryCourseIdsByGradeId?cnId="+row.id,function(data){
                    $("#courseId").combobox("setValues",data);
                });
            }
        },
        reload: function () {
            cn_datagrid.datagrid("reload");
        },
        changeState: function () {
            //获取选中的那一行的数据
            var row = cn_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要操作的行");
            }

            $.messager.confirm("确认", "您确认想要执行这个操作吗", function (r) {
                if (r) {
                    $.get("/courseName/changeState", {id: row.id}, function (data) {
                        if (data.success) {
                            //刷新列表数据
                            cn_datagrid.datagrid("reload");
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

