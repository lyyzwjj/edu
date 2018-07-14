$(function () {
    var systemMenu_treegrid = $('#systemMenu_treegrid');
    var systemMenu_dialog = $("#systemMenu_dialog");
    systemMenu_treegrid.treegrid({
        url: '/systemMenu/data',
        idField: 'id',
        treeField: 'text',
        fit: true,
        fitColumns: true,
        striped: true,
        singleSelect: true,
        toolbar: "#tb",
        columns: [[
            {field: 'id', title: '菜单编号', width: 60, hidden: true},
            {field: 'text', title: '菜单名称', width: 60},
            {field: 'url', title: '菜单路径', width: 80},
            {field: 'parentText', title: '父级菜单', width: 60}
        ]]
    });
    systemMenu_dialog.dialog({
        title: "温馨提示",
        width: 400,
        height: 400,
        top: 100,
        buttons: "#bb",
        closed: true,
        onClose: function () {
            $("#mytextbox").textbox('readonly', true)
            $("#mycombobox").combobox('readonly', false)
        }
    })
    $("#mycombobox").combobox({
        url: '/systemMenu/queryAllParentSystemMenu',
        valueField: 'id',
        textField: 'text',
        panelHeight: 'auto',
        prompt: '默认为根菜单',
        onSelect: function () {
            $("#mytextbox").textbox('readonly', false)
        }
    })
    var cmdObj = {
        reload: function () {
            systemMenu_treegrid.treegrid("reload");
        },
        cancel: function () {
            systemMenu_dialog.dialog("close");
        },
        save: function () {
            var id = $("#id").val();
            controller = "/systemMenu/save";
            if (id) {
                var controller = "/systemMenu/update";
            }
            $("#editForm").form("submit", {
                url: controller,
                success: function (data) {
                    data = $.parseJSON(data);
                    console.log(data);
                    if (!data.success) {
                        $.messager.alert('温馨提示', data.msg);
                    } else {
                        systemMenu_dialog.dialog("close");
                        systemMenu_treegrid.treegrid("reload");
                        window.location.reload();
                    }
                }
            })

        },
        edit: function () {
            $("#editForm").form("clear");
            var row = systemMenu_treegrid.treegrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选择要编辑的行")
            } else {
                console.log(row.parent)
                if (row.url && row.parent) {
                    row["parent.id"] = row.parent.text;
                    $("#mycombobox").combobox('readonly', false)
                } else {
                    row.url = null;
                    if (row.parent) {
                        row["parent.id"] = row.parent.text;
                    }
                    $("#mycombobox").combobox('readonly', true)
                }
                $("#editForm").form("load", row);
                systemMenu_dialog.dialog("open");
                systemMenu_dialog.dialog("setTitle", "系统菜单编辑");
            }
        },
        delete: function () {
            var row = systemMenu_treegrid.treegrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "想选要删除的菜单")
            } else {
                //获取选中行
                var rows = systemMenu_treegrid.treegrid("getChecked");
                for (var i = 0; i < rows.length; i++) {
                    //判断该节点是不是叶子节点
                    var nodes = systemMenu_treegrid.treegrid('getChildren', rows[i].id);
                    if (nodes.length > 0) {
                        alert("删除菜单之前请删除其子菜单");
                        return false;
                    } else {
                        $.get("/systemMenu/delete", {id: row.id}, function (data) {
                            if (!data.success) {
                                $.messager.alert("温馨提示", data.msg)
                            } else {
                                systemMenu_dialog.dialog("close");
                                systemMenu_treegrid.treegrid("reload");
                            }
                        })
                    }
                }
            }
        },
        add: function () {
            $("#editForm").form("clear");
            systemMenu_dialog.dialog("open");
            systemMenu_dialog.dialog("setTitle", "菜单添加");
            $("#editForm").form("load");
        }
    }
    $("a[data-cmd]"
    ).click(function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    })
})