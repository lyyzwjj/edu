$(function () {
    var per_datagrid = $("#per_datagrid");
    per_datagrid.datagrid({
        width: 700,
        height: 500,
       // fit: true,
        url: "/permission/list",

        fitColumns: true,
        fit:true,
        singleSelect: true,
        striped: true,
        rownumbers: true,
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: '编号', width: 100, align: "center"},
            {field: 'name', title: '权限名称', width: 100, align: "center"},
            {field: 'resource', title: '权限表达式', width: 100, align: "center"},

        ]],
    })

    var cmdObj = {
        reload: function () {

            // 点击加载权限首先弹出对话框确认加载
            $.messager.confirm('确认', '您确认想要加载权限吗？', function (r) {
            // 如果为true就去执行加载权限
             //执行加载权限操作：
                if (r) {
                 $.get("/permission/reload",function(data){
                     if(data.success){
                         //成功就刷新数据
                         per_datagrid.datagrid("load");
                     }else{
                     // 失败就弹出对话框提示用户
                         $.messager.alert('确认', data.msg)
                     }
                 })

                }
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
