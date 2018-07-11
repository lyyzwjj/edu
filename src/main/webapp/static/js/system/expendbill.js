$(function(){
    var exp_datagrid = $('#exp_datagrid');
    var exp_dialog = $("#exp_dialog");

    //datagrid的初始化
    exp_datagrid.datagrid({
        url:"/expendbill/list",
        fitColumns:true,
        striped:true,
        pagination:true,
        rownumbers:true,
        fit:true,
        singleSelect:true,
        checkOnSelect:true,
        columns:[[
            {field:'x',checkbox:'true'},
            {field:'id',title:'编号',width:100,hidden:true},
            {field:'payTime',title:'时间',width:100},
            {field:'payMoney',title:'金额',width:100},
            {
                field: "cashier", title: "出纳", width: 100, formatter: function (value, row, index) {
                return value ? value.realname : "";
            }
            },
            {
                field: "auditor", title: "经办人", width: 100, formatter: function (value, row, index) {
                return value ? value.realname : "";
            }
            },
            {
                field: "payment", title: "支付方式", width: 100, formatter: function (value, row, index) {
                return value ? value.payname : "";
            }
            },
            {field:'genre',title:'类型',width:100},
            {field:'billNumber',title:'订单号',width:100},
            {field:'affiliationSubject',title:'归属学科',width:100},
            {
                field: "state", title: "审核", width: 100, formatter: function (value, row, index) {
                if (value == 1) {
                    return "<font color='green'>已审核</font>";
                } else if (value == 0){
                    return "<font color='red'>未审核</font>";
                }
            }
            }
        ]],
        toolbar:"#tb",
    });
    //end

    //exp_dialog的初始化
    exp_dialog.dialog({
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
            exp_datagrid.datagrid("load");
        },

        //取消按钮
        cancel: function () {
            exp_dialog.dialog("close");
        },

        //查询操作
        query: function () {
            var keyword = $("#keyword").textbox("getText");
            var begindate = $("#begindate").datetimebox("getText");
            var enddate = $("#enddate").datetimebox("getText");
            exp_datagrid.datagrid("load", {
                keyword: keyword,
                begindate: begindate,
                enddate: enddate
            });
        },

        //保存操作
        save: function () {
            var id = $("#expId").val();
            controller = "/expendbill/save";
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
                        exp_dialog.dialog("close");
                        exp_datagrid.datagrid("reload");
                    }
                }
            })
        },

        //删除
        remove: function () {
            var row = exp_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要删除的行")
            } else {
                $.get("/expendbill/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        exp_dialog.dialog("close");
                        exp_datagrid.datagrid("reload");
                    }
                })
            }
        },

        //添加
        add: function () {
            $("#editForm").form("clear");
            exp_dialog.dialog("open");
            exp_dialog.dialog("setTitle", "员工添加");
        },

        //审核
        ok: function () {
            var row = exp_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要审核的数据")
            } else {
                $.get("/expendbill/check", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        exp_dialog.dialog("close");
                        exp_datagrid.datagrid("reload");
                    }
                })
            }
        }
    }

    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})

