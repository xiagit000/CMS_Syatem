<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
<s:text name="assignRights"/>
</title>
</head>
<body>
<div class="class_title">
<s:text name="assignRights"/>
</div>
<table class="list">
	<thead>
		<tr>
			<th class="number"><s:text name="orderNumber"></s:text></th>
			<th class="username"><s:text name="username"></s:text></th>
			<th><s:text name="email"></s:text></th>
			<th style="width: 15%;"><s:text name="userLevel"></s:text></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="5">
				<div class="row_left"></div>
				<div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:if test="users.size == 0">
			<tr>
				<td colspan="5" class="center"><s:text name="nodata"></s:text></td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="users" id="u" status="status">
				<tr class="${status.odd ? 'odd':'even'}">
					<td>${status.index + 1}</td>
					<td class="left"><s:property value="#u.username"/></td>
					<td class="left">${u.email}</td>
					<td class="left"><s:text name="%{#u.userRight}"/></td>
					<td>
						<s:if test="#u.userRight.right != 999">
							<a href="<s:url value='/admin/user/right/%{#u.id}/edit'/>"><s:text name="assignRole"/></a>
						</s:if>
					</td>
				</tr>
			</s:iterator>
		</s:else>
	</tbody>
</table>
</body>
</html>