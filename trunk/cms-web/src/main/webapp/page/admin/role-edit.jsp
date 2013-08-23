<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="editRole"/></title>
</head>
<body>
<div class="class_title"><s:text name="editRole"/></div>
<form action="<s:url value='/admin/role/%{role.id}'/>" method="post">
	<input type="hidden" name="_method" value="put">
	<label><s:text name="roleName"/></label><input class="w200" type="text" name="name" value="${role.name}">
	<table class="list">
		<thead>
			<tr class="w300">
				<th class="select"><s:text name="select"/></th>
				<th style="width:15%;"><s:text name="nodeName"/></th>
				<th><s:text name="privilegeList"></s:text></th>
			</tr>
		</thead>
		<tfoot>
			<tr class="toolbar">
				<td colspan="3">
						<div class="row_left">
							<input type="button" class="btn bw2" value="<s:text name='add'/>" onclick="go('<s:url value='/admin/role/new'/>');"/>
							<!--<s:if test="!menus.empty">
							<input type="button" class="btn bw2" value="<s:text name='checkall'/>"
								 onclick="selAll('selectType',1)" />
							<input type="button" class="btn bw2" value="<s:text name='invert'/>"
								 onclick="selAll('selectType',3)" />
							<input type="button" class="btn bw2" value="<s:text name='cancle'/>"
								 onclick="selAll('selectType',2)" />
							 </s:if>
							--><input type="submit" class="btn bw4" value="<s:text name='applyChange'></s:text>"/>
							<input type="button" class="btn bw6" value="<s:text name='backRoleList'/>" onclick="go('<s:url value='/admin/role'/>');"/>
							<input type="button" class="btn bw6" value="<s:text name='backUpperNode'/>"
								 onclick="go('<s:url value='/admin/role/%{role.id}/edit?parentId=%{grandParentId}'/>');"/>
						</div>
						<div class="clear"></div>
				</td>
			</tr>
		</tfoot>
		<tbody>
			<s:if test="!menus.empty">
			<s:iterator value="menus" id="m" status="status">
				<tr class="odd">
					<td class="center">
						<!--<input type="checkbox" name="selectType"/>
					-->
					${status.index + 1}
					</td>
					<td class="left" style="padding-left: ${level*20}px;">
						<a href="<s:url value='/admin/role/%{role.id}/edit?parentId=%{#m.nodeId}'/>">${m.name}</a>
					</td>
					<td class="left">
						<s:iterator value="opts" id="o">
							<label style="margin-left: 10px;">
								<s:text name="%{#o.name}"></s:text>
							</label>
							<s:if test="%{role.check(#m.nodeId,#o)}">
								<input type="checkbox" value="${m.nodeId}-${o.value}" checked="checked" name="privilege"/>
							</s:if>
							<s:else>
								<input type="checkbox" value="${m.nodeId}-${o.value}" name="privilege"/>
							</s:else>
						</s:iterator>
					</td>
				</tr>
			</s:iterator>
			</s:if>
			<s:else>
				<tr>
					<td colspan="3" class="center"><s:text name="nodata"/></td>
				</tr>
			</s:else>
		</tbody>
	</table>
	</form>
</body>
</html>