$(function(){
    var clientTrace_datagrid=$("#clientTrace_datagrid");
    var clientTrace_dialog=$("#clientTrace_dialog");
    var clientTrace_dialog=$("#clientTrace_dialog");
    clientTrace_datagrid.datagrid({
        fit:true,
        url:"/clientTrace/list",
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
            {field: 'traceMan', title: '跟踪人员', width: 90, align: "center", formatter: function (value) {
                if (value) {
                    return value.username;
                }}},
            {field: 'traceTimes', title: '跟踪次数', width: 100, align: "center"},
            {field: 'lastTraceDate', title: '最后跟踪时间', width: 100, align: "center"},
            {field: 'bookDate', title: '预约日期', width: 100, align: "center"},
            {field: 'nextTraceDate', title: '下次跟踪时间', width: 100, align: "center"},
            {field: 'weChatNum', title: '微信号', width: 100, align: "center"},
            {field: 'tel', title: '电话', width: 110, align: "center"},
            {field: 'shcool', title: '学校', width: 100, align: "center"},
            {field: 'degreeofIntention', title: '意向程度', width: 100, align: "center"},
            {field: 'intentionSchool', title: '意向校区', width: 100, align: "center"},
            {field: 'intentionClass', title: '意向班级', width: 100, align: "center"},
            {field: 'clientState', title: '客户当前状态', width: 100, align: "center"},
            {
                field: 'isManTrace', title: '未跟踪', width: 100, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return "<font color='green'>有</font>";
                } else {
                    return "<font color='red'>无</font>";
                }
            }
            },
            {field: 'remark', title: '备注', width: 100, align: "center"}
        ]],
    })




// 初始化一个弹框 点击添加或者编辑的时候才打开
    clientTrace_dialog.dialog({
        width:850,
        height:550,
        buttons:"#bb",
        // 一开始就是关闭的状态
        closed:true
    })

   /* //初始化学员跟踪表
    clientTrace_dialog.dialog({
        width:850,
        height:550,
        buttons:"#bb",
        // 一开始就是关闭的状态
       closed:true
    })*/

    var cmdObj={
        //添加操作
        add: function () {
            $("#editForm").form("clear");
            clientTrace_dialog.dialog("open");
            clientTrace_dialog.dialog("setTitle", "潜在客户添加");
        },


        //编辑操作
        edit:function(){
            //编辑需要回显数据
            //从datagrid中获取编辑的那一行数据
            var row=clientTrace_datagrid.datagrid("getSelected");
            if(!row){
                //如果不为true 说明没有选择数据 让用户选择数据
                $.messager.alert("温馨提示","请选择要编辑的数据");
            }else{
                //将选中的行的数据加载到对话框中的form表单中
                clientTrace_dialog.dialog("open");
                clientTrace_dialog.dialog("setTitle","潜在客户编辑");
                $("#editForm").form("clear");
                $("#editForm").form("load",row);

            }
        },
        //编辑操作
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
                $("#editForm").form("clear");
                $("#editForm").form("load",row);
                $(":input").prop("readonly",true);

            }
        },

        //保存操作
        save : function() {
            // 点击保存 提交表单
            // 获取id 能够获取到的就是更新 不能获取的是保存
            var id = $("#clientId").val();
            var url = "/clientTrace/save";
            if (id) {
                url = "/clientTrace/update";
            }

            $("#editForm").form("submit", {
                url : url,
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
                        clientTrace_datagrid.datagrid("load");

                    }
                }
            })
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
            clientTrace_datagrid.datagrid("reload");
        },

        /*//跟踪
        trace:function(){
            var row=clientTrace_datagrid.datagrid("getSelected");
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
        }*/

    }


    //调用方法
    $("a[data-cmd]").click(function(){
        var cmd=$(this).data("cmd");
        cmdObj[cmd]();
    })



})

