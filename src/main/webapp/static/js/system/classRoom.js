$(function () {
    var class_datagrid = $("#class_datagrid");
    var class_dialog = $("#class_dialog");
    class_datagrid.datagrid({
        url: "/classRoom/list",
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
            {field: 'name', title: '教室名称', width: 100},
            {field: 'address', title: '教室地址', width: 100},
            {field: 'seat', title: '座位号', width: 100},
            {field:"state",title:"状态",width:100,formatter:function(value,row,index){
                if(value==1){
                    return "<font color='green'>可用</font>"
                }else if(value==0){
                    return "<font color='red'>不可用</font>"
                }
            }}
        ]], onClickRow: function (index, row) {
            //根据教室的状态修改可用/不可用的显示
            if (row.state == 1) {
                $("#change_btn").linkbutton({
                    text: "可用"
                })
            } else {
                $("#change_btn").linkbutton({
                    text: "不可用"
                })
            }
        }
    })


//工具栏初始
    class_dialog.dialog(
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
            class_datagrid.datagrid("load");
        },
        add: function () {
            //保存之前清空数据
            $("#editForm").form("clear");
            class_dialog.dialog("open");
            class_dialog.dialog("setTitle", "教室保存");
        },
        cancel: function () {
            class_dialog.dialog("close");
        },
        save: function () {
            //获取到id
            var id = $("#classId").val();
            //根据id判断是添加还是编辑
            var url = "/classRoom/save";
            if (id) {
                url = "/classRoom/update"
            }
            //提交表单
            $("#editForm").form("submit", {
                //表单提交路径
                url: url,
                //操作成功之后执行的函数,data是返回的数据,是json格式的字符串
                success: function (data) {
                    //将json格式的字符串转换为json对象
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.errorMsg);
                    } else {
                        //操作成功提示用户
                        $.messager.alert('温馨提示', "保存成功");
                        //关闭输入框
                        class_dialog.dialog("close");
                        //重新加载表格
                        class_datagrid.datagrid("reload");
                    }
                },
            })
        },
        edit: function () {
            //在操作之前将表单的数据清空
            $("#editForm").form("clear");
            //从datagrid中获取当前被选中的数据
            var row = class_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要编辑的行");
            } else {
                //打开编辑对话框
                class_dialog.dialog("open");
                //设置标题
                class_dialog.dialog("setTitle", "教室编辑");
                //将数据加载到form表单中
                $("#editForm").form("load", row);
                //强制设置回显
                $("#adminId").combobox('setValue', row.admin);
            }
        },
        reload: function () {
            class_datagrid.datagrid("reload");
        },
        changeState: function () {
            //获取选中的那一行的数据
            var row = class_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要操作的行");
            }

            $.messager.confirm("确认", "您确认想要执行这个操作吗", function (r) {
                if (r) {
                    $.get("/classRoom/changeState", {id: row.id}, function (data) {
                        if (data.success) {
                            //刷新列表数据
                            class_datagrid.datagrid("reload");
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

