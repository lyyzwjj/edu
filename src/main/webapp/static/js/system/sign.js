$(function () {
    var sign_datagrid = $("#sign_datagrid");
    sign_datagrid.datagrid({
        url: "/sign/selfList",
        fit: true,
        //单选
        singleSelect: true,
        //是否显示分页栏
        pagination: true,
        //按比例分配宽度
        fitColumns: true,
        columns: [[
            {field: 'id', title: '编号', width: 100},
            {field: 'employee', title: '对象名字', width: 100,formatter:function(value,row,index){
                if(value){
                    return value.name
                }
            }},
            {field: 'signIn', title: '签到时间', width: 100},
            {field:"signInState",title:"签到状态",width:100,formatter:function(value,row,index){
                if(value==0){
                    return "<font color='green'>正常</font>"
                }else if(value==1){
                    return "<font color='red'>异常</font>"
                }
            }},
            {field: 'signOut', title: '签退时间', width: 100},
            {field:"signOutState",title:"签退状态",width:100,formatter:function(value,row,index){
                if(value==0){
                    return "<font color='green'>正常</font>"
                }else if(value==1){
                    return "<font color='red'>异常</font>"
                }
            }}
        ]]
    })
})

