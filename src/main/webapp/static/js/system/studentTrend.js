$(function () {
    var studentTrend_datagrid = $("#studentTrend_datagrid");
    var studentTrend_dialog = $("#studentTrend_dialog");
    studentTrend_datagrid.datagrid({
        fit: true,
        url: "/studentTrend/list",
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
                return row.receiptbill.client.name;
            }
            },
            {
                field: 'genre', title: '类型', width: 90, align: "center", formatter: function (value, row, index) {
                if (value == 1) {
                    return "<font color='green'>大神班</font>";
                } else if (value == 0) {
                    return "<font color='green'>基础班</font>";
                }
            }
            },
            {
                field: 'totalmoney', title: '总学费', width: 90, align: "center", formatter: function (value, row, index) {
                return row.receiptbill.totalmoney;
            }
            },
            {
                field: 'receiptmoney',
                title: '已缴学费',
                width: 90,
                align: "center",
                formatter: function (value, row, index) {
                    return row.receiptbill.receiptmoney;
                }
            },
            {field: 'exchangetime', title: '换班日期', width: 90, align: "center"},
            {
                field: 'qqnum', title: 'QQ', width: 90, align: "center", formatter: function (value, row, index) {
                return row.receiptbill.client.qqnum;
            }
            },
            {
                field: 'tel', title: '联系电话', width: 90, align: "center", formatter: function (value, row, index) {
                return row.receiptbill.client.tel;
            }
            },
            {
                field: 'oldclass', title: '以前的班级', width: 90, align: "center", formatter: function (value, row, index) {
                if (value != null) {
                    return value.name;
                }
            }
            },
            {
                field: 'newclass', title: '转换的班级', width: 90, align: "center", formatter: function (value, row, index) {
                if (value != null) {
                    return value.name;
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
                field: 'state', title: '状态', width: 90, align: "center", formatter: function (value, row, index) {
                if (row.receiptbill.state == 1) {
                    return "<font color='green'>已缴清</font>";
                } else if (row.receiptbill.state == 0) {
                    return "<font color='red'>未缴清</font>";
                }
            }
            },
            {
                field: 'trendstate', title: '审核', width: 90, align: "center", formatter: function (value, row, index) {
                if (value == 1) {
                    return "<font color='green'>已审核</font>";
                } else if (value == 0) {
                    return "<font color='red'>未审核</font>";
                }
            }
            },
        ]],
    });


// 初始化一个弹框 点击添加或者编辑的时候才打开
    studentTrend_dialog.dialog({
        width: 300,
        height: 300,
        buttons: "#bb",
        // 一开始就是关闭的状态
        closed: true
    });

    var cmdObj = {
        //添加操作
        add: function () {
            $("#editForm").form("clear");
            studentTrend_dialog.dialog("open");
            studentTrend_dialog.dialog("setTitle", "学员转换添加");
            $('#studentTrend_combogrid').combogrid({
                panelWidth: 450,
                textField: 'name',
                idField: 'id',
                url: '/receiptbill/queryAllBills',
                columns: [[
                    {field: 'id', title: '编号', width: 100, hidden: true},
                    {
                        field: 'name', title: '学员名称', width: 100, formatter: function (value, row, index) {
                        return row.client.name;
                    }
                    },
                    {
                        field: 'tel', title: '电话', width: 100, formatter: function (value, row, index) {
                        return row.client.tel;
                    }
                    },
                    {
                        field: 'qqnum', title: 'QQ', width: 100, formatter: function (value, row, index) {
                        return row.client.qqnum;
                    }
                    },
                    {
                        field: 'grade', title: '班级', width: 100, formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                    },
                    {
                        field: 'courseName', title: '学科', width: 100, formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                    },
                    {
                        field: 'marketer', title: '营销人员', width: 100, formatter: function (value, row, index) {
                        return value ? value.realname : '';
                    }
                    },
                ]]
            });
        },

        //保存操作
        save: function () {
            // 点击保存 提交表单
            // 获取id 能够获取到的就是更新 不能获取的是保存
            var id = $("#stId").val();
            var url = "/studentTrend/save";
            if (id) {
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
                        studentTrend_dialog.dialog("close");
                        studentTrend_datagrid.datagrid("load");

                    }
                }
            })
        },

        //审核功能
        changeState: function () {
            var row = studentTrend_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要审核的学员");
            } else {
                $.messager.confirm('确认', '您确认审核该学员吗？', function (r) {
                    if (r) {
                        //发起请求
                        $.get("/studentTrend/changeState", {id: row.id, stateId: 1}, function (data) {
                            if (data.success) {
                                studentTrend_dialog.dialog("close");
                                studentTrend_datagrid.datagrid("load");
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
            var row = studentTrend_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要删除的行")
            } else {
                $.get("/studentTrend/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        studentTrend_dialog.dialog("close");
                        studentTrend_datagrid.datagrid("load");
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
         studentTrend_datagrid.datagrid("load",{
         keyword:keyword,
         begindate:begindate,
         enddate:enddate
         })
         },
        //取消对话框
        cancel: function () {
            studentTrend_dialog.dialog("close");
        },
        //刷新
        reload: function () {
            studentTrend_datagrid.datagrid("reload");
        },
    }


    //调用方法
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })


})

