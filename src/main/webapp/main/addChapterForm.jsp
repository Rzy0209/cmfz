<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#title").textbox({
            required:true
        });
        $("#duration").textbox({
            required:true
        });
        $("#uploadDate").datebox({
            required:true,
            editable:false
        });
        $("#chapterSelected").combobox({
            url:"${pageContext.request.contextPath}/album/showAll",
            valueField: 'id',
            textField: 'title',
            required:true
        });

        $("#addBChapterBtn").linkbutton({
           onClick:function () {
               $("#addChapterForm").form("submit",{
                   url:"${pageContext.request.contextPath}/chapter/insertChapter",
                   onSubmit:function () {
                       return true;
                   },
                   success:function () {
                       $("#chapterAddDialog").dialog("close");
                       $.messager.show({
                           title:'消息消息',
                           msg:'添加章节成功',
                           timeout:400,
                           showType:'slide'
                       });
                       $("#album").treegrid("reload");
                   }

               })
           }
        });
        $("#clearChapterBtn").linkbutton({
            onClick:function () {
                $("#addChapterForm").form("clear");
            }
        })

    })
</script>

<form id="addChapterForm" method="post" enctype="multipart/form-data">
    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">
    <tr>
        <td valign="middle" align="right">
            所属专辑:
        </td>
        <td valign="middle" align="right">
            <input id="chapterSelected" name="album_id"/>
        </td>
    </tr>
        <tr>
            <td valign="middle" align="right">
                章节名称:
            </td>
            <td valign="middle" align="right">
                <input id="title" name="title"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                描述:
            </td>
            <td valign="middle" align="right">
                <input type="text"  name="duration" id="duration"/>
            </td>
        </tr>

    <tr>
        <td valign="middle" align="right">
            选择文件:
        </td>
        <td valign="middle" align="right">
            <input type="file"  name="file"/>
        </td>
    </tr>
    <tr>
        <td valign="middle" align="right">
            发行日期:
        </td>
        <td valign="middle" align="right">
            <input type="text"  name="uploadDate" id="uploadDate" />
        </td>
    </tr>
    </table>
</form>
<p>
    <a id="addBChapterBtn" >添加章节</a>
    <a id="clearChapterBtn">重置</a>
</p>