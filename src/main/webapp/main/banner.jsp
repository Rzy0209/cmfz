<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function(){
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                $("#addBannerDialog").dialog({
                    title:"添加Banner",
                    width:500,
                    height:300,
                    href:"${pageContext.request.contextPath}/main/addBanner.jsp"
                })
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);

                } else {
                    $.messager.show({
                        title:'消息消息 ',
                        msg:'请先选中行。',
                        timeout:400,
                        showType:'slide'
                    });

                }


            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-remove',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if(row==null){
                    $.messager.show({
                        title:'消息消息 ',
                        msg:'请先选中行。',
                        timeout:400,
                        showType:'slide'
                    });
                }else{
                    $('#dg').edatagrid("destroyRow");
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow")

            }
        }]




        $("#dg").edatagrid({
            fitColumns:true,
            striped:true,
            fit:true,
            pagination:true,
            pageSize:3,
            pageList:[1,3,5,7,9],
            updateUrl: "${pageContext.request.contextPath}/banner/updateBanner",
            destroyUrl:"${pageContext.request.contextPath}/banner/deleteBanner",
            url:"${pageContext.request.contextPath}/banner/showByPage",
            toolbar:toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.publishDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })

    });
</script>

<table id="dg">
    <thead>
        <tr>
            <th data-options="field:'title',width:100">名字</th>
            <th data-options="field:'status',width:100,editor:{type:'text',options:{required:true}}">状态</th>
            <th data-options="field:'publishDate',width:100">时间</th>
        </tr>
    </thead>
</table>
<!--  添加图片 -->
<div id="addBannerDialog"></div>