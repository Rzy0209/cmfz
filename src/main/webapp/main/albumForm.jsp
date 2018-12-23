<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#albumForm").form("load","${pageContext.request.contextPath}/album/showOne?id=${param.id}")
    })
</script>

<form id="albumForm" method="post">
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
            图片标题:
        </td>
        <td valign="middle" align="right">
            <input type="text"  name="title" id="title" readonly/>
        </td>
    </tr>
    <tr>
        <td valign="middle" align="right">
            count:
        </td>
        <td valign="middle" align="right">
            <input type="text"  name="count" id="count" readonly />
        </td>
    </tr>

    <tr>
        <td valign="middle" align="right">
            封面:
        </td>
        <td valign="middle" align="right">
            <img src="${pageContext.request.contextPath}/image/ddd.jpg" height="30" width="60" name="coverImg"  readonly/>
        </td>
    </tr>

    <tr>
        <td valign="middle" align="right">
            状态:
        </td>
        <td valign="middle" align="right">
            <input type="text"  name="score" id="score"  readonly/>
        </td>
    </tr>

    <tr>
        <td valign="middle" align="right">
            作者:
        </td>
        <td valign="middle" align="right">
            <input type="text"  name="author" id="author" readonly />
        </td>
    </tr>

    <tr>
        <td valign="middle" align="right">
            播音:
        </td>
        <td valign="middle" align="right">
            <input type="text"  name="broadcast" id="broadcast" readonly/>
        </td>
    </tr>

    <tr>
        <td valign="middle" align="right">
            简介:
        </td>
        <td valign="middle" align="right">
            <input type="text"  name="brief" id="brief" readonly/>
        </td>
    </tr>

    <tr>
        <td valign="middle" align="right">
            发行日期:
        </td>
        <td valign="middle" align="right">
            <input type="text"  name="publishDate" id="publishDate" readonly/>
        </td>
    </tr>

</table>
</form>