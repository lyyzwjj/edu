$(function () {
    $("#dataDictionary_datagrid").datagrid({
        title:"字典目录",
        fit: true,
        url: "/dataDictionary/list",
        //自适应列表宽度
        fitColumns: true,
        //是否显示分页栏
        pagination: true,
        //是否显示行号列
        rownumbers: true,
        //是否显示斑马线
        striped: true,
        //允许选中一行()
        singleSelect: true,
        //定义列
        columns: [
            [
                {field: 'id', title: '编号', width: 100, align: "center"},
                {field: 'sn', title: '字典编号', width: 100, align: "center"},
                {field: 'name', title: '字典名称', width: 100, align: "center"},
                {field: 'intro', title: '字典简介', width: 100, align: "center"},
            ]]
    })
})