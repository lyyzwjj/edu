$(function () {
    $("#main_tree").tree({
        url:"/systemMenu/queryRootMenu",
        onClick:function (node) {
            var isLeaf = $("#main_tree").tree("isLeaf",node.target)
            if(!isLeaf){
                return;
            }
            var exists = $("#main_tabs").tabs("exists",node.text);
            if(exists){
                $("#main_tabs").tabs("select",node.text);
            }else{
                $("#main_tabs").tabs("add",{
                    title:node.text,
                    content:"<iframe width='98%' height='98%' src="+node.url+"></iframe>",
                    closable:true
                })
            }
        }
    });
    $("#main_tabs").tabs({})


})

function signIn(){
    /*$.messager.alert("温馨提示", '你确实需要签到吗?', 'info', function () {
        $.ajax("/sign/signIn",function(data){
           if(data.success){
               $.messager.alert("温馨提示", '签到成功', 'info');
           }else{
               $.messager.alert("温馨提示", data.errorMsg, 'info');
           }

        });
    });*/
    $.messager.confirm('确认', '你确实签到吗？', function (r) {
        if (r) {
            //发起请求
            $.get("/sign/signIn", function (data) {
                if (data.success) {
                    $.messager.alert("温馨提示", '签到成功', 'info');
                } else {
                    $.messager.alert("温馨提示", data.errorMsg, 'info');
                }
            })
        }
    });
}


function signOut(){
    /*$.messager.alert("温馨提示", '你确实需要签退吗?', 'info', function () {
        $.ajax("/sign/signOut",function(data){
            if(data.success){
                $.messager.alert("温馨提示", '签退成功', 'info');
            }else{
                $.messager.alert("温馨提示", '签退失败', 'info');
            }
        });
    });*/
    $.messager.confirm('确认', '你确实签退吗？', function (r) {
        if (r) {
            //发起请求
            $.get("/sign/signOut", function (data) {
                if (data.success) {
                    $.messager.alert("温馨提示", '签退成功', 'info');
                } else {
                    $.messager.alert("温馨提示", data.errorMsg, 'info');
                }
            })
        }
    });
}