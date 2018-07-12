$(function(){
    var clientMajor_datagrid=$("#clientMajor_datagrid");
    var clientMajor_dialog=$("#clientMajor_dialog");
    var clientTrace_dialog=$("#clientTrace_dialog");
    clientMajor_datagrid.datagrid({
        fit:true,
        url:"/clientMajor/list",
        fitColumns:true,
        striped:true,
        pagination:true,
        rownumbers:true,
        toolbar:"#tb",
        singleSelect:true,
        columns:[[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'id', width: 90, align: "center",hidden:'true'},
            {field: 'name', title: '学校名称', width: 90, align: "center"},
            {
                field: 'saleMan', title: '营销人员', width: 90, align: "center", formatter: function (value) {
                if (value) {
                    return value.username;
                }}
            },
            {field: 'traceMan', title: '跟踪人员', width: 90, align: "center", formatter: function (value) {
                if (value) {
                    return value.username;
                }}},
            {field: 'lastTraceDate', title: '最后跟踪时间', width: 100, align: "center"},
            {field: 'nextTraceDate', title: '下次跟踪时间', width: 100, align: "center"},
            {field: 'tel', title: '学校电话', width: 110, align: "center"},
            {
                field: 'contactPerson', title: '联系人', width: 110, align: "center", formatter: function (value) {
                if (value) {
                    return value.name;
                }
            }
            },
            {
                field: 'contactPerson', title: '联系人电话', width: 110, align: "center", formatter: function (value) {
                if (value) {
                    return value.tel;
                }
            }
            },
            {field: 'degreeofIntention', title: '意向程度', width: 100, align: "center"},
            {field: 'intentionClass', title: '意向班级', width: 100, align: "center"},
            {field: 'clientState', title: '客户当前状态', width: 100, align: "center"},
            {
                field: 'traceState', title: '跟踪状态', width: 100, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return "<font color='green'>跟进中</font>";
                } else {
                    return "<font color='red'>无人跟进</font>";
                }
            }
            },
            {field: 'remark', title: '备注', width: 100, align: "center"}
        ]],
    });




// 初始化一个弹框 点击添加或者编辑的时候才打开
    clientMajor_dialog.dialog({
        width:850,
        height:550,
        buttons:"#bb",
        // 一开始就是关闭的状态
        closed:true
    });


    var cmdObj= {
        //添加操作
        add: function () {
            $("#editForm").form("clear");
            clientMajor_dialog.dialog("open");
            clientMajor_dialog.dialog("setTitle", "潜在客户添加");
        },


        //编辑操作
        edit: function () {
            //编辑需要回显数据
            //从datagrid中获取编辑的那一行数据
            var row = clientMajor_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要编辑的数据");
            } else {
                //将选中的行的数据加载到对话框中的form表单中
                clientMajor_dialog.dialog("open");
                clientMajor_dialog.dialog("setTitle", "潜在客户编辑");
                $("#editForm").form("clear");
                $("#editForm").form("load", row);

            }
        },
        //编辑操作
        view: function () {
            //编辑需要回显数据
            //从datagrid中获取编辑的那一行数据
            var row = clientMajor_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要查看的客户");
            } else {
                //将选中的行的数据加载到对话框中的form表单中
                clientMajor_dialog.dialog("open");
                clientMajor_dialog.dialog("setTitle", "潜在客户编辑");
                $("#editForm").form("clear");
                $("#editForm").form("load", row);
                $(":input").prop("readonly", true);

            }
        },

        //保存操作
        save: function () {
            // 点击保存 提交表单
            // 获取id 能够获取到的就是更新 不能获取的是保存
            var id = $("#clientId").val();
            var url = "/clientMajor/save";
            if (id) {
                url = "/clientMajor/update";
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
                        clientMajor_dialog.dialog("close");
                        clientMajor_datagrid.datagrid("load");

                    }
                }
            })
        },
        //高级查询
        query: function () {
            var keyword = $("#keyword").textbox("getValue");
            var beginDate = $("#beginDate").datebox("getValue");
            var endDate = $("#endDate").datebox("getValue");
            //将数据通过load
            clientMajor_datagrid.datagrid("load", {
                keyword: keyword,
                beginDate: beginDate,
                endDate: endDate
            })
        },
        //潜在学员转正功能
        remove: function () {
            var row = clientMajor_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要删除的客户");
            } else {
                $.messager.confirm('确认', '您确认将该客户删除吗？', function (r) {
                    if (r) {
                        //发起请求
                        $.get("/client/delete", {id: row.id}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", "删除成功");
                                clientMajor_datagrid.datagrid("load");
                            } else {
                                $.messager.alert("温馨提示", data.errorMsg);
                            }
                        })
                    }
                });

            }
        },
        //取消对话框
        cancel: function () {
            clientMajor_dialog.dialog("close");
        },
        //刷新
        reload: function () {
            clientMajor_datagrid.datagrid("reload");
        }
    }


    //调用方法
    $("a[data-cmd]").click(function(){
        var cmd=$(this).data("cmd");
        cmdObj[cmd]();
    })



})

