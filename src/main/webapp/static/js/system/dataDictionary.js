$(function () {
    var dataDictionaryItem_datagrid = $("#dataDictionaryItem_datagrid");
    var dataDictionaryItem_dialog = $("#dataDictionaryItem_dialog");
    var dataDictionary_datagrid = $("#dataDictionary_datagrid");
    var dataDictionary_dialog = $("#dataDictionary_dialog");
    var object = new Object();
    $("#dataDictionary_datagrid").datagrid({
        fit:true,
        url: "/dataDictionary/list",
        //自适应列表宽度
        fitColumns: true,
        //是否显示分页栏
        pagination: true,
        //是否显示斑马线
        striped: true,
        //允许选中一行()
        singleSelect: true,
        toolbar: "#mtb",
        //定义列
        columns: [
            [
                {field: 'id', title: '编号', width: 100, align: "center"},
                {field: 'sn', title: '字典编号', width: 100, align: "center"},
                {field: 'name', title: '字典名称', width: 100, align: "center"},
                {field: 'intro', title: '字典简介', width: 100, align: "center"},
            ]],
        onDblClickRow: function (index, row) {
            object["parent.name"] = row.name;
            object["parent.id"] = row.id;
            $("#dataDictionaryItem_datagrid").datagrid({
                fit:true,
                url: "/dataDictionaryItem/queryListByParent?parentId=" + row.id,
                //自适应列表宽度
                fitColumns: true,
                //是否显示斑马线
                striped: true,
                //允许选中一行()
                singleSelect: true,
                //定义列
                columns: [
                    [
                        {field: 'id', title: '字典明细编号', width: 100, align: "center"},
                        {field: 'name', title: '字典明细名称', width: 100, align: "center"},
                        {field: 'intro', title: '字典明细简介', width: 100, align: "center"},
                        {
                            field: 'parent', title: '字典目录', width: 100, formatter: function (value, row, index) {
                            return value.name
                        }
                        }
                    ]],
                toolbar: "#tb"
            })
        }
    });
    dataDictionary_dialog.dialog({
        title: "温馨提示",
        width: 400,
        height: 400,
        top: 100,
        buttons: "#mbb",
        closed: true
    })
    dataDictionaryItem_dialog.dialog({
        title: "温馨提示",
        width: 400,
        height: 400,
        top: 100,
        buttons: "#bb",
        closed: true
    })
    var cmdObj = {
        //数据字典明细
        reload: function () {
            dataDictionaryItem_datagrid.datagrid("load");
        },
        cancel: function () {
            dataDictionaryItem_dialog.dialog("close");
        },
        save: function () {
            var id = $("#itemId").val();
            controller = "/dataDictionaryItem/save";
            if (id) {
                var controller = "/dataDictionaryItem/update";
            }
            $("#editForm").form("submit", {
                url: controller,
                success: function (data) {
                    data = $.parseJSON(data);
                    console.log(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        dataDictionaryItem_dialog.dialog("close");
                        dataDictionaryItem_datagrid.datagrid("reload");
                    }
                }
            })
        },
        edit: function () {
            $("#editForm").form("clear");
            var row = dataDictionaryItem_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选择要编辑的行")
            } else {
                dataDictionaryItem_dialog.dialog("open");
                dataDictionaryItem_dialog.dialog("setTitle", "字典明细编辑");
                    row["parent.name"] = row.parent.name;
                    row["parent.id"] = row.parent.id;
                $("#editForm").form("load", row);
            }
        },
        ban: function () {
            var row = dataDictionaryItem_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选要禁用的字典明细")
            } else {
                $.get("/dataDictionaryItem/ban", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        dataDictionaryItem_dialog.dialog("close");
                        dataDictionaryItem_datagrid.datagrid("reload");
                    }
                })
            }
        },
        add: function () {
            dataDictionaryItem_dialog.dialog("open");
            $("#editForm").form("clear");
            dataDictionaryItem_dialog.dialog("setTitle", "字典添加");
            console.log(object)
            $("#editForm").form("load",object);
        },
        //数据字典
        mreload: function () {
            dataDictionary_datagrid.datagrid("load");
        },
        mcancel: function () {
            dataDictionary_dialog.dialog("close");
        },
        msave: function () {
            var id = $("#mId").val();
            controller = "/dataDictionary/save";
            if (id) {
                var controller = "/dataDictionary/update";
            }
            $("#meditForm").form("submit", {
                url: controller,
                success: function (data) {
                    data = $.parseJSON(data);
                    console.log(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        dataDictionary_dialog.dialog("close");
                        dataDictionary_datagrid.datagrid("reload");
                    }
                }
            })
        },
        medit: function () {
            $("#meditForm").form("clear");
            var row = dataDictionary_datagrid.datagrid("getSelected");
            console.log(row)
            if (!row) {
                $.messager.alert("温馨提示", "想选择要编辑的行")
            } else {
                dataDictionary_dialog.dialog("open");
                dataDictionary_dialog.dialog("setTitle", "字典编辑");
                $("#meditForm").form("load", row);
            }
        },
        mdelete: function () {
            var row = dataDictionary_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选要删除的字典")
            } else {
                $.get("/dataDictionary/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.msg)
                    } else {
                        dataDictionary_dialog.dialog("close");
                        dataDictionary_datagrid.datagrid("reload");
                    }
                })
            }
        },
        madd: function () {
            $("#meditForm").form("clear");
            dataDictionary_dialog.dialog("open");
            dataDictionary_dialog.dialog("setTitle", "字典添加");
            $("#meditForm").form("load",object);
        }
    }
    $("a[data-cmd]").click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})