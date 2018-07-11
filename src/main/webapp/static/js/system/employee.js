$(function () {
    var emp_datagrid = $("#emp_datagrid");
    var emp_dialog = $("#emp_dialog");
    emp_datagrid.datagrid({
        width: 700,
        height: 500,
        fit: true,
        url: "/employee/list",
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'ID', width: 50, align: "center"},
            {field: 'employeeId', title: '工号', width: 100, align: "center"},
            {field: 'username', title: '用户名', width: 80, align: "center"},
            {field: 'password', title: '密码', width: 100, align: "center"},
            {field: 'realname', title: '真实姓名', width: 100, align: "center"},
            {field: 'age', title: '年龄', width: 80, align: "center", sortable: true, order: "asc"},
            {
                field: 'gender', title: '性别', width: 80, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return "<font color='green'>男</font>";
                } else {
                    return "<font color='red'>女</font>";
                }
            }
            },
            {field: 'bornDate', title: '出生日期', width: 100, align: "center", sortable: true, order: "asc"},
            {field: 'cardId', title: '身份证号', width: 150, align: "center"},
            {field: 'tel', title: '电话', width: 100, align: "center"},
            {field: 'eamil', title: '邮箱', width: 150, align: "center"},
            {field: 'qq', title: 'QQ', width: 100, align: "center"},
            {field: 'address', title: '地址', width: 100, align: "center"},
            {field: 'attendanceId', title: '考勤卡号', width: 100, align: "center"},
            {field: 'hireDate', title: '入职日期', width: 100, align: "center", sortable: true, order: "asc"},
            {field: 'seniority', title: '工龄', width: 100, align: "center", sortable: true, order: "asc"},
            {
                field: 'state', title: '状态', width: 100, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return "<font color='green'>在职</font>";
                } else {
                    return "<font color='red'>离职</font>";
                }
            }
            },
            {
                field: 'admin', title: '超级管理员身份', width: 80, align: "center", formatter: function (value, row, index) {
                return value ? "是" : "否";
            }
            },
            {
                field: 'dept',
                title: '部门',
                width: 100,
                align: "center",
                formatter: function (value, row, index) {
                    return value ? value.name : "未分配部门";
                }
            }
        ]],
        toolbar: "#tb",
        fitColumns: true,
        pagination: true,
        singleSelect: true,
        striped: true,
        rownumbers: true,
        onClickRow: function (index, row) {
            if (row.state == 0) {
                $("#change_btn").linkbutton({text: "复职"})
            } else {
                $("#change_btn").linkbutton({text: "离职"})
            }
        }
    });
    emp_dialog.dialog({
        title: "温馨提示",
        width: 880,
        height: 500,
        top: 100,
        buttons: "#bb",
        closed: true
    })

    var cmdObj = {
        reload: function () {
            emp_datagrid.datagrid("load");
        },
        cancel: function () {
            emp_dialog.dialog("close");
        },
        //高级查询函数
        query: function () {
            var keyword = $("#keyword").textbox("getText");
            var beginDate = $("#beginDate").datebox("getText");
            var endDate = $("#endDate").datebox("getText");
            emp_datagrid.datagrid("load", {
                keyword: keyword,
                beginDate: beginDate,
                endDate: endDate
            });
        },
        //保存操作
        save: function () {
            var id = $("#empId").val();
            controller = "/employee/save";
            if (id) {
                var controller = "/employee/update";
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
        },
        //编辑操作
        edit: function () {
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
                /*
                 $.get("/role/getRoldsIdByEmployeeId?employeeId=" + row.id, function (data) {
                 $("#rolesId").combobox("setValues", data);
                 })*/
                console.log(row);
                $("#editForm").form("load", row);

                //强制设置回显
                $("#adminId").combobox('setValue', row.admin);
                $("#stateId").combobox('setValue', row.state);
            }
        },
        //更新状态
        changeState: function () {
            var row = emp_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择需要离职或复职的员工")
            } else {
                $.get("/employee/changeState", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        $.messager.alert("温馨提示", "操作成功");
                        emp_dialog.dialog("close");
                        emp_datagrid.datagrid("reload");
                    }
                })
            }
        },
        //删除
        delete: function () {
            var row = emp_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择需要删除的行")
            } else {
                $.get("/employee/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg)
                    } else {
                        $.messager.alert("温馨提示", "删除成功")
                        emp_dialog.dialog("close");
                        emp_datagrid.datagrid("reload");
                    }
                })
            }
        },
        //添加菜单的初始化
        add: function () {
            $("#editForm").form("clear");
            emp_dialog.dialog("open");
            emp_dialog.dialog("setTitle", "员工添加");
        },
        query:function(){
            var keyword = $("#keyword").textbox("getText");
            var beginDate = $("#beginDate").datebox("getText");
            var endDate = $("#endDate").datebox("getText");
            emp_datagrid.datagrid("load", {
                keyword: keyword,
                beginDate: beginDate,
                endDate: endDate
            });
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
 $.get("/employee/changeState", {id: row.id}, function (data) {
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
 controller = "/employee/save";
 if (id) {
 var controller = "/employee/update";
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
