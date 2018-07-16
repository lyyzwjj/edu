$(function(){
    var clientSchoolLinkman_datagrid=$("#clientSchoolLinkman_datagrid");
    var clientSchoolLinkman_dialog=$("#clientSchoolLinkman_dialog");
    var clientTrace_dialog=$("#clientTrace_dialog");
    clientSchoolLinkman_datagrid.datagrid({
        fit:true,
        url:"/clientSchoolLinkman/list",
        fitColumns:true,
        striped:true,
        pagination:true,
        rownumbers:true,
        toolbar:"#tb",
        singleSelect:true,
        columns:[[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'id',  align: "center",hidden:'true'},
            {field: 'name', title: '姓名', width: 90, align: "center"},
            {
                field: 'schoolName', title: '学校名称', width: 100, align: "center", formatter: function (value) {
                if (value) {
                    return value.name;
                }}
            },
            {field: 'gender', title: '性别', width: 100, align: "center",formatter:function(value){
                if(value==1){
                    return "男";
                }else{
                    return "女";
                }
            }},
            {field: 'tel', title: '联系电话', width: 100, align: "center"},
            {field: 'weChat', title: '微信', width: 100, align: "center"},
            {field: "qq", title: 'QQ', width: 100, align: "center"},
            {field: 'birthday', title: '生日', width: 110, align: "center"},
            {field: 'department', title: '部门', width: 100, align: "center"},
            {field: 'job', title: '职务', width: 100, align: "center"},
            {field: 'isMajorLinkman', title: '主联系人', width: 100, align: "center",formatter:function(value){
                if(value==1){
                    return "是";
                }else{
                    return "否";
                }
            }},
        ]]
    });




// 初始化一个弹框 点击添加或者编辑的时候才打开
    clientSchoolLinkman_dialog.dialog({
        width:550,
        height:450,
        buttons:"#bb",
        // 一开始就是关闭的状态
        closed:true
    });


    var cmdObj= {
        //添加操作
        add: function () {
            $("#clientSchoolLinkman_form").form("clear");
            clientSchoolLinkman_dialog.dialog("open");
            clientSchoolLinkman_dialog.dialog("setTitle", "学校联系人添加");
        },


        //编辑操作
        edit: function () {
            //编辑需要回显数据
            //从datagrid中获取编辑的那一行数据
            var row = clientSchoolLinkman_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要编辑的数据");
            } else {
                //将选中的行的数据加载到对话框中的form表单中
                clientSchoolLinkman_dialog.dialog("open");
                clientSchoolLinkman_dialog.dialog("setTitle", "学校联系人编辑");
                $("#clientSchoolLinkman_form").form("clear");
                $("#clientSchoolLinkman_form").form("load", row);

            }
        },
        //删除大客户功能
        remove: function () {
            var row = clientSchoolLinkman_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要删除的客户");
            } else {
                $.messager.confirm('确认', '您确认将该客户删除吗？', function (r) {
                    if (r) {
                        //发起请求
                        $.get("/clientSchoolLinkman/delete", {id: row.id}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", "删除成功");
                                clientSchoolLinkman_datagrid.datagrid("load");
                            } else {
                                $.messager.alert("温馨提示", data.errorMsg);
                            }
                        })
                    }
                });

            }
        },
        //保存操作
        save: function () {
            // 点击保存 提交表单
            // 获取id 能够获取到的就是更新 不能获取的是保存
            var id = $("#clientSchoolLinkmanId").val();
            var url = "/clientSchoolLinkman/save";
            if (id) {
                url = "/clientSchoolLinkman/update";
            }

            $("#clientSchoolLinkman_form").form("submit", {
                url: url,
                success: function (data) {
                    // 接受返回的数据
                    // 操作失败 提示用户
                    // 操作成功,提示用户 关闭当前对话框,刷新页面
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        $.messager.alert("温馨提示", "保存成功");
                        clientSchoolLinkman_dialog.dialog("close");
                        clientSchoolLinkman_datagrid.datagrid("load");

                    }
                }
            })
        },
        //高级查询
        query: function () {
            var keyword = $("#keyword").textbox("getValue");
            var beginDate = $("#beginDate").datebox("getValue");
            var endDate = $("#endDate").datebox("getValue");
            //将数据通过load
            clientSchoolLinkman_datagrid.datagrid("load", {
                keyword: keyword,
                beginDate: beginDate,
                endDate: endDate
            })
        },
        //取消对话框
        cancel: function () {
            clientSchoolLinkman_dialog.dialog("close");
        },
        //刷新
        reload: function () {
            clientSchoolLinkman_datagrid.datagrid("reload");
        }
    }


    //调用方法
    $("a[data-cmd]").click(function(){
        var cmd=$(this).data("cmd");
        cmdObj[cmd]();
    })



})
