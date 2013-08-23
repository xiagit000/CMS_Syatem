<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
<s:text name="reg_online"></s:text><s:text name="list"></s:text>
</title>
</head>
<body>
<% request.setAttribute("colspan","5"); %>
<div class="class_title">
<s:text name="reg_online"></s:text><s:text name="list"></s:text>
</div>
<table class="list">
	<thead>
		<tr>
			<th class="number"><s:text name="orderNumber"></s:text></th>
			<th><s:text name="reg_name"></s:text></th>
			<th><s:text name="reg_schoolName"></s:text></th>
			<th><s:text name="reg_specialty"></s:text></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="${colspan }">
				<div class="row_left">
<!--					<input type="button" value="<s:text name='add'/>" onclick="go('<s:url value="/admin/user/manage/new"/>')" class="btn bw2" />-->
				</div>
				<div class="row_right">
					<s:include value="../../common/page.jsp"></s:include>
				</div>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:if test="registers.size == 0">
			<tr>
				<td colspan="${colspan }" class="center"><s:text name="nodata"></s:text></td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="registers" id="reg" status="status">
				<tr class="${status.odd ? 'odd':'even'}">
					<td>${status.index + 1}</td>
					<td class="left"><s:property value="#reg.schoolInfo.name"/></td>
					<td class="left"><s:property value="#reg.schoolInfo.schoolName"/></td>
					<td class="left"><s:property value="#reg.schoolInfo.specialty"/></td>
					<td>
					<a href="<s:url value='/open/register/%{#reg.id}'/>" target="_blank"><s:text name="view" /></a>
					<a href="<s:url value='/admin/register/manage/%{#reg.id}'/>?_method=delete"
						 onclick="return delConfirm();"><s:text name="delete"></s:text></a>
					</td>
				</tr>
			</s:iterator>
		</s:else>
	</tbody>
</table>
</body>
</html>