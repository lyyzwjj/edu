$(function(){
    $('#dg').datagrid({
        url:"/expendbill/list",
        fitColumns:true,
        striped:true,
        pagination:true,
        rownumbers:true,
        singleSelect:true,
        checkOnSelect:true,
        columns:[[
            {field:'x',checkbox:'true'},
            {field:'id',title:'编号',width:100,hidden:true},
            {field:'payTime',title:'时间',width:100},
            {field:'payMoney',title:'jine',width:100},
            {field:'payMoney',title:'jine',width:100},
            {
                field: "cashier", title: "部门", width: 100, formatter: function (value, row, index) {
                return value ? value.name : "未分配";
            }
            },
        ]]
    });
})