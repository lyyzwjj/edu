$(function () {
    var sta_datagrid = $("#sta_datagrid");

    sta_datagrid.datagrid({
        fit: true,
        url: "/statement/list",
        fitColumns: true,
        striped: true,
        rownumbers: true,
        toolbar: "#toolbar",
        singleSelect: true,
        columns: [[
            {field: "groupByType", title: '分组信息', width: 90, align: "center"},
            {field: "receiptmoney", title: '已付总额', width: 90, align: "center"},
            {field: 'unpaid', title: '未付总额', width: 90, align: "center"},

        ]],

    });


    var cmdObj = {


        //查询操作
        query: function () {
            var keyword = $("#keyword").textbox("getText");
            var beginDate = $("#beginDate").datetimebox("getText");
            var endDate = $("#endDate").datetimebox("getText");
            var groupByType = $("#groupByType").datetimebox("getValue");
            sta_datagrid.datagrid("load", {
                keyword: keyword,
                beginDate: beginDate,
                endDate: endDate,
                groupByType: groupByType
            });
        },


        //刷新
        reload: function () {
            sta_datagrid.datagrid("reload");
        },
    }
    //调用方法
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })


    /* $(function(){
     $(".btn_bar").click(function () {
     //获取到表单中所有的查询条件
     $.dialog.open("/order/car?"+$("#searchForm").serialize(), {
     id: 'evaluate',
     title: '柱状报表',
     width: 800,
     height: 600,
     left: '50%',
     top: '50%',
     lock: true,
     opacity: 0.5
     });
     }) ;

     $(".btn_pie").click(function () {
     //获取到表单中所有的查询条件
     $.dialog.open("/order/pie?"+$("#searchForm").serialize(), {
     id: 'evaluate',
     title: '饼状报表',
     width: 750,
     height: 500,
     lock: true,
     opacity: 0.2
     });
     }) ;
     })*/
})
$(function () {


    $("#openBar").click(function () {
        $("#mydialog").dialog(open(
            "/statement/car?" + $("#query").serialize(), {
                id: 'evaluate',
                title: '柱状报表',
                width: 800,
                height: 600,
                left: '50%',
                top: '50%',
                lock: true,
                opacity: 0.5,
            }
        ))
    })
    $("#openPie").click(function () {
        $("#mydialog").dialog(open(
            "/statement/pie?" + $("#query").serialize(), {
                id: 'evaluate',
                title: '饼形报表',
                width: 800,
                height: 600,
                left: '50%',
                top: '50%',
                lock: true,
                opacity: 0.5,
            }
        ))
    })

})
