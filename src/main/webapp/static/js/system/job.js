$(function () {
    var job_datagrid = $("#job_datagrid");
    var job_dialog = $("#job_dialog");

    job_datagrid.datagrid({
        width: 500,
        height: 500,
        fit: true,
        url: "/job/list",
        toolbar: "#tb",
        fitColumns: true,
        pagination: true,
        singleSelect: true,
        striped: true,
        rownumbers: true,
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'ID', width: 50, align: "center"},
            {field: 'jobName', title: '职务名称', width: 100, align: "center"},
            {field: 'baseSalary', title: '基本工资', width: 80, align: "center"},
            {field: 'accumulationFund', title: '公积金缴存基数', width: 100, align: "center"},
            {field: 'proportion', title: '公积金缴存比例', width: 100, align: "center"},
            {field: 'socialInsurance', title: '社保缴存金额', width: 100, align: "center"},
            {field: 'overtimeAllowance', title: '加班补贴', width: 100, align: "center"},
            {field: 'bonus', title: '奖金', width: 100, align: "center"},
            {field: 'coefficient', title: '奖金系数', width: 100, align: "center"}
        ]]
    });
    job_dialog.dialog({
        title: "温馨提示",
        width: 500,
        height: 500,
        top: 100,
        buttons: "#bb",
        closed: true
    })

    var cmdObj = {
        reload: function () {
            job_datagrid.datagrid("load");
        },
        cancel: function () {
            job_dialog.dialog("close");
        },
        //保存操作
        save: function () {
            var id = $("#jobId").val();
            controller = "/job/save";
            if (id) {
                var controller = "/job/update";
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
                        job_dialog.dialog("close");
                        job_datagrid.datagrid("reload");
                    }
                }
            })
        },
        //编辑操作
        edit: function () {
            $("#editForm").form("clear");
            var row = job_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选择要编辑的行")
            } else {
                job_dialog.dialog("open");
                job_dialog.dialog("setTitle", "职务VS工资等级编辑");
                $("#editForm").form("load", row);
            }
        },
        //删除
        delete: function () {
            var row = job_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择需要删除的行")
            } else {
                $.get("/job/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg)
                    } else {
                        $.messager.alert("温馨提示", "删除成功")
                        job_dialog.dialog("close");
                        job_datagrid.datagrid("reload");
                    }
                })
            }
        },
        //添加菜单的初始化
        add: function () {
            $("#editForm").form("clear");
            job_dialog.dialog("open");
            job_dialog.dialog("setTitle", "职务VS工资等级添加");
        },
    }


    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})
