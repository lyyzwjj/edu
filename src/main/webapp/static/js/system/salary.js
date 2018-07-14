$(function () {
    var salary_datagrid = $("#salary_datagrid");
    var salary_dialog = $("#salary_dialog");

    salary_datagrid.datagrid({
        width: 500,
        height: 500,
        fit: true,
        url: "/salary/list",
        toolbar: "#tb",
        fitColumns: true,
        pagination: true,
        singleSelect: true,
        striped: true,
        rownumbers: true,
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'ID', width: 50, align: "center"},
            {
                field: "realname", title: "真实姓名", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.realname;
            }
            },
            {
                field: "name", title: "部门名称", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.dept.name;
            }
            },
            {field: 'workDay', title: '工作天数', width: 100, align: "center"},
            {field: 'bankcardNumber', title: '银行卡号', width: 100, align: "center"},
            {field: 'lateday', title: '迟到天数', width: 100, align: "center"},

            {field: 'month', title: '月份', width: 100, align: "center"},
            {
                field: "jobName", title: "职务名称", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.job.jobName;
            }
            },
            {
                field: "baseSalary", title: "基本工资", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.job.baseSalary;
            }
            },
            {
                field: "accumulationFund", title: "公积金缴存基数", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.job.accumulationFund;
            }
            },
            {
                field: "proportion", title: "公积金缴存比例", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.job.proportion;
            }
            },
            {
                field: "overtimeAllowance", title: "加班津贴", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.job.overtimeAllowance;
            }
            },
            {
                field: "bonus", title: "奖金", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.job.bonus;
            }
            },
            {
                field: "coefficient", title: "奖金系数", width: 100, align: "center", formatter: function (value, row, index) {
                return row.employee.job.coefficient;
            }
            },
            {field: 'realWages', title: '实发工资', width: 100, align: "center"}

        ]]
    });
    salary_dialog.dialog({
        title: "温馨提示",
        width: 500,
        height: 500,
        top: 100,
        buttons: "#bb",
        closed: true
    })

    var cmdObj = {
        reload: function () {
            salary_datagrid.datagrid("load");
        },
        cancel: function () {
            salary_dialog.dialog("close");
        },
        //保存操作
        save: function () {
            var id = $("#salaryId").val();
            controller = "/salary/save";
            if (id) {
                var controller = "/salary/update";
            }
            $("#editForm").form("submit", {
                url: controller,
                success: function (data) {
                    data = $.parseJSON(data);
                    console.log(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        $.messager.alert('温馨提示', "保存成功");
                        salary_dialog.dialog("close");
                        salary_datagrid.datagrid("reload");
                    }
                }
            })
        },
        //编辑操作
        edit: function () {
            $("#editForm").form("clear");
            var row = salary_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选择要编辑的行")
            } else {
                salary_dialog.dialog("open");
                salary_dialog.dialog("setTitle", "职务VS工资等级编辑");
                $("#editForm").form("load", row);
            }
        },
        //删除
        delete: function () {
            var row = salary_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择需要删除的行")
            } else {
                $.get("/salary/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg)
                    } else {
                        $.messager.alert("温馨提示", "删除成功")
                        salary_dialog.dialog("close");
                        salary_datagrid.datagrid("reload");
                    }
                })
            }
        },
        //添加菜单的初始化
        add: function () {
            $("#editForm").form("clear");
            salary_dialog.dialog("open");
            salary_dialog.dialog("setTitle", "职务VS工资等级添加");
        },
    }


    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})
