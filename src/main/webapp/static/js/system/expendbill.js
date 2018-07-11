$(function(){
    $('#exp_datagruid').datagrid({
        url:"/expendbill/list",
        fitColumns:true,
        striped:true,
        pagination:true,
        rownumbers:true,
        fit:true,
        singleSelect:true,
        checkOnSelect:true,
        columns:[[
            {field:'x',checkbox:'true'},
            {field:'id',title:'编号',width:100,hidden:true},
            {field:'payTime',title:'时间',width:100},
            {field:'payMoney',title:'金额',width:100},
            {
                field: "cashier", title: "出纳", width: 100, formatter: function (value, row, index) {
                return value ? value.realname : "";
            }
            },
            {
                field: "auditor", title: "经办人", width: 100, formatter: function (value, row, index) {
                return value ? value.realname : "";
            }
            },
            {
                field: "payment", title: "支付方式", width: 100, formatter: function (value, row, index) {
                return value ? value.payname : "";
            }
            },
            {field:'genre',title:'类型',width:100},
            {field:'billNumber',title:'订单号',width:100},
            {field:'affiliationSubject',title:'归属学科',width:100},
            {
                field: "state", title: "审核", width: 100, formatter: function (value, row, index) {
                if (value == 1) {
                    return "<font color='green'>已审核</font>";
                } else if (value == 0){
                    return "<font color='red'>未审核</font>";
                }
            }
            }
        ]]
    });
})