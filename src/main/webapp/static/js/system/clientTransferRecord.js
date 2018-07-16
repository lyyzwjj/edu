$(function(){
    var clientTransferRecord_datagrid=$("#clientTransferRecord_datagrid");
    var clientTrace_dialog=$("#clientTrace_dialog");
    clientTransferRecord_datagrid.datagrid({
        fit:true,
        url:"/clientTransferRecord/list",
        fitColumns:true,
        striped:true,
        pagination:true,
        rownumbers:true,
        toolbar:"#tb",
        singleSelect:true,
        columns:[[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'id', width: 90, align: "center",hidden:'true'},
            {field: 'name', title: '客户姓名', width: 90, align: "center",formatter:function(value,row,index){
                        return row.client.name;
            }},
            {field: 'qq', title: 'QQ', width: 90, align: "center"},
            {field: "tel" ,title: '客户电话', width: 100, align: "center"},
            {field: 'currentdate', title: '操作时间', width: 100, align: "center"},
            {field: 'originalTraceMan', title: '原跟踪人员', width: 100, align: "center",formatter:function(value){
                    if(value){
                        return value.username;
                    }
            }},
            {field: 'currentTraceMan', title: '现跟踪人员', width: 110, align: "center",formatter:function(value){
                    if(value){
                        return value.username;
                    }
                 }
            }
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


    var cmdObj={


        //查看操作
        view:function(){
            //编辑需要回显数据
            //从datagrid中获取编辑的那一行数据
            var row=clientTrace_datagrid.datagrid("getSelected");
            if(!row){
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示","请选择要查看的客户");
            }else{
                //将选中的行的数据加载到对话框中的form表单中
                clientTrace_dialog.dialog("open");
                clientTrace_dialog.dialog("setTitle","潜在客户编辑");
                $("#clientTrace_form").form("clear");
                $("#clientTrace_form").form("load",row);
                $(":input").prop("readonly",true);

            }
        },

        //高级查询
        query:function() {
            var keyword=$("#keyword").textbox("getValue");
            var beginDate=$("#beginDate").datebox("getValue");
            var endDate=$("#endDate").datebox("getValue");
            //将数据通过load
            clientTrace_datagrid.datagrid("load",{
                keyword:keyword,
                beginDate:beginDate,
                endDate:endDate
            })
        },
        //取消对话框
        cancel:function() {
            clientTrace_dialog.dialog("close");
        },
        //刷新
        reload:function () {
            clientTransferRecord_datagrid.datagrid("reload");
        }


    }


    //调用方法
    $("a[data-cmd]").click(function(){
        var cmd=$(this).data("cmd");
        cmdObj[cmd]();
    })



})

