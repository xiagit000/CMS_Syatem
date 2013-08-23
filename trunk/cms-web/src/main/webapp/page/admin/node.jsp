<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="nodeManage"/></title>
</head>
<body>
<div class="class_title">
<s:text name="nodeManage"/>
</div>
<table class="list">
	<thead>
		<tr class="w300">
			<th class="select"><s:text name="orderNumber"/></th>
			<th><s:text name="name"/></th>
			<th class="position"><s:text name="position"></s:text></th>
			<th class="operation" style="width: 30%;"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="4">
					<div class="row_left">
						<s:if test="isAddable(parentId)">
							<input type="button" value="<s:text name='addNode'/>"
							 onclick="go('<s:url value="/admin/node/new?parentId=%{parentId}"/>')" class="btn bw4" />
							&nbsp;&nbsp;
						</s:if>
						<s:if test="parentId != null">
							<input type="button" value="<s:text name='upwardsNode'/>"
							 onclick="go('<s:url value="/admin/node?parentId=%{parent.parent.id}"/>')" class="btn bw6" />
							&nbsp;&nbsp;
						</s:if>
						<s:if test="parentId == null"><s:text name="topNodeTip"></s:text></s:if>
					</div>
					<s:if test="!menus.empty"><div class="row_right"><s:include value="../common/page.jsp"></s:include></div></s:if>
					<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:if test="!nodes.empty">
		<s:iterator value="nodes"  var="n" status="status">
			<tr class="${status.odd ? 'odd':'even'}">
				<td class="center">${status.index + 1}</td>
				<td class="left">
					<s:if test="n.isAuthrized(currentUser,Opera)"></s:if>
					<a href="<s:url value='/admin/node?parentId=%{id}'/>">${name}</a>
					<s:if test="!children.empty">
						<br/>
						子栏目：<s:iterator value="children" var="nc">
							<a href="<s:url value='/admin/node?parentId=%{id}'/>">${name}</a>
						</s:iterator>
					</s:if>
				</td>
				<td><input type="text" value="${position}" disabled="disabled"/></td>
				<td>
					<a href="<s:url value='/admin/node/%{id}/edit'/>"><s:text name="edit"/></a>&nbsp;&nbsp;
					<s:if test="parentNodeId != null || currentUser.userRight.right == 999">
						<a href="<s:url value='/admin/node/%{id}/up?parentId=%{parentId}&position=%{position}'/>"><s:text name="upNode"/></a>&nbsp;&nbsp;
						<a href="<s:url value='/admin/node/%{id}/down?parentId=%{parentId}&position=%{position}'/>"><s:text name="downNode"/></a>&nbsp;&nbsp;
						<a href="<s:url value='/admin/node/%{id}?_method=delete&parentId=%{parentId}'/>" onclick="return delConfirm();"><s:text name="deleteNode"/></a>&nbsp;&nbsp;
					</s:if>
					<a href="<s:url value='/admin/node/new?parentId=%{id}'/>"><s:text name="addChildNode"/></a>&nbsp;&nbsp;
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