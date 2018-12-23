<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
        var toolbar = [{
            iconCls: 'icon-add',
            text: "专辑详情",
            handler: function () {
             var a = $("#album").treegrid("getSelected");
              if(a==null){
                  $.messager.alert({
                      title:"系统消息",
                      msg:"请选择要查看的内容",
                      icon:"warning"
                  })
              }else{
                 var rows = $("#album").treegrid("getChecked");
                 for (var i=0;i<rows.length;i++){
                     //判断该节点是不是叶子节点
                     var nodes=$("#album").treegrid("getChildren",rows[i].id);
                     if(nodes.length>0){
                         var id =$("#album").treegrid("getSelected").id;
                         //初始化对话框
                         $("#albumDialog").dialog({
                             title:"专辑详情",
                             width:600,
                             height:400,
                             modal:true,
                             closed:true,
                             href:"${pageContext.request.contextPath}/main/albumForm.jsp?id="+id
                         });
                         $("#albumDialog").dialog("open");
                     }else{
                         $.messager.alert({
                             title:"系统消息",
                             msg:"请选择专辑,而非章节",
                             icon:"warning"
                         })
                     }
                 }
              }
            },

        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-edit',
            handler: function () {
                $("#albumAddDialog").dialog({
                    title:"添加专辑",
                    width:600,
                    height:400,
                    modal:true,
                    closed:true,
                    href:"${pageContext.request.contextPath}/main/addAlbumForm.jsp"
                });
                $("#albumAddDialog").dialog("open");
            }
        }, '-', {
            text: "添加音频",
            iconCls: 'icon-remove',
            handler: function () {
                alert('帮助按钮')
            }
        }, '-', {
            text: "音频下载",
            iconCls: 'icon-save',
            handler: function () {
                alert("请选择下载的歌曲")
                $("#dg").edatagrid("saveRow")

            }
        }]

    $(function () {
        $('#album').treegrid({
            method:"post",
            url:'${pageContext.request.contextPath}/album/showAll',
            idField:'id',
            treeField:'title',
            columns:[[
                {field:'title',title:'名字',width:60},
                {field:'duration',title:'描述',width:80},
                {field:'size',title:'大小',width:80}
            ]],
            fit:true,
            fitColumns:true,
            toolbar:toolbar,
        });
    })

</script>

<table id="album"></table>

<div id="albumDialog"></div>
<div id="albumAddDialog"></div>