$(function () {
    //变量抽取
    var recruit_datagrid = $("#recruit_datagrid");
    var recruit_dialog = $("#recruit_dialog");
    var recruit_form = $("#recruit_form");
    var recruititem_datagrid = $("#recruititem_datagrid");

    recruit_datagrid.datagrid({
        url: '/recruit/list',
        toolbar: "#toolbar",
        striped: true,
        rownumbers: true,
        singleSelect: true,
        pagination: true,
        pagePosition: "bottom",
        fitColumns: true,
        fit: true,
        columns: [[
            {
                field: "planType", title: '计划类别', width: 100, align: 'center', formatter: function (value) {
                return value ? value.name : '';
            }
            },
            {field: "plan", title: '计划名称', width: 100, align: 'center'},
            {field: 'draftTime', title: '制定日期', width: 100, align: 'center'},

            {
                field: 'inputUser', title: '制定人', width: 100, align: 'center', formatter: function (value) {
                    console.log(value);
                return value ? value.realname : '';
            }
            },
            {
                field: 'dept', title: '申请部门', width: 100, align: 'center', formatter: function (value) {
                return value ? value.name : '';
            }
            },
            {
                field: 'auditor', title: '审核人', width: 100, align: 'center', formatter: function (value) {
                return value ? value.realname : "<span style='color: red'>未审核</span>";
            }
            },
            {
                field: 'auditTime', title: '审核时间', width: 100, align: 'center', formatter: function (value) {
                return value ? value : "<span style='color: red'>未审核</span>";
            }
            },
            {
                field: 'examineState', title: '审批状态', width: 100, align: 'center',
                formatter: function (value) {
                    switch (value) {
                        case 0:
                            return "<span style='color: red'>待审批</span>";
                        case 1:

                            return "<span style='color: green'>已审批</span>";
                        case 2:
                            return "<span style='color: red'>审批被拒</span>";
                        default:
                    }

                }
            }
        ]]
    });

    //发送ajax请求,得到对应的数据字典的信息
    var recruitTypeData = undefined;
    $.ajax({
        url: '/dataDictionaryItem/selectByDictionarySn?sn=recruitType',
        type: 'get',
        dataType: "json",
        async: false,
        success: function (data) {
            recruitTypeData = data;
        }
    });

    //发送ajax请求,得到对应的数据字典的信息
    var engageData = undefined;
    $.ajax({
        url: '/dataDictionaryItem/selectByDictionarySn?sn=engageId',
        type: 'get',
        dataType: "json",
        async: false,
        success: function (data) {
            engageData = data;
        }
    });

    //发送ajax请求,得到对应的数据字典的信息
    var educationData = undefined;
    $.ajax({
        url: '/dataDictionaryItem/selectByDictionarySn?sn=educationId',
        type: 'get',
        dataType: "json",
        async: false,
        success: function (data) {
            educationData = data;
        }
    });

    //发送ajax请求,得到对应的数据字典的信息
    var recruitSalaryData = undefined;
    $.ajax({
        url: '/dataDictionaryItem/selectByDictionarySn?sn=recruitSalaryId',
        type: 'get',
        dataType: "json",
        async: false,
        success: function (data) {
            recruitSalaryData = data;
        }
    });

    var editRecruitItemIndex = undefined;
    var addOrEdit = undefined;
    var id;
    recruititem_datagrid.datagrid({
        url: '/recruit/queryByRecruitId',
        rownumbers: true,
        fitColumns: 'true',
        singleSelect: 'true',
        toolbar: "#recruititem_toolbar",
        columns: [[
            {
                field: 'id', hidden: 'true', formatter: function (value, row) {
                id = value;
                return value;
            }
            },
            {field: 'job', width: 100, align: 'center', title: '招聘职位', editor: 'text'},
            {
                field: 'recruitType', width: 100, align: 'center', title: '招聘方式', editor: {
                type: 'combobox',
                options: {
                    data: recruitTypeData,
                    valueField: 'id',
                    editable: false,
                    panelHeight: 'auto',
                    required: true,
                    textField: 'name'
                }
            },
                formatter: function (value, row) {
                    if (id) {
                        return value.name;
                    } else {
                        for (var i = 0; i < recruitTypeData.length; i++) {
                            if (recruitTypeData[i].id == value) {
                                return recruitTypeData[i].name;
                            }
                        }
                        return row.id;
                    }
                }
            },
            {
                field: 'engage', width: 100, align: 'center', title: '聘用形式', editor: {
                type: 'combobox',
                options: {
                    data: engageData,
                    valueField: 'id',
                    editable: false,
                    required: true,
                    panelHeight: 'auto',
                    textField: 'name'
                }
            },
                formatter: function (value, row) {
                    console.log(id);
                    if (id) {
                        return value.name;
                    } else {
                        for (var i = 0; i < engageData.length; i++) {
                            if (engageData[i].id == value) {
                                return engageData[i].name;
                            }
                        }
                        return row.id;
                    }
                }
            },
            {field: 'recruitNumber', width: 100, align: 'center', title: '人数', editor: 'text'},
            {
                field: 'education', width: 100, align: 'center', title: '学历要求', editor: {
                type: 'combobox',
                options: {
                    data: educationData,
                    valueField: 'id',
                    editable: false,
                    required: true,
                    panelHeight: 'auto',
                    textField: 'name'
                }
            },
                formatter: function (value, row) {
                    if (id) {
                        return value.name;
                    } else {
                        for (var i = 0; i < educationData.length; i++) {
                            if (educationData[i].id == value) {
                                return educationData[i].name;
                            }
                        }
                        return row.id;
                    }
                }
            },
            {field: 'recruitRequired', width: 100, align: 'center', title: '技能要求', editor: 'text'},
            {
                field: 'recruitSalary', width: 100, align: 'center', title: '薪资情况', editor: {
                type: 'combobox',
                options: {
                    data: recruitSalaryData,
                    valueField: 'id',
                    editable: false,
                    required: true,
                    panelHeight: 'auto',
                    textField: 'name'
                }
            },
                formatter: function (value, row) {
                    if (id) {
                        return value.name;
                    } else {
                        for (var i = 0; i < recruitSalaryData.length; i++) {
                            if (recruitSalaryData[i].id == value) {
                                return recruitSalaryData[i].name;
                            }
                        }
                        return row.id;
                    }
                }

            },
            {field: 'remark', width: 100, align: 'center', title: '备注', editor: 'text'}
        ]],
        onClickRow: function (index) {
            if (editRecruitItemIndex != index) {
                if (endEditingRecruitItem()) {
                    recruititem_datagrid.datagrid("selectRow", index).datagrid("beginEdit", index);
                    editRecruitItemIndex = index;
                } else {
                    recruititem_datagrid.datagrid("selectRow", editRecruitItemIndex);
                }
            }
        }
    });

    function endEditingRecruitItem() {
        if (editRecruitItemIndex == undefined) {
            return true
        }
        if (recruititem_datagrid.datagrid('validateRow', editRecruitItemIndex)) {
            recruititem_datagrid.datagrid('endEdit', editRecruitItemIndex);
            editRecruitItemIndex = undefined;
            return true;
        } else {
            return false;
        }
    }

    var methodObj = {
        // 新增
        add: function add() {
            addOrEdit = undefined;
            recruit_dialog.dialog("setTitle", '招聘计划');
            recruit_dialog.dialog("open");
        },
        //保存
        save: function save() {
            recruit_form.form('submit', {
                url: '/recruit/saveOrUpdate',
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        methodObj.cancel();
                        $.messager.alert("温馨提示", "保存成功", 'info', function () {
                            recruit_datagrid.datagrid('reload');
                        })
                    } else {
                        $.messager.alert("温馨提示", data.msg, 'error');
                    }
                },
                onSubmit: function (param) {
                    methodObj.accept_recruititem();
                    var rows = recruititem_datagrid.datagrid('getRows');
                    for (var i = 0; i < rows.length; i++) {
                        var row = rows[i];
                        param['items[' + i + '].job'] = row.job;
                        param['items[' + i + '].recruitType.id'] = row.recruitType;
                        param['items[' + i + '].engage.id'] = row.engage;
                        param['items[' + i + '].recruitNumber'] = row.recruitNumber;
                        param['items[' + i + '].education.id'] = row.education;
                        param['items[' + i + '].recruitRequired'] = row.recruitRequired;
                        param['items[' + i + '].recruitSalary.id'] = row.recruitSalary;
                        param['items[' + i + '].remark'] = row.remark;
                    }
                }
            });
        },
        //编辑
        edit: function edit() {
            addOrEdit = 1;
            var row = recruit_datagrid.datagrid('getSelected');
            if (!row) {
                $.messager.alert('温馨提示', "请选中一条数据", 'warning');
                return;
            }
            if(row.examineState==1){
                $.messager.alert('温馨提示', "已审核,禁止编辑", 'warning');
                return;
            }
            recruit_dialog.dialog("setTitle", '编辑招聘');
            recruit_dialog.dialog("open", true);
            if (row.planType) {
                row['planType.id'] = row.planType.id;
            }
            if (row.recruitType) {
                row['recruitType.id'] = row.recruitType.id;
            }
            if (row.engage) {
                row['engage.id'] = row.engage.id;
            }
            if (row.politicalStatus) {
                row['politicalStatus.id'] = row.politicalStatus.id;
            }
            if (row.position) {
                row['position.id'] = row.position.id;
            }
            if (row.business) {
                row['business.id'] = row.business.id;
            }
            if (row.education) {
                row['education.id'] = row.education.id;
            }
            if (row.married) {
                row['married.id'] = row.married.id;
            }
            if (row.recruitSalary) {
                row['recruitSalary.id'] = row.recruitSalary.id;
            }
            recruit_form.form('load', row);
            recruititem_datagrid.datagrid("load",
                {
                    recruitId: row.id
                }
            );
        },
        //取消
        cancel: function cancel() {
            recruit_dialog.dialog("close", true);
        },
        //刷新
        reload: function reload() {
            recruit_datagrid.datagrid("load");
        },
        //高级查询
        query: function query() {
            var examine = $("[name=examine]").val();
            var staff = $("[name=staff]").val();
            var beginDate = $("[name=beginDate]").val();
            var endDate = $("[name=endDate]").val();
            recruit_datagrid.datagrid('load', {
                examine: examine,
                staff: staff,
                beginDate: beginDate,
                endDate: endDate
            });
        },
        add_recruititem: function () {
            if (endEditingRecruitItem()) {
                recruititem_datagrid.datagrid("appendRow", {});
                editRecruitItemIndex = recruititem_datagrid.datagrid("getRows").length - 1;
                recruititem_datagrid.datagrid("selectRow", editRecruitItemIndex).datagrid("beginEdit", editRecruitItemIndex);
            }
        },
        remove_recruititem: function () {
            if (editRecruitItemIndex == undefined) {
                return
            }
            recruititem_datagrid.datagrid('cancelEdit', editRecruitItemIndex).datagrid('deleteRow', editRecruitItemIndex);
            editRecruitItemIndex = undefined;
        },
        accept_recruititem: function () {
            if (endEditingRecruitItem()) {
                recruititem_datagrid.datagrid('acceptChanges');
            }
        },
        reject_recruititem: function () {
            recruititem_datagrid.datagrid('rejectChanges');
            editRecruitItemIndex = undefined;
        }
    };

    //调用方法
    $('a[data-cmd]').click(function () {
        var cmd = $(this).data("cmd");
        methodObj[cmd]();
    });

    recruit_dialog.dialog({
        title: "员工信息",
        width: 900,
        height: 450,
        modal: true,
        buttons: "#form_btns",
        closed: true,
        onClose: function () {
            recruit_form.form("clear");
            recruititem_datagrid.datagrid("loadData", {total: 0, rows: []});
        }
    });

});






















