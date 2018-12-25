<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        //标题
        $("#title").textbox({
            required:true
        });
        //数量
        $("#count").textbox({
            required:true
        });
        //封面
        $("#coverImg").textbox({
            required:true
        });
        //评分
        $("#score").textbox({
            required:true
        });
        //作者
        $("#author").textbox({
            required:true
        });
        //播音
        $("#broadcast").textbox({
            required:true
        });
        //简介
        $("#brief").textbox({
            required:true
        });
        //发布日期
        $("#publishDate").datebox({
            required:true,
            editable:true
        });
        $("#addAlbumBtn").linkbutton({
            onClick:function () {
                $("#addAlbumForm").form("submit",{
                    url:"${pageContext.request.contextPath}/album/insertAlbum",
                    onSubmit:function () {
                        return true;
                    },
                    success:function(){
                        $("#albumAddDialog").dialog("close");
                        $.messager.show({
                            title:'消息消息',
                            msg:'添加专辑成功',
                            timeout:400,
                            showType:'slide'
                        });
                        $("#album").treegrid("reload");
                    }
                })
            }
        });
        $("#clearAlumBtn").linkbutton({
            onClick:function () {
                $("#allAlbumForm").form("clear");
            }
        });


    })
</script>

<form id="addAlbumForm" method="post">
    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">
        <tr>
            <td valign="middle" align="right">

            </td>
            <td valign="middle" align="right">
                <input type="text"  name="id" id="id" hidden />
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                专辑标题:
            </td>
            <td valign="middle" align="right">
                <input type="text"  name="title" id="title" />
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                歌曲数量:
            </td>
            <td valign="middle" align="right">
                <input type="text"  name="count" id="count"  />
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                封面:
            </td>
            <td valign="middle" align="right">
                <input type="text" name="coverImg" id="coverImg"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                评分:
            </td>
            <td valign="middle" align="right">
                <input type="text"  name="score" id="score"  />
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                作者:
            </td>
            <td valign="middle" align="right">
                <input type="text"  name="author" id="author"  />
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                播音:
            </td>
            <td valign="middle" align="right">
                <input type="text"  name="broadcast" id="broadcast"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                简介:
            </td>
            <td valign="middle" align="right">
                <input type="text"  name="brief" id="brief" />
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                发行日期:
            </td>
            <td valign="middle" align="right">
                <input type="text"  name="publishDate" id="publishDate" />
            </td>
        </tr>

    </table>
</form>
<a id="addAlbumBtn">添加专辑</a><br/><a id="clearAlumBtn">重置</a>