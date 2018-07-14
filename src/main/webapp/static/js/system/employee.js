$(function () {
    //变量抽取
    var staff_datagrid = $("#staff_datagrid");
    var staff_dialog = $("#staff_dialog");
    var staff_form = $("#staff_form");
    var easyui_tabs = $("#easyui-tabs");
    var staff_salary_form = $("#staff_salary_form");
    staff_datagrid.datagrid({
        url: '/employee/list',
        toolbar: "#toolbar",
        striped: true,
        rownumbers: true,
        singleSelect: true,
        sortOrder: 'asc',
        pagination: true,
        pagePosition: "bottom",
        fit: true,
        columns: [[
            {field: 'x', checkbox: true},
            {field: 'id', title: 'ID', width: 50, align: "center"},
            {field: 'employeeId', title: '工号', width: 100, align: "center"},
            {field: 'username', title: '用户名', width: 80, align: "center"},
            {field: 'password', title: '密码', width: 100, align: "center"},
            {field: 'realname', title: '真实姓名', width: 100, align: "center"},
            {field: 'age', title: '年龄', width: 80, align: "center", sortable: true, order: "asc"},
            {
                field: 'gender', title: '性别', width: 80, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return "<font color='green'>男</font>";
                } else {
                    return "<font color='red'>女</font>";
                }
            }
            },
            {field: 'bornDate', title: '出生日期', width: 100, align: "center", sortable: true, order: "asc"},
            {field: 'cardId', title: '身份证号', width: 150, align: "center"},
            {field: 'tel', title: '电话', width: 100, align: "center"},
            {field: 'eamil', title: '邮箱', width: 150, align: "center"},
            {field: 'qq', title: 'QQ', width: 100, align: "center"},
            {field: 'address', title: '地址', width: 100, align: "center"},
            {field: 'attendanceId', title: '考勤卡号', width: 100, align: "center"},
            {field: 'hireDate', title: '入职日期', width: 100, align: "center", sortable: true, order: "asc"},
            {field: 'seniority', title: '工龄', width: 100, align: "center", sortable: true, order: "asc"},
            {
                field: 'state', title: '状态', width: 100, align: "center", formatter: function (value, row, index) {
                if (value) {
                    return "<font color='green'>在职</font>";
                } else {
                    return "<font color='red'>离职</font>";
                }
            }
            },
            {
                field: 'admin', title: '超级管理员身份', width: 80, align: "center", formatter: function (value, row, index) {
                return value ? "是" : "否";
            }
            },
            {
                field: 'dept',
                title: '部门',
                width: 100,
                align: "center",
                formatter: function (value, row, index) {
                    return value ? value.name : "未分配部门";
                }
            }
        ]]
    });

    $("#excel_dialog").dialog({
        width: 300,
        height: 150,
        closed: true,
        onClose: function () {
            $("#excel_form").form("clear");
        }
    });

    //excel 导入ajaxForm提交
    $("#excel_form").submit(function () {
        var str = $("#uploadFile").val();
        if (str.length === 0) {
            $("#excel_dialog").dialog("close");
            $.messager.alert("温馨提示", "请选择文件", "warning");
            return false;
        }
    });
    $("#excel_form").ajaxForm(function (data) {
        $("#excel_dialog").dialog("close");
        if (data.success) {
            $.messager.alert("温馨提示", data.msg, "info", function () {
                staff_datagrid.datagrid("reload");
            });
        } else {
            $.messager.alert("温馨提示", data.msg, "warning");
        }
    });
    var easyui_tabs_title = "基本信息";
    /*选项卡切换*/
    easyui_tabs.tabs({
        border: false,
        fit: true,
        onSelect: function (title, index) {
            easyui_tabs_title = title;
            if (index == 1) {
                $("#btn_save").linkbutton('disable');
            } else {
                $("#btn_save").linkbutton('enable');
            }
        }
    });

    /*家庭情况*/
    var staff_family_datagrid = $('#staff_family_datagrid');
    var staff_work_datagrid = $('#staff_work_datagrid');
    var staff_education_datagrid = $('#staff_education_datagrid');
    var editFamilyIndex = undefined;
    var editWorkIndex = undefined;
    var editEducationIndex = undefined;
    staff_family_datagrid.datagrid({
        url: '/family/queryByStaffId',
        rownumbers: true,
        fitColumns: 'true',
        singleSelect: 'true',
        toolbar: "#staff_family_toolbar",
        columns: [[
            {field: 'id', hidden: true},
            {field: 'appellation', width: 100, align: 'center', title: '称谓', editor: 'text'},
            {field: 'username', width: 100, align: 'center', title: '姓名', editor: 'text'},
            {field: 'company', width: 100, align: 'center', title: '工作单位', editor: 'text'},
            {field: 'profession', width: 100, align: 'center', title: '职业', editor: 'text'},
            {field: 'bornDate', width: 100, align: 'center', title: '出生日期', editor: 'datebox'},
            {field: 'remark', width: 100, align: 'center', title: '备注', editor: 'text'}
        ]],
        onClickRow: function (index) {
            if (editFamilyIndex != index) {
                if (endEditingFamily()) {
                    staff_family_datagrid.datagrid("selectRow", index).datagrid("beginEdit", index);
                    editFamilyIndex = index;
                } else {
                    staff_family_datagrid.datagrid("selectRow", editFamilyIndex);
                }
            }
        }
    });

    staff_work_datagrid.datagrid({
        url: '/work/queryByStaffId',
        rownumbers: true,
        fitColumns: 'true',
        singleSelect: 'true',
        toolbar: "#staff_work_toolbar",
        columns: [[
            {field: 'id', hidden: true},
            {field: 'company', width: 100, align: 'center', title: '工作单位', editor: 'text'},
            {field: 'profession', width: 100, align: 'center', title: '职业', editor: 'text'},
            {field: 'business', width: 100, align: 'center', title: '职务', editor: 'text'},
            {field: 'beginDate', width: 100, align: 'center', title: '开始日期', editor: 'datebox'},
            {field: 'endDate', width: 100, align: 'center', title: '结束日期', editor: 'datebox'},
            {field: 'remark', width: 100, align: 'center', title: '备注', editor: 'text'}
        ]],
        onClickRow: function (index) {
            if (editWorkIndex != index) {
                if (endEditingWork()) {
                    staff_work_datagrid.datagrid("selectRow", index).datagrid("beginEdit", index);
                    editWorkIndex = index;
                } else {
                    staff_work_datagrid.datagrid("selectRow", editWorkIndex);
                }
            }
        }
    });

    staff_education_datagrid.datagrid({
        url: '/education/queryByStaffId',
        rownumbers: true,
        fitColumns: 'true',
        singleSelect: 'true',
        toolbar: "#staff_education_toolbar",
        columns: [[
            {field: 'id', hidden: true},
            {field: 'school', width: 100, align: 'center', title: '毕业学校', editor: 'text'},
            {field: 'major', width: 100, align: 'center', title: '所学专业', editor: 'text'},
            {field: 'witness', width: 100, align: 'center', title: '证明人', editor: 'text'},
            {field: 'beginDate', width: 100, align: 'center', title: '开始日期', editor: 'datebox'},
            {field: 'endDate', width: 100, align: 'center', title: '结束日期', editor: 'datebox'},
            {field: 'remark', width: 100, align: 'center', title: '备注', editor: 'text'}
        ]],
        onClickRow: function (index) {
            if (editEducationIndex != index) {
                if (endEditingEducation()) {
                    staff_education_datagrid.datagrid("selectRow", index).datagrid("beginEdit", index);
                    editEducationIndex = index;
                } else {
                    staff_education_datagrid.datagrid("selectRow", editEducationIndex);
                }
            }
        }
    });

    function endEditingFamily() {
        if (editFamilyIndex == undefined) {
            return true
        }
        if (staff_family_datagrid.datagrid('validateRow', editFamilyIndex)) {
            staff_family_datagrid.datagrid('endEdit', editFamilyIndex);
            editFamilyIndex = undefined;
            return true;
        } else {
            return false;
        }
    }

    function endEditingWork() {
        if (editWorkIndex == undefined) {
            return true
        }
        if (staff_work_datagrid.datagrid('validateRow', editWorkIndex)) {
            staff_work_datagrid.datagrid('endEdit', editWorkIndex);
            editWorkIndex = undefined;
            return true;
        } else {
            return false;
        }
    }

    function endEditingEducation() {
        if (editEducationIndex == undefined) {
            return true
        }
        if (staff_education_datagrid.datagrid('validateRow', editEducationIndex)) {
            staff_education_datagrid.datagrid('endEdit', editEducationIndex);
            editEducationIndex = undefined;
            return true;
        } else {
            return false;
        }
    }

    var methodObj = {
        // 新增
        add: function add() {
            easyui_tabs.tabs('getTab', "工资信息").panel('options').tab.hide();
            easyui_tabs.tabs('getTab', "家庭情况").panel('options').tab.hide();
            easyui_tabs.tabs('getTab', "工作经历").panel('options').tab.hide();
            easyui_tabs.tabs('getTab', "教育情况").panel('options').tab.hide();
            easyui_tabs.tabs('getTab', "身份证图片").panel('options').tab.hide();
            $("#easyui-tabs").tabs("select", 1);

            staff_dialog.dialog("setTitle", '员工信息');
            staff_dialog.dialog("open");

        },
        //保存
        save: function save() {
            if (easyui_tabs_title == "基本信息") {
                staff_form.form('submit', {
                    url: '/employee/saveOrUpdate',
                    success: function (data) {
                        data = $.parseJSON(data);
                        if (data.success) {
                            methodObj.cancel();
                            $.messager.alert("温馨提示", '保存成功', 'info', function () {
                                staff_datagrid.datagrid('reload');
                            })
                        } else {
                            $.messager.alert("温馨提示", data.msg, 'error');
                        }
                    },
                    onSubmit: function (param) {
                        var ids = $("#roles_combobox").combobox('getValues');
                        console.log(ids);
                        for (var i = 0; i < ids.length; i++) {
                            //提交额外的参数
                            param['roles[' + i + '].id'] = ids[i];
                        }
                    }
                });
            } else if (easyui_tabs_title == "家庭情况") {
                methodObj.accept_family();
                var rows = staff_family_datagrid.datagrid('getRows');
                var staff_id = {staff_id: staff_datagrid.datagrid('getSelected').id};
                for(var i = 0; i< rows.length; i++){
                    var arys = new Array();
                    var newborndate = rows[i].bornDate;
                    arys = newborndate.split('-');
                    var newDate = new Date(arys[0],arys[1],arys[2]);
                    rows[i].bornDate = newDate.getTime();
                    rows[i].staff_id = staff_id.staff_id;
                }
                rows = JSON.stringify(rows);
                $.ajax({
                    url: '/family/save',
                    type: 'post',
                    dataType: 'json',
                    data: {rows: rows},
                    success: function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示", '操作成功', 'info', function () {
                                staff_family_datagrid.datagrid("reload");
                            })
                        }
                    }
                });
            } else if (easyui_tabs_title == "工作经历") {
                methodObj.accept_work();
                var rows = staff_work_datagrid.datagrid('getRows');
                var staff_id = {staff_id: staff_datagrid.datagrid('getSelected').id};
                for(var i = 0; i< rows.length; i++){
                    var arys = new Array();
                    var date1 = rows[i].beginDate;
                    var date2 = rows[i].endDate;
                    arys1 = date1.split('-');
                    arys2 = date2.split('-');
                    var date1 = new Date(arys1[0],arys1[1],arys1[2]);
                    var date2 = new Date(arys2[0],arys2[1],arys2[2]);
                    rows[i].beginDate = date1.getTime();
                    rows[i].endDate = date2.getTime();
                    rows[i].staff_id = staff_id.staff_id;
                }
                rows = JSON.stringify(rows);
                $.ajax({
                    url: '/work/saveWork',
                    type: 'post',
                    dataType: 'json',
                    data: {rows: rows},
                    success: function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示", '操作成功', 'info', function () {
                                staff_work_datagrid.datagrid("reload");
                            })
                        }
                    }
                });
            } else if (easyui_tabs_title == "教育情况") {
                methodObj.accept_education();
                var rows = staff_education_datagrid.datagrid('getRows');
                var staff_id = {staff_id: staff_datagrid.datagrid('getSelected').id};
                for(var i = 0; i< rows.length; i++){
                    var arys = new Array();
                    var date1 = rows[i].beginDate;
                    var date2 = rows[i].endDate;
                    arys1 = date1.split('-');
                    arys2 = date2.split('-');
                    var date1 = new Date(arys1[0],arys1[1],arys1[2]);
                    var date2 = new Date(arys2[0],arys2[1],arys2[2]);
                    rows[i].beginDate = date1.getTime();
                    rows[i].endDate = date2.getTime();
                    rows[i].staff_id = staff_id.staff_id;
                }
                rows = JSON.stringify(rows);
                $.ajax({
                    url: '/education/saveEducation',
                    type: 'post',
                    dataType: 'json',
                    data: {rows: rows},
                    success: function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示", '操作成功', 'info', function () {
                                staff_education_datagrid.datagrid("reload");
                            })
                        }
                    }
                });
            }
        },
        //编辑
        edit: function edit() {
            var row = staff_datagrid.datagrid('getSelected');
            if (!row) {
                $.messager.alert('温馨提示', "请选中一条数据", 'warning');
                return;
            }
            easyui_tabs.tabs('getTab', "工资信息").panel('options').tab.show();//显示tab页
            easyui_tabs.tabs('getTab', "家庭情况").panel('options').tab.show();
            easyui_tabs.tabs('getTab', "工作经历").panel('options').tab.show();
            easyui_tabs.tabs('getTab', "教育情况").panel('options').tab.show();
            easyui_tabs.tabs('getTab', "身份证图片").panel('options').tab.show();
            staff_dialog.dialog("setTitle", '编辑员工');
            staff_dialog.dialog("open", true);
            //角色回显
            $.get("/role/getRoleIdByEmpId?empId=" + row.id, function (data) {
                $("#roles_combobox").combobox("setValues", data);
            });

            if (row.dept) {
                row['dept.id'] = row.dept.id;
            }
            if (row.job) {
                row['job.id'] = row.job.id;
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
            staff_form.form('load', row);
            /*查询员工的工资信息,通过工号查询*/
            $.ajax({
                type: 'post',
                url: '/salary/queryByIdentifier',
                data: {identifier: row.identifier},
                success: function (data) {
                    if (data.success) {
                        var json = $.parseJSON(data.jsonData);
                        var date = new Date(json.month);
                        var year = date.getFullYear() + '-';
                        var month = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
                        json.month = year + month;
                        staff_salary_form.form('load', json);
                    }
                }
            });
            /*查询家庭*/
            staff_family_datagrid.datagrid('load', {
                staff_id: row.id
            });
            /*查询工作经历*/
            staff_work_datagrid.datagrid('load', {
                staff_id: row.id
            });
            /*查询教育经历*/
            staff_education_datagrid.datagrid('load', {
                staff_id: row.id
            });
            if (row.portrait) {
                $(".layui-upload-img").css('display', 'block');
                $(".layui-upload-img").prop("src", $("#pageContext").val() + row.portrait);
            } else {
                $(".layui-upload-img").css('display', 'none');
            }
        },
        //取消
        cancel: function cancel() {
            staff_dialog.dialog("close", true);
        },
        //刷新
        reload: function reload() {
            staff_datagrid.datagrid("load");
        },
        //高级查询函数
        query: function () {
            var keyword = $("#keyword").textbox("getText");
            var beginDate = $("#beginDate").datebox("getText");
            var endDate = $("#endDate").datebox("getText");
            var deptId = $("#deptId").datebox("getValue");
            staff_datagrid.datagrid("load", {
                keyword: keyword,
                beginDate: beginDate,
                endDate: endDate,
                deptId: deptId
            });
        },
        //更新状态
        changeState: function () {
            var row = staff_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择需要离职或复职的员工")
            } else {
                $.get("/employee/changeState", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg);
                    } else {
                        $.messager.alert("温馨提示", "操作成功");
                        staff_dialog.dialog("close");
                        staff_datagrid.datagrid("reload");
                    }
                })
            }
        },
        //删除
        delete: function () {
            var row = staff_datagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择需要删除的行")
            } else {
                $.get("/employee/delete", {id: row.id}, function (data) {
                    if (!data.success) {
                        $.messager.alert("温馨提示", data.errorMsg)
                    } else {
                        $.messager.alert("温馨提示", "删除成功")
                        staff_dialog.dialog("close");
                        staff_datagrid.datagrid("reload");
                    }
                })
            }
        },
        exportExcel: function () {
            var columnField = staff_datagrid.datagrid('getColumnFields');
            console.log(columnField);
            var table = [];
            for (var i = 0; i < columnField.length; i++) {
                var tableName = staff_datagrid.datagrid('getColumnOption', columnField[i]).title;
                table.push(encodeURIComponent(encodeURIComponent(tableName)));
            }
            window.location.href = "/staff/exportExcel?" + 'titles=' + table;
        },
        importExcel: function () {
            $("#excel_dialog").dialog("setTitle", "文件上传");
            $("#excel_dialog").dialog("open");
        },
        add_family: function () {
            if (endEditingFamily()) {
                staff_family_datagrid.datagrid("appendRow", {});
                editFamilyIndex = staff_family_datagrid.datagrid("getRows").length - 1;
                staff_family_datagrid.datagrid("selectRow", editFamilyIndex).datagrid("beginEdit", editFamilyIndex);
            }
        },
        remove_family: function () {
            if (editFamilyIndex == undefined) {
                return
            }
            staff_family_datagrid.datagrid('cancelEdit', editFamilyIndex).datagrid('deleteRow', editFamilyIndex);
            editFamilyIndex = undefined;
        },
        accept_family: function () {
            if (endEditingFamily()) {
                staff_family_datagrid.datagrid('acceptChanges');
            }
        },
        reject_family: function () {
            staff_family_datagrid.datagrid('rejectChanges');
            editFamilyIndex = undefined;
        },
        add_work: function () {
            if (endEditingWork()) {
                staff_work_datagrid.datagrid("appendRow", {});
                editWorkIndex = staff_work_datagrid.datagrid("getRows").length - 1;
                staff_work_datagrid.datagrid("selectRow", editWorkIndex).datagrid("beginEdit", editWorkIndex);
            }
        },
        remove_work: function () {
            if (editWorkIndex == undefined) {
                return
            }
            staff_work_datagrid.datagrid('cancelEdit', editWorkIndex).datagrid('deleteRow', editWorkIndex);
            editWorkIndex = undefined;
        },
        accept_work: function () {
            if (endEditingWork()) {
                staff_work_datagrid.datagrid('acceptChanges');
            }
        },
        reject_work: function () {
            staff_work_datagrid.datagrid('rejectChanges');
            editWorkIndex = undefined;
        },
        add_education: function () {
            if (endEditingEducation()) {
                staff_education_datagrid.datagrid("appendRow", {});
                editEducationIndex = staff_education_datagrid.datagrid("getRows").length - 1;
                staff_education_datagrid.datagrid("selectRow", editEducationIndex).datagrid("beginEdit", editEducationIndex);
            }
        },
        remove_education: function () {
            if (editEducationIndex == undefined) {
                return
            }
            staff_education_datagrid.datagrid('cancelEdit', editEducationIndex).datagrid('deleteRow', editEducationIndex);
            editEducationIndex = undefined;
        },
        accept_education: function () {
            if (endEditingEducation()) {
                staff_education_datagrid.datagrid('acceptChanges');
            }
        },
        reject_education: function () {
            staff_education_datagrid.datagrid('rejectChanges');
            editEducationIndex = undefined;
        }
    };

    //调用方法
    $('a[data-cmd]').click(function () {
        var cmd = $(this).data("cmd");
        methodObj[cmd]();
    });

    staff_dialog.dialog({
        title: "员工信息",
        width: 800,
        height: 450,
        modal: true,
        buttons: "#form_btns",
        closed: true,
        onClose: function () {
            easyui_tabs.tabs("select", "基本信息");
            staff_form.form("clear");
            staff_salary_form.form("clear");
            staff_family_datagrid.datagrid("loadData", {total: 0, rows: []});
            staff_work_datagrid.datagrid("loadData", {total: 0, rows: []});
            staff_education_datagrid.datagrid("loadData", {total: 0, rows: []});
            $(".layui-upload-img").prop("src", "");
        }
    });


    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#upload_pic'
            , url: '/employee/upload'
            , size: "500"
            , auto: false
            , bindAction: '#btn_save'
            , before: function (obj) {
                //图片大小和非空限制
                layer.load(); //上传loading
                this.data = {
                    staff_id: staff_datagrid.datagrid('getSelected').id,
                    portrait: staff_datagrid.datagrid('getSelected').portrait
                };
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('.layui-upload-img').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                layer.closeAll("loading");
                staff_dialog.dialog("close");
                staff_datagrid.datagrid("reload");
                if (res.success) {
                        $.messager.alert("温馨提示","上传成功");
                } else {
                    ErroAlert("上传失败,请稍后重试");
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var upload_text = $('#upload_text');
                upload_text.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini upload-reload">重试</a>');
                upload_text.find('.upload-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    });
});
























