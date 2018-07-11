$(function () {

    var emp_datagrid = $("#emp_datagrid");
    var emp_dialog = $("#emp_dialog");

    emp_datagrid.datagrid({
        fit: true,
        url: "/employee/list",
        //自适应列表宽度
        fitColumns: true,
        //是否显示分页栏
        pagination: true,
        pagePosition: "boht",
        //是否显示行号列
        rownumbers: true,
        //是否显示斑马线
        striped: true,
        //允许选中一行()
        singleSelect: true,
        //定义列
        columns: [
            [
                {field: 'ck', checkbox: true},
                {field: 'id', title: '编号', width: 100, align: "center"},
                {field: 'username', title: '用户名', width: 100, align: "center"},
                {field: 'password', title: '密码', width: 100, align: "center"},
                {field: 'realname', title: '真实姓名', width: 100, align: "center"},
                {field: 'tel', title: '电话号码', width: 100, align: "center"},
                {field: 'email', title: '邮箱', width: 100, align: "center"},
                {
                    field: 'dept',
                    title: '部门',
                    width: 100,
                    align: "center",
                    formatter: function (value, row, index) {
                        return value ? value.name : "未分配部门";
                    }
                },
                {field: 'hiredate', title: '入职时间', width: 100, align: "center", sortable: true, order: "asc"},
                {
                    field: 'admin',
                    title: '是否为超级管理员',
                    width: 100,
                    align: "center",
                    formatter: function (value, row, index) {
                        return value ? "是" : "否";
                    }
                },
                {
                    field: 'state',
                    title: '状态',
                    width: 100,
                    align: "center",
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return "<font color='green'>在职</font>";
                        } else if (value == 0) {
                            return "<font color='red'>离职</font>";
                        }
                    }
                },
            ]],
        onClickRow: function (index, row) {
            //根据员工的状态修改离职/副职的显示
            if (row.state == 1) {
                $("#change_btn").linkbutton({
                    text: "离职"
                })
            } else {
                $("#change_btn").linkbutton({
                    text: "复职"
                })
            }
        }
    });

    //工具栏初始
    emp_dialog.dialog(
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
            emp_datagrid.datagrid("load");
        },
        add: function () {
            //保存之前清空数据
            $("#editForm").form("clear");
            emp_dialog.dialog("open");
            emp_dialog.dialog("setTitle", "员工保存");
        },
        cancel: function () {
            emp_dialog.dialog("close");
        },
        save: function () {
            //获取到id
            var id = $("#empId").val();
            //根据id判断是添加还是编辑
            var url = "/employee/save";
            if (id) {
                url = "/employee/update"
            }
            //提交表单
            $("#editForm").form("submit", {
                //表单提交路径
                url: url,
                onSubmit: function (param) {
                    //将格式转化为roles[0].id
                    var ids = $("#rolesId").combobox("getValues");
                    for (var i = 0; i < ids.length; i++) {
                        param["roles[" + i + "].id"] = ids[i];
                        console.log(i);
                    }
                },
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
                        emp_dialog.dialog("close");
                        //重新加载表格
                        emp_datagrid.datagrid("reload");
                    }
                },
            })
        },
        edit: function () {
            //在操作之前将表单的数据清空
            $("#editForm").form("clear");
            //从datagrid中获取当前被选中的数据
            var row = emp_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要编辑的行");
            } else {
                //打开编辑对话框
                emp_dialog.dialog("open");
                //设置标题
                emp_dialog.dialog("setTitle", "员工编辑");
                //将选中的row数据加载到对话框的表单中,用于回显
                if (row.dept) {
                    row["dept.id"] = row.dept.id;
                }
                //将数据加载到form表单中
                $("#editForm").form("load", row);
                //强制设置回显
                $("#adminId").combobox('setValue', row.admin);

                //角色组件name无法使用同名原则自动赋值,需要手动赋值
                $.get("/role/getRoleIdByEmpId?empId=" + row.id, function (data) {
                    console.log(row.id);
                    $("#rolesId").combobox("setValues", data);
                });
            }
        },
        reload: function () {
            emp_datagrid.datagrid("reload");
        },
        changeState: function () {
            //获取选中的那一行的数据
            var row = emp_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要操作的行");
            }

            $.messager.confirm("确认", "您确认想要执行这个操作吗", function (r) {
                if (r) {
                    $.get("/employee/changeState", {id: row.id}, function (data) {
                        if (data.success) {
                            //刷新列表数据
                            emp_datagrid.datagrid("reload");
                        } else {
                            $.messager.alert('温馨提示', data.errorMsg);
                        }

                    });
                }
            });
        },
        query: function () {
            var keyword = $("#keyword").textbox("getValue");
            var deptId = $("#deptId").textbox("getValue");

            emp_datagrid.datagrid("load", {
                keyword: keyword,
                deptId: deptId
            });
        }
    }

    //调用
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})

