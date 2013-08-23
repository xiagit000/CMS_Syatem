<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>编辑文字广告</title>
</head>
<body>

    <script src="<s:url value='/javascript/adword/form.js'/>" type="text/javascript"></script>
    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>

<div class="class_title">编辑文字广告</div>
<form action="<s:url value='/admin/adword/%{adword.id}'/>" method="post" >
<input type="hidden" name="_method" value="put"/>
<table class="info">
    <thead>
        <tr>
            <th class="two_col_head"><s:text name="section"></s:text></th>
            <th><s:text name="info"></s:text></th>
        </tr>
    </thead>
    <tfoot>
        <tr class="toolbar">
            <td colspan="2">
                <div class="row_left">
                    <input class="btn bw2" type="submit" value="<s:text name='ok'/>" />
                    <input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
                </div>
                <div class="clear"></div>
            </td>
        </tr>
    </tfoot>
    <tbody>
        <tr class="odd">
            <td>广告标题</td>
            <td><input name="adword.title" class="w300" id="title" type="text" value="${adword.title}"/>
            <span id="titleVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
            </td>
        </tr>
        <tr class="even">
            <td>广告内容</td>
            <td><input name="adword.content" class="w300" id="content" type="text" value="${adword.content}"/>
            <span id="contentVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
            </td>
        </tr>
         <tr class="odd">
            <td>广告优先级</td>
            <td><input name="adword.orderby" class="w300" id="orderby" type="text" value="${adword.orderby}"/>
            <span id="contentVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
            </td>
        </tr>
        <%-- <tr class="odd">
            <td>交易时间</td>
            <td><input name="linkHref" class="w300" value="http://" id="href" type="text"/>
            <span id="hrefVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
            </td>
        </tr> --%>
    </tbody>
</table>
</form>
</body>
</html>