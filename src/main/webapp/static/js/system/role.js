$(function () {
    var role_datagrid = $("#role_datagrid");
    var role_dialog = $("#role_dialog");
    var allPermissions = $("#allPermissions");
    var selfPermissions = $("#selfPermissions");
    var allData = {};
    role_datagrid.datagrid({
        width: 700,
        height: 500,
        fit: true,
        url: "/role/list",
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: '编号', width: 100, align: "center"},
            {field: 'sn', title: '描述', width: 100, align: "center"},
            {field: 'name', title: '角色全称', width: 100, align: "center"},

        ]],
        toolbar: "#tb",
        fitColumns: true,
        pagination: true,
        singleSelect: true,
        striped: true,
        rownumbers: true,

    });
    role_dialog.dialog({
        title: "温馨提示",
        width: 600,
        height: 500,
        top: 100,
        buttons: "#bb",
        closed: true
    });
    allPermissions.datagrid({
        title: "系统权限",
        width: 250,
        height: 350,
        url: "/permission/all",
        rownumbers: true,
        fitColumns: true,
        columns: [[
            {field: 'id', title: '编号', width: 100, align: "center", hidden: true},
            {field: 'name', title: '权限名', width: 100, align: "center"},

        ]],
        toolbar: "#alltb",
        onDblClickRow: function (index, row) {
            //双击删除一个
            allPermissions.datagrid("deleteRow", index);
            selfPermissions.datagrid("appendRow", row);
        },
        onLoadSuccess: function (data) {
            allData = $.extend(true, {}, data)
        }
    });
    selfPermissions.datagrid({
        title: "自身拥有的权限",
        width: 250,
        height: 350,
        rownumbers: true,
        fitColumns: true,
        columns: [[
            {field: 'id', title: '编号', width: 100, align: "center", hidden: true},
            {field: 'name', title: '权限名', width: 100, align: "center"},

        ]],
        toolbar: "#selftb",
        onDblClickRow: function (index, row) {
            //双击删除一个
            selfPermissions.datagrid("deleteRow", index);
            allPermissions.datagrid("appendRow", row);
        },
        onLoadSuccess: function (data) {
            var rows = selfPermissions.datagrid("getRows");
            var ids = $.map(rows, function (item) {
                return item.id;
            })
            //查询系统权限集合
            //加载左边所有的权限
            var allRows = allPermissions.datagrid("getRows");
            for (var i = allRows.length - 1; i >= 0; i--) {
                if ($.inArray(allRows[i].id, ids) >= 0) {
                    //存在删除该数据
                    allPermissions.datagrid("deleteRow", i)
                }
            }
        }

    });
    $("#all_all_a").linkbutton({
        iconCls: 'icon-ok',
        onClick: function () {
            allPermissions.datagrid("checkAll")
        }

    });
    $("#all_cancel_a").linkbutton({
        iconCls: 'icon-no',
        onClick: function () {
            allPermissions.datagrid("unselectAll");
        }
    });
    $("#all_part_a").linkbutton({
        iconCls: 'icon-redo',
        onClick: function () {
            var rows = allPermissions.datagrid("getSelections");
            for (var i = 0; i < rows.length; i++) {
                selfPermissions.datagrid("appendRow", rows[i])
            }
            var copyRows = [];
            for (var j = 0; j < rows.length; j++) {
                copyRows.push(rows[j]);
            }
            for (var i = 0; i < copyRows.length; i++) {
                var index = allPermissions.datagrid('getRowIndex', copyRows[i]);
                allPermissions.datagrid('deleteRow', index);
            }
        }
    });
    $("#self_all_a").linkbutton({
        iconCls: 'icon-ok',
        onClick: function () {
            selfPermissions.datagrid("checkAll")
        }
    });
    $("#self_cancel_a").linkbutton({
        iconCls: 'icon-no',
        onClick: function () {
            selfPermissions.datagrid("unselectAll")
        }
    });
    $("#self_part_a").linkbutton({
        iconCls: 'icon-undo',
        onClick: function () {
            var rows = selfPermissions.datagrid("getSelections");
            for (var i = 0; i < rows.length; i++) {
                allPermissions.datagrid("appendRow", rows[i])
            }
            var copyRows = [];
            for (var j = 0; j < rows.length; j++) {
                copyRows.push(rows[j]);
            }
            for (var i = 0; i < copyRows.length; i++) {
                var index = selfPermissions.datagrid('getRowIndex', copyRows[i]);
                selfPermissions.datagrid('deleteRow', index);
            }
        }

    });
    var cmdObj = {
        reload: function () {
            role_datagrid.datagrid("load");
        },
        cancel: function () {
            role_dialog.dialog("close");
            allPermissions.datagrid("load");
            selfPermissions.datagrid("load");
        },
        query: function () {
            var keyword = $("#keyword").textbox("getText");
            var beginDate = $("#beginDate").datebox("getText");
            var endDate = $("#endDate").datebox("getText");
            role_datagrid.datagrid("load", {
                keyword: keyword,
                beginDate: beginDate,
                endDate: endDate
            });
        },
        save: function () {
            var id = $("#id").val();
            controller = "/role/save";
            if (id) {
                var controller = "/role/update";
            }
            $("#editForm").form("submit", {
                url: controller,
                onSubmit: function (param) {
                    var rows = selfPermissions.datagrid("getRows");
                    for (var i = 0; i < rows.length; i++) {
                        param["permissions[" + i + "].id"] = rows[i].id;
                        console.log("参数是否传递============" + rows[i].id);
                    }

                },
                success: function (data) {
                    // 1:接受返回数据
                    data = $.parseJSON(data);
                    // 2判断操作是否成功
                    // 3操作失败,提示用户
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        // 4操作成功
                        // 4.1提示用户操作成功
                        // 4.2关闭当前对话框
                        $("#role_dialog").dialog("close");
                        // 4.3刷新页面
                        $("#role_datagrid").datagrid("reload");
                    }
                }
            })
            allPermissions.datagrid("load");
            selfPermissions.datagrid("load");
        },
        edit: function () {
            var row = role_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选择要编辑的行")
            } else {

                //清空数据
                $("#editForm").form("clear");
                //数据回显
                $("#editForm").form("load", row);
                var options = selfPermissions.datagrid("options");
                console.log(options)
                //console.log("canshu ======"+-options);
                //加载已有权限请求路径
                options.url = "/permission/queryPermissionByRoleId?roleId=" + row.id;
                selfPermissions.datagrid("load")

                role_dialog.dialog("open");
                -
                    role_dialog.dialog("setTitle", "角色编辑");
            }

            //打开对话框
            /*   if (row.dept) {
             row["dept.id"] = row.dept.id;
             //此处的dept.id和name,age是同一等级
             }
             $.get("/role/getRoldsIdByEmployeeId?roleId=" + row.id, function (data) {
             $("#rolesId").combobox("setValues", data);
             })
             console.log(row);*/

        },
        delete: function () {
            var row = role_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要删除的行")
            } else {
                $.messager.confirm('确认', '确定删除角色吗', function (r) {
                    if(r){
                        $.get("/role/delete", {id: row.id}, function (data) {
                            if (!data.success) {
                                $.messager.alert("温馨提示", data.msg)
                            }
                            $.messager.alert("温馨提示", "删除成功");
                            role_dialog.dialog("close");
                            role_datagrid.datagrid("reload");

                            // 退出操作;
                        })

                    }}
                )
            }
        },
        add: function () {
            $("#editForm").form("clear");
            allPermissions.datagrid("loadData", allData);
            selfPermissions.datagrid("loadData", []);
            role_dialog.dialog("open");
            role_dialog.dialog("setTitle", "员工添加");

        }
    }
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})


