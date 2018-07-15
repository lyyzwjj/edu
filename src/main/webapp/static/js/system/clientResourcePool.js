$(function(){
    var clientResourcePool_datagrid=$("#clientResourcePool_datagrid");
    var clientResourcePool_dialog=$("#clientResourcePool_dialog");
    var clientTrace_dialog=$("#clientTrace_dialog");
    var client_datagrid=$("#client_datagrid");
    var send_dialog=$("#send_dialog");
    var client_dialog=$("#client_dialog");

    clientResourcePool_datagrid.datagrid({
        fit:true,
        url:"/clientResourcePool/list",
        fitColumns:true,
        striped:true,
        pagination:true,
        rownumbers:true,
        toolbar:"#tb",
        singleSelect:true,
        columns:[[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'id', width: 90, align: "center",hidden:'true'},
            {field: 'name', title: '客户姓名', width: 90, align: "center"},
            {
                field: 'saleMan', title: '营销人员', width: 90, align: "center", formatter: function (value) {
                if (value) {
                    return value.username;
                }}
            },
            {field: 'school', title: '客户学校', width: 90, align: "center"},
            {field: 'gender', title: '客户性别', width: 90, align: "center",formatter:function(value){
                    if(value==1){
                        return "男";
                    }else{
                        return "女";
                    }
            }},
            {field: 'traceTimes', title: '跟踪次数', width: 100, align: "center"},
            {field: 'lastTraceDate', title: '最后跟踪时间', width: 100, align: "center"},
            {field: 'tel', title: '电话', width: 110, align: "center"},
            {field: 'remark', title: '备注', width: 100, align: "center"}
        ]]
    })




// 初始化一个弹框 点击添加或者编辑的时候才打开
    clientTrace_dialog.dialog({
        title:"客户追踪",
        width:850,
        height:550,
        buttons:"#bb",
        // 一开始就是关闭的状态
        closed:true
    });


    send_dialog.dialog({
        title:"指派客户",
        width:300,
        height:200,
        buttons:"#bb2",
        // 一开始就是关闭的状态
        closed:true
    });

    client_dialog.dialog({
        width:850,
        height:550,
        buttons:"#bb_client",
        closed:true
    })


    //初始化



    var cmdObj={


        //保存操作
        saveClient : function() {
            // 点击保存 提交表单
            // 获取id 能够获取到的就是更新 不能获取的是保存
            var id = $("#clientId").val();
            alert(id)
            var url = "/client/save";
            if (id) {
                url = "/client/update";
            }

            $("#editForm").form("submit", {
                url : url,
                success : function(data) {
                    alert(url)
                    console.log(data)
                    // 接受返回的数据
                    // 操作失败 提示用户
                    // 操作成功,提示用户 关闭当前对话框,刷新页面
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        $.messager.alert("温馨提示", "保存成功");
                        client_dialog.dialog("close");
                        client_datagrid.datagrid("load");

                    }
                }
            })
        },

        //取消对话框
        cancel:function() {
            clientTrace_dialog.dialog("close");
        },
        //刷新
        reload:function () {
            clientResourcePool_datagrid.datagrid("reload");
        },
        //跟踪
        trace:function(){
            var row=clientResourcePool_datagrid.datagrid("getSelected");
            if(!row){
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示","请选择要跟踪的学员");
            }else{
                //将选中的行的数据加载到对话框中的form表单中

                clientTrace_dialog.dialog("open");
                clientTrace_dialog.dialog("setTitle","客户跟踪");
                $("#clientTrace_form").form("clear");
                $("#clientTrace_form").form("load",row);

            }
        },
        saveTrace:function(){
            $("#clientTrace_form").form("submit", {
                url : "/clientTrace/update",
                success : function(data) {
                    // 接受返回的数据
                    // 操作失败 提示用户
                    // 操作成功,提示用户 关闭当前对话框,刷新页面
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        $.messager.alert("温馨提示", "保存成功");
                        clientTrace_dialog.dialog("close");
                    }
                }
            })
        },
       //编辑
        edit:function(){
            var row=clientResourcePool_datagrid.datagrid("getSelected");
            if(!row){
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示","请选择要编辑的客户");
            }else{
                //将选中的行的数据加载到对话框中的form表单中
                if(row.saleMan) {
                    row["saleMan.id"] = row.saleMan.id;
                }
                if(row.inputMan) {
                    row["inputMan.id"] = row.inputMan.id;
                }
                if(row.education){
                    row["education.id"]=row.education.id;
                }
                if(row.major){
                    row["major.id"]=row.major.id;
                }
                if(row.sourceOfClient){
                    row["sourceOfClient.id"]=row.sourceOfClient.id;
                }
                if(row.school){
                    row["school.id"]=row.school.id;
                }
                if(row.yearsOfWorkExperience){
                    row["yearsOfWorkExperience.id"]=row.yearsOfWorkExperience.id;
                }
                if(row.hometown){
                    row["hometown.id"]=row.hometown.id;
                }
                if(row.degreeOfIntention){
                    row["degreeOfIntention.id"]=row.degreeOfIntention.id;
                }
                if(row.intentionSchool){
                    row["intentionSchool.id"]=row.intentionSchool.id;
                }
                if(row.intentionClass){
                    row["intentionClass.id"]=row.intentionClass.id;
                }
                client_dialog.dialog("open");
                client_dialog.dialog("setTitle","客户跟踪");
                $("#editForm").form("clear");
                $("#editForm").form("load",row);

            }
        },

        //接收客户
        send:function(){
            var row=clientResourcePool_datagrid.datagrid("getSelected");
            if(!row){
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示","请选择要转移的客户");
            }else{
                //将选中的行的数据加载到对话框中的form表单中
                send_dialog.dialog("open");
                $("#send_form").form("clear");
                $("#send_form").form("load",row);

            }
        },

        //转交之后的保存
        saveSend:function(){
            alert("转移的")
            $("#send_form").form("submit",{
                url:"/clientTransferRecord/save",
                success : function(data) {

                    alert("进来")
                    // 接受返回的数据
                    // 操作失败 提示用户
                    // 操作成功,提示用户 关闭当前对话框,刷新页面
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        $.messager.alert("温馨提示", "转移成功");
                        send_dialog.dialog("close");
                    }
                }
            })
        },


        //接收
        //选择数据 接收成功后  转移记录中多一条 同时资源池客户不改变
        accept:function(){
            var row=clientResourcePool_datagrid.datagrid("getSelected");
            if(!row){
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示","请选择要接收的客户");
            }else {
                $.messager.confirm('确认', '您确认接收该客户吗？', function (r) {
                    if (r) {
                        //发起请求
                        $.get("/clientTransferRecord/save",  function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", "接收成功!");
                                client_datagrid.datagrid("load");
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

