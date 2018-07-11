$(function () {
    var role_datagrid = $("#role_datagrid");
    var role_dialog = $("#role_dialog");
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
        width: 400,
        height: 400,
        top: 100,
        buttons: "#bb",
        closed: true
    })
    var cmdObj = {
        reload: function () {
            role_datagrid.datagrid("load");
        },
        cancel: function () {
            role_dialog.dialog("close");
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
                success : function(data) {
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
        },
        edit: function () {
            $("#editForm").form("clear");
            var row = role_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选择要编辑的行")
            } else {
                role_dialog.dialog("open");
                role_dialog.dialog("setTitle", "员工编辑");
              /*  if (row.dept) {
                    row["dept.id"] = row.dept.id;
                    //此处的dept.id和name,age是同一等级
                }
                $.get("/role/getRoldsIdByEmployeeId?roleId=" + row.id, function (data) {
                    $("#rolesId").combobox("setValues", data);
                })
                console.log(row);*/
                $("#editForm").form("load", row);
            }
        },
        delete: function () {
            var row = role_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择要删除的行")
            } else {
                $.get("/role/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        role_dialog.dialog("close");
                        role_datagrid.datagrid("reload");
                    }
                })

        }},
        add: function () {
            $("#editForm").form("clear");
            role_dialog.dialog("open");
            role_dialog.dialog("setTitle", "员工添加");
        }
    }
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})

/*function add() {
 $("#editForm").form("clear");
 emp_dialog.dialog("open");
 emp_dialog.dialog("setTitle", "员工添加");
 }*/
/*function edit() {
 $("#editForm").form("clear");
 var row = emp_datagrid.datagrid("getSelected");
 if (!row) {
 $.messager.alert("温馨提示", "想选择要编辑的行")
 } else {
 emp_dialog.dialog("open");
 emp_dialog.dialog("setTitle", "员工编辑");
 if (row.dept) {
 row["dept.id"] = row.dept.id;
 //此处的dept.id和name,age是同一等级
 }
 console.log(row);
 $("#editForm").form("load", row);
 }
 }*/
/*function changeState() {
 var row = emp_datagrid.datagrid("getSelected");
 if (!row) {
 $.messager.alert("温馨提示", "想选要离职的员工")
 } else {
 $.get("/role/changeState", {id: row.id}, function (data) {
 if (!data.success) {
 $.messager.alert("温馨提示", data.msg)
 } else {
 emp_dialog.dialog("close");
 emp_datagrid.datagrid("reload");
 }
 })
 }
 }*/
/*function save() {
 var id = $("#empId").val();
 controller = "/role/save";
 if (id) {
 var controller = "/role/update";
 }
 $("#editForm").form("submit", {
 url: controller,
 success: function (data) {
 data = $.parseJSON(data);
 console.log(data);
 if (!data.success) {
 $.messager.alert('温馨提示', data.msg);
 } else {
 emp_dialog.dialog("close");
 emp_datagrid.datagrid("reload");
 }
 }
 })
 }*/
/*function reload() {
 emp_datagrid.datagrid("load");
 }*/
/*function cancel() {
 emp_dialog.dialog("close");
 }*/
/*
 function query() {
 var keyword = $("#keyword").textbox("getText");
 var beginDate = $("#beginDate").datebox("getText");
 var endDate = $("#endDate").datebox("getText");
 emp_datagrid.datagrid("load", {
 keyword: keyword,
 beginDate: beginDate,
 endDate: endDate
 });
 }*/
