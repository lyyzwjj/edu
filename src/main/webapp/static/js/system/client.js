$(function () {
    var client_datagrid = $("#client_datagrid");
    var client_dialog = $("#client_dialog");
    client_datagrid.datagrid({
        width: 700,
        height: 500,
        fit: true,
        url: "/client/list",
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'id', width: 100, align: "center",hidden:true},
            {field: 'name', title: '客户姓名', width: 100, align: "center"},
            {field: 'saleMan', title: '营销人员', width: 100, align: "center"},
            {field: 'inputMan', title: '跟踪人员', width: 100, align: "center"},
            {field: 'traceTimes', title: '跟踪次数', width: 100, align: "center"},
            {field: 'lastTraceDate', title: '最后跟踪时间', width: 100, align: "center"},
            {field: 'bookDate', title: '预约日期', width: 100, align: "center"},
            {field: 'nextTraceDate', title: '下次跟踪时间', width: 100, align: "center"},
            {field: 'weChatNum', title: '微信号', width: 100, align: "center"},
            {field: 'tel', title: '电话', width: 100, align: "center"},
            {field: 'shcool', title: '学校', width: 100, align: "center"},
            {field: 'degreeofIntention', title: '意向程度', width: 100, align: "center"},
            {field: 'intentionSchool', title: '意向校区', width: 100, align: "center"},
            {field: 'intentionClass', title: '意向班级', width: 100, align: "center"},
            {field: 'state', title: '状态', width: 100, align: "center"},
            {
                field: 'isManTrace', title: '未跟踪', width: 100, align: "center", formatter: function (value, row, index) {
                    if (value) {
                        return "<font color='green'>有</font>";
                    } else {
                        return "<font color='red'>无</font>";
                    }
                }
            },
            {field: 'remark', title: '备注', width: 100, align: "center"}
        ]],
        toolbar: "#tb",
        fitColumns: true,
        pagination: true,
        singleSelect: true,
        striped: true,
        rownumbers: true
       /*onClickRow: function (index, row) {
            if (row.state == 0) {
                $("#change_btn").linkbutton({text: "复职"})
            } else {
                $("#change_btn").linkbutton({text: "离职"})
            }
        }*/
    });
    client_dialog.dialog({
        title: "温馨提示",
        width: 400,
        height: 400,
        top: 100,
        buttons: "#bb",
        closed: true
    })
    var cmdObj = {
        reload: function () {
            client_datagrid.datagrid("load");
        },
        cancel: function () {
            client_dialog.dialog("close");
        },
        query: function () {
            var keyword = $("#keyword").textbox("getText");
            var beginDate = $("#beginDate").datebox("getText");
            var endDate = $("#endDate").datebox("getText");
            client_datagrid.datagrid("load", {
                keyword: keyword,
                beginDate: beginDate,
                endDate: endDate
            });
        },
        save: function () {
            var id = $("#clientId").val();
            controller = "/client/save";
            if (id) {
                var controller = "/client/update";
            }
            $("#editForm").form("submit", {
                url: controller,
               /* onSubmit: function (param) {
                    var ids = $("#rolesId").combobox("getValues");
                    for (var i = 0; i < ids.length; i++) {
                        param["roles[" + i + "].id"] = ids[i];
                    }
                },*/
                success: function (data) {
                    data = $.parseJSON(data);
                    console.log(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        client_dialog.dialog("close");
                        client_datagrid.datagrid("reload");
                    }
                }
            })
        },
        edit: function () {
            $("#editForm").form("clear");
            var row = client_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要编辑的行")
            } else {
                client_dialog.dialog("open");
                client_dialog.dialog("setTitle", "潜在客户编辑");
            }
        },
        changeState: function () {
            var row = client_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要编辑的数据")
            } else {
                $.get("/client/changeState", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        client_dialog.dialog("close");
                        client_datagrid.datagrid("reload");
                    }
                })
            }
        },
        add: function () {
            $("#editForm").form("clear");
            client_dialog.dialog("open");
            client_dialog.dialog("setTitle", "潜在客户添加");
        }
    }
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})


