<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>悬浮广告列表</title>
</head>
<body>
<div class="class_title">
悬浮广告列表
</div>
<table class="list">
    <thead>
        <tr class="w300">
            <th class="number"><s:text name="orderNumber"/></th>
            <th>广告标题</th>
            <th>广告内容</th>
            <th class="operation"><s:text name="operation"></s:text></th>
        </tr>
    </thead>
		<tfoot>
        <tr class="toolbar">
            <td colspan="4">
                <div class="row_left"></div>
                <div class="row_left">
                   <input class="btn bw2" onclick="go('<s:url value="/admin/drift/new"/>')"
                    value="<s:text name='add'/>" type="button"/>
                </div>
                <s:if test="drifts.size != 0">
                    <div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
                </s:if>
                <div class="clear"></div>
            </td>
        </tr>
    </tfoot>
		<tbody>
        <s:if test="drifts.size != 0">
        <s:iterator value="drifts" var="entry" status="status">
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
                <td>
                <a href="<s:url value='/admin/drift/%{id}/onIndex'/>">首页显示</a>${onIndex ? '（首页）':''}
                <a href="<s:url value='/admin/drift/%{id}/edit'/>">编辑</a> 
                <a href="<s:url value='/admin/drift/%{id}/delete'/>"
                         onclick="return delConfirm();"><s:text name="delete" /></a></td>
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