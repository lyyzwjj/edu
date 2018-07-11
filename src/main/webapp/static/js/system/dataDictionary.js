$(function () {
    $("#dataDictionary_datagrid").datagrid({
        fit: true,
        url: "/employee/list",
        //自适应列表宽度
        fitColumns: true,
        //是否显示分页栏
        pagination: true,
        pagePosition: "boht",
        //是否显示行号列
        rownumbers: true,
        //是否显示斑马线
        striped: true,
        //允许选中一行()
        singleSelect: true,
        //定义列
        columns: [
            [
                {field: 'ck', checkbox: true},
                {field: 'id', title: '编号', width: 100, align: "center"},
                {field: 'username', title: '用户名', width: 100, align: "center"},
                {field: 'password', title: '密码', width: 100, align: "center"},
                {field: 'realname', title: '真实姓名', width: 100, align: "center"},
                {field: 'tel', title: '电话号码', width: 100, align: "center"},
                {field: 'email', title: '邮箱', width: 100, align: "center"},
                {
                    field: 'dept',
                    title: '部门',
                    width: 100,
                    align: "center",
                    formatter: function (value, row, index) {
                        return value ? value.name : "未分配部门";
                    }
                },
                {field: 'hiredate', title: '入职时间', width: 100, align: "center", sortable: true, order: "asc"},
                {
                    field: 'admin',
                    title: '是否为超级管理员',
                    width: 100,
                    align: "center",
                    formatter: function (value, row, index) {
                        return value ? "是" : "否";
                    }
                },
            ]],
    })
})