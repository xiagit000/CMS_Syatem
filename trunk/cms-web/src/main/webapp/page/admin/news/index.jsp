<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>内部新闻列表</title>
</head>
<body>
<div class="class_title">
内部新闻列表
</div>
<table class="list">
    <thead>
        <tr class="w300">
            <th class="number"><s:text name="orderNumber"/></th>
            <th>新闻名称</th>
            <th>发布时间</th>
            <th class="operation"><s:text name="operation"></s:text></th>
        </tr>
    </thead>
		<tfoot>
        <tr class="toolbar">
            <td colspan="4">
                <div class="row_left"></div>
                <s:if test="#session.right.getRight() > 0">
	                <div class="row_left">
	                   <input class="btn bw2" onclick="go('<s:url value="/admin/news/new"/>')"
	                    value="<s:text name='add'/>" type="button"/>
	                </div>
                </s:if>
                <s:if test="newes.size != 0">
                    <div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
                </s:if>
                <div class="clear"></div>
            </td>
        </tr>
    </tfoot>
		<tbody>
        <s:if test="newes.size != 0">
        <s:iterator value="newes" var="entry" status="status">
            <tr class="${status.odd ? 'odd':'even'}">
                <td>
                    ${status.index+1}
                </td>
                <td class="left">
                    <a href="<s:url value='/admin/news/%{id}/show'/>" ><s:property value="title"/></a>
                </td>
                <td class="left">
                    <s:date name="createTime" format="yyyy年MM月dd日 E"/>
                </td>
                <td>
                    <s:if test="#session.right.getRight() > 0">
                      <a href="<s:url value='/admin/news/%{id}/edit'/>" >编辑</a>&nbsp;&nbsp;
                      <a href="<s:url value='/admin/news/%{id}/delete'/>" onclick="return delConfirm();"><s:text name="delete"></s:text></a>
                      <a href="<s:url value='/admin/news/%{id}/reverts'/>" >查看回复</a>
                      <a href="<s:url value='/admin/news/%{id}/showNoReverter'/>" >未回复会员</a>
                    </s:if>
                </td>
            </tr>
        </s:iterator>
        </s:if>
        <s:else>
            <tr>
                <td colspan="4" class="center"><s:text name="nodata"/></td>
            </tr>
        </s:else>
    </tbody>
</table>
</body>
</html>