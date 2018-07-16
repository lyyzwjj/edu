$(function () {
    var studentLeave_datagrid = $("#studentLeave_datagrid");
    var studentLeave_dialog = $("#studentLeave_dialog");
    studentLeave_datagrid.datagrid({
        fit: true,
        url: "/studentLeave/list",
        fitColumns: true,
        striped: true,
        pagination: true,
        rownumbers: true,
        toolbar: "#tb",
        singleSelect: true,
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'id', width: 90, align: "center", hidden: 'true'},
            {
                field: 'name', title: '学员姓名', width: 90, align: "center", formatter: function (value, row, index) {
                return row.client.name;
            }
            },
            {
                field: 'qq', title: 'QQ', width: 100, formatter: function (value, row, index) {
                return row.client.qq;
            }
            },
            {
                field: 'tel', title: '电话', width: 100, formatter: function (value, row, index) {
                return row.client.tel;
            }
            },
            {field: 'day', title: '上课天数', width: 90, align: "center"},
            {
                field: 'grade', title: '流失班级', width: 100, formatter: function (value, row, index) {
                return value.name;
            }
            },
            {
                field: 'phase', title: '流失阶段', width: 90, align: "center", formatter: function (value, row, index) {
                if (value == 1) {
                    return "<font color='green'>大神班</font>";
                } else if (value == 0) {
                    return "<font color='green'>基础班</font>";
                }
            }
            },
            {field: 'reason', title: '流失原因', width: 90, align: "center"},
            {field: 'leavetime', title: '流失时间', width: 90, align: "center"},

            {
                field: 'operator', title: '经办人', width: 90, align: "center", formatter: function (value, row, index) {
                if (value != null) {
                    return value.realname;
                }
            }
            },
            {
                field: 'inputer', title: '录入人', width: 90, align: "center", formatter: function (value, row, index) {
                if (value != null) {
                    return value.realname;
                }
            }
            },
            {
                field: 'marketer', title: '营销人员', width: 90, align: "center", formatter: function (value, row, index) {
                if (value != null) {
                    return value.realname;
                }
            }
            },
            {
                field: 'reimburse', title: '是否退款', width: 90, align: "center", formatter: function (value, row, index) {
                if (value == 1) {
                    return "<font color='green'>已退款</font>";
                } else if (value == 0) {
                    return "<font color='red'>未退款</font>";
                }
            }
            },
            {
                field: 'state', title: '审核', width: 90, align: "center", formatter: function (value, row, index) {
                if (value == 1) {
                    return "<font color='green'>已审核</font>";
                } else if (value == 0) {
                    return "<font color='red'>未审核</font>";
                }
            }
            },
            {
                field: 'auditor', title: '审核人', width: 90, align: "center", formatter: function (value, row, index) {
                if (value != null) {
                    return value.realname;
                }
            }
            },
        ]],
    });


// 初始化一个弹框 点击添加或者编辑的时候才打开
    studentLeave_dialog.dialog({
        width: 300,
        height: 300,
        buttons: "#bb",
        // 一开始就是关闭的状态
        closed: true
    });

    var cmdObj = {

        //审核功能
        changeState: function () {
            var row = studentLeave_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要审核的学员");
            } else {
                $.messager.confirm('确认', '您确认审核该学员吗？', function (r) {
                    if (r) {
                        //发起请求
                        $.get("/studentLeave/changeState", {id: row.id}, function (data) {
                            if (data.success) {
                                studentLeave_dialog.dialog("close");
                                studentLeave_datagrid.datagrid("load");
                            } else {
                                $.messager.alert("温馨提示", data.errorMsg);
                            }
                        })
                    }
                });

            }
        },

        //删除
        remove: function () {
            var row = studentLeave_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要删除的行")
            } else {
                $.get("/studentLeave/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        studentLeave_dialog.dialog("close");
                        studentLeave_datagrid.datagrid("load");
                    }
                })
            }
        },

        //高级查询
         query:function() {
         var keyword=$("#keyword").textbox("getValue");
         var begindate=$("#begindate").datebox("getValue");
         var enddate=$("#enddate").datebox("getValue");
         //将数据通过load
         studentLeave_datagrid.datagrid("load",{
         keyword:keyword,
         begindate:begindate,
         enddate:enddate
         })
         },
        //取消对话框
        cancel: function () {
            studentLeave_dialog.dialog("close");
        },
        //刷新
        reload: function () {
            studentLeave_datagrid.datagrid("reload");
        },
    }


    //调用方法
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })


})

