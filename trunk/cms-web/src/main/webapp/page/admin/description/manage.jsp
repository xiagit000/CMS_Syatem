<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
<s:text name="des_column"></s:text><s:text name="list"></s:text>
</title>
</head>
<body>
<% request.setAttribute("colspan","3"); %>
<div class="class_title">
<s:text name="des_column" /><s:text name="list" />
</div>
<table class="list">
	<thead>
		<tr>
			<th class="number"><s:text name="orderNumber"></s:text></th>
			<th><s:text name="des_column_talbe_title"></s:text></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="${colspan }">
				<div class="row_left">
				<input type="button" value="<s:text name='des_column_add'/>" onclick="go('<s:url value='/admin/description/manage/new'/>')" class="btn bw4" />
				</div>
				<div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:if test="descriptions.size == 0">
			<tr>
				<td colspan="${colspan }" class="center"><s:text name="nodata"></s:text></td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="descriptions" id="des" status="status">
				<tr class="${status.odd ? 'odd':'even'}">
					<td>${status.index + 1}</td>
					<td class="left">${des.name }</td>
					<td>
					<a href="<s:url value='/admin/description/manage/%{#des.id}/edit'/>"><s:text name="edit"></s:text></a>
					<a href="<s:url value='/admin/description/manage/%{#des.id}'/>?_method=delete"
						 onclick="return delConfirm();"><s:text name="delete"></s:text></a>
					</td>
				</tr>
			</s:iterator>
		</s:else>
	</tbody>
</table>
</body>
</html>