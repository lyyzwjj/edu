$(function () {
    var talentPool_datagrid = $("#talentPool_datagrid");
    var talentPool_dialog = $("#talentPool_dialog");
    talentPool_datagrid.datagrid({
        url: "/talentPool/list",
        fit: true,
        //单选
        singleSelect: true,
        //是否显示分页栏
        pagination: true,
        //按比例分配宽度
        fitColumns: true,
        toolbar: "#tb",
        columns: [[
            {field: 'id', title: '编号', width: 100},
            {field: 'name', title: '应聘姓名', width: 100},
            {field: 'employDate', title: '应聘日期', width: 100,sortable:true,order:"desc"},
            {field: 'duty', title: '应聘职务', width: 100,formatter:function(value,row,index){
                return value ? value.name : "";
            }},
            {field: 'hireType', title: '聘用类型', width: 100,formatter:function(value,row,index){
                return value ? value.name : "";
            }},
            {field: 'workYear', title: '工作年限', width: 100,formatter:function(value,row,index){
                return value ? value.name : "";
            }},
            {field: 'education', title: '学历要求', width: 100,formatter:function(value,row,index){
                return value ? value.name : "";
            }},
            {field: 'recruitSalary', title: '薪资要求', width: 100,formatter:function(value,row,index){
                return value ? value.name : "";
            }},
            {field: 'recruitrequired', title: '相关技能', width: 100},
            {field: 'remark', title: '备注', width: 100},
        ]]
    })


//工具栏初始
    talentPool_dialog.dialog(
        {
            width: 500,
            height: 500,
            buttons: "#bb",
            closed: true
        }
    );

//响应函数集合对象
    var cmdObj = {
        //工具栏的刷新
        reload: function () {
            talentPool_datagrid.datagrid("load");
        },
        add: function () {
            //保存之前清空数据
            $("#editForm").form("clear");
            talentPool_dialog.dialog("open");
            talentPool_dialog.dialog("setTitle", "应聘者信息");
        },
        cancel: function () {
            talentPool_dialog.dialog("close");
        },
        save: function () {
            var id = $("#talentPoolId").val();
            controller = "/talentPool/save";
            if (id) {
                var controller = "/talentPool/update";
            }
            $("#editForm").form("submit", {
                url: controller,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        talentPool_dialog.dialog("close");
                        talentPool_datagrid.datagrid("reload");
                    }
                }
            })
        },
        edit: function () {
            //在操作之前将表单的数据清空
            $("#editForm").form("clear");
            //从datagrid中获取当前被选中的数据
            var row = talentPool_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', "请选择需要编辑的行");
            } else {
                //打开编辑对话框
                talentPool_dialog.dialog("open");
                //设置标题
                talentPool_dialog.dialog("setTitle", "应聘者信息");
                //将选中row数据加载的对话框中form表单中,用于回显
                //form加载原理,根据同名匹配原则
                if (row.duty) {
                    row['duty.id'] = row.duty.id;
                }
                if (row.hireType) {
                    row['hireType.id'] = row.hireType.id;
                }
                if (row.workYear) {
                    row['workYear.id'] = row.workYear.id;
                }
                if (row.education) {
                    row['education.id'] = row.education.id;
                }
                if (row.recruitSalary) {
                    row['recruitSalary.id'] = row.recruitSalary.id;
                }
                //将数据加载到form表单中
                $("#editForm").form("load", row);

                //强制设置回显
                $("#adminId").combobox('setValue', row.admin);

            }
        }, query: function () {
            var beginDate = $("#beginDate").datetimebox("getValue");
            var endDate = $("#endDate").datetimebox("getValue");
            talentPool_datagrid.datagrid("load", {
                beginDate:beginDate,
                endDate:endDate});
        },
        reload: function () {
            talentPool_datagrid.datagrid("reload");
        },
    };

//调用
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})

