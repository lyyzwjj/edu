$(function () {
    var client_datagrid = $("#client_datagrid");
    var client_dialog = $("#client_dialog");
    var clientTrace_dialog = $("#clientTrace_dialog");
    client_datagrid.datagrid({
        fit: true,
        url: "/student/queryStudents",
        fitColumns: true,
        striped: true,
        pagination: true,
        rownumbers: true,
        toolbar: "#tb",
        singleSelect: true,
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'id', width: 90, align: "center", hidden: 'true'},
            {field: 'name', title: '学员姓名', width: 90, align: "center"},
            {
                field: 'saleMan', title: '营销人员', width: 90, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return value.realname;
                }
            }
            },
            /*{
             field: 'receipttime', title: '入学时间', width: 90, align: "center", formatter: function (value, row, index) {
             return row.receiptBill.receipttime;
             }
             },*/
            {
                field: 'totalmoney', title: '总学费', width: 90, align: "center", formatter: function (value, row, index) {
                return row.studentReceiptGather.totalmoney;
            }
            },
            {
                field: 'totalreceiptmoney',
                title: '已缴学费',
                width: 90,
                align: "center",
                formatter: function (value, row, index) {
                    return row.studentReceiptGather.totalreceiptmoney;
                }
            },
            {
                field: 'unpaidmoney',
                title: '待缴学费',
                width: 90,
                align: "center",
                formatter: function (value, row, index) {
                    return row.studentReceiptGather.unpaidmoney;
                }
            },
            {field: 'tel', title: '电话', width: 90, align: "center"},
            {field: 'email', title: '邮箱', width: 90, align: "center"},
            {
                field: 'stateId',
                title: '状态',
                width: 90,
                align: "center",
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return "<font color='green'>在读</font>"
                    } else if (value == 3) {
                        return "<font color='yellow'>休学</font>"
                    } else if (value == 4) {
                        return "<font color='red'>流失</font>"
                    }
                }
            }
        ]],
        onClickRow: function (index, row) {
            if (row.stateId == 3) {
                $("#trend_btn").linkbutton({text: "复学"})
            } else {
                $("#trend_btn").linkbutton({text: "休学"})
            }
        }
    });


// 初始化一个弹框 点击添加或者编辑的时候才打开
    client_dialog.dialog({
        width: 850,
        height: 550,
        buttons: "#bb",
        // 一开始就是关闭的状态
        closed: true
    })

    var cmdObj = {

        //编辑操作
        edit: function () {
            //编辑需要回显数据
            //从datagrid中获取编辑的那一行数据
            var row = client_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要编辑的数据");
            } else {
                //将选中的行的数据加载到对话框中的form表单中
                client_dialog.dialog("open");
                client_dialog.dialog("setTitle", "学员编辑");
                $("#editForm").form("clear");
                if (row.education) {
                    row['education.id'] = row.education.id;
                }
                if (row.major) {
                    row['major.id'] = row.major.id;
                }
                if (row.sourceOfClient) {
                    row['sourceOfClient.id'] = row.sourceOfClient.id;
                }
                if (row.clientType) {
                    row['clientType.id'] = row.clientType.id;
                }
                if (row.yearsOfWorkExperience) {
                    row['yearsOfWorkExperience.id'] = row.yearsOfWorkExperience.id;
                }
                if (row.hometown) {
                    row['hometown.id'] = row.hometown.id;
                }
                if (row.intentionSchool) {
                    row['intentionSchool.id'] = row.intentionSchool.id;
                }
                if (row.intentionClass) {
                    row['intentionClass.id'] = row.intentionClass.id;
                }

                $("#editForm").form("load", row);

            }
        },


        //休学/复学
        trend: function () {
            var row = client_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择需要休学的学员")
            } else {
                $.get("/student/trend", {id: row.id}, function (data) {
                    if (data.success) {
                        $.messager.alert("温馨提示", "操作成功");
                        client_datagrid.datagrid("load");
                    } else {
                        $.messager.alert("温馨提示", data.errorMsg);

                    }
                })

            }
        },

        //流失
        leave: function () {
            var row = client_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择需要流失的学员")
            } else {
                $("#leave_dialog").dialog({
                    width: 400,
                    height: 400,
                    title: "流失添加",
                    buttons: "#leave_form_btns",
                    // 一开始就是关闭的状态
                    closed: false
                });
                if (row.id) {
                    row['client.id'] = row.id;
                }
                ;
                $("#leave_form").form("load", row);

            }
        },

        //流失保存操作
        leaveSave: function () {
            // 点击保存 提交表单
            // 获取id 能够获取到的就是更新 不能获取的是保存
            var id = $("#studentLeave").val();
            url = "/studentLeave/save";
            if (id) {
                return;
            }
            $("#leave_form").form("submit", {
                url: url,
                success: function (data) {
                    // 接受返回的数据
                    // 操作失败 提示用户
                    // 操作成功,提示用户 关闭当前对话框,刷新页面
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        $.messager.alert("温馨提示", "保存成功");
                        $("#leave_dialog").dialog("close");
                        client_datagrid.datagrid("load");

                    }
                }
            })
        },


        //保存操作
        save: function () {
            // 点击保存 提交表单
            // 获取id 能够获取到的就是更新 不能获取的是保存
            var id = $("#clientId").val();
            url = "/student/updateByStudent";
            if (!id) {
                return;
            }
            $("#editForm").form("submit", {
                url: url,
                success: function (data) {
                    // 接受返回的数据
                    // 操作失败 提示用户
                    // 操作成功,提示用户 关闭当前对话框,刷新页面
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        $.messager.alert("温馨提示", "保存成功");
                        client_dialog.dialog("close");
                        client_datagrid.datagrid("load");

                    }
                }
            })
        },


        //查询操作
        query: function () {
            var keyword = $("#keyword").textbox("getText");
            var begindate = $("#begindate").datetimebox("getText");
            var enddate = $("#enddate").datetimebox("getText");
            client_datagrid.datagrid("load", {
                keyword: keyword,
                begindate: begindate,
                enddate: enddate
            });
        },

        //取消对话框
        cancel: function () {
            client_dialog.dialog("close");
        },
        //刷新
        reload: function () {
            client_datagrid.datagrid("reload");
        },
    }
    //调用方法
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})

