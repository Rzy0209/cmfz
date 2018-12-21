<%@page pageEncoding="UTF-8" %>



<script type="text/javascript">
    $("#title").textbox({
        required:true
    });
    $("#status").textbox({
        required:true
    });
    $("#publishDate").datebox({
        required:true,
        editable:false
    });
    $("#description").textbox({
        required:true
    });
    $("#addBannerBtn").linkbutton({
        iconCls:"icon-add",
        plain:true,
        onClick:function(){
            $("#addBannerForm").form("submit",{
                url:"${pageContext.request.contextPath}/banner/addBanner",
                onSubmit:function(){
                    return true;
                },
                success:function(){
                   $("#addBannerDialog").dialog("close");
                    $.messager.show({
                        title:'消息消息',
                        msg:'成功添加一个Banner',
                        timeout:400,
                        showType:'slide'
                    });
                    url:"${pageContext.request.contextPath}/banner/showByPage"

                }
            })
        }
    });
    $("#clearBannerBtn").linkbutton({
        onClick:function(){
            $("#addBannerForm").form("clear")
        }
    })



</script>

<form id="addBannerForm" method="post" enctype="multipart/form-data">

    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">
        <tr>
            <td valign="middle" align="right">
                图片标题:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="title" id="title" />
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                状态:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="status" id="status" />
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                上传日期:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="publishDate" id="publishDate"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                图片描述:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="description" id="description"/>
            </td>
        </tr>

        <br><input type="file" name="file">

    </table>

    <p>
        <a id="addBannerBtn" >添加Banner</a>
        <a id="clearBannerBtn">重置</a>
    </p>
</form>