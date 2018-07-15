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