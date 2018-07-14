$(function () {
    var rep_datagrid = $('#rep_datagrid');
    var rep_dialog = $("#rep_dialog");

    //datagrid的初始化
    rep_datagrid.datagrid({
        url: "/receiptbill/list",
        fitColumns: true,
        striped: true,
        pagination: true,
        rownumbers: true,
        fit: true,
        singleSelect: true,
        checkOnSelect: true,
        columns: [[
            {field: 'x', checkbox: 'true'},
            {field: 'id', title: '编号', width: 100, hidden: true},
            {
                field: "client", title: "学员名称", width: 100, formatter: function (value, row, index) {
                return value ? value.name : "";
            }
            },
            {field: 'receipttime', title: '收款时间', width: 100},
            {field: 'receiptmoney', title: '收款金额', width: 100},
            {field: 'totalmoney', title: '总金额', width: 100},
            /*{field: 'unpaidmoney', title: '待付金额', width: 100},*/
            {
                field: "unpaidmoney", title: "待付金额", width: 100, formatter: function (value, row, index) {
                if (value) {
                    return value;
                } else {
                    return 0;
                }
            }
            },
            {
                field: "grade", title: "班级", width: 100, formatter: function (value, row, index) {
                return value ? value.name : "";
            }
            },
            {
                field: "receipter", title: "收款人", width: 100, formatter: function (value, row, index) {
                return value ? value.realname : "";
            }
            },
            {
                field: "payment", title: "收款方式", width: 100, formatter: function (value, row, index) {
                return value ? value.payname : "";
            }
            },
            {field: 'billnum', title: '订单号', width: 100},
            {
                field: "courseName", title: "学科", width: 100, formatter: function (value, row, index) {
                return value ? value.name : "";
            }
            },
            {
                field: "marketer", title: "营销人员", width: 100, formatter: function (value, row, index) {
                return value ? value.realname : "";
            }
            },
            {
                field: "campus", title: "校区", width: 100, formatter: function (value, row, index) {
                return value ? value.name : "";
            }
            },
            {field: 'remark', title: '备注', width: 100},
            {
                field: 'auditor', title: '审核人', width: 90, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return value.realname;
                }}
            },
            {
                field: "state", title: "审核", width: 100, formatter: function (value, row, index) {
                if (value == 1) {
                    return "<font color='green'>已审核</font>";
                } else if (value == 0) {
                    return "<font color='red'>未审核</font>";
                }
            }
            }
        ]],
        toolbar: "#tb",
    });
    //end

    //rep_dialog的初始化
    rep_dialog.dialog({
        title: "温馨提示",
        width: 400,
        height: 400,
        top: 100,
        buttons: "#bb",
        closed: true
    })
    //end

    var cmdObj = {

        //刷新操作
        reload: function () {
            rep_datagrid.datagrid("load");
        },

        //取消按钮
        cancel: function () {
            rep_dialog.dialog("close");
        },

        //查询操作
        query: function () {
            var keyword = $("#keyword").textbox("getText");
            var begindate = $("#begindate").datetimebox("getText");
            var enddate = $("#enddate").datetimebox("getText");
            var paymentId = $("#paymentId").combobox("getValue");
            var gradeId = $("#gradeId").combobox("getValue");
            rep_datagrid.datagrid("load", {
                keyword: keyword,
                begindate: begindate,
                enddate: enddate,
                paymentId: paymentId,
                gradeId: gradeId
            });
        },

        //保存操作
        save: function () {
            var id = $("#repId").val();
            controller = "/receiptbill/save";
            if (id) {
                return;
            }
            $("#editForm").form("submit", {
                url: controller,
                /*onSubmit: function (param) {
                 var ids = $("#rolesId").combobox("getValues");
                 for (var i = 0; i < ids.length; i++) {
                 param["roles[" + i + "].id"] = ids[i];
                 }
                 },*/
                success: function (data) {
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        rep_dialog.dialog("close");
                        rep_datagrid.datagrid("reload");
                    }
                }
            })
        },

        //删除
        remove: function () {
            var row = rep_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要删除的行")
            } else {
                $.get("/receiptbill/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        rep_dialog.dialog("close");
                        rep_datagrid.datagrid("reload");
                    }
                })
            }
        },

        //添加
        add: function () {
            $("#editForm").form("clear");
            rep_dialog.dialog("open");
            rep_dialog.dialog("setTitle", "收款添加");
            $('#receiptbill_combogrid').combogrid({
                panelWidth: 450,
                textField: 'name',
                idField: 'id',
                url: '/student/queryStudents',
                columns: [[
                    {field: 'id', title: '编号', width: 100, hidden: true},
                    {
                        field: 'name', title: '学员名称', width: 100, formatter: function (value, row, index) {
                            if (value){
                                return value.name;
                            }
                    }
                    },
                    {
                        field: 'tel', title: '电话', width: 100, formatter: function (value, row, index) {
                        if (value){
                            return value.tel;
                        }
                    }
                    },
                    {
                        field: 'qqnum', title: 'QQ', width: 100, formatter: function (value, row, index) {
                        if (value){
                            return value.qqnum;
                        }
                    }
                    },
                    {
                        field: 'saleMan', title: '营销人员', width: 90, align: "center", formatter: function (value, row, index) {
                        if (value) {
                            return value.realname;
                        }}
                    },
                    {
                        field: 'receipttime', title: '入学时间', width: 90, align: "center", formatter: function (value, row, index) {
                        return row.receiptBill.receipttime;
                    }
                    },
                    {
                        field: 'totalmoney', title: '总学费', width: 90, align: "center", formatter: function (value, row, index) {
                        return row.receiptBill.totalmoney;
                    }
                    },
                    {
                        field: 'receiptmoney', title: '已缴学费', width: 90, align: "center", formatter: function (value, row, index) {
                        return row.receiptBill.receiptmoney;
                    }
                    },
                    {
                        field: 'state', title: '缴款状态', width: 90, align: "center", formatter: function (value, row, index) {
                        value = row.receiptBill.state
                        if (value == 1) {
                            return "<font color='green'>已缴清</font>";
                        } else if (value == 0) {
                            return "<font color='red'>未缴清</font>";
                        }
                    }
                    },
                    {
                        field: 'name', title: '校区', width: 90, align: "center", formatter: function (value, row, index) {
                        return ow.receiptBill.name;
                    }
                    },
                    {field: 'email', title: '邮箱', width: 90, align: "center"},
                ]]
            });
        },

        //审核
        ok: function () {
            var row = rep_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要审核的数据")
            } else {
                $.get("/receiptbill/check", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        rep_dialog.dialog("close");
                        rep_datagrid.datagrid("reload");
                    }
                })
            }
        }
    }

    $("a[data-cmd]"
    ).click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})

