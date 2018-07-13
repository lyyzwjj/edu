$(function() {
    $("#dep_datagrid").datagrid({
        width : 500,
        height : 500,
        url : "/department/list",
        singleSelect : true,
        pagePosition : "bottom",
        columns : [ [
            {
                field : 'x',
                checkbox : true
            },{
                field : 'id',
                title : '部门编号',
                width : 100
            }, {
                field : 'sn',
                title : '部门编码',
                width : 100
            },
            {
                field : 'name',
                title : '部门名称',
                width : 100
            },
            {
                field : 'state',
                title : '状态',
                width : 100,
                formatter : function(value, row, index) {
                    if (value) {
                        return "<font color='green'>正常</font>";
                    } else {
                        return "<font color='red'>已停用</font>";
                    }
                },
               /* onClickRow:function(index,row){
                //根据部门状态修改正常或停用的显示
                if(row.state==1){
                    $("#change_btn").linkbutton({
                        text:"已停用"
                    })
                }else{
                    $("#change_btn").linkbutton({
                        text:"正常"
                    }
                },
*/
            }, ] ],
        pagination : true,
        toolbar : "#tb",
    })
    $("#dep_dialog").dialog({
        width : 400,
        height : 400,
        buttons : "#bb",
        closed : true,
    })


})
function add() {
    $("#editfrom").form("clear");
    $("#dep_dialog").dialog("open");
    $("#dep_dialog").dialog("setTitle", "部门添加");
}
function edit() {
    $("#editfrom").form("clear");
    // 必须是选中的
    var row = $("#dep_datagrid").datagrid("getSelected")
    if (!row) {
        $.messager.alert('温馨提示', '请选择要编辑的部门')
    } else {
        // 打开对话框
        $("#dep_dialog").dialog("open");
        // 设置对话框为部门编辑
        $("#dep_dialog").dialog("setTitle", "部门编辑");
        /*	if (row.department) {
         row["department.id"] = row.department.id;
         }*/
        $("#editfrom").form("load", row);
    }

}
function save() {
    // 获取id
    var id = $("#id").val();
    var controller ="/department/save";
    if (id) {
        controller ="/department/update";
    }
    // url:错误信息路径
    // 提交表单操作
    $("#editfrom").form("submit", {
        url : controller,
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
                $("#dep_dialog").dialog("close");
                // 4.3刷新页面
                $("#dep_datagrid").datagrid("reload");
            }
        }
    })
}
// 改变状态操作
function changeState() {
    // 首先必须是选中的,
    var row = $("#dep_datagrid").datagrid("getSelected");
    // 如果没有选中给出提示
    if (!row) {
        $.messager.alert('温馨提示', '请选择要改变的行')
    } else {
        // 如果选中了使用ajax方式发起删除请求
        $.get("/department/changeState", {
            id : row.id
        }, function(data) {
            // 如果删除失败,给出提示信息
            if (!data.success) {
                $.messager.alert('温馨提示', data.msg);
                // 成功刷新页面
            } else {

                $("#dep_datagrid").datagrid("reload");
            }
        });
    }
}
// 刷新列表数据
function reload() {
    $("#dep_datagrid").datagrid("reload");
}
// 关闭对话框
function cancel() {
    $("#dep_dialog").dialog("close");
}
// 高级查询
function query() {
    var keyword = $("#keyword").textbox("getValue");

    $("dep_datagrid").datagrid("load",{
        keyword:keyword
    })
}
