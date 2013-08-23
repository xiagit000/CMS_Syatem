<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>投票列表</title>
</head>
<body>

<div class="class_title">投票列表</div>

<table class="list">
    <thead>
        <tr class="w300">
            <th class="number"><s:text name="orderNumber"/></th>
            <th>投票标题</th>
            <th>投票内容</th>
            <th>发布时间</th>
            <th class="operation"><s:text name="operation"></s:text></th>
        </tr>
    </thead>
        <tfoot>
        <tr class="toolbar">
            <td colspan="5">
                <div class="row_left"></div>
                <div class="row_left">
                   <input class="btn bw2" onclick="go('<s:url value="/admin/vote/new"/>')"
                    value="<s:text name='add'/>" type="button"/>
                </div>
                <s:if test="votes.size != 0">
                    <div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
                </s:if>
                <div class="clear"></div>
            </td>
        </tr>
    </tfoot>
        <tbody>
        <s:if test="votes.size != 0">
        <s:iterator value="votes" var="entry" status="status">
            <tr class="${status.odd ? 'odd':'even'}">
                <td>
                    ${status.index+1}
                </td>
                <td class="left">
                    <s:property value="title"/>
                </td>
                <td class="left">
                    <s:property value="content"/>
                </td>
                <td class="left">
                    <s:date name="createTime" format="yyyy年MM月dd日 E"/>
                </td>
                <td>
                    <a href="<s:url value='/admin/vote/%{id}/show'/>" >查看结果/编辑选项</a>&nbsp;&nbsp;
                    <a href="<s:url value='/admin/vote/%{id}/edit'/>" >编辑</a>&nbsp;&nbsp;
                    <a href="<s:url value='/admin/vote/%{id}/delete'/>" onclick="return delConfirm();">删除</a>
                </td>
            </tr>
        </s:iterator>
        </s:if>
        <s:else>
            <tr>
                <td colspan="5" class="center"><s:text name="nodata"/></td>
            </tr>
        </s:else>
    </tbody>
</table>
</body>
</html>