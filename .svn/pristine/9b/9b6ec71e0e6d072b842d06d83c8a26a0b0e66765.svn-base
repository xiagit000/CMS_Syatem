<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.username}--<s:text name="assignRights"/></title>
</head>
<body>
<div class="class_title">
<s:text name="assignRights"/>
</div>
<label for="typeName">
	<s:text name="assignUserRightTip">
		<s:param>${user.username}</s:param>
	</s:text></label>
<form action="<s:url value='/admin/user/right/%{user.id}'/>" method="post">
<input type="hidden" name="_method" value="put">
<table class="info">
	<thead>
		<tr>
			<th class="two_col_head">
				<s:text name="roleName"></s:text>
			</th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td>
				<div class="row_left">
					<input class="btn bw4" type="submit" value="<s:text name='applyChange'/>" />
					<input class="btn bw2" type="button" onclick="go('<s:url value="/admin/user/right"/>');" value="<s:text name='back'/>"/>
				</div>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:iterator value="roles" id="r" status="status">
		<tr class="${status.odd?'odd':'even'}">
			<td>
			<s:if test="user.hasRole(#r)"><input type="checkbox" value="${r.id}" name="selectRoles" checked="checked"></s:if>
			<s:else><input type="checkbox" value="${r.id}" name="selectRoles"></s:else>
			${r.name}
			</td>
		</tr>
	</s:iterator>
	</tbody>
</table>
</form>
</body>
</html>