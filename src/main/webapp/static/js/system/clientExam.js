$(function(){
    var clientExam_datagrid=$("#clientExam_datagrid");
    var clientExam_dialog=$("#clientExam_dialog");
    var clientTrace_dialog=$("#clientTrace_dialog");
    clientExam_datagrid.datagrid({
        fit:true,
        url:"/clientExam/list",
        fitColumns:true,
        striped:true,
        pagination:true,
        rownumbers:true,
        toolbar:"#tb",
        singleSelect:true,
        columns:[[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'id', width: 90, align: "center",hidden:'true'},
            {field: 'name', title: '姓名', width: 90, align: "center",formatter:function(value){
                    if(value){
                        return value.name;
                    }
            }},
            {field: 'examType', title: '考试类型', width: 100, align: "center", formatter: function (value) {
                if (value) {
                    return value.name;
                }
            }},
            {field: 'intentionClass', title: '意向学科', width: 100, align: "center", formatter: function (value) {
                if (value) {
                    return value.name;
                }
            }},
            {
                field: 'saleMan', title: '营销人员', width: 90, align: "center", formatter: function (value) {
                if (value) {
                    return value.username;
                }}
            },
            {field: 'inputMan', title: '录入人员', width: 90, align: "center", formatter: function (value) {
                if (value) {
                    return value.username;
                }}},
            {field: 'examDate', title: '考试时间', width: 100, align: "center"},

            {field: 'passExam', title: '是否通过', width: 100, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return "<font color='green'>通过</font>";
                } else {
                    return "<font color='red'>未通过</font>";
                }
            }},
            {field: 'remark', title: '备注', width: 100, align: "center"}
        ]],
        onClickRow : function(index, row) {

            // 根据员工的状态修改离职/复职按钮的显示
            if (row.passExam == 1) {

                $("#change_btn").linkbutton({
                    text : "未通过"
                })
            } else {
                $("#change_btn").linkbutton({
                    text : "通过"
                })
            }
        }
    });



//初始化考试表
    clientExam_dialog.dialog({
        title:"考试登记",
        width:350,
        height:300,
        buttons:"#bb_exam"
        // 一开始就是关闭的状态
        /*closed:true*/
    })


    var cmdObj= {
        //添加操作
        add: function () {
            $("#clientExam_form").form("clear");
            clientExam_dialog.dialog("open");
            clientExam_dialog.dialog("setTitle", "潜在客户添加");
        },


        //编辑操作
        edit: function () {
            //编辑需要回显数据
            //从datagrid中获取编辑的那一行数据
            var row = clientExam_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要编辑的数据");
            } else {
                alert("进来======")
                //将选中的行的数据加载到对话框中的form表单中
                if(row.examType){
                    row["examType.id"]=row.examType.id
                }
                if(row.name){
                    row["name.id"]=row.name.id
                }
                if(row.intentionClass){
                    row["intentionClass.id"]=row.intentionClass.id
                }
                clientExam_dialog.dialog("open");
                clientExam_dialog.dialog("setTitle", "考试登记编辑");
                $("#clientExam_form").form("clear");
                $("#clientExam_form").form("load", row);

            }
        },

        //保存操作
        saveExam: function () {
            alert("点击保存是否有反应")
            // 点击保存 提交表单
            // 获取id 能够获取到的就是更新 不能获取的是保存
            var id = $("#clientExamId").val();
            var url = "/clientExam/save";
            if (id) {
                url = "/clientExam/update";
            }
            alert(url)
            $("#clientExam_form").form("submit", {
                url: url,
                success: function (data) {
                    // 接受返回的数据
                    // 操作失败 提示用户
                    // 操作成功,提示用户 关闭当前对话框,刷新页面
                    var data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        alert("是否进来了=========")
                        $.messager.alert("温馨提示", "保存成功");
                        clientExam_dialog.dialog("close");
                        clientExam_datagrid.datagrid("load");

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
            clientExam_datagrid.datagrid("load", {
                keyword: keyword
            })
        },
        //删除大客户功能
        remove: function () {
            var row = clientExam_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要删除的客户");
            } else {
                $.messager.confirm('确认', '您确认将该客户删除吗？', function (r) {
                    if (r) {
                        //发起请求
                        $.get("/clientExam/delete", {id: row.id}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", "删除成功");
                                clientExam_datagrid.datagrid("load");
                            } else {
                                $.messager.alert("温馨提示", data.errorMsg);
                            }
                        })
                    }
                });

            }
        },
        //取消对话框
        cancel: function () {
            clientExam_dialog.dialog("close");
        },
        //刷新
        reload: function () {
            clientExam_datagrid.datagrid("reload");
        },


        //考试是否通过
        changeState:function(){
            var row = clientExam_datagrid.datagrid("getSelected");
            if (!row) {
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示", "请选择要操作的客户");
            } else {
                $.messager.confirm('确认',"确定改变改客户的考试结果",  function (r) {
                    if (r) {
                        //发起请求
                        $.get("/clientExam/changeState", {id: row.id,passExam:row.passExam}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", "操作成功");
                                clientExam_datagrid.datagrid("load");
                            } else {
                                $.messager.alert("温馨提示", data.errorMsg);
                            }
                        })
                    }
                });

            }
        }
    }


    //调用方法
    $("a[data-cmd]").click(function(){
        var cmd=$(this).data("cmd");
        cmdObj[cmd]();
    })



})

