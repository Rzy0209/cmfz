<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">

        var toolbar = [{
            iconCls: 'icon-add',
            text: "专辑详情",
            handler: function () {
                alert('编辑按钮')
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);
                } else {
                    alert("请先选中行")
                }


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